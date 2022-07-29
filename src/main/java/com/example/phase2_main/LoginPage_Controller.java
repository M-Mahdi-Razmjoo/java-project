package com.example.phase2_main;

import com.example.phase2_main.Main;
import com.example.phase2_main.repository.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class LoginPage_Controller {

    @FXML
    private TextField login_username;
    @FXML
    private PasswordField login_password;
    @FXML
    private Label login_warning;
    @FXML
    private TextField signup_username;
    @FXML
    private PasswordField signup_password;
    @FXML
    private PasswordField signup_confirmPassword;
    @FXML
    private TextField signup_bio;
    @FXML
    private TextField signup_securityQuestion;
    @FXML
    private Label signup_warning;
    @FXML
    private TextField login_forgetPassword_username;
    @FXML
    private TextField login_forgetPassword_securityQuestion;
    @FXML
    private Label login_forgetPassword_warning;
    @FXML
    private TextField signup_norc;
    @FXML
    private TextField signup_photoDirectory;



    public void login(ActionEvent event) throws SQLException {
        switch (userRepository.loginUser(login_username.getText() , login_password.getText() , Main.mainConnection)){
            case 3 :
                //بره به صفحه اصلی
                System.out.println("1");
                System.out.println("you logged in");
                break;
            case 33 :
                login_warning.setText("Password is wrong!");
                break;
            case 333 :
                login_warning.setText("There is no such user!");
                break;
        }
    }

    public void loginByForgetPassword(ActionEvent event) throws SQLException {
        switch (userRepository.forgetPassword(login_forgetPassword_username.getText() , Main.mainConnection , login_forgetPassword_securityQuestion.getText())){
            case 3 :
                //بره به صفحه اصلی
                System.out.println("2");
                break;
            case 33 :
                login_forgetPassword_warning.setText("Wrong answer!");
        }
    }

    public void signup(ActionEvent event) throws SQLException {
        if(signup_username.getText().length()<5){
            signup_warning.setText("Username must have at least 5 characters!");
        } else {
            if(signup_password.getText().length()<8){
                signup_warning.setText("Password must have at least 8 characters!");
            } else {
                if(!(signup_password.getText().equals(signup_confirmPassword))){
                    signup_warning.setText("Entered passwords are not the same!");
                } else {
                    if(!(signup_norc.getText().equalsIgnoreCase("normal") || signup_norc.getText().equalsIgnoreCase("commercial"))){
                        signup_warning.setText("Choose only one of Normal and Commercial");
                    } else {
                        if(signup_norc.getText().equalsIgnoreCase("commercial")){
                            Main.IsCommercial=true;
                        }
                        if(signup_bio.getText().equals("")){
                            signup_warning.setText("Write a short summary about yourself in bio.");
                        } else {
                            if(signup_securityQuestion.getText().equals("")){
                                signup_warning.setText("You must answer to security question.");
                            } else {
                                switch (userRepository.signupUser(Main.mainConnection , signup_username.getText() , signup_password.getText() , signup_securityQuestion.getText() , signup_bio.getText())){
                                    case 3 :
                                        //بره صفحه اصلی
                                        System.out.println("3");
                                        break;
                                    case 33 :
                                        signup_warning.setText("This username isn't available!");
                                        break;
                                    case 333 :

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
