package com.example.phase2_main;

import com.example.phase2_main.repository.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MessagingInGroup_Controller implements Initializable {
    public static String groupName;
    public static String groupID;
    public static String []beingPhoto = new String[5];
    public static String []sender = new String[5];
    public static String []content = new String[5];
    public static String []photoDirectory = new String[5];
    public static String []replyToSender = new String[5];
    public static String []replyToMessage = new String[5];
    public static String []beingForwarded = new String[5];
    public static String []forwardedFrom = new String[5];
    public static String []beingEdited = new String[5];
    public static String []date = new String[5];
    public static String []time = new String[5];
    public static int []messageID = new int[5];



    @FXML
    private TextField photoDirectoryy;//چون یه ارایه با این اسم داریم
    @FXML
    private TextField newMessage;
    @FXML
    private Label message_warning;

    @FXML
    private Label first_firstLine;
    @FXML
    private Label first_secondLine;
    @FXML
    private Circle first_leftCircle;
    @FXML
    private Circle first_rightCircle;
    @FXML
    private Label first_date_left;
    @FXML
    private Label first_time_left;
    @FXML
    private Label first_date_right;
    @FXML
    private Label first_time_right;

    @FXML
    private Label second_firstLine;
    @FXML
    private Label second_secondLine;
    @FXML
    private Circle second_leftCircle;
    @FXML
    private Circle second_rightCircle;
    @FXML
    private Label second_date_left;
    @FXML
    private Label second_time_left;
    @FXML
    private Label second_date_right;
    @FXML
    private Label second_time_right;

    @FXML
    private Label third_firstLine;
    @FXML
    private Label third_secondLine;
    @FXML
    private Circle third_leftCircle;
    @FXML
    private Circle third_rightCircle;
    @FXML
    private Label third_date_left;
    @FXML
    private Label third_time_left;
    @FXML
    private Label third_date_right;
    @FXML
    private Label third_time_right;

    @FXML
    private Label fourth_firstLine;
    @FXML
    private Label fourth_secondLine;
    @FXML
    private Circle fourth_leftCircle;
    @FXML
    private Circle fourth_rightCircle;
    @FXML
    private Label fourth_date_left;
    @FXML
    private Label fourth_time_left;
    @FXML
    private Label fourth_date_right;
    @FXML
    private Label fourth_time_right;

    @FXML
    private Label fifth_firstLine;
    @FXML
    private Label fifth_secondLine;
    @FXML
    private Circle fifth_leftCircle;
    @FXML
    private Circle fifth_rightCircle;
    @FXML
    private Label fifth_date_left;
    @FXML
    private Label fifth_time_left;
    @FXML
    private Label fifth_date_right;
    @FXML
    private Label fifth_time_right;

    @FXML
    private ImageView first_leftImage;
    @FXML
    private ImageView first_rightImage;
    @FXML
    private ImageView second_leftImage;
    @FXML
    private ImageView second_rightImage;
    @FXML
    private ImageView third_leftImage;
    @FXML
    private ImageView third_rightImage;
    @FXML
    private ImageView fourth_leftImage;
    @FXML
    private ImageView fourth_rightImage;
    @FXML
    private ImageView fifth_leftImage;
    @FXML
    private ImageView fifth_rightImage;

    @FXML
    private Button reply_first;
    @FXML
    private Button forward_first;
    @FXML
    private Button edit_first;
    @FXML
    private Button delete_first;
    @FXML
    private Button reply_second;
    @FXML
    private Button forward_second;
    @FXML
    private Button edit_second;
    @FXML
    private Button delete_second;
    @FXML
    private Button reply_third;
    @FXML
    private Button forward_third;
    @FXML
    private Button edit_third;
    @FXML
    private Button delete_third;
    @FXML
    private Button reply_fourth;
    @FXML
    private Button forward_fourth;
    @FXML
    private Button edit_fourth;
    @FXML
    private Button delete_fourth;
    @FXML
    private Button reply_fifth;
    @FXML
    private Button forward_fifth;
    @FXML
    private Button edit_fifth;
    @FXML
    private Button delete_fifth;

    @FXML
    private Label memberNumber;
    @FXML
    private Label group_name;
    @FXML
    private Circle groupImage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        group_name.setText(groupName);
        try {
            memberNumber.setText(String.valueOf(groupRepository.memberCounter(groupID , Main.mainConnection))+" members");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (!(groupRepository.findGroupPhoto(groupID , Main.mainConnection).equalsIgnoreCase("nothing"))) {
                Image image = new Image(groupRepository.findGroupPhoto(groupID , Main.mainConnection));
                groupImage.setFill(new ImagePattern(image, 0, 0, 1, 1, true));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Label> labels_line = new ArrayList<>(Arrays.asList(first_firstLine , first_secondLine , second_firstLine , second_secondLine , third_firstLine , third_secondLine , fourth_firstLine , fourth_secondLine , fifth_firstLine , fifth_secondLine));
        ArrayList<Circle> circles_photo = new ArrayList<>(Arrays.asList(first_leftCircle , first_rightCircle , second_leftCircle , second_rightCircle , third_leftCircle , third_rightCircle , fourth_leftCircle , fourth_rightCircle , fifth_leftCircle , fifth_rightCircle));
        ArrayList<Label> labels_date = new ArrayList<>(Arrays.asList(first_date_left , first_date_right , second_date_left , second_date_right , third_date_left , third_date_right , fourth_date_left , fourth_date_right , fifth_date_left , fifth_date_right));
        ArrayList<Label> labels_time = new ArrayList<>(Arrays.asList(first_time_left , first_time_right , second_time_left , second_time_right , third_time_left , third_time_right , fourth_time_left , fourth_time_right , fifth_time_left , fifth_time_right));
        ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(first_leftImage , first_rightImage , second_leftImage , second_rightImage , third_leftImage , third_rightImage , fourth_leftImage , fourth_rightImage , fifth_leftImage , fifth_rightImage));
        ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(reply_first , forward_first , edit_first , delete_first ,
                reply_second , forward_second , edit_second , delete_second ,
                reply_third , forward_third , edit_third , delete_third ,
                reply_fourth , forward_fourth , edit_fourth , delete_fourth ,
                reply_fifth , forward_fifth , edit_fifth , delete_fifth));

        try {
            groupRepository.showMessages(groupID , Main.mainConnection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int arrayListCounter=0;
        int mainCounter=0;

        if(sender[0]==null){
            mainCounter=0;
            for(int i=0 ; i<10 ; i++){
                circles_photo.get(i).setVisible(false);
                imageViews.get(i).setVisible(false);
            }
            for(int i=0 ; i<20 ; i++){
                buttons.get(i).setVisible(false);
            }
        } else if(sender[1]==null){
            mainCounter=1;
            for(int i=2 ; i<10 ; i++){
                circles_photo.get(i).setVisible(false);
                imageViews.get(i).setVisible(false);
            }
            for(int i=4 ; i<20 ; i++){
                buttons.get(i).setVisible(false);
            }
        } else if (sender[2]==null){
            mainCounter=2;
            for(int i=4 ; i<10 ; i++){
                circles_photo.get(i).setVisible(false);
                imageViews.get(i).setVisible(false);
            }
            for(int i=8 ; i<20 ; i++){
                buttons.get(i).setVisible(false);
            }
        } else if(sender[3]==null){
            mainCounter=3;
            for(int i=6 ; i<10 ; i++){
                circles_photo.get(i).setVisible(false);
                imageViews.get(i).setVisible(false);
            }
            for(int i=12 ; i<20 ; i++){
                buttons.get(i).setVisible(false);
            }
        } else if(sender[4]==null){
            mainCounter=4;
            for(int i=8 ; i<10 ; i++){
                circles_photo.get(i).setVisible(false);
                imageViews.get(i).setVisible(false);
            }
            for(int i=16 ; i<20 ; i++){
                buttons.get(i).setVisible(false);
            }
        } else {
            mainCounter=5;
        }

        for(int i=0 ; i<mainCounter ; i++){
            if(replyToSender[i].equalsIgnoreCase("nothing")){
                if(beingPhoto[i].equalsIgnoreCase("yes")){
                    if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                        labels_line.get(arrayListCounter).setText("");
                        labels_line.get(arrayListCounter+1).setText("");
                        circles_photo.get(arrayListCounter).setVisible(false);
                        Image image = null;
                        try {
                            image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                        labels_date.get(arrayListCounter).setText(date[i]);
                        labels_date.get(arrayListCounter+1).setText("");
                        labels_time.get(arrayListCounter).setText(time[i]);
                        labels_time.get(arrayListCounter+1).setText("");
                        Image image2 = new Image(photoDirectory[i] , 100 , 100 , false , false);
                        imageViews.get(arrayListCounter).setVisible(false);
                        imageViews.get(arrayListCounter+1).setImage(image2);

                        labels_line.get(arrayListCounter+2).setText("");
                        labels_line.get(arrayListCounter+3).setText("");
                        circles_photo.get(arrayListCounter+2).setVisible(false);
                        circles_photo.get(arrayListCounter+3).setVisible(false);
                        labels_date.get(arrayListCounter+2).setText("");
                        labels_date.get(arrayListCounter+3).setText("");
                        labels_time.get(arrayListCounter+2).setText("");
                        labels_time.get(arrayListCounter+3).setText("");
                        imageViews.get(arrayListCounter+2).setVisible(false);
                        imageViews.get(arrayListCounter+3).setVisible(false);
                        buttons.get(4*arrayListCounter+4).setVisible(false);
                        buttons.get(4*arrayListCounter+5).setVisible(false);
                        buttons.get(4*arrayListCounter+6).setVisible(false);
                        buttons.get(4*arrayListCounter+7).setVisible(false);
                        arrayListCounter+=4;//***
                        i++;
                    } else {
                        labels_line.get(arrayListCounter).setText("");
                        labels_line.get(arrayListCounter+1).setText("");
                        Image image = null;
                        try {
                            image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                        circles_photo.get(arrayListCounter+1).setVisible(false);
                        labels_date.get(arrayListCounter).setText("");
                        labels_date.get(arrayListCounter+1).setText(date[i]);
                        labels_time.get(arrayListCounter).setText("");
                        labels_time.get(arrayListCounter+1).setText(time[i]);
                        Image image2 = new Image(photoDirectory[i] , 100 , 100 , false , false);
                        imageViews.get(arrayListCounter).setImage(image2);
                        imageViews.get(arrayListCounter+1).setVisible(false);

                        labels_line.get(arrayListCounter+2).setText("");
                        labels_line.get(arrayListCounter+3).setText("");
                        circles_photo.get(arrayListCounter+2).setVisible(false);
                        circles_photo.get(arrayListCounter+3).setVisible(false);
                        labels_date.get(arrayListCounter+2).setText("");
                        labels_date.get(arrayListCounter+3).setText("");
                        labels_time.get(arrayListCounter+2).setText("");
                        labels_time.get(arrayListCounter+3).setText("");
                        imageViews.get(arrayListCounter+2).setVisible(false);
                        imageViews.get(arrayListCounter+3).setVisible(false);
                        buttons.get(4*arrayListCounter+4).setVisible(false);
                        buttons.get(4*arrayListCounter+5).setVisible(false);
                        buttons.get(4*arrayListCounter+6).setVisible(false);
                        buttons.get(4*arrayListCounter+7).setVisible(false);
                        arrayListCounter+=4;//***
                        i++;
                    }
                } else {
                    if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                        if(content[i].length()>57){
                            labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                            labels_line.get(arrayListCounter).setAlignment(Pos.BASELINE_RIGHT);
                            labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                            labels_line.get(arrayListCounter+1).setAlignment(Pos.BASELINE_RIGHT);
                            circles_photo.get(arrayListCounter).setVisible(false);
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            labels_date.get(arrayListCounter).setText(date[i]);
                            if(beingEdited[i].equalsIgnoreCase("yes")){
                                labels_date.get(arrayListCounter+1).setText("edited");
                            } else {
                                labels_date.get(arrayListCounter+1).setText("");
                            }
                            labels_time.get(arrayListCounter).setText(time[i]);
                            if(beingForwarded[i].equalsIgnoreCase("yes")){
                                labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                            } else {
                                labels_time.get(arrayListCounter+1).setText("");
                            }
                            imageViews.get(arrayListCounter).setVisible(false);
                            imageViews.get(arrayListCounter+1).setVisible(false);
                            arrayListCounter+=2;
                        } else {
                            labels_line.get(arrayListCounter).setText("");
                            labels_line.get(arrayListCounter+1).setText(content[i]);
                            labels_line.get(arrayListCounter+1).setAlignment(Pos.BASELINE_RIGHT);
                            circles_photo.get(arrayListCounter).setVisible(false);
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            labels_date.get(arrayListCounter).setText(date[i]);
                            if(beingEdited[i].equalsIgnoreCase("yes")){
                                labels_date.get(arrayListCounter+1).setText("edited");
                            } else {
                                labels_date.get(arrayListCounter+1).setText("");
                            }
                            labels_time.get(arrayListCounter).setText(time[i]);
                            if(beingForwarded[i].equalsIgnoreCase("yes")){
                                labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                            } else {
                                labels_time.get(arrayListCounter+1).setText("");
                            }
                            imageViews.get(arrayListCounter).setVisible(false);
                            imageViews.get(arrayListCounter+1).setVisible(false);
                            arrayListCounter+=2;
                        }
                    } else {
                        if(content[i].length()>57){
                            labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                            labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            circles_photo.get(arrayListCounter+1).setVisible(false);
                            if(beingEdited[i].equalsIgnoreCase("yes")){
                                labels_date.get(arrayListCounter).setText("edited");
                            } else {
                                labels_date.get(arrayListCounter).setText("");
                            }
                            labels_date.get(arrayListCounter+1).setText(date[i]);
                            if(beingForwarded[i].equalsIgnoreCase("yes")){
                                labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                            } else {
                                labels_time.get(arrayListCounter).setText("");
                            }
                            labels_time.get(arrayListCounter+1).setText(time[i]);
                            imageViews.get(arrayListCounter).setVisible(false);
                            imageViews.get(arrayListCounter+1).setVisible(false);
                            arrayListCounter+=2;
                        } else {
                            labels_line.get(arrayListCounter).setText("");
                            labels_line.get(arrayListCounter+1).setText(content[i]);
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            circles_photo.get(arrayListCounter+1).setVisible(false);
                            if(beingEdited[i].equalsIgnoreCase("yes")){
                                labels_date.get(arrayListCounter).setText("edited");
                            } else {
                                labels_date.get(arrayListCounter).setText("");
                            }
                            labels_date.get(arrayListCounter+1).setText(date[i]);
                            if(beingForwarded[i].equalsIgnoreCase("yes")){
                                labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                            } else {
                                labels_time.get(arrayListCounter).setText("");
                            }
                            labels_time.get(arrayListCounter+1).setText(time[i]);
                            imageViews.get(arrayListCounter).setVisible(false);
                            imageViews.get(arrayListCounter+1).setVisible(false);
                            arrayListCounter+=2;
                        }
                    }
                }
            }

            else {
                if(beingPhoto[i].equalsIgnoreCase("yes")){
                    if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                        labels_line.get(arrayListCounter).setText("");
                        labels_line.get(arrayListCounter+1).setText("");
                        circles_photo.get(arrayListCounter).setVisible(false);
                        Image image = null;
                        try {
                            image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                        labels_date.get(arrayListCounter).setText(date[i]);
                        labels_date.get(arrayListCounter+1).setText("");
                        labels_time.get(arrayListCounter).setText(time[i]);
                        labels_time.get(arrayListCounter+1).setText("");
                        Image image2 = new Image(photoDirectory[i], 100 , 100 , false , false);
                        imageViews.get(arrayListCounter).setVisible(false);
                        imageViews.get(arrayListCounter+1).setImage(image2);

                        int countSpaces=24-replyToSender[i].length();
                        String string="│";
                        for(int j=0 ; j<countSpaces ; j++){
                            string+=" ";
                        }
                        labels_line.get(arrayListCounter+2).setText(string+"reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                        labels_line.get(arrayListCounter+3).setText("");
                        circles_photo.get(arrayListCounter+2).setVisible(false);
                        circles_photo.get(arrayListCounter+3).setVisible(false);
                        labels_date.get(arrayListCounter+2).setText("");
                        labels_date.get(arrayListCounter+3).setText("");
                        labels_time.get(arrayListCounter+2).setText("");
                        labels_time.get(arrayListCounter+3).setText("");
                        imageViews.get(arrayListCounter+2).setVisible(false);
                        imageViews.get(arrayListCounter+3).setVisible(false);
                        buttons.get(4*arrayListCounter+4).setVisible(false);
                        buttons.get(4*arrayListCounter+5).setVisible(false);
                        buttons.get(4*arrayListCounter+6).setVisible(false);
                        buttons.get(4*arrayListCounter+7).setVisible(false);
                        arrayListCounter+=4;//***
                        i++;
                    } else {
                        labels_line.get(arrayListCounter).setText("");
                        labels_line.get(arrayListCounter+1).setText("");
                        Image image = null;
                        try {
                            image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                        circles_photo.get(arrayListCounter+1).setVisible(false);
                        labels_date.get(arrayListCounter).setText("");
                        labels_date.get(arrayListCounter+1).setText(date[i]);
                        labels_time.get(arrayListCounter).setText("");
                        labels_time.get(arrayListCounter+1).setText(time[i]);
                        Image image2 = new Image(photoDirectory[i], 100 , 100 , false , false);
                        imageViews.get(arrayListCounter).setImage(image2);
                        imageViews.get(arrayListCounter+1).setVisible(false);

                        labels_line.get(arrayListCounter+2).setText("           │reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                        labels_line.get(arrayListCounter+3).setText("");
                        circles_photo.get(arrayListCounter+2).setVisible(false);
                        circles_photo.get(arrayListCounter+3).setVisible(false);
                        labels_date.get(arrayListCounter+2).setText("");
                        labels_date.get(arrayListCounter+3).setText("");
                        labels_time.get(arrayListCounter+2).setText("");
                        labels_time.get(arrayListCounter+3).setText("");
                        imageViews.get(arrayListCounter+2).setVisible(false);
                        imageViews.get(arrayListCounter+3).setVisible(false);
                        buttons.get(4*arrayListCounter+4).setVisible(false);
                        buttons.get(4*arrayListCounter+5).setVisible(false);
                        buttons.get(4*arrayListCounter+6).setVisible(false);
                        buttons.get(4*arrayListCounter+7).setVisible(false);
                        arrayListCounter+=4;//***
                        i++;
                    }
                } else {
                    if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                        if(content[i].length()>57){
                            labels_line.get(arrayListCounter).setText("│reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                            labels_line.get(arrayListCounter).setAlignment(Pos.BASELINE_RIGHT);
                            labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                            labels_line.get(arrayListCounter+1).setAlignment(Pos.BASELINE_RIGHT);
                            circles_photo.get(arrayListCounter).setVisible(false);
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            labels_date.get(arrayListCounter).setText(date[i]);
                            if(beingEdited[i].equalsIgnoreCase("yes")){
                                labels_date.get(arrayListCounter+1).setText("edited");
                            } else {
                                labels_date.get(arrayListCounter+1).setText("");
                            }
                            labels_time.get(arrayListCounter).setText(time[i]);
                            if(beingForwarded[i].equalsIgnoreCase("yes")){
                                labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                            } else {
                                labels_time.get(arrayListCounter+1).setText("");
                            }
                            imageViews.get(arrayListCounter).setVisible(false);
                            imageViews.get(arrayListCounter+1).setVisible(false);
                            arrayListCounter+=2;
                        } else {
                            labels_line.get(arrayListCounter).setText("│reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                            labels_line.get(arrayListCounter).setAlignment(Pos.BASELINE_RIGHT);
                            labels_line.get(arrayListCounter+1).setText(content[i]);
                            labels_line.get(arrayListCounter+1).setAlignment(Pos.BASELINE_RIGHT);
                            circles_photo.get(arrayListCounter).setVisible(false);
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            labels_date.get(arrayListCounter).setText(date[i]);
                            if(beingEdited[i].equalsIgnoreCase("yes")){
                                labels_date.get(arrayListCounter+1).setText("edited");
                            } else {
                                labels_date.get(arrayListCounter+1).setText("");
                            }
                            labels_time.get(arrayListCounter).setText(time[i]);
                            if(beingForwarded[i].equalsIgnoreCase("yes")){
                                labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                            } else {
                                labels_time.get(arrayListCounter+1).setText("");
                            }
                            imageViews.get(arrayListCounter).setVisible(false);
                            imageViews.get(arrayListCounter+1).setVisible(false);
                            arrayListCounter+=2;
                        }
                    } else {
                        if(content[i].length()>57){
                            labels_line.get(arrayListCounter).setText("│reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                            labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            circles_photo.get(arrayListCounter+1).setVisible(false);
                            if(beingEdited[i].equalsIgnoreCase("yes")){
                                labels_date.get(arrayListCounter).setText("edited");
                            } else {
                                labels_date.get(arrayListCounter).setText("");
                            }
                            labels_date.get(arrayListCounter+1).setText(date[i]);
                            if(beingForwarded[i].equalsIgnoreCase("yes")){
                                labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                            } else {
                                labels_time.get(arrayListCounter).setText("");
                            }
                            labels_time.get(arrayListCounter+1).setText(time[i]);
                            imageViews.get(arrayListCounter).setVisible(false);
                            imageViews.get(arrayListCounter+1).setVisible(false);
                            arrayListCounter+=2;
                        } else {
                            labels_line.get(arrayListCounter).setText("│reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                            labels_line.get(arrayListCounter+1).setText(content[i]);
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            circles_photo.get(arrayListCounter+1).setVisible(false);
                            if(beingEdited[i].equalsIgnoreCase("yes")){
                                labels_date.get(arrayListCounter).setText("edited");
                            } else {
                                labels_date.get(arrayListCounter).setText("");
                            }
                            labels_date.get(arrayListCounter+1).setText(date[i]);
                            if(beingForwarded[i].equalsIgnoreCase("yes")){
                                labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                            } else {
                                labels_time.get(arrayListCounter).setText("");
                            }
                            labels_time.get(arrayListCounter+1).setText(time[i]);
                            imageViews.get(arrayListCounter).setVisible(false);
                            imageViews.get(arrayListCounter+1).setVisible(false);
                            arrayListCounter+=2;
                        }
                    }
                }
            }
        }
    }

    public void sendMessage(ActionEvent event) throws SQLException {
        if(groupRepository.newMessage(newMessage.getText() , groupID , Main.mainConnection)){
            ArrayList<Label> labels_line = new ArrayList<>(Arrays.asList(first_firstLine , first_secondLine , second_firstLine , second_secondLine , third_firstLine , third_secondLine , fourth_firstLine , fourth_secondLine , fifth_firstLine , fifth_secondLine));
            ArrayList<Circle> circles_photo = new ArrayList<>(Arrays.asList(first_leftCircle , first_rightCircle , second_leftCircle , second_rightCircle , third_leftCircle , third_rightCircle , fourth_leftCircle , fourth_rightCircle , fifth_leftCircle , fifth_rightCircle));
            ArrayList<Label> labels_date = new ArrayList<>(Arrays.asList(first_date_left , first_date_right , second_date_left , second_date_right , third_date_left , third_date_right , fourth_date_left , fourth_date_right , fifth_date_left , fifth_date_right));
            ArrayList<Label> labels_time = new ArrayList<>(Arrays.asList(first_time_left , first_time_right , second_time_left , second_time_right , third_time_left , third_time_right , fourth_time_left , fourth_time_right , fifth_time_left , fifth_time_right));
            ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(first_leftImage , first_rightImage , second_leftImage , second_rightImage , third_leftImage , third_rightImage , fourth_leftImage , fourth_rightImage , fifth_leftImage , fifth_rightImage));
            ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(reply_first , forward_first , edit_first , delete_first ,
                    reply_second , forward_second , edit_second , delete_second ,
                    reply_third , forward_third , edit_third , delete_third ,
                    reply_fourth , forward_fourth , edit_fourth , delete_fourth ,
                    reply_fifth , forward_fifth , edit_fifth , delete_fifth));

            for(int i=2 ; i<10 ; i++){
                circles_photo.get(i).setVisible(true);
                imageViews.get(i).setVisible(true);
            }
            for(int i=4 ; i<20 ; i++){
                buttons.get(i).setVisible(true);
            }

            try {
                groupRepository.showMessages(groupID , Main.mainConnection);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            int arrayListCounter=0;
            int mainCounter=0;

            if(sender[0]==null){
                mainCounter=0;
                for(int i=0 ; i<10 ; i++){
                    circles_photo.get(i).setVisible(false);
                    imageViews.get(i).setVisible(false);
                }
                for(int i=0 ; i<20 ; i++){
                    buttons.get(i).setVisible(false);
                }
            } else if(sender[1]==null){
                mainCounter=1;
                for(int i=2 ; i<10 ; i++){
                    circles_photo.get(i).setVisible(false);
                    imageViews.get(i).setVisible(false);
                }
                for(int i=4 ; i<20 ; i++){
                    buttons.get(i).setVisible(false);
                }
            } else if (sender[2]==null){
                mainCounter=2;
                for(int i=4 ; i<10 ; i++){
                    circles_photo.get(i).setVisible(false);
                    imageViews.get(i).setVisible(false);
                }
                for(int i=8 ; i<20 ; i++){
                    buttons.get(i).setVisible(false);
                }
            } else if(sender[3]==null){
                mainCounter=3;
                for(int i=6 ; i<10 ; i++){
                    circles_photo.get(i).setVisible(false);
                    imageViews.get(i).setVisible(false);
                }
                for(int i=12 ; i<20 ; i++){
                    buttons.get(i).setVisible(false);
                }
            } else if(sender[4]==null){
                mainCounter=4;
                for(int i=8 ; i<10 ; i++){
                    circles_photo.get(i).setVisible(false);
                    imageViews.get(i).setVisible(false);
                }
                for(int i=16 ; i<20 ; i++){
                    buttons.get(i).setVisible(false);
                }
            } else {
                mainCounter=5;
            }


            for(int i=0 ; i<mainCounter ; i++){
                if(replyToSender[i].equalsIgnoreCase("nothing")){
                    if(beingPhoto[i].equalsIgnoreCase("yes")){
                        if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                            labels_line.get(arrayListCounter).setText("");
                            labels_line.get(arrayListCounter+1).setText("");
                            circles_photo.get(arrayListCounter).setVisible(false);
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            labels_date.get(arrayListCounter).setText(date[i]);
                            labels_date.get(arrayListCounter+1).setText("");
                            labels_time.get(arrayListCounter).setText(time[i]);
                            labels_time.get(arrayListCounter+1).setText("");
                            Image image2 = new Image(photoDirectory[i], 100 , 100 , false , false);
                            imageViews.get(arrayListCounter).setVisible(false);
                            imageViews.get(arrayListCounter+1).setImage(image2);

                            labels_line.get(arrayListCounter+2).setText("");
                            labels_line.get(arrayListCounter+3).setText("");
                            circles_photo.get(arrayListCounter+2).setVisible(false);
                            circles_photo.get(arrayListCounter+3).setVisible(false);
                            labels_date.get(arrayListCounter+2).setText("");
                            labels_date.get(arrayListCounter+3).setText("");
                            labels_time.get(arrayListCounter+2).setText("");
                            labels_time.get(arrayListCounter+3).setText("");
                            imageViews.get(arrayListCounter+2).setVisible(false);
                            imageViews.get(arrayListCounter+3).setVisible(false);
                            buttons.get(4*arrayListCounter+4).setVisible(false);
                            buttons.get(4*arrayListCounter+5).setVisible(false);
                            buttons.get(4*arrayListCounter+6).setVisible(false);
                            buttons.get(4*arrayListCounter+7).setVisible(false);
                            arrayListCounter+=4;
                            i++;
                        } else {
                            labels_line.get(arrayListCounter).setText("");
                            labels_line.get(arrayListCounter+1).setText("");
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            circles_photo.get(arrayListCounter+1).setVisible(false);
                            labels_date.get(arrayListCounter).setText("");
                            labels_date.get(arrayListCounter+1).setText(date[i]);
                            labels_time.get(arrayListCounter).setText("");
                            labels_time.get(arrayListCounter+1).setText(time[i]);
                            Image image2 = new Image(photoDirectory[i], 100 , 100 , false , false);
                            imageViews.get(arrayListCounter).setImage(image2);
                            imageViews.get(arrayListCounter+1).setVisible(false);

                            labels_line.get(arrayListCounter+2).setText("");
                            labels_line.get(arrayListCounter+3).setText("");
                            circles_photo.get(arrayListCounter+2).setVisible(false);
                            circles_photo.get(arrayListCounter+3).setVisible(false);
                            labels_date.get(arrayListCounter+2).setText("");
                            labels_date.get(arrayListCounter+3).setText("");
                            labels_time.get(arrayListCounter+2).setText("");
                            labels_time.get(arrayListCounter+3).setText("");
                            imageViews.get(arrayListCounter+2).setVisible(false);
                            imageViews.get(arrayListCounter+3).setVisible(false);
                            buttons.get(4*arrayListCounter+4).setVisible(false);
                            buttons.get(4*arrayListCounter+5).setVisible(false);
                            buttons.get(4*arrayListCounter+6).setVisible(false);
                            buttons.get(4*arrayListCounter+7).setVisible(false);
                            arrayListCounter+=4;
                            i++;
                        }
                    } else {
                        if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                            if(content[i].length()>57){
                                labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                labels_line.get(arrayListCounter).setAlignment(Pos.BASELINE_RIGHT);
                                labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                labels_line.get(arrayListCounter+1).setAlignment(Pos.BASELINE_RIGHT);
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter+1).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter+1).setText("");
                                }
                                labels_time.get(arrayListCounter).setText(time[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter+1).setText("");
                                }
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText(content[i]);
                                labels_line.get(arrayListCounter+1).setAlignment(Pos.BASELINE_RIGHT);
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter+1).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter+1).setText("");
                                }
                                labels_time.get(arrayListCounter).setText(time[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter+1).setText("");
                                }
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            }
                        } else {
                            if(content[i].length()>57){
                                labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter).setText("");
                                }
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter).setText("");
                                }
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText(content[i]);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter).setText("");
                                }
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter).setText("");
                                }
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            }
                        }
                    }
                }

                else {
                    if(beingPhoto[i].equalsIgnoreCase("yes")){
                        if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                            labels_line.get(arrayListCounter).setText("");
                            labels_line.get(arrayListCounter+1).setText("");
                            circles_photo.get(arrayListCounter).setVisible(false);
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            labels_date.get(arrayListCounter).setText(date[i]);
                            labels_date.get(arrayListCounter+1).setText("");
                            labels_time.get(arrayListCounter).setText(time[i]);
                            labels_time.get(arrayListCounter+1).setText("");
                            Image image2 = new Image(photoDirectory[i], 100 , 100 , false , false);
                            imageViews.get(arrayListCounter).setVisible(false);
                            imageViews.get(arrayListCounter+1).setImage(image2);

                            int countSpaces=24-replyToSender[i].length();
                            String string="│";
                            for(int j=0 ; j<countSpaces ; j++){
                                string+=" ";
                            }
                            labels_line.get(arrayListCounter+2).setText(string+"reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                            labels_line.get(arrayListCounter+3).setText("");
                            circles_photo.get(arrayListCounter+2).setVisible(false);
                            circles_photo.get(arrayListCounter+3).setVisible(false);
                            labels_date.get(arrayListCounter+2).setText("");
                            labels_date.get(arrayListCounter+3).setText("");
                            labels_time.get(arrayListCounter+2).setText("");
                            labels_time.get(arrayListCounter+3).setText("");
                            imageViews.get(arrayListCounter+2).setVisible(false);
                            imageViews.get(arrayListCounter+3).setVisible(false);
                            buttons.get(4*arrayListCounter+4).setVisible(false);
                            buttons.get(4*arrayListCounter+5).setVisible(false);
                            buttons.get(4*arrayListCounter+6).setVisible(false);
                            buttons.get(4*arrayListCounter+7).setVisible(false);
                            arrayListCounter+=4;
                            i++;
                        } else {
                            labels_line.get(arrayListCounter).setText("");
                            labels_line.get(arrayListCounter+1).setText("");
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            circles_photo.get(arrayListCounter+1).setVisible(false);
                            labels_date.get(arrayListCounter).setText("");
                            labels_date.get(arrayListCounter+1).setText(date[i]);
                            labels_time.get(arrayListCounter).setText("");
                            labels_time.get(arrayListCounter+1).setText(time[i]);
                            Image image2 = new Image(photoDirectory[i], 100 , 100 , false , false);
                            imageViews.get(arrayListCounter).setImage(image2);
                            imageViews.get(arrayListCounter+1).setVisible(false);

                            labels_line.get(arrayListCounter+2).setText("           │reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                            labels_line.get(arrayListCounter+3).setText("");
                            circles_photo.get(arrayListCounter+2).setVisible(false);
                            circles_photo.get(arrayListCounter+3).setVisible(false);
                            labels_date.get(arrayListCounter+2).setText("");
                            labels_date.get(arrayListCounter+3).setText("");
                            labels_time.get(arrayListCounter+2).setText("");
                            labels_time.get(arrayListCounter+3).setText("");
                            imageViews.get(arrayListCounter+2).setVisible(false);
                            imageViews.get(arrayListCounter+3).setVisible(false);
                            buttons.get(4*arrayListCounter+4).setVisible(false);
                            buttons.get(4*arrayListCounter+5).setVisible(false);
                            buttons.get(4*arrayListCounter+6).setVisible(false);
                            buttons.get(4*arrayListCounter+7).setVisible(false);
                            arrayListCounter+=4;
                            i++;
                        }
                    } else {
                        if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                            if(content[i].length()>57){
                                labels_line.get(arrayListCounter).setText("│reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                labels_line.get(arrayListCounter).setAlignment(Pos.BASELINE_RIGHT);
                                labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                labels_line.get(arrayListCounter+1).setAlignment(Pos.BASELINE_RIGHT);
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter+1).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter+1).setText("");
                                }
                                labels_time.get(arrayListCounter).setText(time[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter+1).setText("");
                                }
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            } else {
                                labels_line.get(arrayListCounter).setText("│reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                labels_line.get(arrayListCounter).setAlignment(Pos.BASELINE_RIGHT);
                                labels_line.get(arrayListCounter+1).setText(content[i]);
                                labels_line.get(arrayListCounter+1).setAlignment(Pos.BASELINE_RIGHT);
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter+1).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter+1).setText("");
                                }
                                labels_time.get(arrayListCounter).setText(time[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter+1).setText("");
                                }
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            }
                        } else {
                            if(content[i].length()>57){
                                labels_line.get(arrayListCounter).setText("│reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter).setText("");
                                }
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter).setText("");
                                }
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            } else {
                                labels_line.get(arrayListCounter).setText("│reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                labels_line.get(arrayListCounter+1).setText(content[i]);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter).setText("");
                                }
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter).setText("");
                                }
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            }
                        }
                    }
                }
            }
        } else {
            message_warning.setText("You are ban in this group!");
        }
    }

    public void sendPhoto(ActionEvent event) throws SQLException {
        if(groupRepository.newMessagePhoto(photoDirectoryy.getText() , groupID , Main.mainConnection)){
            ArrayList<Label> labels_line = new ArrayList<>(Arrays.asList(first_firstLine , first_secondLine , second_firstLine , second_secondLine , third_firstLine , third_secondLine , fourth_firstLine , fourth_secondLine , fifth_firstLine , fifth_secondLine));
            ArrayList<Circle> circles_photo = new ArrayList<>(Arrays.asList(first_leftCircle , first_rightCircle , second_leftCircle , second_rightCircle , third_leftCircle , third_rightCircle , fourth_leftCircle , fourth_rightCircle , fifth_leftCircle , fifth_rightCircle));
            ArrayList<Label> labels_date = new ArrayList<>(Arrays.asList(first_date_left , first_date_right , second_date_left , second_date_right , third_date_left , third_date_right , fourth_date_left , fourth_date_right , fifth_date_left , fifth_date_right));
            ArrayList<Label> labels_time = new ArrayList<>(Arrays.asList(first_time_left , first_time_right , second_time_left , second_time_right , third_time_left , third_time_right , fourth_time_left , fourth_time_right , fifth_time_left , fifth_time_right));
            ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(first_leftImage , first_rightImage , second_leftImage , second_rightImage , third_leftImage , third_rightImage , fourth_leftImage , fourth_rightImage , fifth_leftImage , fifth_rightImage));
            ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(reply_first , forward_first , edit_first , delete_first ,
                    reply_second , forward_second , edit_second , delete_second ,
                    reply_third , forward_third , edit_third , delete_third ,
                    reply_fourth , forward_fourth , edit_fourth , delete_fourth ,
                    reply_fifth , forward_fifth , edit_fifth , delete_fifth));

            for(int i=2 ; i<10 ; i++){
                circles_photo.get(i).setVisible(true);
                imageViews.get(i).setVisible(true);
            }
            for(int i=4 ; i<20 ; i++){
                buttons.get(i).setVisible(true);
            }

            try {
                groupRepository.showMessages(groupID , Main.mainConnection);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            int arrayListCounter=0;
            int mainCounter=0;

            if(sender[0]==null){
                mainCounter=0;
                for(int i=0 ; i<10 ; i++){
                    circles_photo.get(i).setVisible(false);
                    imageViews.get(i).setVisible(false);
                }
                for(int i=0 ; i<20 ; i++){
                    buttons.get(i).setVisible(false);
                }
            } else if(sender[1]==null){
                mainCounter=1;
                for(int i=2 ; i<10 ; i++){
                    circles_photo.get(i).setVisible(false);
                    imageViews.get(i).setVisible(false);
                }
                for(int i=4 ; i<20 ; i++){
                    buttons.get(i).setVisible(false);
                }
            } else if (sender[2]==null){
                mainCounter=2;
                for(int i=4 ; i<10 ; i++){
                    circles_photo.get(i).setVisible(false);
                    imageViews.get(i).setVisible(false);
                }
                for(int i=8 ; i<20 ; i++){
                    buttons.get(i).setVisible(false);
                }
            } else if(sender[3]==null){
                mainCounter=3;
                for(int i=6 ; i<10 ; i++){
                    circles_photo.get(i).setVisible(false);
                    imageViews.get(i).setVisible(false);
                }
                for(int i=12 ; i<20 ; i++){
                    buttons.get(i).setVisible(false);
                }
            } else if(sender[4]==null){
                mainCounter=4;
                for(int i=8 ; i<10 ; i++){
                    circles_photo.get(i).setVisible(false);
                    imageViews.get(i).setVisible(false);
                }
                for(int i=16 ; i<20 ; i++){
                    buttons.get(i).setVisible(false);
                }
            } else {
                mainCounter=5;
            }

            for(int i=0 ; i<mainCounter ; i++){
                if(replyToSender[i].equalsIgnoreCase("nothing")){
                    if(beingPhoto[i].equalsIgnoreCase("yes")){
                        if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                            labels_line.get(arrayListCounter).setText("");
                            labels_line.get(arrayListCounter+1).setText("");
                            circles_photo.get(arrayListCounter).setVisible(false);
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            labels_date.get(arrayListCounter).setText(date[i]);
                            labels_date.get(arrayListCounter+1).setText("");
                            labels_time.get(arrayListCounter).setText(time[i]);
                            labels_time.get(arrayListCounter+1).setText("");
                            Image image2 = new Image(photoDirectory[i], 100 , 100 , false , false);
                            imageViews.get(arrayListCounter).setVisible(false);
                            imageViews.get(arrayListCounter+1).setImage(image2);

                            labels_line.get(arrayListCounter+2).setText("");
                            labels_line.get(arrayListCounter+3).setText("");
                            circles_photo.get(arrayListCounter+2).setVisible(false);
                            circles_photo.get(arrayListCounter+3).setVisible(false);
                            labels_date.get(arrayListCounter+2).setText("");
                            labels_date.get(arrayListCounter+3).setText("");
                            labels_time.get(arrayListCounter+2).setText("");
                            labels_time.get(arrayListCounter+3).setText("");
                            imageViews.get(arrayListCounter+2).setVisible(false);
                            imageViews.get(arrayListCounter+3).setVisible(false);
                            buttons.get(4*arrayListCounter+4).setVisible(false);
                            buttons.get(4*arrayListCounter+5).setVisible(false);
                            buttons.get(4*arrayListCounter+6).setVisible(false);
                            buttons.get(4*arrayListCounter+7).setVisible(false);
                            arrayListCounter+=4;
                            i++;
                        } else {
                            labels_line.get(arrayListCounter).setText("");
                            labels_line.get(arrayListCounter+1).setText("");
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            circles_photo.get(arrayListCounter+1).setVisible(false);
                            labels_date.get(arrayListCounter).setText("");
                            labels_date.get(arrayListCounter+1).setText(date[i]);
                            labels_time.get(arrayListCounter).setText("");
                            labels_time.get(arrayListCounter+1).setText(time[i]);
                            Image image2 = new Image(photoDirectory[i], 100 , 100 , false , false);
                            imageViews.get(arrayListCounter).setImage(image2);
                            imageViews.get(arrayListCounter+1).setVisible(false);

                            labels_line.get(arrayListCounter+2).setText("");
                            labels_line.get(arrayListCounter+3).setText("");
                            circles_photo.get(arrayListCounter+2).setVisible(false);
                            circles_photo.get(arrayListCounter+3).setVisible(false);
                            labels_date.get(arrayListCounter+2).setText("");
                            labels_date.get(arrayListCounter+3).setText("");
                            labels_time.get(arrayListCounter+2).setText("");
                            labels_time.get(arrayListCounter+3).setText("");
                            imageViews.get(arrayListCounter+2).setVisible(false);
                            imageViews.get(arrayListCounter+3).setVisible(false);
                            buttons.get(4*arrayListCounter+4).setVisible(false);
                            buttons.get(4*arrayListCounter+5).setVisible(false);
                            buttons.get(4*arrayListCounter+6).setVisible(false);
                            buttons.get(4*arrayListCounter+7).setVisible(false);
                            arrayListCounter+=4;
                            i++;
                        }
                    } else {
                        if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                            if(content[i].length()>57){
                                labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                labels_line.get(arrayListCounter).setAlignment(Pos.BASELINE_RIGHT);
                                labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                labels_line.get(arrayListCounter+1).setAlignment(Pos.BASELINE_RIGHT);
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter+1).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter+1).setText("");
                                }
                                labels_time.get(arrayListCounter).setText(time[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter+1).setText("");
                                }
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText(content[i]);
                                labels_line.get(arrayListCounter+1).setAlignment(Pos.BASELINE_RIGHT);
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter+1).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter+1).setText("");
                                }
                                labels_time.get(arrayListCounter).setText(time[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter+1).setText("");
                                }
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            }
                        } else {
                            if(content[i].length()>57){
                                labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter).setText("");
                                }
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter).setText("");
                                }
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText(content[i]);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter).setText("");
                                }
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter).setText("");
                                }
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            }
                        }
                    }
                }

                else {
                    if(beingPhoto[i].equalsIgnoreCase("yes")){
                        if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                            labels_line.get(arrayListCounter).setText("");
                            labels_line.get(arrayListCounter+1).setText("");
                            circles_photo.get(arrayListCounter).setVisible(false);
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            labels_date.get(arrayListCounter).setText(date[i]);
                            labels_date.get(arrayListCounter+1).setText("");
                            labels_time.get(arrayListCounter).setText(time[i]);
                            labels_time.get(arrayListCounter+1).setText("");
                            Image image2 = new Image(photoDirectory[i], 100 , 100 , false , false);
                            imageViews.get(arrayListCounter).setVisible(false);
                            imageViews.get(arrayListCounter+1).setImage(image2);

                            int countSpaces=24-replyToSender[i].length();
                            String string="│";
                            for(int j=0 ; j<countSpaces ; j++){
                                string+=" ";
                            }
                            labels_line.get(arrayListCounter+2).setText(string+"reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                            labels_line.get(arrayListCounter+3).setText("");
                            circles_photo.get(arrayListCounter+2).setVisible(false);
                            circles_photo.get(arrayListCounter+3).setVisible(false);
                            labels_date.get(arrayListCounter+2).setText("");
                            labels_date.get(arrayListCounter+3).setText("");
                            labels_time.get(arrayListCounter+2).setText("");
                            labels_time.get(arrayListCounter+3).setText("");
                            imageViews.get(arrayListCounter+2).setVisible(false);
                            imageViews.get(arrayListCounter+3).setVisible(false);
                            buttons.get(4*arrayListCounter+4).setVisible(false);
                            buttons.get(4*arrayListCounter+5).setVisible(false);
                            buttons.get(4*arrayListCounter+6).setVisible(false);
                            buttons.get(4*arrayListCounter+7).setVisible(false);
                            arrayListCounter+=4;
                            i++;
                        } else {
                            labels_line.get(arrayListCounter).setText("");
                            labels_line.get(arrayListCounter+1).setText("");
                            Image image = null;
                            try {
                                image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                            circles_photo.get(arrayListCounter+1).setVisible(false);
                            labels_date.get(arrayListCounter).setText("");
                            labels_date.get(arrayListCounter+1).setText(date[i]);
                            labels_time.get(arrayListCounter).setText("");
                            labels_time.get(arrayListCounter+1).setText(time[i]);
                            Image image2 = new Image(photoDirectory[i], 100 , 100 , false , false);
                            imageViews.get(arrayListCounter).setImage(image2);
                            imageViews.get(arrayListCounter+1).setVisible(false);

                            labels_line.get(arrayListCounter+2).setText("           │reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                            labels_line.get(arrayListCounter+3).setText("");
                            circles_photo.get(arrayListCounter+2).setVisible(false);
                            circles_photo.get(arrayListCounter+3).setVisible(false);
                            labels_date.get(arrayListCounter+2).setText("");
                            labels_date.get(arrayListCounter+3).setText("");
                            labels_time.get(arrayListCounter+2).setText("");
                            labels_time.get(arrayListCounter+3).setText("");
                            imageViews.get(arrayListCounter+2).setVisible(false);
                            imageViews.get(arrayListCounter+3).setVisible(false);
                            buttons.get(4*arrayListCounter+4).setVisible(false);
                            buttons.get(4*arrayListCounter+5).setVisible(false);
                            buttons.get(4*arrayListCounter+6).setVisible(false);
                            buttons.get(4*arrayListCounter+7).setVisible(false);
                            arrayListCounter+=4;
                            i++;
                        }
                    } else {
                        if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                            if(content[i].length()>57){
                                labels_line.get(arrayListCounter).setText("│reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                labels_line.get(arrayListCounter).setAlignment(Pos.BASELINE_RIGHT);
                                labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                labels_line.get(arrayListCounter+1).setAlignment(Pos.BASELINE_RIGHT);
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter+1).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter+1).setText("");
                                }
                                labels_time.get(arrayListCounter).setText(time[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter+1).setText("");
                                }
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            } else {
                                labels_line.get(arrayListCounter).setText("│reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                labels_line.get(arrayListCounter).setAlignment(Pos.BASELINE_RIGHT);
                                labels_line.get(arrayListCounter+1).setText(content[i]);
                                labels_line.get(arrayListCounter+1).setAlignment(Pos.BASELINE_RIGHT);
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter+1).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter+1).setText("");
                                }
                                labels_time.get(arrayListCounter).setText(time[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter+1).setText("");
                                }
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            }
                        } else {
                            if(content[i].length()>57){
                                labels_line.get(arrayListCounter).setText("│reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter).setText("");
                                }
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter).setText("");
                                }
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            } else {
                                labels_line.get(arrayListCounter).setText("│reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                labels_line.get(arrayListCounter+1).setText(content[i]);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                if(beingEdited[i].equalsIgnoreCase("yes")){
                                    labels_date.get(arrayListCounter).setText("edited");
                                } else {
                                    labels_date.get(arrayListCounter).setText("");
                                }
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                if(beingForwarded[i].equalsIgnoreCase("yes")){
                                    labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                } else {
                                    labels_time.get(arrayListCounter).setText("");
                                }
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setVisible(false);
                                arrayListCounter+=2;
                            }
                        }
                    }
                }
            }
        } else {
            message_warning.setText("You are ban in this group!");
        }
    }

    public void members(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MembersOfAGroup.fxml");
    }

    public void search (ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("SearchMessageInGroup.fxml");
    }

    public void settings (ActionEvent event) throws IOException, SQLException {
        if(groupRepository.groupSettingsCheck(groupID , Main.mainConnection)){
            Main main = new Main();
            main.changeScene("GroupSettings.fxml");
        } else {
            message_warning.setText("You have not access to change settings");
        }
    }

    public void leave (ActionEvent event) throws SQLException, IOException {
        groupRepository.leaveTheGroup(Main.currentUser.getUsername() , groupID , Main.mainConnection);
        Main main = new Main();
        main.changeScene("GroupNames.fxml");
    }

    public void back(ActionEvent event) throws IOException {
        beingPhoto = new String[5];
        sender = new String[5];
        content = new String[5];
        photoDirectory = new String[5];
        replyToSender = new String[5];
        replyToMessage = new String[5];
        beingForwarded = new String[5];
        forwardedFrom = new String[5];
        beingEdited = new String[5];
        date = new String[5];
        time = new String[5];
        messageID = new int[5];
        Main main = new Main();
        main.changeScene("GroupNames.fxml");
    }

    public void reply_first(ActionEvent event) throws IOException {
        if(beingPhoto[0].equalsIgnoreCase("yes")){
            ReplyMessage_Controller.beingPhoto=true;
            ReplyMessage_Controller.groupID=groupID;
            ReplyMessage_Controller.messageID=messageID[0];
            Main main = new Main();
            main.changeScene("ReplyMessage.fxml");
        } else {
            ReplyMessage_Controller.beingPhoto=false;
            ReplyMessage_Controller.groupID=groupID;
            ReplyMessage_Controller.messageID=messageID[0];
            Main main = new Main();
            main.changeScene("ReplyMessage.fxml");
        }
    }

    public void forward_first(ActionEvent event) throws IOException {
        if(beingPhoto[0].equalsIgnoreCase("yes")){
            ForwardMessage_Controller.beingPhoto=true;
        } else {
            ForwardMessage_Controller.beingPhoto=false;
        }
        ForwardMessage_Controller.messageID=messageID[0];
        Main main = new Main();
        main.changeScene("ForwardMessage.fxml");
    }

    public void edit_first(ActionEvent event) throws IOException {
        if(beingPhoto[0].equalsIgnoreCase("yes")){
            EditMessage_Controller.beingPhoto=true;
        } else {
            EditMessage_Controller.beingPhoto=false;
        }
        EditMessage_Controller.messageID=messageID[0];
        EditMessage_Controller.groupID=groupID;
        Main main = new Main();
        main.changeScene("EditMessage.fxml");
    }

    public void delete_first(ActionEvent event) throws SQLException {
        if(beingPhoto[0].equalsIgnoreCase("yes")){
            if(groupRepository.deleteMessage(messageID[0],groupID , Main.mainConnection)){
                ArrayList<Label> labels_line = new ArrayList<>(Arrays.asList(first_firstLine , first_secondLine , second_firstLine , second_secondLine , third_firstLine , third_secondLine , fourth_firstLine , fourth_secondLine , fifth_firstLine , fifth_secondLine));
                ArrayList<Circle> circles_photo = new ArrayList<>(Arrays.asList(first_leftCircle , first_rightCircle , second_leftCircle , second_rightCircle , third_leftCircle , third_rightCircle , fourth_leftCircle , fourth_rightCircle , fifth_leftCircle , fifth_rightCircle));
                ArrayList<Label> labels_date = new ArrayList<>(Arrays.asList(first_date_left , first_date_right , second_date_left , second_date_right , third_date_left , third_date_right , fourth_date_left , fourth_date_right , fifth_date_left , fifth_date_right));
                ArrayList<Label> labels_time = new ArrayList<>(Arrays.asList(first_time_left , first_time_right , second_time_left , second_time_right , third_time_left , third_time_right , fourth_time_left , fourth_time_right , fifth_time_left , fifth_time_right));
                ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(first_leftImage , first_rightImage , second_leftImage , second_rightImage , third_leftImage , third_rightImage , fourth_leftImage , fourth_rightImage , fifth_leftImage , fifth_rightImage));
                ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(reply_first , forward_first , edit_first , delete_first ,
                        reply_second , forward_second , edit_second , delete_second ,
                        reply_third , forward_third , edit_third , delete_third ,
                        reply_fourth , forward_fourth , edit_fourth , delete_fourth ,
                        reply_fifth , forward_fifth , edit_fifth , delete_fifth));

                try {
                    groupRepository.showMessages(groupID , Main.mainConnection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                int arrayListCounter=0;
                int mainCounter=0;

                if(sender[0]==null){
                    mainCounter=0;
                    for(int i=0 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=0 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[1]==null){
                    mainCounter=1;
                    for(int i=2 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=4 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if (sender[2]==null){
                    mainCounter=2;
                    for(int i=4 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=8 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[3]==null){
                    mainCounter=3;
                    for(int i=6 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=12 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[4]==null){
                    mainCounter=4;
                    for(int i=8 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=16 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else {
                    mainCounter=5;
                }

                for(int i=0 ; i<mainCounter ; i++){
                    if(replyToSender[i].equalsIgnoreCase("nothing")){
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    String temp="";
                                    for(int j=0 ; j<content[i].length() ; j++){
                                        temp+=" ";
                                    }
                                    labels_line.get(arrayListCounter+1).setText(temp+content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }

                    else {
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                int countSpaces=24-replyToSender[i].length();
                                String string="│";
                                for(int j=0 ; j<countSpaces ; j++){
                                    string+=" ";
                                }
                                labels_line.get(arrayListCounter+2).setText(string+"reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("           │reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }
                }
            } else {
                message_warning.setText("You can not delete this message");
            }
        } else {
            if(groupRepository.deleteMessage(messageID[0],groupID , Main.mainConnection)){
                ArrayList<Label> labels_line = new ArrayList<>(Arrays.asList(first_firstLine , first_secondLine , second_firstLine , second_secondLine , third_firstLine , third_secondLine , fourth_firstLine , fourth_secondLine , fifth_firstLine , fifth_secondLine));
                ArrayList<Circle> circles_photo = new ArrayList<>(Arrays.asList(first_leftCircle , first_rightCircle , second_leftCircle , second_rightCircle , third_leftCircle , third_rightCircle , fourth_leftCircle , fourth_rightCircle , fifth_leftCircle , fifth_rightCircle));
                ArrayList<Label> labels_date = new ArrayList<>(Arrays.asList(first_date_left , first_date_right , second_date_left , second_date_right , third_date_left , third_date_right , fourth_date_left , fourth_date_right , fifth_date_left , fifth_date_right));
                ArrayList<Label> labels_time = new ArrayList<>(Arrays.asList(first_time_left , first_time_right , second_time_left , second_time_right , third_time_left , third_time_right , fourth_time_left , fourth_time_right , fifth_time_left , fifth_time_right));
                ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(first_leftImage , first_rightImage , second_leftImage , second_rightImage , third_leftImage , third_rightImage , fourth_leftImage , fourth_rightImage , fifth_leftImage , fifth_rightImage));
                ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(reply_first , forward_first , edit_first , delete_first ,
                        reply_second , forward_second , edit_second , delete_second ,
                        reply_third , forward_third , edit_third , delete_third ,
                        reply_fourth , forward_fourth , edit_fourth , delete_fourth ,
                        reply_fifth , forward_fifth , edit_fifth , delete_fifth));

                try {
                    groupRepository.showMessages(groupID , Main.mainConnection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                int arrayListCounter=0;

                for(int i=0 ; i<5 ; i++){
                    if(replyToSender[i].equalsIgnoreCase("nothing")){
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    String temp="";
                                    for(int j=0 ; j<content[i].length() ; j++){
                                        temp+=" ";
                                    }
                                    labels_line.get(arrayListCounter+1).setText(temp+content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }

                    else {
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                int countSpaces=24-replyToSender[i].length();
                                String string="│";
                                for(int j=0 ; j<countSpaces ; j++){
                                    string+=" ";
                                }
                                labels_line.get(arrayListCounter+2).setText(string+"reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("           │reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }
                }
            } else {
                message_warning.setText("You can not delete this message");
            }
        }
    }

    public void reply_second(ActionEvent event) throws IOException {
        if(beingPhoto[1].equalsIgnoreCase("yes")){
            ReplyMessage_Controller.beingPhoto=true;
            ReplyMessage_Controller.groupID=groupID;
            ReplyMessage_Controller.messageID=messageID[1];
            Main main = new Main();
            main.changeScene("ReplyMessage.fxml");
        } else {
            ReplyMessage_Controller.beingPhoto=false;
            ReplyMessage_Controller.groupID=groupID;
            ReplyMessage_Controller.messageID=messageID[1];
            Main main = new Main();
            main.changeScene("ReplyMessage.fxml");
        }
    }

    public void forward_second(ActionEvent event) throws IOException {
        if(beingPhoto[1].equalsIgnoreCase("yes")){
            ForwardMessage_Controller.beingPhoto=true;
        } else {
            ForwardMessage_Controller.beingPhoto=false;
        }
        ForwardMessage_Controller.messageID=messageID[1];
        Main main = new Main();
        main.changeScene("ForwardMessage.fxml");
    }

    public void edit_second(ActionEvent event) throws IOException {
        if(beingPhoto[1].equalsIgnoreCase("yes")){
            EditMessage_Controller.beingPhoto=true;
        } else {
            EditMessage_Controller.beingPhoto=false;
        }
        EditMessage_Controller.messageID=messageID[1];
        EditMessage_Controller.groupID=groupID;
        Main main = new Main();
        main.changeScene("EditMessage.fxml");
    }

    public void delete_second(ActionEvent event) throws SQLException {
        if(beingPhoto[1].equalsIgnoreCase("yes")){
            if(groupRepository.deleteMessage(messageID[1],groupID , Main.mainConnection)){
                ArrayList<Label> labels_line = new ArrayList<>(Arrays.asList(first_firstLine , first_secondLine , second_firstLine , second_secondLine , third_firstLine , third_secondLine , fourth_firstLine , fourth_secondLine , fifth_firstLine , fifth_secondLine));
                ArrayList<Circle> circles_photo = new ArrayList<>(Arrays.asList(first_leftCircle , first_rightCircle , second_leftCircle , second_rightCircle , third_leftCircle , third_rightCircle , fourth_leftCircle , fourth_rightCircle , fifth_leftCircle , fifth_rightCircle));
                ArrayList<Label> labels_date = new ArrayList<>(Arrays.asList(first_date_left , first_date_right , second_date_left , second_date_right , third_date_left , third_date_right , fourth_date_left , fourth_date_right , fifth_date_left , fifth_date_right));
                ArrayList<Label> labels_time = new ArrayList<>(Arrays.asList(first_time_left , first_time_right , second_time_left , second_time_right , third_time_left , third_time_right , fourth_time_left , fourth_time_right , fifth_time_left , fifth_time_right));
                ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(first_leftImage , first_rightImage , second_leftImage , second_rightImage , third_leftImage , third_rightImage , fourth_leftImage , fourth_rightImage , fifth_leftImage , fifth_rightImage));
                ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(reply_first , forward_first , edit_first , delete_first ,
                        reply_second , forward_second , edit_second , delete_second ,
                        reply_third , forward_third , edit_third , delete_third ,
                        reply_fourth , forward_fourth , edit_fourth , delete_fourth ,
                        reply_fifth , forward_fifth , edit_fifth , delete_fifth));

                try {
                    groupRepository.showMessages(groupID , Main.mainConnection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                int arrayListCounter=0;
                int mainCounter=0;

                if(sender[0]==null){
                    mainCounter=0;
                    for(int i=0 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=0 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[1]==null){
                    mainCounter=1;
                    for(int i=2 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=4 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if (sender[2]==null){
                    mainCounter=2;
                    for(int i=4 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=8 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[3]==null){
                    mainCounter=3;
                    for(int i=6 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=12 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[4]==null){
                    mainCounter=4;
                    for(int i=8 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=16 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else {
                    mainCounter=5;
                }

                for(int i=0 ; i<mainCounter ; i++){
                    if(replyToSender[i].equalsIgnoreCase("nothing")){
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    String temp="";
                                    for(int j=0 ; j<content[i].length() ; j++){
                                        temp+=" ";
                                    }
                                    labels_line.get(arrayListCounter+1).setText(temp+content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }

                    else {
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                int countSpaces=24-replyToSender[i].length();
                                String string="│";
                                for(int j=0 ; j<countSpaces ; j++){
                                    string+=" ";
                                }
                                labels_line.get(arrayListCounter+2).setText(string+"reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("           │reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }
                }
            } else {
                message_warning.setText("You can not delete this message");
            }
        } else {
            if(groupRepository.deleteMessage(messageID[1],groupID , Main.mainConnection)){
                ArrayList<Label> labels_line = new ArrayList<>(Arrays.asList(first_firstLine , first_secondLine , second_firstLine , second_secondLine , third_firstLine , third_secondLine , fourth_firstLine , fourth_secondLine , fifth_firstLine , fifth_secondLine));
                ArrayList<Circle> circles_photo = new ArrayList<>(Arrays.asList(first_leftCircle , first_rightCircle , second_leftCircle , second_rightCircle , third_leftCircle , third_rightCircle , fourth_leftCircle , fourth_rightCircle , fifth_leftCircle , fifth_rightCircle));
                ArrayList<Label> labels_date = new ArrayList<>(Arrays.asList(first_date_left , first_date_right , second_date_left , second_date_right , third_date_left , third_date_right , fourth_date_left , fourth_date_right , fifth_date_left , fifth_date_right));
                ArrayList<Label> labels_time = new ArrayList<>(Arrays.asList(first_time_left , first_time_right , second_time_left , second_time_right , third_time_left , third_time_right , fourth_time_left , fourth_time_right , fifth_time_left , fifth_time_right));
                ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(first_leftImage , first_rightImage , second_leftImage , second_rightImage , third_leftImage , third_rightImage , fourth_leftImage , fourth_rightImage , fifth_leftImage , fifth_rightImage));
                ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(reply_first , forward_first , edit_first , delete_first ,
                        reply_second , forward_second , edit_second , delete_second ,
                        reply_third , forward_third , edit_third , delete_third ,
                        reply_fourth , forward_fourth , edit_fourth , delete_fourth ,
                        reply_fifth , forward_fifth , edit_fifth , delete_fifth));

                try {
                    groupRepository.showMessages(groupID , Main.mainConnection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                int arrayListCounter=0;

                for(int i=0 ; i<5 ; i++){
                    if(replyToSender[i].equalsIgnoreCase("nothing")){
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    String temp="";
                                    for(int j=0 ; j<content[i].length() ; j++){
                                        temp+=" ";
                                    }
                                    labels_line.get(arrayListCounter+1).setText(temp+content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }

                    else {
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                int countSpaces=24-replyToSender[i].length();
                                String string="│";
                                for(int j=0 ; j<countSpaces ; j++){
                                    string+=" ";
                                }
                                labels_line.get(arrayListCounter+2).setText(string+"reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("           │reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }
                }
            } else {
                message_warning.setText("You can not delete this message");
            }
        }
    }

    public void reply_third(ActionEvent event) throws IOException {
        if(beingPhoto[2].equalsIgnoreCase("yes")){
            ReplyMessage_Controller.beingPhoto=true;
            ReplyMessage_Controller.groupID=groupID;
            ReplyMessage_Controller.messageID=messageID[2];
            Main main = new Main();
            main.changeScene("ReplyMessage.fxml");
        } else {
            ReplyMessage_Controller.beingPhoto=false;
            ReplyMessage_Controller.groupID=groupID;
            ReplyMessage_Controller.messageID=messageID[2];
            Main main = new Main();
            main.changeScene("ReplyMessage.fxml");
        }
    }

    public void forward_third(ActionEvent event) throws IOException {
        if(beingPhoto[2].equalsIgnoreCase("yes")){
            ForwardMessage_Controller.beingPhoto=true;
        } else {
            ForwardMessage_Controller.beingPhoto=false;
        }
        ForwardMessage_Controller.messageID=messageID[2];
        Main main = new Main();
        main.changeScene("ForwardMessage.fxml");
    }

    public void edit_third(ActionEvent event) throws IOException {
        if(beingPhoto[2].equalsIgnoreCase("yes")){
            EditMessage_Controller.beingPhoto=true;
        } else {
            EditMessage_Controller.beingPhoto=false;
        }
        EditMessage_Controller.messageID=messageID[2];
        EditMessage_Controller.groupID=groupID;
        Main main = new Main();
        main.changeScene("EditMessage.fxml");
    }

    public void delete_third(ActionEvent event) throws SQLException {
        if(beingPhoto[2].equalsIgnoreCase("yes")){
            if(groupRepository.deleteMessage(messageID[2],groupID , Main.mainConnection)){
                ArrayList<Label> labels_line = new ArrayList<>(Arrays.asList(first_firstLine , first_secondLine , second_firstLine , second_secondLine , third_firstLine , third_secondLine , fourth_firstLine , fourth_secondLine , fifth_firstLine , fifth_secondLine));
                ArrayList<Circle> circles_photo = new ArrayList<>(Arrays.asList(first_leftCircle , first_rightCircle , second_leftCircle , second_rightCircle , third_leftCircle , third_rightCircle , fourth_leftCircle , fourth_rightCircle , fifth_leftCircle , fifth_rightCircle));
                ArrayList<Label> labels_date = new ArrayList<>(Arrays.asList(first_date_left , first_date_right , second_date_left , second_date_right , third_date_left , third_date_right , fourth_date_left , fourth_date_right , fifth_date_left , fifth_date_right));
                ArrayList<Label> labels_time = new ArrayList<>(Arrays.asList(first_time_left , first_time_right , second_time_left , second_time_right , third_time_left , third_time_right , fourth_time_left , fourth_time_right , fifth_time_left , fifth_time_right));
                ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(first_leftImage , first_rightImage , second_leftImage , second_rightImage , third_leftImage , third_rightImage , fourth_leftImage , fourth_rightImage , fifth_leftImage , fifth_rightImage));
                ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(reply_first , forward_first , edit_first , delete_first ,
                        reply_second , forward_second , edit_second , delete_second ,
                        reply_third , forward_third , edit_third , delete_third ,
                        reply_fourth , forward_fourth , edit_fourth , delete_fourth ,
                        reply_fifth , forward_fifth , edit_fifth , delete_fifth));

                try {
                    groupRepository.showMessages(groupID , Main.mainConnection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                int arrayListCounter=0;
                int mainCounter=0;

                if(sender[0]==null){
                    mainCounter=0;
                    for(int i=0 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=0 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[1]==null){
                    mainCounter=1;
                    for(int i=2 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=4 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if (sender[2]==null){
                    mainCounter=2;
                    for(int i=4 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=8 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[3]==null){
                    mainCounter=3;
                    for(int i=6 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=12 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[4]==null){
                    mainCounter=4;
                    for(int i=8 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=16 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else {
                    mainCounter=5;
                }

                for(int i=0 ; i<mainCounter ; i++){
                    if(replyToSender[i].equalsIgnoreCase("nothing")){
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    String temp="";
                                    for(int j=0 ; j<content[i].length() ; j++){
                                        temp+=" ";
                                    }
                                    labels_line.get(arrayListCounter+1).setText(temp+content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }

                    else {
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                int countSpaces=24-replyToSender[i].length();
                                String string="│";
                                for(int j=0 ; j<countSpaces ; j++){
                                    string+=" ";
                                }
                                labels_line.get(arrayListCounter+2).setText(string+"reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("           │reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }
                }
            } else {
                message_warning.setText("You can not delete this message");
            }
        } else {
            if(groupRepository.deleteMessage(messageID[2],groupID , Main.mainConnection)){
                ArrayList<Label> labels_line = new ArrayList<>(Arrays.asList(first_firstLine , first_secondLine , second_firstLine , second_secondLine , third_firstLine , third_secondLine , fourth_firstLine , fourth_secondLine , fifth_firstLine , fifth_secondLine));
                ArrayList<Circle> circles_photo = new ArrayList<>(Arrays.asList(first_leftCircle , first_rightCircle , second_leftCircle , second_rightCircle , third_leftCircle , third_rightCircle , fourth_leftCircle , fourth_rightCircle , fifth_leftCircle , fifth_rightCircle));
                ArrayList<Label> labels_date = new ArrayList<>(Arrays.asList(first_date_left , first_date_right , second_date_left , second_date_right , third_date_left , third_date_right , fourth_date_left , fourth_date_right , fifth_date_left , fifth_date_right));
                ArrayList<Label> labels_time = new ArrayList<>(Arrays.asList(first_time_left , first_time_right , second_time_left , second_time_right , third_time_left , third_time_right , fourth_time_left , fourth_time_right , fifth_time_left , fifth_time_right));
                ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(first_leftImage , first_rightImage , second_leftImage , second_rightImage , third_leftImage , third_rightImage , fourth_leftImage , fourth_rightImage , fifth_leftImage , fifth_rightImage));
                ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(reply_first , forward_first , edit_first , delete_first ,
                        reply_second , forward_second , edit_second , delete_second ,
                        reply_third , forward_third , edit_third , delete_third ,
                        reply_fourth , forward_fourth , edit_fourth , delete_fourth ,
                        reply_fifth , forward_fifth , edit_fifth , delete_fifth));

                try {
                    groupRepository.showMessages(groupID , Main.mainConnection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                int arrayListCounter=0;

                for(int i=0 ; i<5 ; i++){
                    if(replyToSender[i].equalsIgnoreCase("nothing")){
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    String temp="";
                                    for(int j=0 ; j<content[i].length() ; j++){
                                        temp+=" ";
                                    }
                                    labels_line.get(arrayListCounter+1).setText(temp+content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }

                    else {
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                int countSpaces=24-replyToSender[i].length();
                                String string="│";
                                for(int j=0 ; j<countSpaces ; j++){
                                    string+=" ";
                                }
                                labels_line.get(arrayListCounter+2).setText(string+"reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("           │reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }
                }
            } else {
                message_warning.setText("You can not delete this message");
            }
        }
    }

    public void reply_fourth(ActionEvent event) throws IOException {
        if(beingPhoto[3].equalsIgnoreCase("yes")){
            ReplyMessage_Controller.beingPhoto=true;
            ReplyMessage_Controller.groupID=groupID;
            ReplyMessage_Controller.messageID=messageID[3];
            Main main = new Main();
            main.changeScene("ReplyMessage.fxml");
        } else {
            ReplyMessage_Controller.beingPhoto=false;
            ReplyMessage_Controller.groupID=groupID;
            ReplyMessage_Controller.messageID=messageID[3];
            Main main = new Main();
            main.changeScene("ReplyMessage.fxml");
        }
    }

    public void forward_fourth(ActionEvent event) throws IOException {
        if(beingPhoto[3].equalsIgnoreCase("yes")){
            ForwardMessage_Controller.beingPhoto=true;
        } else {
            ForwardMessage_Controller.beingPhoto=false;
        }
        ForwardMessage_Controller.messageID=messageID[3];
        Main main = new Main();
        main.changeScene("ForwardMessage.fxml");
    }

    public void edit_fourth(ActionEvent event) throws IOException {
        if(beingPhoto[3].equalsIgnoreCase("yes")){
            EditMessage_Controller.beingPhoto=true;
        } else {
            EditMessage_Controller.beingPhoto=false;
        }
        EditMessage_Controller.messageID=messageID[3];
        EditMessage_Controller.groupID=groupID;
        Main main = new Main();
        main.changeScene("EditMessage.fxml");
    }

    public void delete_fourth(ActionEvent event) throws SQLException {
        if(beingPhoto[3].equalsIgnoreCase("yes")){
            if(groupRepository.deleteMessage(messageID[3],groupID , Main.mainConnection)){
                ArrayList<Label> labels_line = new ArrayList<>(Arrays.asList(first_firstLine , first_secondLine , second_firstLine , second_secondLine , third_firstLine , third_secondLine , fourth_firstLine , fourth_secondLine , fifth_firstLine , fifth_secondLine));
                ArrayList<Circle> circles_photo = new ArrayList<>(Arrays.asList(first_leftCircle , first_rightCircle , second_leftCircle , second_rightCircle , third_leftCircle , third_rightCircle , fourth_leftCircle , fourth_rightCircle , fifth_leftCircle , fifth_rightCircle));
                ArrayList<Label> labels_date = new ArrayList<>(Arrays.asList(first_date_left , first_date_right , second_date_left , second_date_right , third_date_left , third_date_right , fourth_date_left , fourth_date_right , fifth_date_left , fifth_date_right));
                ArrayList<Label> labels_time = new ArrayList<>(Arrays.asList(first_time_left , first_time_right , second_time_left , second_time_right , third_time_left , third_time_right , fourth_time_left , fourth_time_right , fifth_time_left , fifth_time_right));
                ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(first_leftImage , first_rightImage , second_leftImage , second_rightImage , third_leftImage , third_rightImage , fourth_leftImage , fourth_rightImage , fifth_leftImage , fifth_rightImage));
                ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(reply_first , forward_first , edit_first , delete_first ,
                        reply_second , forward_second , edit_second , delete_second ,
                        reply_third , forward_third , edit_third , delete_third ,
                        reply_fourth , forward_fourth , edit_fourth , delete_fourth ,
                        reply_fifth , forward_fifth , edit_fifth , delete_fifth));

                try {
                    groupRepository.showMessages(groupID , Main.mainConnection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                int arrayListCounter=0;
                int mainCounter=0;

                if(sender[0]==null){
                    mainCounter=0;
                    for(int i=0 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=0 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[1]==null){
                    mainCounter=1;
                    for(int i=2 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=4 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if (sender[2]==null){
                    mainCounter=2;
                    for(int i=4 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=8 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[3]==null){
                    mainCounter=3;
                    for(int i=6 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=12 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[4]==null){
                    mainCounter=4;
                    for(int i=8 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=16 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else {
                    mainCounter=5;
                }

                for(int i=0 ; i<mainCounter ; i++){
                    if(replyToSender[i].equalsIgnoreCase("nothing")){
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    String temp="";
                                    for(int j=0 ; j<content[i].length() ; j++){
                                        temp+=" ";
                                    }
                                    labels_line.get(arrayListCounter+1).setText(temp+content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }

                    else {
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                int countSpaces=24-replyToSender[i].length();
                                String string="│";
                                for(int j=0 ; j<countSpaces ; j++){
                                    string+=" ";
                                }
                                labels_line.get(arrayListCounter+2).setText(string+"reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("           │reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }
                }
            } else {
                message_warning.setText("You can not delete this message");
            }
        } else {
            if(groupRepository.deleteMessage(messageID[3],groupID , Main.mainConnection)){
                ArrayList<Label> labels_line = new ArrayList<>(Arrays.asList(first_firstLine , first_secondLine , second_firstLine , second_secondLine , third_firstLine , third_secondLine , fourth_firstLine , fourth_secondLine , fifth_firstLine , fifth_secondLine));
                ArrayList<Circle> circles_photo = new ArrayList<>(Arrays.asList(first_leftCircle , first_rightCircle , second_leftCircle , second_rightCircle , third_leftCircle , third_rightCircle , fourth_leftCircle , fourth_rightCircle , fifth_leftCircle , fifth_rightCircle));
                ArrayList<Label> labels_date = new ArrayList<>(Arrays.asList(first_date_left , first_date_right , second_date_left , second_date_right , third_date_left , third_date_right , fourth_date_left , fourth_date_right , fifth_date_left , fifth_date_right));
                ArrayList<Label> labels_time = new ArrayList<>(Arrays.asList(first_time_left , first_time_right , second_time_left , second_time_right , third_time_left , third_time_right , fourth_time_left , fourth_time_right , fifth_time_left , fifth_time_right));
                ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(first_leftImage , first_rightImage , second_leftImage , second_rightImage , third_leftImage , third_rightImage , fourth_leftImage , fourth_rightImage , fifth_leftImage , fifth_rightImage));
                ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(reply_first , forward_first , edit_first , delete_first ,
                        reply_second , forward_second , edit_second , delete_second ,
                        reply_third , forward_third , edit_third , delete_third ,
                        reply_fourth , forward_fourth , edit_fourth , delete_fourth ,
                        reply_fifth , forward_fifth , edit_fifth , delete_fifth));

                try {
                    groupRepository.showMessages(groupID , Main.mainConnection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                int arrayListCounter=0;

                for(int i=0 ; i<5 ; i++){
                    if(replyToSender[i].equalsIgnoreCase("nothing")){
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    String temp="";
                                    for(int j=0 ; j<content[i].length() ; j++){
                                        temp+=" ";
                                    }
                                    labels_line.get(arrayListCounter+1).setText(temp+content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }

                    else {
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                int countSpaces=24-replyToSender[i].length();
                                String string="│";
                                for(int j=0 ; j<countSpaces ; j++){
                                    string+=" ";
                                }
                                labels_line.get(arrayListCounter+2).setText(string+"reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("           │reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }
                }
            } else {
                message_warning.setText("You can not delete this message");
            }
        }
    }

    public void reply_fifth(ActionEvent event) throws IOException {
        if(beingPhoto[4].equalsIgnoreCase("yes")){
            ReplyMessage_Controller.beingPhoto=true;
            ReplyMessage_Controller.groupID=groupID;
            ReplyMessage_Controller.messageID=messageID[4];
            Main main = new Main();
            main.changeScene("ReplyMessage.fxml");
        } else {
            ReplyMessage_Controller.beingPhoto=false;
            ReplyMessage_Controller.groupID=groupID;
            ReplyMessage_Controller.messageID=messageID[4];
            Main main = new Main();
            main.changeScene("ReplyMessage.fxml");
        }
    }

    public void forward_fifth(ActionEvent event) throws IOException {
        if(beingPhoto[4].equalsIgnoreCase("yes")){
            ForwardMessage_Controller.beingPhoto=true;
        } else {
            ForwardMessage_Controller.beingPhoto=false;
        }
        ForwardMessage_Controller.messageID=messageID[4];
        Main main = new Main();
        main.changeScene("ForwardMessage.fxml");
    }

    public void edit_fifth(ActionEvent event) throws IOException {
        if(beingPhoto[4].equalsIgnoreCase("yes")){
            EditMessage_Controller.beingPhoto=true;
        } else {
            EditMessage_Controller.beingPhoto=false;
        }
        EditMessage_Controller.messageID=messageID[4];
        EditMessage_Controller.groupID=groupID;
        Main main = new Main();
        main.changeScene("EditMessage.fxml");
    }

    public void delete_fifth(ActionEvent event) throws SQLException {
        if(beingPhoto[4].equalsIgnoreCase("yes")){
            if(groupRepository.deleteMessage(messageID[4],groupID , Main.mainConnection)){
                ArrayList<Label> labels_line = new ArrayList<>(Arrays.asList(first_firstLine , first_secondLine , second_firstLine , second_secondLine , third_firstLine , third_secondLine , fourth_firstLine , fourth_secondLine , fifth_firstLine , fifth_secondLine));
                ArrayList<Circle> circles_photo = new ArrayList<>(Arrays.asList(first_leftCircle , first_rightCircle , second_leftCircle , second_rightCircle , third_leftCircle , third_rightCircle , fourth_leftCircle , fourth_rightCircle , fifth_leftCircle , fifth_rightCircle));
                ArrayList<Label> labels_date = new ArrayList<>(Arrays.asList(first_date_left , first_date_right , second_date_left , second_date_right , third_date_left , third_date_right , fourth_date_left , fourth_date_right , fifth_date_left , fifth_date_right));
                ArrayList<Label> labels_time = new ArrayList<>(Arrays.asList(first_time_left , first_time_right , second_time_left , second_time_right , third_time_left , third_time_right , fourth_time_left , fourth_time_right , fifth_time_left , fifth_time_right));
                ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(first_leftImage , first_rightImage , second_leftImage , second_rightImage , third_leftImage , third_rightImage , fourth_leftImage , fourth_rightImage , fifth_leftImage , fifth_rightImage));
                ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(reply_first , forward_first , edit_first , delete_first ,
                        reply_second , forward_second , edit_second , delete_second ,
                        reply_third , forward_third , edit_third , delete_third ,
                        reply_fourth , forward_fourth , edit_fourth , delete_fourth ,
                        reply_fifth , forward_fifth , edit_fifth , delete_fifth));

                try {
                    groupRepository.showMessages(groupID , Main.mainConnection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                int arrayListCounter=0;
                int mainCounter=0;

                if(sender[0]==null){
                    mainCounter=0;
                    for(int i=0 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=0 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[1]==null){
                    mainCounter=1;
                    for(int i=2 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=4 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if (sender[2]==null){
                    mainCounter=2;
                    for(int i=4 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=8 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[3]==null){
                    mainCounter=3;
                    for(int i=6 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=12 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else if(sender[4]==null){
                    mainCounter=4;
                    for(int i=8 ; i<10 ; i++){
                        circles_photo.get(i).setVisible(false);
                        imageViews.get(i).setVisible(false);
                    }
                    for(int i=16 ; i<20 ; i++){
                        buttons.get(i).setVisible(false);
                    }
                } else {
                    mainCounter=5;
                }

                for(int i=0 ; i<mainCounter ; i++){
                    if(replyToSender[i].equalsIgnoreCase("nothing")){
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    String temp="";
                                    for(int j=0 ; j<content[i].length() ; j++){
                                        temp+=" ";
                                    }
                                    labels_line.get(arrayListCounter+1).setText(temp+content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }

                    else {
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                int countSpaces=24-replyToSender[i].length();
                                String string="│";
                                for(int j=0 ; j<countSpaces ; j++){
                                    string+=" ";
                                }
                                labels_line.get(arrayListCounter+2).setText(string+"reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("           │reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }
                }
            } else {
                message_warning.setText("You can not delete this message");
            }
        } else {
            if(groupRepository.deleteMessage(messageID[4],groupID , Main.mainConnection)){
                ArrayList<Label> labels_line = new ArrayList<>(Arrays.asList(first_firstLine , first_secondLine , second_firstLine , second_secondLine , third_firstLine , third_secondLine , fourth_firstLine , fourth_secondLine , fifth_firstLine , fifth_secondLine));
                ArrayList<Circle> circles_photo = new ArrayList<>(Arrays.asList(first_leftCircle , first_rightCircle , second_leftCircle , second_rightCircle , third_leftCircle , third_rightCircle , fourth_leftCircle , fourth_rightCircle , fifth_leftCircle , fifth_rightCircle));
                ArrayList<Label> labels_date = new ArrayList<>(Arrays.asList(first_date_left , first_date_right , second_date_left , second_date_right , third_date_left , third_date_right , fourth_date_left , fourth_date_right , fifth_date_left , fifth_date_right));
                ArrayList<Label> labels_time = new ArrayList<>(Arrays.asList(first_time_left , first_time_right , second_time_left , second_time_right , third_time_left , third_time_right , fourth_time_left , fourth_time_right , fifth_time_left , fifth_time_right));
                ArrayList<ImageView> imageViews = new ArrayList<>(Arrays.asList(first_leftImage , first_rightImage , second_leftImage , second_rightImage , third_leftImage , third_rightImage , fourth_leftImage , fourth_rightImage , fifth_leftImage , fifth_rightImage));
                ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(reply_first , forward_first , edit_first , delete_first ,
                        reply_second , forward_second , edit_second , delete_second ,
                        reply_third , forward_third , edit_third , delete_third ,
                        reply_fourth , forward_fourth , edit_fourth , delete_fourth ,
                        reply_fifth , forward_fifth , edit_fifth , delete_fifth));

                try {
                    groupRepository.showMessages(groupID , Main.mainConnection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                int arrayListCounter=0;

                for(int i=0 ; i<5 ; i++){
                    if(replyToSender[i].equalsIgnoreCase("nothing")){
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("");
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    String temp="";
                                    for(int j=0 ; j<content[i].length() ; j++){
                                        temp+=" ";
                                    }
                                    labels_line.get(arrayListCounter+1).setText(temp+content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText(content[i].substring(0 , 58));
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(58 , content[i].length()));
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }

                    else {
                        if(beingPhoto[i].equalsIgnoreCase("yes")){
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                circles_photo.get(arrayListCounter).setVisible(false);
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                labels_date.get(arrayListCounter).setText(date[i]);
                                labels_date.get(arrayListCounter+1).setText("");
                                labels_time.get(arrayListCounter).setText(time[i]);
                                labels_time.get(arrayListCounter+1).setText("");
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setVisible(false);
                                imageViews.get(arrayListCounter+1).setImage(image2);

                                int countSpaces=24-replyToSender[i].length();
                                String string="│";
                                for(int j=0 ; j<countSpaces ; j++){
                                    string+=" ";
                                }
                                labels_line.get(arrayListCounter+2).setText(string+"reply to "+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            } else {
                                labels_line.get(arrayListCounter).setText("");
                                labels_line.get(arrayListCounter+1).setText("");
                                Image image = null;
                                try {
                                    image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                circles_photo.get(arrayListCounter+1).setVisible(false);
                                labels_date.get(arrayListCounter).setText("");
                                labels_date.get(arrayListCounter+1).setText(date[i]);
                                labels_time.get(arrayListCounter).setText("");
                                labels_time.get(arrayListCounter+1).setText(time[i]);
                                Image image2 = new Image(photoDirectory[i]);
                                imageViews.get(arrayListCounter).setImage(image2);
                                imageViews.get(arrayListCounter+1).setVisible(false);

                                labels_line.get(arrayListCounter+2).setText("           │reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10));
                                labels_line.get(arrayListCounter+3).setText("");
                                circles_photo.get(arrayListCounter+2).setVisible(false);
                                circles_photo.get(arrayListCounter+3).setVisible(false);
                                labels_date.get(arrayListCounter+2).setText("");
                                labels_date.get(arrayListCounter+3).setText("");
                                labels_time.get(arrayListCounter+2).setText("");
                                labels_time.get(arrayListCounter+3).setText("");
                                imageViews.get(arrayListCounter+2).setVisible(false);
                                imageViews.get(arrayListCounter+3).setVisible(false);
                                buttons.get(4*arrayListCounter+4).setVisible(false);
                                buttons.get(4*arrayListCounter+5).setVisible(false);
                                buttons.get(4*arrayListCounter+6).setVisible(false);
                                buttons.get(4*arrayListCounter+7).setVisible(false);
                                arrayListCounter+=4;
                                i++;
                            }
                        } else {
                            if(sender[i].equalsIgnoreCase(Main.currentUser.getUsername())){
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    circles_photo.get(arrayListCounter).setVisible(false);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(Main.currentUser.getUsername() , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter+1).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    labels_date.get(arrayListCounter).setText(date[i]);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter+1).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter+1).setText("");
                                    }
                                    labels_time.get(arrayListCounter).setText(time[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter+1).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter+1).setText("");
                                    }
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            } else {
                                if(content[i].length()>57){
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i].substring(0 , 55)+"...");
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                } else {
                                    labels_line.get(arrayListCounter).setText("│reply to"+replyToSender[i]+" : "+replyToMessage[i].substring(0 , 10) + "...");
                                    labels_line.get(arrayListCounter+1).setText(content[i]);
                                    Image image = null;
                                    try {
                                        image = new Image(groupRepository.photoDirectory(sender[i] , Main.mainConnection));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    circles_photo.get(arrayListCounter).setFill(new ImagePattern(image , 0, 0, 1, 1, true));
                                    circles_photo.get(arrayListCounter+1).setVisible(false);
                                    if(beingEdited[i].equalsIgnoreCase("yes")){
                                        labels_date.get(arrayListCounter).setText("edited");
                                    } else {
                                        labels_date.get(arrayListCounter).setText("");
                                    }
                                    labels_date.get(arrayListCounter+1).setText(date[i]);
                                    if(beingForwarded[i].equalsIgnoreCase("yes")){
                                        labels_time.get(arrayListCounter).setText("forwarded from "+forwardedFrom[i]);
                                    } else {
                                        labels_time.get(arrayListCounter).setText("");
                                    }
                                    labels_time.get(arrayListCounter+1).setText(time[i]);
                                    imageViews.get(arrayListCounter).setVisible(false);
                                    imageViews.get(arrayListCounter+1).setVisible(false);
                                    arrayListCounter+=2;
                                }
                            }
                        }
                    }
                }
            } else {
                message_warning.setText("You can not delete this message");
            }
        }
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

    public void settings1(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Settings.fxml");
    }

    public void exit(ActionEvent event){
        System.exit(0);
    }

}
