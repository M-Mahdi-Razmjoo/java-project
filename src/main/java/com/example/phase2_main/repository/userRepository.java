package com.example.phase2_main.repository;


import com.example.phase2_main.Main;
import com.example.phase2_main.entity.*;

import java.sql.*;

public class userRepository {

    public static int loginUser(String username , String password , Connection connection) throws SQLException {
        boolean checkUsernameExistence = false;
        boolean checkPass = false;

        String pass = null;
        String bio = null;
        String securityQuestion = null;

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        while(resultSet.next()){
            if(resultSet.getString("username").equalsIgnoreCase(username)){
                checkUsernameExistence=true;
                pass = resultSet.getString("password");
                bio = resultSet.getString("bio");
                securityQuestion = resultSet.getString("securityQuestion");
                if(resultSet.getString("password").equalsIgnoreCase(password)){
                    checkPass=true;
                }
            }
        }

        if(checkUsernameExistence && checkPass){
            User user = new User(username , password ,securityQuestion , bio);
            Main.currentUser=user;
            return 3;
        } else if (checkUsernameExistence==true && checkPass==false){
            return 33;
        } else {
            return 333;
        }


    }



    public static int forgetPassword(String username , Connection connection , String securityQ) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        boolean checkSQ = false;

        String pass = null;
        String bio = null;
        String securityQuestion = null;

        while(resultSet.next()){
            if(resultSet.getString("securityQuestion").equalsIgnoreCase(securityQ)){
                checkSQ=true;
                pass = resultSet.getString("password");
                bio = resultSet.getString("bio");
                securityQuestion = resultSet.getString("securityQuestion");
            }
        }

        if(checkSQ){
            User user = new User(username , pass ,securityQuestion , bio);
            Main.currentUser=user;
            return 3;
        } else {
            return 33;
        }

    }


    public static int signupUser(Connection connection , String username , String pass , String securityQuestion , String bio) throws SQLException {
        boolean check = false;

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        while(resultSet.next()){
            if(resultSet.getString("username").equalsIgnoreCase(username)){
                check=true;
            }
        }

        if(check){
            return 33;
        } else {
            User user = new User(username , pass , securityQuestion , bio);
            Main.currentUser=user;
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users(username , password , bio , securityQuestion)" +
                            "values (?,?,?,?)");


            preparedStatement.setString(1 , username);
            preparedStatement.setString(2 , pass);
            preparedStatement.setString(3 , bio);
            preparedStatement.setString(4 , securityQuestion);

            preparedStatement.executeUpdate();
            return 3;
        }
    }

    public static void CommercialCheck(String username , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        while(resultSet.next()){
            if(resultSet.getString("username").equals(username) && resultSet.getString("bio").equals("ThIsAcCoUntIsCoMmErCiAl")){
                Main.IsCommercial = true ;
            }
        }
    }

    public static boolean IsCommercialCheck(String username , Connection connection)throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        while(resultSet.next()){
            if(resultSet.getString("username").equals(username) && resultSet.getString("bio").equals("ThIsAcCoUntIsCoMmErCiAl")){
                return true ;
            }
        }
        return false;
    }
}
