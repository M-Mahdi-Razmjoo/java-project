package com.example.phase2_main;

import com.example.phase2_main.repository.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class ReplyMessage_Controller {
    public static boolean beingPhoto;
    public static String groupID;
    public static int messageID;

    @FXML
    private TextField message;
    @FXML
    private Label message_warning;
    @FXML
    private TextField photo;
    @FXML
    private Label photo_warning;

    public void replyBYMessage(ActionEvent event) throws SQLException, IOException {
        Main main = new Main();
        if(beingPhoto){
            if(groupRepository.replyMessage_photo(groupID , messageID , photo.getText() , Main.mainConnection)){
                main.changeScene("MessagingInGroup.fxml");
            } else {
                message_warning.setText("You are ban in this group!");
            }
        } else {
            if(groupRepository.replyMessage_message(groupID , messageID , message.getText() , Main.mainConnection)){
                main.changeScene("MessagingInGroup.fxml");
            } else {
                message_warning.setText("You are ban in this group!");
            }
        }
    }

    public void replyByPhoto(ActionEvent event) throws SQLException, IOException {
        Main main = new Main();
        if(beingPhoto){
            if(groupRepository.replyPhoto_photo(groupID , messageID , photo.getText() , Main.mainConnection)){
                main.changeScene("MessagingInGroup.fxml");
            } else {
                message_warning.setText("You are ban in this group!");
            }
        } else {
            if(groupRepository.replyPhoto_message(groupID , messageID , message.getText() , Main.mainConnection)){
                main.changeScene("MessagingInGroup.fxml");
            } else {
                message_warning.setText("You are ban in this group!");
            }
        }
    }

    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MessagingInGroup.fxml");
    }

}
