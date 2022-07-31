package com.example.phase2_main.repository;

import com.example.phase2_main.*;


import com.example.phase2_main.Main;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class postRepository {
    public static void post(String postContent , String photoDirectory , Connection connection) throws SQLException {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO posts(sender  , senderPhotoDirectory , content , replyTo, photoDirectory , date , time )" +
                        "VALUES (?,?,?,?,?,?,?)"
        );

        preparedStatement.setString(1 , Main.currentUser.getUsername());
        preparedStatement.setString(2 , Main.currentUser.getPhotoDirectory());
        preparedStatement.setString(3 , postContent);
        preparedStatement.setString(4 , "0");
        preparedStatement.setString(5 , photoDirectory);
        preparedStatement.setString(6 , localDate.toString());
        preparedStatement.setString(7 , localTime.toString());

        preparedStatement.executeUpdate();
    }


    public static void showPosts( String username , int postCounter , Connection connection) throws SQLException {
        ArrayList<String> usernames = new ArrayList<>();


        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM followers");

        while(resultSet1.next()){
            if(resultSet1.getString("thisUsername").equalsIgnoreCase(username)){
                usernames.add(resultSet1.getString("targetUser"));
            }
        }

        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM posts ORDER BY id DESC ");
        int counter=0;
        boolean checkPostCounter=false;


        while(resultSet2.next()){
            if(counter<15){
                for(int i=0 ; i<usernames.size() ; i++){
                    if(resultSet2.getString("sender").equalsIgnoreCase(usernames.get(i)) && resultSet2.getString("replyTo").equalsIgnoreCase("0")){
                        checkPostCounter=true;
                    }
                }
                if(resultSet2.getString("sender").equalsIgnoreCase(username) && resultSet2.getString("replyTo").equalsIgnoreCase("0")){
                    checkPostCounter=true;
                }
                if(checkPostCounter=true){
                    counter++;
                }
                if(counter==postCounter){
                    MainPage_Controller.content=resultSet2.getString("content");
                    MainPage_Controller.sender=resultSet2.getString("sender");
                    MainPage_Controller.senderPhoto=resultSet2.getString("senderPhotoDirectory");
                    MainPage_Controller.fileAddress=resultSet2.getString("photoDirectory");
                }
                checkPostCounter=false;
            }
        }

        if (counter!=0){
            MainPage_Controller.checkPost=true;//یعنی حداقل یک پست برای نمایش وجود دارد
        }

        usernames.clear();
    }

    public static int postCounter(String username, Connection connection) throws SQLException {
        ArrayList<String> usernames = new ArrayList<>();


        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM followers");

        while(resultSet1.next()){
            if(resultSet1.getString("thisUsername").equalsIgnoreCase(username)){
                usernames.add(resultSet1.getString("targetUser"));
            }
        }

        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM posts ORDER BY id DESC ");
        int counter=0;
        boolean checkPostCounter=false;


        while(resultSet2.next()){
            if(counter<15){
                for(int i=0 ; i<usernames.size() ; i++){
                    if(resultSet2.getString("sender").equalsIgnoreCase(usernames.get(i)) && resultSet2.getString("replyTo").equalsIgnoreCase("0")){
                        checkPostCounter=true;
                    }
                }
                if(resultSet2.getString("sender").equalsIgnoreCase(username) && resultSet2.getString("replyTo").equalsIgnoreCase("0")){
                    checkPostCounter=true;
                }
                if(checkPostCounter=true){
                    counter++;
                }
                checkPostCounter=false;
            }
        }

        usernames.clear();

        return counter;
    }

    public static void showMyPosts(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM posts ORDER BY id DESC ");

        while(resultSet1.next()){
            if(resultSet1.getString("sender").equalsIgnoreCase(Main.currentUser.getUsername()) && resultSet1.getString("replyTo").equalsIgnoreCase("0")){
                System.out.println("*************************************************");
                System.out.println(Main.currentUser.getUsername() + " at " + resultSet1.getString("time") + " : ");
                System.out.println(resultSet1.getString("content"));
                System.out.println("*************************************************");
            }
        }
    }


    public static void showComments(String sender , String content  , int commentCounter , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM posts");

        int postID=-1;

        int counter=0;

        while(resultSet1.next()){
            if(resultSet1.getString("sender").equalsIgnoreCase(sender) && resultSet1.getString("content").equalsIgnoreCase(content)){
                postID = resultSet1.getInt("id");
            }
        }

        if(postID!=-1){
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM posts  ORDER BY id DESC ");

            while (resultSet2.next()){
                if(resultSet2.getString("replyTo").equalsIgnoreCase(Integer.toString(postID))){
                    counter++;
                }
                if(counter==commentCounter){
                    MainPage_ShowComments_Controller.commentSender=resultSet2.getString("sender");
                    MainPage_ShowComments_Controller.commentContent=resultSet2.getString("content");
                    MainPage_ShowComments_Controller.commentSenderPhoto=resultSet2.getString("senderPhotoDirectory");
                    MainPage_ShowComments_Controller.commentID=resultSet2.getString("id");
                }
            }
        }
    }

    public static void showCommentsOfComments(String sender , String content  , int commentCounter , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM posts");

        int postID=-1;

        int counter=0;

        while(resultSet1.next()){
            if(resultSet1.getString("sender").equalsIgnoreCase(sender) && resultSet1.getString("content").equalsIgnoreCase(content)){
                postID = resultSet1.getInt("id");
            }
        }

        if(postID!=-1){
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM posts  ORDER BY id DESC ");

            while (resultSet2.next()){
                if(resultSet2.getString("replyTo").equalsIgnoreCase(Integer.toString(postID))){
                    counter++;
                }
                if(counter==commentCounter){
                    MainPage_ShowCommentsOfComments_Controller.commentSender=resultSet2.getString("sender");
                    MainPage_ShowCommentsOfComments_Controller.commentContent=resultSet2.getString("content");
                    MainPage_ShowCommentsOfComments_Controller.commentSenderPhoto=resultSet2.getString("senderPhotoDirectory");
                    MainPage_ShowCommentsOfComments_Controller.commentID=resultSet2.getString("id");
                }
            }
        }
    }


    public static int commentCounter(String sender , String content , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM posts");

        int counter=0;

        int postID=-1;

        while(resultSet1.next()){
            if(resultSet1.getString("sender").equalsIgnoreCase(sender) && resultSet1.getString("content").equalsIgnoreCase(content)){
                postID = resultSet1.getInt("id");
            }
        }

        if(postID!=-1){
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM posts  ORDER BY id DESC ");

            while (resultSet2.next()){
                if(resultSet2.getString("replyTo").equalsIgnoreCase(Integer.toString(postID))){
                    counter++;
                }
            }
        }
        return counter;
    }


    public static String findCommentSenderPhoto(String commentSender , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM users");

        String PD="";

        while(resultSet1.next()){
            if(resultSet1.getString("username").equalsIgnoreCase(commentSender)){
                PD=resultSet1.getString("photoDirectory");
            }
        }
        return PD;
    }


    public static void showReplyToAComment(String sender , String id , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM  posts ORDER BY id DESC ");

        while(resultSet.next()){
            if(resultSet.getString("replyTo").equalsIgnoreCase(sender)){
                System.out.println("        ---------------");
                System.out.println(resultSet.getString("sender") + " reply to " + sender);
                System.out.println(resultSet.getString("content"));
                System.out.println("        ---------------");
            }
        }

    }


    public static void commentOnAPost(String sender , String postContent  , String photoDirectory , String content , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM posts");

        int postID=-1;

        while(resultSet1.next()){
            if(resultSet1.getString("sender").equalsIgnoreCase(sender) && resultSet1.getString("content").equalsIgnoreCase(postContent)){
                postID = resultSet1.getInt("id");
            }
        }

        if(postID!=-1){
            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO posts(sender  , senderPhotoDirectory , content , replyTo, photoDirectory , date , time )" +
                            "VALUES (?,?,?,?,?,?,?)"
            );

            preparedStatement.setString(1 , Main.currentUser.getUsername());
            preparedStatement.setString(2 , Main.currentUser.getPhotoDirectory());
            preparedStatement.setString(3 , content);
            preparedStatement.setString(4 , Integer.toString(postID));
            preparedStatement.setString(5 , photoDirectory);
            preparedStatement.setString(6 , localDate.toString());
            preparedStatement.setString(7 , localTime.toString());

            preparedStatement.executeUpdate();
        }

    }


    public static void commentOnComment(String sender , String commentContent , String content, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM posts");

        int postID=-1;

        while(resultSet1.next()){
            if(resultSet1.getString("sender").equalsIgnoreCase(sender) && resultSet1.getString("content").equalsIgnoreCase(commentContent)){
                postID = resultSet1.getInt("id");
            }
        }

        if(postID!=-1){
            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO posts(sender  , senderPhotoDirectory , content , replyTo, photoDirectory , date , time )" +
                            "VALUES (?,?,?,?,?,?,?)"
            );

            preparedStatement.setString(1 , Main.currentUser.getUsername());
            preparedStatement.setString(2 , Main.currentUser.getPhotoDirectory());
            preparedStatement.setString(3 , content);
            preparedStatement.setString(4 , Integer.toString(postID));
            preparedStatement.setString(5 , "nothing");
            preparedStatement.setString(6 , localDate.toString());
            preparedStatement.setString(7 , localTime.toString());

            preparedStatement.executeUpdate();
        }
    }

}
