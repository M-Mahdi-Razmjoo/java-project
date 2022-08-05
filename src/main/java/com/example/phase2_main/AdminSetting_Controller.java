package com.example.phase2_main;

import com.example.phase2_main.repository.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class AdminSetting_Controller {
    @FXML
    private TextField firstUsername;
    @FXML
    private TextField secondUsername;
    @FXML
    private TextField thirdUsername;
    @FXML
    private Label admin_warning;

    public void setFirstAdmin(ActionEvent event) throws SQLException {
        if(firstUsername.getText().equalsIgnoreCase("")){
            admin_warning.setText("You must enter at least one character!");
        } else {
            if(groupRepository.setAdmin("admin1" , firstUsername.getText() , MessagingInGroup_Controller.groupID , Main.mainConnection)){
                admin_warning.setText("Admin 1 has been set successfully");
            } else {
                admin_warning.setText("There is no such a username in this group!");
            }
        }
    }

    public void setSecondAdmin(ActionEvent event) throws SQLException {
        if(secondUsername.getText().equalsIgnoreCase("")){
            admin_warning.setText("You must enter at least one character!");
        } else {
            if(groupRepository.setAdmin("admin2" , secondUsername.getText() , MessagingInGroup_Controller.groupID , Main.mainConnection)){
                admin_warning.setText("Admin 2 has been set successfully");
            } else {
                admin_warning.setText("There is no such a username in this group!");
            }
        }
    }

    public void setThirdAdmin(ActionEvent event) throws SQLException {
        if(thirdUsername.getText().equalsIgnoreCase("")){
            admin_warning.setText("You must enter at least one character!");
        } else {
            if(groupRepository.setAdmin("admin3" , thirdUsername.getText() , MessagingInGroup_Controller.groupID , Main.mainConnection)){
                admin_warning.setText("Admin 3 has been set successfully");
            } else {
                admin_warning.setText("There is no such a username in this group!");
            }
        }
    }

    public void removeFirstAdmin(ActionEvent event) throws SQLException {
        groupRepository.removeAdmin("admin1" , MessagingInGroup_Controller.groupID , Main.mainConnection);
    }

    public void removeSecondAdmin(ActionEvent event) throws SQLException {
        groupRepository.removeAdmin("admin2" , MessagingInGroup_Controller.groupID , Main.mainConnection);
    }

    public void removeThirdAdmin(ActionEvent event) throws SQLException {
        groupRepository.removeAdmin("admin3" , MessagingInGroup_Controller.groupID , Main.mainConnection);
    }

    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("GroupSettings.fxml");
    }

}
