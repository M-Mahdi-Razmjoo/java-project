package com.example.phase2_main;

import com.example.phase2_main.repository.followersRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class SearchOthersPage_Controller {
    public static boolean haveProfile = true ;
    public static String profilePhotoAddress;
    @FXML
    private TextField bioTextField;
    @FXML
    private TextField followersTextField;
    @FXML
    private TextField followingsTextField;
    @FXML
    private Button action;
    @FXML
    private Button message;
    @FXML
    private Button exit;
    @FXML
    private Label usernameLabel;
    @FXML
    private Circle profilePhoto;
    @FXML
    private Button search;
    @FXML
    private TextField SearchUsername;
    @FXML
    private Label WarningLabel;

    public void search(ActionEvent event) throws SQLException {
        Main main = new Main();
        WarningLabel.setText("");
        switch (followersRepository.followCheck(SearchUsername.getText(), main.mainConnection)) {
            case 222:
                WarningLabel.setText("you searched your own id ...");
                SearchUsername.clear();
                break;
            case 333:
                action.setText("follow");
                usernameLabel.setText(SearchUsername.getText());
                followersRepository.setFollowers(SearchUsername.getText(), main.mainConnection);
                followersTextField.setText(String.valueOf(followersRepository.followers.size()));
                followingsTextField.setText(String.valueOf(followersRepository.following.size()));
                bioTextField.setText(followersRepository.bio);
                if (haveProfile) {
                    Image image = new Image(profilePhotoAddress);
                    profilePhoto.setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                }else{
                    Image image = new Image("file:/E:/intellij IDEA/java-project/src/Images/person.png");
                    profilePhoto.setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                }
                break;
            case 444:
                WarningLabel.setText("USer not found ...");
                SearchUsername.clear();
                bioTextField.clear();
                followingsTextField.clear();
                followersTextField.clear();
                usernameLabel.setText("");
                break;
            case 555:
                action.setText("Unfollow");
                usernameLabel.setText(SearchUsername.getText());
                followersRepository.setFollowers(SearchUsername.getText(), main.mainConnection);
                followersTextField.setText(String.valueOf(followersRepository.followers.size()));
                followingsTextField.setText(String.valueOf(followersRepository.following.size()));
                bioTextField.setText(followersRepository.bio);
                if (haveProfile) {
                    Image image = new Image(profilePhotoAddress);
                    profilePhoto.setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                }else{
                    Image image = new Image("file:/E:/intellij IDEA/java-project/src/Images/person.png");
                    profilePhoto.setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                }
                break;
        }
    }

    public void actionN(ActionEvent event) throws SQLException {
        Main main = new Main();
        if(action.getText().equalsIgnoreCase("Follow")){
            if(!(usernameLabel.getText().equals(""))) {
                followersRepository.follow(SearchUsername.getText(), main.mainConnection);
                action.setText("unFollow");
                followersRepository.setFollowers(SearchUsername.getText() , main.mainConnection);
                followersTextField.setText(String.valueOf(followersRepository.followers.size()));
            }
        }else if(action.getText().equalsIgnoreCase("unFollow")){
            if(!(usernameLabel.getText().equals(""))) {
                followersRepository.unfollow(SearchUsername.getText(), main.mainConnection);
                action.setText("Follow");
                followersRepository.setFollowers(SearchUsername.getText() , main.mainConnection);
                followersTextField.setText(String.valueOf(followersRepository.followers.size()));
            }
        }
    }

    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        SearchUsername.clear();
        bioTextField.clear();
        followingsTextField.clear();
        followersTextField.clear();
        usernameLabel.setText("");
        //profilePhoto.setFill(Paint.valueOf("#000000"));
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