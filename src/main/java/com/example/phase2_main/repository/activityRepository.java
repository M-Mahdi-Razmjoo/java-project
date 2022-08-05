package com.example.phase2_main.repository;

import com.example.phase2_main.Activity_Controller;
import com.example.phase2_main.Main;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class activityRepository {

    public static void activityInsert(String username , String target , int postID , Connection connection) throws SQLException {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO activity(username , target , postID , date , time )" +
                        "VALUES (?,?,?,?,?)"
        );


        preparedStatement.setString(1 , username);
        preparedStatement.setString(2 , target);
        preparedStatement.setInt(3 , postID);
        preparedStatement.setString(4 , localDate.toString());
        preparedStatement.setString(5 , localTime.toString());

        preparedStatement.executeUpdate();

    }


    public static void showActivity(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM activity ORDER BY id DESC ");

        int check=0;

        ArrayList<String> activities = new ArrayList<>();

        while(resultSet1.next()){
            if(resultSet1.getString("target").equalsIgnoreCase(Main.currentUser.getUsername()) && resultSet1.getInt("postID")==0){
                activities.add(resultSet1.getString("username") + " started following you " + "-" + " Date :" + resultSet1.getString("date") + " - Time :" + resultSet1.getString("time"));
            } else if(resultSet1.getString("target").equalsIgnoreCase(Main.currentUser.getUsername()) && resultSet1.getInt("postID")!=0){
                activities.add(resultSet1.getString("username") + " liked your post " + "-" + " Date :" + resultSet1.getString("date") + " - Time :" + resultSet1.getString("time"));
            }
        }
        Activity_Controller.activities=activities;
    }
}
