package com.example.phase2_main;

import com.example.phase2_main.repository.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyPage_Controller implements Initializable {
    public static String myUsername;
    @FXML
    private Label username;
    @FXML
    private Label followerNumber;
    @FXML
    private Label followingNumber;
    @FXML
    private Circle circle_myPhoto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setText(myUsername);
        try {
            followerNumber.setText(String.valueOf(followersRepository.countFollowers(myUsername , Main.mainConnection)));
            followingNumber.setText(String.valueOf(followersRepository.countFollowings(myUsername , Main.mainConnection)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String photoDirectory = null;
        try {
            photoDirectory = groupRepository.photoDirectory(myUsername , Main.mainConnection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!(photoDirectory.equalsIgnoreCase("nothing"))) {
            Image image = new Image(photoDirectory);
            circle_myPhoto.setFill(new ImagePattern(image, 0, 0, 1, 1, true));
        }
    }

    public void myPosts(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MyPosts.fxml");
    }

    public void activity(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Activity.fxml");
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
