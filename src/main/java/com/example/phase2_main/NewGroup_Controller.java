package com.example.phase2_main;

import com.example.phase2_main.repository.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class NewGroup_Controller {

    @FXML
    private TextField groupName;
    @FXML
    private TextField groupPhoto;
    @FXML
    private TextField groupID;
    @FXML
    private Label newGroup_warning;

    public void makeGroup(ActionEvent event) throws SQLException, IOException {
        Main main = new Main();
        if(groupName.getText().equalsIgnoreCase("")){
            newGroup_warning.setText("Be sure to enter the group name.");
        } else {
            newGroup_warning.setText("");
            if(groupID.getText().equalsIgnoreCase("")){
                newGroup_warning.setText("The group must have an ID.");
            } else {
                newGroup_warning.setText("");
                if(!(groupRepository.IdAvailability(groupID.getText() , Main.mainConnection))){
                    newGroup_warning.setText("This ID isn't available");
                } else {
                    newGroup_warning.setText("");
                    groupRepository.creatNewGroup(groupName.getText() , groupPhoto.getText() , groupID.getText() , Main.mainConnection);
                    main.changeScene("GroupNames.fxml");
                }
            }
        }
    }

    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("GroupNames.fxml");
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
