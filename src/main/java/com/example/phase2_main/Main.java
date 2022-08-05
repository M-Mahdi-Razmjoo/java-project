package com.example.phase2_main;

import com.example.phase2_main.util.*;
import com.example.phase2_main.entity.*;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {
    static final String DB_URL = "jdbc:mysql://localhost:3306/phase1";
    static final String USER = "root";
    static final String PASS = "mahjoo2831";

    public static User currentUser;
    public static boolean IsCommercial = false ;
    public static Connection mainConnection;

    private static Stage stage;

    public static String photoDirectory;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        primaryStage.setTitle("Social Media App");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(DB_URL , USER , PASS);
        mainConnection=connection;
        AppContext.getDatabaseInitializer().createTables(connection);

        launch(args);
    }

    public  void changeScene(String fxmlFile) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        stage.getScene().setRoot(parent);
    }

}