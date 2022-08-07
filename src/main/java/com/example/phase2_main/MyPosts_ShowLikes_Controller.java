package com.example.phase2_main;

import com.example.phase2_main.repository.likeRepository;
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

public class MyPosts_ShowLikes_Controller implements Initializable {
    public static ArrayList<String> likers;

    @FXML
    private TreeView comment_likes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> rootItem = new TreeItem<>("likers");

        try {
            likers= likeRepository.showLikesOfPost(MyPosts_Controller.sender , MyPosts_Controller.content , Main.mainConnection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(int i=0 ; i<likers.size() ; i++){
            try{
                TreeItem<String> branchItem = new TreeItem<>(likers.get(i));
                rootItem.getChildren().add(branchItem);
            } catch (NullPointerException e){

            }
        }
        if(comment_likes != null){
            comment_likes.setRoot(rootItem);
            comment_likes.setShowRoot(false);
        }
    }

    public void back (ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MyPosts.fxml");
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
