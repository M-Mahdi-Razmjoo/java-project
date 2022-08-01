package com.example.phase2_main;

import com.example.phase2_main.repository.likeRepository;
import com.example.phase2_main.repository.postRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainPage_ShowCommentsOfComments_Controller implements Initializable {

    public static int commentCounter;
    public static String commentSender;
    public static String commentContent;
    public static String commentSenderPhoto;
    public static String commentID;

    @FXML
    private Circle comment_circle;
    @FXML
    private Label comment_username;
    @FXML
    private Label comment_firstLine;
    @FXML
    private Label comment_secondLine;
    @FXML
    private Label comment_warning;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        commentCounter=1;
        try {
            postRepository.showCommentsOfComments(MainPage_Controller.sender , MainPage_Controller.content , commentCounter , Main.mainConnection);
            if(commentContent.length()>50){
                comment_username.setText(commentSender);
                comment_firstLine.setText(commentContent.substring(0,51));
                comment_secondLine.setText(commentContent.substring(51,commentContent.length()));
                if(!(commentSenderPhoto.equalsIgnoreCase("nothing"))){
                    Image image = new Image(commentSenderPhoto);
                    comment_circle.setFill(new ImagePattern(image , 0.2 , 0.2 , 0.4 , 0.4 , true));
                }
            } else {
                comment_username.setText(commentSender);
                comment_firstLine.setText(commentContent);
                comment_secondLine.setText("");
                if(!(commentSenderPhoto.equalsIgnoreCase("nothing"))){
                    Image image = new Image(commentSenderPhoto);
                    comment_circle.setFill(new ImagePattern(image , 0.2 , 0.2 , 0.4 , 0.4 , true));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void like(ActionEvent event) throws SQLException {
        likeRepository.likeAComment(commentID , Main.mainConnection);
    }

    public void nextComment(ActionEvent event) throws SQLException {
        if(commentCounter>1){
            commentCounter--;
            postRepository.showCommentsOfComments(MainPage_Controller.sender , MainPage_Controller.content , commentCounter , Main.mainConnection);
            if(commentContent.length()>50){
                comment_username.setText(commentSender);
                comment_firstLine.setText(commentContent.substring(0,51));
                comment_secondLine.setText(commentContent.substring(51,commentContent.length()));
                if(!(commentSenderPhoto.equalsIgnoreCase("nothing"))){
                    Image image = new Image(commentSenderPhoto);
                    comment_circle.setFill(new ImagePattern(image , 0.2 , 0.2 , 0.4 , 0.4 , true));
                }
            } else {
                comment_username.setText(commentSender);
                comment_firstLine.setText(commentContent);
                comment_secondLine.setText("");
                if(!(commentSenderPhoto.equalsIgnoreCase("nothing"))){
                    Image image = new Image(commentSenderPhoto);
                    comment_circle.setFill(new ImagePattern(image , 0.2 , 0.2 , 0.4 , 0.4 , true));
                }
            }
        }
    }

    public void previousComment(ActionEvent event) throws SQLException {
        if(postRepository.commentCounter(commentSender , commentContent , Main.mainConnection)>commentCounter){
            commentCounter++;
            postRepository.showCommentsOfComments(MainPage_Controller.sender , MainPage_Controller.content , commentCounter , Main.mainConnection);
            if(commentContent.length()>50){
                comment_username.setText(commentSender);
                comment_firstLine.setText(commentContent.substring(0,51));
                comment_secondLine.setText(commentContent.substring(51,commentContent.length()));
                if(!(commentSenderPhoto.equalsIgnoreCase("nothing"))){
                    Image image = new Image(commentSenderPhoto);
                    comment_circle.setFill(new ImagePattern(image , 0.2 , 0.2 , 0.4 , 0.4 , true));
                }
            } else {
                comment_username.setText(commentSender);
                comment_firstLine.setText(commentContent);
                comment_secondLine.setText("");
                if(!(commentSenderPhoto.equalsIgnoreCase("nothing"))){
                    Image image = new Image(commentSenderPhoto);
                    comment_circle.setFill(new ImagePattern(image , 0.2 , 0.2 , 0.4 , 0.4 , true));
                }
            }
        }
    }

    public void showLikes(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MainPage_ShowLikesOfCommentsOfComments.fxml");
    }

    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MainPage_ShowComments.fxml");
    }

    public void newPost(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("NewPost.fxml");
    }

    public void messages(){

    }

    public void groups(){

    }

    public void searchOthers(){

    }

    public void myPage(){

    }

    public void settings(){

    }

    public void exit(){

    }



}
