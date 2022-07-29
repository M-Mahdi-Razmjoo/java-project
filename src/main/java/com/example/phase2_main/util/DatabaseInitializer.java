package com.example.phase2_main.util;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public void createTables(Connection connection) throws SQLException {
        initUserTable(connection.createStatement());
        initFollowerTable(connection.createStatement());
        initPostTable(connection.createStatement());
        initLikeTable(connection.createStatement());
        initActivityTable(connection.createStatement());
        initMessageTable(connection.createStatement());
        initGroupsMessageTable(connection.createStatement());
        initGroupActivityTable(connection.createStatement());
        initGroupsSettingsTable(connection.createStatement());
    }

    private void initUserTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS "+
                        "users(username varchar(255)," +
                        "password varchar (255)," +
                        "bio varchar (255)," +
                        "securityQuestion varchar (255)," +
                        "id int NOT NULL AUTO_INCREMENT," +
                        "PRIMARY KEY (id))");
        statement.executeUpdate("ALTER TABLE users AUTO_INCREMENT=100");
        statement.close();
    }
    private void initFollowerTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "followers(thisUsername varchar (255),"+
                        "targetUser varchar (255) ,"+
                        "id int NOT NULL AUTO_INCREMENT,"+
                        "PRIMARY KEY (id))"
        );
        statement.executeUpdate("ALTER TABLE followers AUTO_INCREMENT=400");
        statement.close();
    }

    private void initPostTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "posts(id int NOT NULL AUTO_INCREMENT," +
                        "sender varchar (255) ," +
                        "content varchar(255) ," +
                        "replyTo varchar (255)," +
                        "date varchar(255) ," +
                        "time varchar(255) ," +
                        "PRIMARY KEY (id))"
        );
        statement.executeUpdate("ALTER TABLE posts AUTO_INCREMENT=1000");
        statement.close();
    }

    private void initLikeTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "likes(id int NOT NULL AUTO_INCREMENT," +
                        "user varchar (255) ," +
                        "postID int NOT NULL ," +
                        "date varchar(255) ," +
                        "time varchar(255) ," +
                        "PRIMARY KEY (id))"
        );
        statement.executeUpdate("ALTER TABLE likes AUTO_INCREMENT=2000");
        statement.close();
    }

    private void initActivityTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "activity(id int NOT NULL AUTO_INCREMENT," +
                        "username varchar (255) ," +
                        "target varchar(255) ," +
                        "postID int NOT NULL ," +
                        "date varchar(255) ," +
                        "time varchar(255) ," +
                        "PRIMARY KEY (id))"
        );
        statement.executeUpdate("ALTER TABLE likes AUTO_INCREMENT=3000");
        statement.close();
    }

    private void initMessageTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "messages(thisUsername varchar (255),"+
                        "targetUser varchar (255) ,"+
                        "messageContext varchar (255) ,"+
                        "messageType varchar (255),"+
                        "messageSeen varchar (255),"+
                        "messageDate varchar (255) ,"+
                        "messageTime varchar (255),"+
                        "id int NOT NULL AUTO_INCREMENT,"+
                        "PRIMARY KEY (id))"
        );
        statement.executeUpdate("ALTER TABLE messages AUTO_INCREMENT = 10000");
        statement.close();
    }

    private void initGroupsMessageTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "groupsMessage(id int NOT NULL AUTO_INCREMENT," +
                        "groupName varchar (255) ," +
                        "groupID varchar (255) ," +
                        "sender varchar(255) ," +
                        "content varchar (255) ," +
                        "replyToSender varchar (255) ," +
                        "replyToMessage varchar (255) ," +
                        "beingForwarded varchar (255) ," +
                        "forwardedFrom varchar (255) ," +
                        "beingEdited varchar (255) ," +
                        "date varchar(255) ," +
                        "time varchar(255) ," +
                        "PRIMARY KEY (id))"
        );
        statement.executeUpdate("ALTER TABLE groupsMessage AUTO_INCREMENT=7000");
        statement.close();
    }

    private void initGroupActivityTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "groupActivity(id int NOT NULL AUTO_INCREMENT," +
                        "username varchar (255) ," +
                        "groupID varchar (255) ," +
                        "groupName varchar (255) ," +
                        "beingBan varchar (255) ," +
                        "date varchar(255) ," +
                        "time varchar(255) ," +
                        "PRIMARY KEY (id))"
        );
        statement.executeUpdate("ALTER TABLE groupActivity AUTO_INCREMENT=20000");
        statement.close();
    }

    private void initGroupsSettingsTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "groupsSettings(id int NOT NULL AUTO_INCREMENT," +
                        "groupID varchar (255) ," +
                        "groupName varchar (255) ," +
                        "owner varchar(255) ," +
                        "admin1 varchar(255) ," +
                        "admin2 varchar(255) ," +
                        "admin3 varchar(255) ," +
                        "date varchar(255) ," +
                        "time varchar(255) ," +
                        "PRIMARY KEY (id))"
        );
        statement.executeUpdate("ALTER TABLE groupsSettings AUTO_INCREMENT=30000");
        statement.close();
    }

}
