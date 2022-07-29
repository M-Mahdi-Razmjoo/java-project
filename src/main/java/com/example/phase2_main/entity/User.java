package com.example.phase2_main.entity;

public class User {
    private String username;
    private String pass;
    private String securityQuestion;//favorite food
    private String bio;


    public User() {
    }

    public User(String username, String pass, String securityQuestion, String bio) {
        this.username = username;
        this.pass = pass;
        this.securityQuestion = securityQuestion;
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
