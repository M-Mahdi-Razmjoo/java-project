package com.example.phase2_main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Settings_Controller {
    @FXML
    private TextField newPassword;
    @FXML
    private TextField newPhoto;
    @FXML
    private Label setting_warning;

    public void changePassword(ActionEvent event) throws SQLException {
        Statement statement = Main.mainConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM users");
        while(resultSet1.next()){
            if(resultSet1.getString("username").equals(Main.currentUser.getUsername())){
                resultSet1.updateString("password" , newPassword.getText());
                resultSet1.updateRow();
                setting_warning.setText("Password changed");
            }
        }
    }

    public void changePhoto(ActionEvent event) throws SQLException {
        Statement statement = Main.mainConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM users");
        while(resultSet1.next()){
            if(resultSet1.getString("username").equals(Main.currentUser.getUsername())){
                resultSet1.updateString("photoDirectory" , newPhoto.getText());
                resultSet1.updateRow();
                setting_warning.setText("Photo changed");
            }
        }
    }

    public void logout(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("LoginPage.fxml");
    }

}
