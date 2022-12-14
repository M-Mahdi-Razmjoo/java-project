package com.example.phase2_main;

import com.example.phase2_main.repository.likeRepository;
import com.example.phase2_main.repository.postRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyPosts_Controller implements Initializable {
    public static int postCounter;//newest post
    public static String content;
    public static String sender;
    public static String senderPhoto;
    public static String fileAddress;//ادرس عکس پیام طرف

    public static boolean checkPost=false;//این در زمانی که هیچ پستی برای نمایش وجود نداره به ما کمک میکنه

    @FXML
    private Label mainPage_username;
    @FXML
    private Label mainPage_firstLine = new Label();
    @FXML
    private Label mainPage_secondLine;
    @FXML
    private Label mainPage_thirdLine;
    @FXML
    private TextField mainPage_comment;
    @FXML
    private Circle circle_photo;
    @FXML
    private ImageView mainPage_messageImage;
    @FXML
    private Label mainPage_warning;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            postCounter=1;
            postRepository.showMyPosts(Main.currentUser.getUsername() , postCounter , Main.mainConnection);
            if(checkPost){
                if(content.length()>60) {
                    if (content.length() > 120) {
                        mainPage_firstLine.setText(content.substring(0, 61));
                        mainPage_secondLine.setText(content.substring(61, 121));
                        mainPage_thirdLine.setText(content.substring(121, content.length()));
                        mainPage_username.setText(sender);
                        if (!(senderPhoto.equalsIgnoreCase("nothing"))) {
                            Image image = new Image(senderPhoto);
                            circle_photo.setFill(new ImagePattern(image, 0, 0, 1, 1, true));
                        }
                        if (!(fileAddress.equalsIgnoreCase("nothing"))) {
                            Image image = new Image(fileAddress);
                            mainPage_messageImage.setImage(image);
                        }
                    } else {
                        mainPage_firstLine.setText(content.substring(0, 61));
                        mainPage_secondLine.setText(content.substring(61, content.length()));
                        mainPage_username.setText(sender);
                        if (!(senderPhoto.equalsIgnoreCase("nothing"))) {
                            Image image = new Image(senderPhoto);
                            circle_photo.setFill(new ImagePattern(image, 0, 0, 1, 1, true));
                        }
                        if (!(fileAddress.equalsIgnoreCase("nothing"))) {
                            Image image = new Image(fileAddress);
                            mainPage_messageImage.setImage(image);
                        }
                    }
                } else if(!(content.equalsIgnoreCase(""))) {
                    mainPage_firstLine.setText(content);
                    mainPage_username.setText(sender);
                    if(!(senderPhoto.equalsIgnoreCase("nothing"))){
                        Image image = new Image(senderPhoto);
                        circle_photo.setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                    }
                    if(!(fileAddress.equalsIgnoreCase("nothing"))){
                        Image image = new Image(fileAddress);
                        mainPage_messageImage.setImage(image);
                    }
                }
            } else {
                mainPage_firstLine.setText("No Post!");
                Image image = new Image("file:/E:/University/term2/OOP/Project_Main/src/Images/person.png");
                circle_photo.setFill(new ImagePattern(image , 0, 0, 1, 1, true));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void comment(ActionEvent event) throws SQLException {
        if(mainPage_comment.getText().equalsIgnoreCase("")){
            mainPage_warning.setText("Comment field is empty!");
        } else {
            mainPage_warning.setText("");
            postRepository.commentOnAPost(sender , content , fileAddress , mainPage_comment.getText() , Main.mainConnection);
        }
    }

    public void nextPost(ActionEvent event) throws SQLException {
        if(postCounter>1){
            postCounter--;
            postRepository.showMyPosts(Main.currentUser.getUsername() , postCounter , Main.mainConnection);
            if(checkPost){
                if(content.length()>60) {
                    if (content.length() > 120) {
                        mainPage_firstLine.setText(content.substring(0, 61));
                        mainPage_secondLine.setText(content.substring(61, 121));
                        mainPage_thirdLine.setText(content.substring(121, content.length()));
                        mainPage_username.setText(sender);
                        if (!(senderPhoto.equalsIgnoreCase("nothing"))) {
                            Image image = new Image(senderPhoto);
                            circle_photo.setFill(new ImagePattern(image, 0, 0, 1, 1, true));
                        }
                        if (!(fileAddress.equalsIgnoreCase("nothing"))) {
                            Image image = new Image(fileAddress);
                            mainPage_messageImage.setImage(image);
                        }
                    } else {
                        mainPage_firstLine.setText(content.substring(0, 61));
                        mainPage_secondLine.setText(content.substring(61, content.length()));
                        mainPage_username.setText(sender);
                        if (!(senderPhoto.equalsIgnoreCase("nothing"))) {
                            Image image = new Image(senderPhoto);
                            circle_photo.setFill(new ImagePattern(image, 0, 0, 1, 1, true));
                        }
                        if (!(fileAddress.equalsIgnoreCase("nothing"))) {
                            Image image = new Image(fileAddress);
                            mainPage_messageImage.setImage(image);
                        }
                    }
                } else if(!(content.equalsIgnoreCase(""))) {
                    mainPage_firstLine.setText(content);
                    mainPage_username.setText(sender);
                    if(!(senderPhoto.equalsIgnoreCase("nothing"))){
                        Image image = new Image(senderPhoto);
                        circle_photo.setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                    }
                    if(!(fileAddress.equalsIgnoreCase("nothing"))){
                        Image image = new Image(fileAddress);
                        mainPage_messageImage.setImage(image);
                    }
                }
            } else {
                mainPage_firstLine.setText("No Post!");
                Image image = new Image("file:/E:/University/term2/OOP/Project_Main/src/Images/person.png");
                circle_photo.setFill(new ImagePattern(image , 0, 0, 1, 1, true));
            }
        }
    }

    public void previousPost(ActionEvent event) throws SQLException, IOException {
        if(postRepository.postCounter(Main.currentUser.getUsername() , Main.mainConnection)>postCounter){
            //System.out.println(postRepository.postCounter(Main.currentUser.getUsername() , Main.mainConnection));
            postCounter++;
            postRepository.showMyPosts(Main.currentUser.getUsername() , postCounter , Main.mainConnection);
            if(checkPost){
                if(content.length()>60) {
                    if (content.length() > 120) {
                        mainPage_firstLine.setText(content.substring(0, 61));
                        mainPage_secondLine.setText(content.substring(61, 121));
                        mainPage_thirdLine.setText(content.substring(121, content.length()));
                        mainPage_username.setText(sender);
                        if (!(senderPhoto.equalsIgnoreCase("nothing"))) {
                            Image image = new Image(senderPhoto);
                            circle_photo.setFill(new ImagePattern(image, 0, 0, 1, 1, true));
                        }
                        if (!(fileAddress.equalsIgnoreCase("nothing"))) {
                            Image image = new Image(fileAddress);
                            mainPage_messageImage.setImage(image);
                        }
                    } else {
                        mainPage_firstLine.setText(content.substring(0, 61));
                        mainPage_secondLine.setText(content.substring(61, content.length()));
                        mainPage_username.setText(sender);
                        if (!(senderPhoto.equalsIgnoreCase("nothing"))) {
                            Image image = new Image(senderPhoto);
                            circle_photo.setFill(new ImagePattern(image, 0, 0, 1, 1, true));
                        }
                        if (!(fileAddress.equalsIgnoreCase("nothing"))) {
                            Image image = new Image(fileAddress);
                            mainPage_messageImage.setImage(image);
                        }
                    }
                } else if(!(content.equalsIgnoreCase(""))) {
                    mainPage_firstLine.setText(content);
                    mainPage_username.setText(sender);
                    if(!(senderPhoto.equalsIgnoreCase("nothing"))){
                        Image image = new Image(senderPhoto);
                        circle_photo.setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                    }
                    if(!(fileAddress.equalsIgnoreCase("nothing"))){
                        Image image = new Image(fileAddress);
                        mainPage_messageImage.setImage(image);
                    }
                }
            } else {
                mainPage_firstLine.setText("No Post!");
                Image image = new Image("file:/E:/University/term2/OOP/Project_Main/src/Images/person.png");
                circle_photo.setFill(new ImagePattern(image , 0, 0, 1, 1, true));
            }
        }
    }

    public void showComments(ActionEvent event) throws SQLException, IOException {
        Main main = new Main();
        if(postRepository.commentCounter(sender , content , Main.mainConnection)==0){
            mainPage_warning.setText("This post has no comments!");
        } else {
            main.changeScene("MyPosts_ShowComments.fxml");
        }
    }

    public void showLikes(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MyPosts_ShowLikes.fxml");
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
