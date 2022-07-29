package com.example.phase2_main.util;

public class AppContext {

    private static final DatabaseInitializer databaseInitializer = new DatabaseInitializer();
    public static DatabaseInitializer getDatabaseInitializer(){
        return databaseInitializer;
    }
}
