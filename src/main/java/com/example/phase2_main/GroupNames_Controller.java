package com.example.phase2_main;

import com.example.phase2_main.repository.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GroupNames_Controller implements Initializable {

    public static ArrayList<String> myGroups = new ArrayList<>();

    @FXML
    private TreeView groupNames;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            groupRepository.showMyGroups(Main.mainConnection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TreeItem<String> rootItem = new TreeItem<>("Groups");

        for(int i=0 ; i<myGroups.size() ; i++){
            TreeItem<String> branchItem = new TreeItem<>(myGroups.get(i));
            rootItem.getChildren().add(branchItem);
        }
        if(groupNames != null){
            groupNames.setRoot(rootItem);
            groupNames.setShowRoot(false);
        }
    }

    public void selectItem() throws IOException {
        EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
            try {
                handleMouseClicked(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        groupNames.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
    }


    private void handleMouseClicked(MouseEvent event) throws IOException {
        Node node = event.getPickResult().getIntersectedNode();
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
            String name = (String) ((TreeItem)groupNames.getSelectionModel().getSelectedItem()).getValue();
            MessagingInGroup_Controller.groupName = name.split("\\s")[0];
            MessagingInGroup_Controller.groupID = name.split("\\s")[2];
            //professormode_showstudetns_controller.courseName=name;
            //مهم

            Main main = new Main();
            main.changeScene("MessagingInGroup.fxml");

//            final Node source = (Node) event.getSource();
//            final Stage stage = (Stage) source.getScene().getWindow();
//            stage.close();
//            Parent root = FXMLLoader.load(getClass().getResource("scene_showstudents.fxml"));
//
//            Stage window = new Stage();
//
//            window.initModality(Modality.APPLICATION_MODAL);
//            window.setTitle("Students");
//
//            Scene scene = new Scene(root);
//            window.setScene(scene);
//            window.showAndWait();
        }
    }

    public void newGroup(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("NewGroup.fxml");
    }

    public void joinAGroup(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("JoinAGroup.fxml");
    }

    public void newPost(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("NewPost.fxml");
    }

    public void messages(ActionEvent event){
        Main main = new Main();
        //main.changeScene("");
    }

    public void groups(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("GroupNames.fxml");
    }

    public void searchOthers(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("SearchOthersPage.fxml");
    }

    public void myPage(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MyPage.fxml");
    }

    public void settings(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Settings.fxml");
    }

    public void exit(ActionEvent event){
        System.exit(0);
    }

}
