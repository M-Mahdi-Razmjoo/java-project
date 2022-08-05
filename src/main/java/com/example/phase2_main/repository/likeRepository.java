package com.example.phase2_main.repository;


import com.example.phase2_main.Main;
import com.example.phase2_main.MainPage_Controller;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class likeRepository {

    public static void like(String sender , String content , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        boolean checkLike = false;

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM posts");

        int postID=-1;

        while(resultSet1.next()){
            if(resultSet1.getString("sender").equalsIgnoreCase(sender) && resultSet1.getString("content").equalsIgnoreCase(content)){
                postID = resultSet1.getInt("id");
            }
        }

        if(postID!=-1){
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM likes");

            while(resultSet2.next()){
                if(resultSet2.getString("user").equalsIgnoreCase(Main.currentUser.getUsername()) && resultSet2.getString("postID").equalsIgnoreCase(Integer.toString(postID))){
                    checkLike=true;
                }
            }
            if(checkLike==false){
                LocalDate localDate = LocalDate.now();
                LocalTime localTime = LocalTime.now();

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO likes(user , postID , date , time )" +
                                "VALUES (?,?,?,?)"
                );

                preparedStatement.setString(1 , Main.currentUser.getUsername());
                preparedStatement.setInt(2 , postID);
                preparedStatement.setString(3 , localDate.toString());
                preparedStatement.setString(4 , localTime.toString());

                preparedStatement.executeUpdate();


                activityRepository.activityInsert(Main.currentUser.getUsername() , sender , postID , connection);
            }
        }
    }


    public static ArrayList<String> showLikesOfPost(String sender , String content , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM posts");

        ArrayList<String> users= new ArrayList<>();

        int postID=-1;

        while(resultSet1.next()){
            if(resultSet1.getString("sender").equalsIgnoreCase(sender) && resultSet1.getString("content").equalsIgnoreCase(content)){
                postID = resultSet1.getInt("id");
            }
        }

        if(postID!=-1){
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM likes");

            while(resultSet2.next()){
                if(resultSet2.getInt("postID")==postID){
                    users.add(resultSet2.getString("user"));
                }
            }
        }

        return users;
    }

    public static ArrayList<String> showLikesOfComment(String id , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM likes");

        ArrayList<String> users = new ArrayList<>();

        while(resultSet1.next()){
            if(resultSet1.getInt("postID") == Integer.parseInt(id)){
                users.add(resultSet1.getString("user"));
            }
        }

        return users;
    }

    public static void likeAComment(String id , Connection connection) throws SQLException {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO likes(user , postID , date , time )" +
                        "VALUES (?,?,?,?)"
        );

        preparedStatement.setString(1 , Main.currentUser.getUsername());
        preparedStatement.setInt(2 , Integer.parseInt(id));
        preparedStatement.setString(3 , localDate.toString());
        preparedStatement.setString(4 , localTime.toString());

        preparedStatement.executeUpdate();
    }

}
