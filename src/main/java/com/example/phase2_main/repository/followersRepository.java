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


import static com.example.phase2_main.Main.currentUser;


public class followersRepository {
        public static ArrayList<String> followers = new ArrayList<>();
        public static ArrayList<String> following = new ArrayList<>();
        public static ArrayList<String> userList = new ArrayList<>();
        public static String bio;

        public static int followCheck(String username, Connection connection) throws SQLException {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            if(username.equals(currentUser.getUsername())){
                return 222;
            }
            while (resultSet.next()) {
                if (resultSet.getString("username").equalsIgnoreCase(username)) {
                    if (duplicatedFollowers(username, connection)) {
                        return 555;
                    }
                    return 333;
                }
            }
            return 444;
            /// 333 user hast
            /// 444 user nist
            /// 555 ghablan follow shode
        }

        public static void follow(String username, Connection connection) throws SQLException {
            String targetUser = username;
            String thisUser = currentUser.getUsername();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO followers(thisUsername,targetUser)" +
                            "values (?,?)");

            preparedStatement.setString(1, thisUser);
            preparedStatement.setString(2, targetUser);

            preparedStatement.executeUpdate();

            activityRepository.activityInsert(thisUser, targetUser, 0, connection);
        }

        private static boolean duplicatedFollowers(String username, Connection connection) throws SQLException {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM followers");
            while (resultSet.next()) {
                if (resultSet.getString("targetUser").equalsIgnoreCase(username)
                        && resultSet.getString("thisUsername").equals(currentUser.getUsername())) {
                    return true;
                }
            }
            return false;
        }

        public static void unfollow(String username, Connection connection) throws SQLException {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM followers");
            while (resultSet.next()) {
                if (resultSet.getString("targetUser").equalsIgnoreCase(username)
                        && resultSet.getString("thisUsername").equals(currentUser.getUsername())) {
                    resultSet.deleteRow();
                    followers.remove(currentUser.getUsername());
                }
            }
        }

        public static void setFollowers(String username , Connection connection) throws SQLException {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM followers");
            Statement st = connection.createStatement();
            ResultSet reSet = st.executeQuery("SELECT * FROM users");

            String temp1,temp2;
            while (resultSet.next()) {
                if (resultSet.getString("targetUser").equals(username)) {
                    temp1 = resultSet.getString("thisUsername");
                    if(!(followers.contains(temp1))){
                        followers.add(temp1);
                    }
                }
                if (resultSet.getString("thisUsername").equals(username)) {
                    temp2 = resultSet.getString("targetUser");
                    if(!(following.contains(temp2))){
                        following.add(temp2);
                    }
                }
            }

            while (reSet.next()) {
                userList.add(reSet.getString("username"));
                if(reSet.getString("username").equalsIgnoreCase(username)){
                    bio = reSet.getString("bio");
                    if(reSet.getString("photoDirectory").equalsIgnoreCase("nothing")){
                        SearchOthersPage_Controller.haveProfile = false;
                    }else{
                        SearchOthersPage_Controller.profilePhotoAddress = reSet.getString("photoDirectory");
                    }
                }
            }
        }

}