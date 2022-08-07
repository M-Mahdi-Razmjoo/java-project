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

public class ShowSearchedMessage_Controller implements Initializable {
    public static String messageID;
    public static String content;
    public static String username1;
    public static String dat1;
    public static String time1;
    public static String photoDirectory;

    @FXML
    private Label username;
    @FXML
    private Label firstLine;
    @FXML
    private Label secondLine;
    @FXML
    private Label date;
    @FXML
    private Label time;
    @FXML
    private Circle circle_photo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            groupRepository.findMessage(messageID , Main.mainConnection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        username.setText(username1);
        if (content.length()>57){
            firstLine.setText(content.substring(0 , 57));
            secondLine.setText(content.substring(57 , content.length()));
        } else {
            firstLine.setText(content);
        }
        date.setText(dat1);
        time.setText(time1);
        if(!(photoDirectory.equalsIgnoreCase("nothing"))){
            Image image = new Image(photoDirectory);
            circle_photo.setFill(new ImagePattern(image , 0, 0, 1, 1, true));
        }
    }

    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("SearchMessageInGroup.fxml");
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
