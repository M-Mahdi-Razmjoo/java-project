package com.example.phase2_main;

import com.example.phase2_main.repository.*;

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

public class ForwardMessage_Controller implements Initializable {
    public static int messageID;
    public static boolean beingPhoto;

    @FXML
    private TreeView groups;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> rootItem = new TreeItem<>("groups");
        ArrayList<String> groupsID = new ArrayList<>();
        try {
            groupsID = groupRepository.showMyGroups2(Main.mainConnection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(int i=0 ; i<groupsID.size() ; i++){
            try{
                TreeItem<String> branchItem = new TreeItem<>(groupsID.get(i));
                rootItem.getChildren().add(branchItem);
            } catch (NullPointerException e){

            }
        }

        if(groups != null){
            groups.setRoot(rootItem);
            groups.setShowRoot(false);
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

        groups.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
    }


    private void handleMouseClicked(MouseEvent event) throws IOException, SQLException {
        Node node = event.getPickResult().getIntersectedNode();
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
            String name = (String) ((TreeItem)groups.getSelectionModel().getSelectedItem()).getValue();
            MessagingInGroup_Controller.groupName = name.split("\\s")[0];
            MessagingInGroup_Controller.groupID = name.split("\\s")[2];
            if(beingPhoto){
                groupRepository.forwardPhoto(messageID , name.split("\\s")[2] , Main.mainConnection);
            } else {
                groupRepository.forwardMessage(messageID , name.split("\\s")[2] , Main.mainConnection);
            }

            Main main = new Main();
            main.changeScene("MessagingInGroup.fxml");

        }
    }

    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MessagingInGroup.fxml");
    }
}
