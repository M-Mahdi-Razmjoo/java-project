package com.example.phase2_main;

import com.example.phase2_main.repository.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Activity_Controller implements Initializable {
    public static ArrayList<String> activities;

    @FXML
    private TreeView myActivity;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            activityRepository.showActivity(Main.mainConnection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TreeItem<String> rootItem = new TreeItem<>("myActivity");

        for(int i=0 ; i<activities.size() ; i++){
            TreeItem<String> branchItem = new TreeItem<>(activities.get(i));
            rootItem.getChildren().add(branchItem);
        }
        if(myActivity != null){
            myActivity.setRoot(rootItem);
            myActivity.setShowRoot(false);
        }
    }

    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MyPage.fxml");
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
