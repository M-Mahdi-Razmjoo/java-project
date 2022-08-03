package com.example.phase2_main;

import com.example.phase2_main.repository.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class EditMessage_Controller {
    public static boolean beingPhoto;
    public static int messageID;
    public static String groupID;

    @FXML
    private TextField newMorP;

    public void edit(ActionEvent event) throws SQLException, IOException {
        Main main = new Main();
        if(beingPhoto){
            groupRepository.editPhoto(messageID , groupID , newMorP.getText() , Main.mainConnection);
            main.changeScene("MessagingInGroup.fxml");
        } else {
            groupRepository.editMessage(messageID , groupID , newMorP.getText() , Main.mainConnection);
            main.changeScene("MessagingInGroup.fxml");
        }
    }

    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MessagingInGroup.fxml");
    }

}
