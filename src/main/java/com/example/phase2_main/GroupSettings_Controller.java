package com.example.phase2_main;

import com.example.phase2_main.repository.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class GroupSettings_Controller {
    @FXML
    private TextField groupName;
    @FXML
    private TextField groupID;
    @FXML
    private TextField memberID;
    @FXML
    private Label setting_warning;

    public void changeGroupName(ActionEvent event) throws SQLException {
        if(groupName.getText().equalsIgnoreCase("")){
            setting_warning.setText("You must enter at least one character!");
        } else {
            groupRepository.changeGroupName(MessagingInGroup_Controller.groupID , groupName.getText() , Main.mainConnection);
            MessagingInGroup_Controller.groupName=groupName.getText();
            setting_warning.setText("Changing the group name was successful");
            groupName.clear();
        }
    }

    public void changeGroupID(ActionEvent event) throws SQLException {
        if(groupID.getText().equalsIgnoreCase("")){
            setting_warning.setText("You must enter at least one character!");
        } else {
            if(groupID.getText().startsWith("@")){
                if(groupRepository.IdAvailability(groupID.getText() , Main.mainConnection)){
                    groupRepository.changeGroupID(groupID.getText() , MessagingInGroup_Controller.groupID , Main.mainConnection);
                    MessagingInGroup_Controller.groupID=groupID.getText();
                    setting_warning.setText("Changing the group ID was successful");
                    groupName.clear();
                } else {
                    setting_warning.setText("This username is not available");
                }
            } else {
                setting_warning.setText("Username must start with @");
            }
        }
    }

    public void addMember(ActionEvent event) throws SQLException {
        if(memberID.getText().equalsIgnoreCase("")){
            setting_warning.setText("You must enter at least one character!");
        } else {
            if(groupRepository.addMember(memberID.getText() , MessagingInGroup_Controller.groupID , Main.mainConnection)==1){
                setting_warning.setText("Adding member was successful");
                memberID.clear();
            } else if(groupRepository.addMember(memberID.getText() , MessagingInGroup_Controller.groupID , Main.mainConnection)==2){
                setting_warning.setText("The username is a member of group!");
            } else if(groupRepository.addMember(memberID.getText() , MessagingInGroup_Controller.groupID , Main.mainConnection)==3){
                setting_warning.setText("There is no such a username!");
            }
        }
    }

    public void removeMember(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("RemoveMember.fxml");
    }

    public void banMember(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("BanMember.fxml");
    }

    public void adminSetting(ActionEvent event){

    }

    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MessagingInGroup.fxml");
    }

}
