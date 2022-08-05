package com.example.phase2_main;

import com.example.phase2_main.repository.groupRepository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BanMember_Controller implements Initializable {
    @FXML
    private TreeView members;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> memberList = new ArrayList<>();
        try {
            memberList = groupRepository.showMembers(MessagingInGroup_Controller.groupID , Main.mainConnection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TreeItem<String> rootItem = new TreeItem<>("members");

        for(int i=0 ; i<memberList.size() ; i++){
            TreeItem<String> branchItem = new TreeItem<>(memberList.get(i));
            rootItem.getChildren().add(branchItem);
        }
        if(members != null){
            members.setRoot(rootItem);
            members.setShowRoot(false);
        }
    }

    public void selectItem() throws IOException {
        EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
            try {
                handleMouseClicked(event);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        };

        members.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
    }


    private void handleMouseClicked(MouseEvent event) throws IOException, SQLException {
        Node node = event.getPickResult().getIntersectedNode();
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
            String name = (String) ((TreeItem)members.getSelectionModel().getSelectedItem()).getValue();
            groupRepository.banMember(name , MessagingInGroup_Controller.groupID , Main.mainConnection);

            Main main = new Main();
            main.changeScene("GroupSettings.fxml");
        }
    }

    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("GroupSettings.fxml");
    }

}
