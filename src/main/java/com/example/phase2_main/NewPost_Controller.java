package com.example.phase2_main;

import com.example.phase2_main.repository.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class NewPost_Controller {
    @FXML
    private TextField newPost_content;
    @FXML
    private TextField newPost_photoDirectory;
    @FXML
    private Label newPost_warning;


    public void post(ActionEvent event) throws SQLException, IOException {
        Main main = new Main();
        if(newPost_content.getText().equalsIgnoreCase("")){
            newPost_warning.setText("You have not entered anything to post!");
        } else {
            if(newPost_content.getText().length()>300){
                newPost_warning.setText("The text of your post should contain 300 characters at most!");
            } else {
                if(newPost_photoDirectory.getText().equalsIgnoreCase("")){
                    postRepository.post(newPost_content.getText() , "nothing" , Main.mainConnection);
                } else {
                    postRepository.post(newPost_content.getText() , newPost_photoDirectory.getText() , Main.mainConnection);
                }
                newPost_content.clear();
                newPost_warning.setText("");
                newPost_photoDirectory.clear();
                main.changeScene("MainPage.fxml");
            }
        }
    }


    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MainPage.fxml");
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
