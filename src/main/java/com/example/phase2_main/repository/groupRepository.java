package com.example.phase2_main.repository;


import com.example.phase2_main.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;


public class groupRepository {

    public static void creatNewGroup(String groupName  , String groupPhotoDirectory , String groupID , Connection connection) throws SQLException {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO groupsSettings(groupID , groupName , groupPhotoDirectory , owner , admin1 , admin2 , admin3 , date , time )" +
                        "VALUES (?,?,?,?,?,?,?,?,?)"
        );

        preparedStatement.setString(1 , groupID);
        preparedStatement.setString(2 , groupName);
        preparedStatement.setString(3 , groupPhotoDirectory);
        preparedStatement.setString(4 , Main.currentUser.getUsername());
        preparedStatement.setString(5 , "not set");
        preparedStatement.setString(6 , "not set");
        preparedStatement.setString(7 , "not set");
        preparedStatement.setString(8 , localDate.toString());
        preparedStatement.setString(9 , localTime.toString());

        preparedStatement.executeUpdate();



        preparedStatement = connection.prepareStatement(
                "INSERT INTO groupActivity(username , groupID , groupName, beingBan , date , time )" +
                        "VALUES (?,?,?,?,?,?)"
        );

        preparedStatement.setString(1 , Main.currentUser.getUsername());
        preparedStatement.setString(2 , groupID);
        preparedStatement.setString(3 , groupName);
        preparedStatement.setString(4 , "No");
        preparedStatement.setString(5 , localDate.toString());
        preparedStatement.setString(6 , localTime.toString());

        preparedStatement.executeUpdate();
    }

    public static boolean IdAvailability (String id , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM groupsSettings");

        boolean check=false;

        while(resultset.next()){
            if(resultset.getString("groupID").equals(id)){
                check=true;
            }
        }

        if(check==false){
            return true;
        } else {
            return false;
        }
    }

    public static void showMyGroups(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM groupActivity");
        String groupName;
        while(resultset.next()){
            if(resultset.getString("username").equals(Main.currentUser.getUsername())){
                groupName=resultset.getString("groupName")+" - "+resultset.getString("groupID");
                GroupNames_Controller.myGroups.add(groupName);
            }
        }
    }

    public static ArrayList<String> showMyGroups2(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM groupActivity");
        String groupName;
        ArrayList<String> groups = new ArrayList<>();
        while(resultset.next()){
            if(resultset.getString("username").equals(Main.currentUser.getUsername())){
                groupName=resultset.getString("groupName")+" - "+resultset.getString("groupID");
                groups.add(groupName);
            }
        }
        return groups;
    }

    public static void showGroupToJoin(String username , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM groupsSettings");
        String groupName;

        ArrayList<String> groups = new ArrayList<>();

        while(resultset.next()){
            if(!(checkBeingInAGroup(username , resultset.getString("groupID") , connection))){
                groupName=resultset.getString("groupName")+" - "+resultset.getString("groupID");
                groups.add(groupName);
            }
        }
        JoinAGroup_Controller.groups=groups;
    }

    public static boolean checkBeingInAGroup(String username , String groupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM groupActivity");

        boolean check=false;

        while(resultset.next()){
            if(resultset.getString("username").equals(username) && resultset.getString("groupID").equals(groupID)){
                check=true;
            }
        }

        return check;
    }

    public static void showMessages(String groupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
        String groupName="";
        while(resultSet1.next()){
            if(resultSet1.getString("groupID").equals(groupID)){
                groupName=resultSet1.getString("groupName");
            }
        }

//        System.out.println("\n");
//        System.out.println("------------------" + groupName + "------------------");
//        System.out.println("*"+groupID+"     "+"*"+memberCounter(groupID,connection)+" members");
//        System.out.println();




        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage ORDER BY id DESC");
        int counter=0;

        while(resultSet2.next()){
            if(resultSet2.getString("groupID").equals(groupID) && counter<5){
                MessagingInGroup_Controller.beingPhoto[counter]=resultSet2.getString("beingPhoto");
                MessagingInGroup_Controller.sender[counter]=resultSet2.getString("sender");
                MessagingInGroup_Controller.content[counter]=resultSet2.getString("content");
                MessagingInGroup_Controller.photoDirectory[counter]=resultSet2.getString("photoDirectory");
                MessagingInGroup_Controller.replyToSender[counter]=resultSet2.getString("replyToSender");
                MessagingInGroup_Controller.replyToMessage[counter]=resultSet2.getString("replyToMessage");
                MessagingInGroup_Controller.beingForwarded[counter]=resultSet2.getString("beingForwarded");
                MessagingInGroup_Controller.forwardedFrom[counter]=resultSet2.getString("forwardedFrom");
                MessagingInGroup_Controller.beingEdited[counter]=resultSet2.getString("beingEdited");
                MessagingInGroup_Controller.date[counter]=resultSet2.getString("date");
                MessagingInGroup_Controller.time[counter]=resultSet2.getString("time");
                MessagingInGroup_Controller.messageID[counter]=resultSet2.getInt("id");


//                if(resultSet2.getString("replyToMessage").equals("nothing")){
//                    if(resultSet2.getString("beingForwarded").equalsIgnoreCase("yes")){
//                        System.out.println("Forwarded from " + resultSet2.getString("forwardedFrom") + " : ");
//
//                    } else {
//                        System.out.println(resultSet2.getString("sender") + " : ");
//                    }
//                    System.out.println(resultSet2.getString("content"));
//                    System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
//                    if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
//                        System.out.print("  " + "edited\n");
//                    } else {
//                        System.out.println();
//                    }
//                    System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
//                    counter++;
//                } else {
//                    if(resultSet2.getString("replyToMessage").equalsIgnoreCase("deleted")){
//                        System.out.println(resultSet2.getString("sender") + " : ");
//                        System.out.println("  │ Deleted message");
//                        System.out.println(resultSet2.getString("content"));
//                        System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
//                        if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
//                            System.out.print("  " + "edited\n");
//                        } else {
//                            System.out.println();
//                        }
//                        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
//                    } else {
//                        System.out.println(resultSet2.getString("sender") + " : ");
//                        System.out.println("  │ " + resultSet2.getString("replyToSender"));
//                        if(resultSet2.getString("replyToMessage").length()>20){
//                            System.out.println("  │ " + resultSet2.getString("replyToMessage").substring(0 , 17) + "...");
//                        } else {
//                            System.out.println("  │ " + resultSet2.getString("replyToMessage"));
//                        }
//                        System.out.println(resultSet2.getString("content"));
//                        System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
//                        if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
//                            System.out.print("  " + "edited\n");
//                        } else {
//                            System.out.println();
//                        }
//                        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
//                    }
//                    counter++;
//                }


            }
        }
    }

    public static String photoDirectory(String username , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM users");

        String photoDirectory="";

        while(resultset.next()){
            if(resultset.getString("username").equals(username)){
                photoDirectory=resultset.getString("photoDirectory");
            }
        }

        return photoDirectory;
    }

    public static int memberCounter(String groupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM groupActivity");

        int counter=0;

        while(resultSet.next()){
            if(resultSet.getString("groupID").equals(groupID)){
                counter++;
            }
        }

        return counter;
    }

    public static boolean newMessage(String content ,String groupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        boolean check=false;
        ResultSet result = statement.executeQuery("SELECT * FROM groupActivity");
        while(result.next()){
            if(result.getString("beingBan").equalsIgnoreCase("yes") && result.getString("username").equalsIgnoreCase(Main.currentUser.getUsername()) && result.getString("groupID").equalsIgnoreCase(groupID)){
                check=true;
            }
        }

        if(check){
            return false;
        } else {
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
            String groupName="";
            while(resultSet1.next()){
                if(resultSet1.getString("groupID").equals(groupID)){
                    groupName=resultSet1.getString("groupName");
                }
            }

            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO groupsMessage(groupName , groupID , sender , content , beingPhoto , photoDirectory , replyToSender , replyToMessage , beingForwarded , forwardedFrom , beingEdited , date , time )" +
                            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"
            );

            preparedStatement.setString(1 , groupName);
            preparedStatement.setString(2 , groupID);
            preparedStatement.setString(3 , Main.currentUser.getUsername());
            preparedStatement.setString(4 , content);
            preparedStatement.setString(5 , "no");
            preparedStatement.setString(6 , "nothing");
            preparedStatement.setString(7 , "nothing");
            preparedStatement.setString(8 , "nothing");
            preparedStatement.setString(9 , "no");
            preparedStatement.setString(10 , "nothing");
            preparedStatement.setString(11 , "no");
            preparedStatement.setString(12 , localDate.toString());
            preparedStatement.setString(13 , localTime.toString());


            preparedStatement.executeUpdate();
            return true;
        }
    }

    public static boolean newMessagePhoto(String photoDirectory , String groupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        boolean check=false;
        ResultSet result = statement.executeQuery("SELECT * FROM groupActivity");
        while(result.next()){
            if(result.getString("beingBan").equalsIgnoreCase("yes") && result.getString("username").equalsIgnoreCase(Main.currentUser.getUsername()) && result.getString("groupID").equalsIgnoreCase(groupID)){
                check=true;
            }
        }

        if(check){
            return false;
        } else {
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
            String groupName="";
            while(resultSet1.next()){
                if(resultSet1.getString("groupID").equals(groupID)){
                    groupName=resultSet1.getString("groupName");
                }
            }

            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO groupsMessage(groupName , groupID , sender , content , beingPhoto , photoDirectory , replyToSender , replyToMessage , beingForwarded , forwardedFrom , beingEdited , date , time )" +
                            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"
            );

            preparedStatement.setString(1 , groupName);
            preparedStatement.setString(2 , groupID);
            preparedStatement.setString(3 , Main.currentUser.getUsername());
            preparedStatement.setString(4 , "nothing");
            preparedStatement.setString(5 , "yes");
            preparedStatement.setString(6 , photoDirectory);
            preparedStatement.setString(7 , "nothing");
            preparedStatement.setString(8 , "nothing");
            preparedStatement.setString(9 , "no");
            preparedStatement.setString(10 , "nothing");
            preparedStatement.setString(11 , "no");
            preparedStatement.setString(12 , localDate.toString());
            preparedStatement.setString(13 , localTime.toString());


            preparedStatement.executeUpdate();
            return true;
        }
    }

    public static boolean replyMessage_message(String groupID , int messageID , String content , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        boolean check1=false;
        ResultSet result = statement.executeQuery("SELECT * FROM groupActivity");
        while(result.next()){
            if(result.getString("beingBan").equalsIgnoreCase("yes") && result.getString("username").equalsIgnoreCase(Main.currentUser.getUsername()) && result.getString("groupID").equalsIgnoreCase(groupID)){
                check1=true;
            }
        }

        if(check1){
            return false;
        } else {
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
            String groupName="";
            while(resultSet1.next()){
                if(resultSet1.getString("groupID").equals(groupID)){
                    groupName=resultSet1.getString("groupName");
                }
            }

            boolean check=false;

            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage");
            String replyToSender="";
            String replyToMessage="";
            while(resultSet2.next()){
                if(resultSet2.getInt("id")==messageID){
                    replyToSender=resultSet2.getString("sender");
                    replyToMessage=resultSet2.getString("content");
                    check=true;
                }
            }

            if(check){
                LocalDate localDate = LocalDate.now();
                LocalTime localTime = LocalTime.now();

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO groupsMessage(groupName , groupID , sender , content , beingPhoto , photoDirectory , replyToSender , replyToMessage , beingForwarded , forwardedFrom , beingEdited , date , time )" +
                                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"
                );

                preparedStatement.setString(1 , groupName);
                preparedStatement.setString(2 , groupID);
                preparedStatement.setString(3 , Main.currentUser.getUsername());
                preparedStatement.setString(4 , content);
                preparedStatement.setString(5 , "no");
                preparedStatement.setString(6 , "nothing");
                preparedStatement.setString(7 , replyToSender);
                preparedStatement.setString(8 , replyToMessage);
                preparedStatement.setString(9 , "no");
                preparedStatement.setString(10 , "nothing");
                preparedStatement.setString(11 , "no");
                preparedStatement.setString(12 , localDate.toString());
                preparedStatement.setString(13 , localTime.toString());


                preparedStatement.executeUpdate();
            }
            return true;
        }
    }

    public static boolean replyPhoto_message(String groupID , int messageID , String content , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        boolean check1=false;
        ResultSet result = statement.executeQuery("SELECT * FROM groupActivity");
        while(result.next()){
            if(result.getString("beingBan").equalsIgnoreCase("yes") && result.getString("username").equalsIgnoreCase(Main.currentUser.getUsername()) && result.getString("groupID").equalsIgnoreCase(groupID)){
                check1=true;
            }
        }

        if(check1){
            return false;
        } else {
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
            String groupName="";
            while(resultSet1.next()){
                if(resultSet1.getString("groupID").equals(groupID)){
                    groupName=resultSet1.getString("groupName");
                }
            }

            boolean check=false;

            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage");
            String replyToSender="";
            String replyToMessage="";
            while(resultSet2.next()){
                if(resultSet2.getInt("id")==messageID){
                    replyToSender=resultSet2.getString("sender");
                    replyToMessage="photo";
                    check=true;
                }
            }

            if(check){
                LocalDate localDate = LocalDate.now();
                LocalTime localTime = LocalTime.now();

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO groupsMessage(groupName , groupID , sender , content , beingPhoto , photoDirectory , replyToSender , replyToMessage , beingForwarded , forwardedFrom , beingEdited , date , time )" +
                                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"
                );

                preparedStatement.setString(1 , groupName);
                preparedStatement.setString(2 , groupID);
                preparedStatement.setString(3 , Main.currentUser.getUsername());
                preparedStatement.setString(4 , content);
                preparedStatement.setString(5 , "no");
                preparedStatement.setString(6 , "nothing");
                preparedStatement.setString(7 , replyToSender);
                preparedStatement.setString(8 , replyToMessage);
                preparedStatement.setString(9 , "no");
                preparedStatement.setString(10 , "nothing");
                preparedStatement.setString(11 , "no");
                preparedStatement.setString(12 , localDate.toString());
                preparedStatement.setString(13 , localTime.toString());


                preparedStatement.executeUpdate();
            }
            return true;
        }
    }

    public static boolean replyMessage_photo(String groupID , int messageID , String photoDirectory , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        boolean check1=false;
        ResultSet result = statement.executeQuery("SELECT * FROM groupActivity");
        while(result.next()){
            if(result.getString("beingBan").equalsIgnoreCase("yes") && result.getString("username").equalsIgnoreCase(Main.currentUser.getUsername()) && result.getString("groupID").equalsIgnoreCase(groupID)){
                check1=true;
            }
        }

        if(check1){
            return false;
        } else {
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
            String groupName="";
            while(resultSet1.next()){
                if(resultSet1.getString("groupID").equals(groupID)){
                    groupName=resultSet1.getString("groupName");
                }
            }

            boolean check=false;

            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage");
            String replyToSender="";
            String replyToMessage="";
            while(resultSet2.next()){
                if(resultSet2.getInt("id")==messageID){
                    replyToSender=resultSet2.getString("sender");
                    replyToMessage=resultSet2.getString("content");
                    check=true;
                }
            }

            if(check){
                LocalDate localDate = LocalDate.now();
                LocalTime localTime = LocalTime.now();

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO groupsMessage(groupName , groupID , sender , content , beingPhoto , photoDirectory , replyToSender , replyToMessage , beingForwarded , forwardedFrom , beingEdited , date , time )" +
                                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"
                );

                preparedStatement.setString(1 , groupName);
                preparedStatement.setString(2 , groupID);
                preparedStatement.setString(3 , Main.currentUser.getUsername());
                preparedStatement.setString(4 , "nothing");
                preparedStatement.setString(5 , "yes");
                preparedStatement.setString(6 , photoDirectory);
                preparedStatement.setString(7 , replyToSender);
                preparedStatement.setString(8 , replyToMessage);
                preparedStatement.setString(9 , "no");
                preparedStatement.setString(10 , "nothing");
                preparedStatement.setString(11 , "no");
                preparedStatement.setString(12 , localDate.toString());
                preparedStatement.setString(13 , localTime.toString());


                preparedStatement.executeUpdate();
            }
            return true;
        }
    }

    public static boolean replyPhoto_photo(String groupID , int messageID , String photoDirectory , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        boolean check1=false;
        ResultSet result = statement.executeQuery("SELECT * FROM groupActivity");
        while(result.next()){
            if(result.getString("beingBan").equalsIgnoreCase("yes") && result.getString("username").equalsIgnoreCase(Main.currentUser.getUsername()) && result.getString("groupID").equalsIgnoreCase(groupID)){
                check1=true;
            }
        }

        if(check1){
            return false;
        } else {
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
            String groupName="";
            while(resultSet1.next()){
                if(resultSet1.getString("groupID").equals(groupID)){
                    groupName=resultSet1.getString("groupName");
                }
            }

            boolean check=false;

            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage");
            String replyToSender="";
            String replyToMessage="";
            while(resultSet2.next()){
                if(resultSet2.getInt("id")==messageID){
                    replyToSender=resultSet2.getString("sender");
                    replyToMessage="photo";
                    check=true;
                }
            }

            if(check){
                LocalDate localDate = LocalDate.now();
                LocalTime localTime = LocalTime.now();

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO groupsMessage(groupName , groupID , sender , content , beingPhoto , photoDirectory , replyToSender , replyToMessage , beingForwarded , forwardedFrom , beingEdited , date , time )" +
                                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"
                );

                preparedStatement.setString(1 , groupName);
                preparedStatement.setString(2 , groupID);
                preparedStatement.setString(3 , Main.currentUser.getUsername());
                preparedStatement.setString(4 , "nothing");
                preparedStatement.setString(5 , "yes");
                preparedStatement.setString(6 , photoDirectory);
                preparedStatement.setString(7 , replyToSender);
                preparedStatement.setString(8 , replyToMessage);
                preparedStatement.setString(9 , "no");
                preparedStatement.setString(10 , "nothing");
                preparedStatement.setString(11 , "no");
                preparedStatement.setString(12 , localDate.toString());
                preparedStatement.setString(13 , localTime.toString());


                preparedStatement.executeUpdate();
            }
            return true;
        }
    }

    public static void forwardMessage(int messageID , String targetGroupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        boolean checkMessageID=false;

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsMessage");
        while(resultSet1.next()){
            if(resultSet1.getInt("id")==messageID){
                checkMessageID=true;
            }
        }

        if(checkMessageID){
            boolean checkTargetGroup1=false;

            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsSettings");
            while(resultSet2.next()){
                if(resultSet2.getString("groupID").equals(targetGroupID)){
                    checkTargetGroup1=true;
                }
            }

            if(checkTargetGroup1){
                boolean checkTargetGroup2=false;

                ResultSet resultSet3 = statement.executeQuery("SELECT * FROM groupActivity");
                while(resultSet3.next()){
                    if(resultSet3.getString("username").equals(Main.currentUser.getUsername()) && resultSet3.getString("groupID").equals(targetGroupID)){
                        checkTargetGroup2=true;
                    }
                }

                if(checkTargetGroup2){
                    String groupName="";
                    String content="";
                    String forwardedFrom="";
                    ResultSet resultSet4 = statement.executeQuery("SELECT * FROM groupsSettings");
                    while(resultSet4.next()){
                        if(resultSet4.getString("groupID").equals(targetGroupID)){
                            groupName=resultSet4.getString("groupName");
                        }
                    }

                    ResultSet resultSet5 = statement.executeQuery("SELECT * FROM groupsMessage");
                    while(resultSet5.next()){
                        if(resultSet5.getInt("id")==messageID){
                            content = resultSet5.getString("content");
                            forwardedFrom = resultSet5.getString("sender");
                        }
                    }

                    LocalDate localDate = LocalDate.now();
                    LocalTime localTime = LocalTime.now();

                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "INSERT INTO groupsMessage(groupName , groupID , sender , content , beingPhoto , photoDirectory , replyToSender , replyToMessage , beingForwarded , forwardedFrom , beingEdited , date , time )" +
                                    "VALUES (?,?,?,?,?,?,?,?,?,?,?)"
                    );

                    preparedStatement.setString(1 , groupName);
                    preparedStatement.setString(2 , targetGroupID);
                    preparedStatement.setString(3 , Main.currentUser.getUsername());
                    preparedStatement.setString(4 , content);
                    preparedStatement.setString(4 , "no");
                    preparedStatement.setString(4 , "nothing");
                    preparedStatement.setString(5 , "nothing");
                    preparedStatement.setString(6 , "nothing");
                    preparedStatement.setString(7 , "yes");
                    preparedStatement.setString(8 , forwardedFrom);
                    preparedStatement.setString(9 , "no");
                    preparedStatement.setString(10 , localDate.toString());
                    preparedStatement.setString(11 , localTime.toString());


                    preparedStatement.executeUpdate();

                } else {
                    System.out.println("You are not a member of this group!");
                }

            } else {
                System.out.println("There is no such a group!");
            }

        } else {
            System.out.println("Message ID is wrong!");
        }

    }

    public static void forwardPhoto(int messageID , String targetGroupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        boolean checkMessageID=false;

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsMessage");
        while(resultSet1.next()){
            if(resultSet1.getInt("id")==messageID){
                checkMessageID=true;
            }
        }

        if(checkMessageID){
            boolean checkTargetGroup1=false;

            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsSettings");
            while(resultSet2.next()){
                if(resultSet2.getString("groupID").equals(targetGroupID)){
                    checkTargetGroup1=true;
                }
            }

            if(checkTargetGroup1){
                boolean checkTargetGroup2=false;

                ResultSet resultSet3 = statement.executeQuery("SELECT * FROM groupActivity");
                while(resultSet3.next()){
                    if(resultSet3.getString("username").equals(Main.currentUser.getUsername()) && resultSet3.getString("groupID").equals(targetGroupID)){
                        checkTargetGroup2=true;
                    }
                }

                if(checkTargetGroup2){
                    String groupName="";
                    String photoDirectory="";
                    String forwardedFrom="";
                    ResultSet resultSet4 = statement.executeQuery("SELECT * FROM groupsSettings");
                    while(resultSet4.next()){
                        if(resultSet4.getString("groupID").equals(targetGroupID)){
                            groupName=resultSet4.getString("groupName");
                        }
                    }

                    ResultSet resultSet5 = statement.executeQuery("SELECT * FROM groupsMessage");
                    while(resultSet5.next()){
                        if(resultSet5.getInt("id")==messageID){
                            photoDirectory = resultSet5.getString("photoDirectory");
                            forwardedFrom = resultSet5.getString("sender");
                        }
                    }

                    LocalDate localDate = LocalDate.now();
                    LocalTime localTime = LocalTime.now();

                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "INSERT INTO groupsMessage(groupName , groupID , sender , content , beingPhoto , photoDirectory , replyToSender , replyToMessage , beingForwarded , forwardedFrom , beingEdited , date , time )" +
                                    "VALUES (?,?,?,?,?,?,?,?,?,?,?)"
                    );

                    preparedStatement.setString(1 , groupName);
                    preparedStatement.setString(2 , targetGroupID);
                    preparedStatement.setString(3 , Main.currentUser.getUsername());
                    preparedStatement.setString(4 , "nothing");
                    preparedStatement.setString(4 , "yes");
                    preparedStatement.setString(4 , photoDirectory);
                    preparedStatement.setString(5 , "nothing");
                    preparedStatement.setString(6 , "nothing");
                    preparedStatement.setString(7 , "yes");
                    preparedStatement.setString(8 , forwardedFrom);
                    preparedStatement.setString(9 , "no");
                    preparedStatement.setString(10 , localDate.toString());
                    preparedStatement.setString(11 , localTime.toString());


                    preparedStatement.executeUpdate();

                } else {
                    System.out.println("You are not a member of this group!");
                }

            } else {
                System.out.println("There is no such a group!");
            }

        } else {
            System.out.println("Message ID is wrong!");
        }

    }

    public static void editMessage(int messageID , String groupID , String content , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
        String groupName="";
        while(resultSet1.next()){
            if(resultSet1.getString("groupID").equals(groupID)){
                groupName=resultSet1.getString("groupName");
            }
        }

        ResultSet resultSet4 = statement.executeQuery("SELECT * FROM groupsMessage");
        boolean checkSender=false;
        while (resultSet4.next()){
            if(resultSet4.getInt("id")==messageID){
                if(resultSet4.getString("sender").equals(Main.currentUser.getUsername())){
                    checkSender=true;
                }
            }
        }

        if(checkSender){
            int counter=0;
            int holder=0;

            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage ORDER BY id DESC");
            while(resultSet2.next()){
                if(resultSet2.getString("groupID").equals(groupID) && resultSet2.getString("sender").equals(Main.currentUser.getUsername())){
                    counter++;
                    if(resultSet2.getInt("id")==messageID){
                        holder=counter;
                    }
                }
            }

            if(holder>5){
                System.out.println("You can not edit this message!");
            } else {
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

                ResultSet resultSet3 = statement.executeQuery("SELECT * FROM groupsMessage");


                while(resultSet3.next()){
                    if(resultSet3.getInt("id")==messageID){
                        resultSet3.updateString("content" , content);
                        resultSet3.updateRow();
                        resultSet3.updateString("beingEdited" , "yes");
                        resultSet3.updateRow();
                    }
                }
            }
        } else {
            System.out.println("You can not edit this message!");
        }

    }

    public static void editPhoto(int messageID , String groupID , String photoDirectory , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
        String groupName="";
        while(resultSet1.next()){
            if(resultSet1.getString("groupID").equals(groupID)){
                groupName=resultSet1.getString("groupName");
            }
        }

        ResultSet resultSet4 = statement.executeQuery("SELECT * FROM groupsMessage");
        boolean checkSender=false;
        while (resultSet4.next()){
            if(resultSet4.getInt("id")==messageID){
                if(resultSet4.getString("sender").equals(Main.currentUser.getUsername())){
                    checkSender=true;
                }
            }
        }

        if(checkSender){
            int counter=0;
            int holder=0;

            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage ORDER BY id DESC");
            while(resultSet2.next()){
                if(resultSet2.getString("groupID").equals(groupID) && resultSet2.getString("sender").equals(Main.currentUser.getUsername())){
                    counter++;
                    if(resultSet2.getInt("id")==messageID){
                        holder=counter;
                    }
                }
            }

            if(holder>5){
                System.out.println("You can not edit this message!");
            } else {
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

                ResultSet resultSet3 = statement.executeQuery("SELECT * FROM groupsMessage");


                while(resultSet3.next()){
                    if(resultSet3.getInt("id")==messageID){
                        resultSet3.updateString("photoDirectory" , photoDirectory);
                        resultSet3.updateRow();
                        resultSet3.updateString("beingEdited" , "yes");
                        resultSet3.updateRow();
                    }
                }
            }
        } else {
            System.out.println("You can not edit this message!");
        }

    }

    public static boolean deleteMessage(int messageID , String groupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
        String groupName="";
        while(resultSet1.next()){
            if(resultSet1.getString("groupID").equals(groupID)){
                groupName=resultSet1.getString("groupName");
            }
        }

        ResultSet resultSet4 = statement.executeQuery("SELECT * FROM groupsMessage");
        String content="";
        while(resultSet4.next()){
            if(resultSet4.getInt("id")==messageID){
                content=resultSet4.getString("content");
            }
        }

        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage");
        boolean checkSender=false;
        while (resultSet2.next()){
            if(resultSet2.getInt("id")==messageID){
                if(resultSet2.getString("sender").equals(Main.currentUser.getUsername())){
                    checkSender=true;
                }
            }
        }

        if(checkSender){
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet3 = statement.executeQuery("SELECT * FROM groupsMessage");

            while(resultSet3.next()){
                if(resultSet3.getString("replyToSender").equals(Main.currentUser.getUsername()) && resultSet3.getString("replyToMessage").equals(content)){
                    resultSet3.updateString("replyToMessage" , "deleted");
                    resultSet3.updateRow();
                }
            }


            PreparedStatement preparedStatement2 = connection.prepareStatement(
                    "DELETE FROM groupsMessage WHERE id = ?"
            );
            preparedStatement2.setInt(1, messageID);
            preparedStatement2.execute();
            return true;
        } else {
            return false;
        }
    }

    public static boolean deletePhoto(int messageID , String groupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
        String groupName="";
        while(resultSet1.next()){
            if(resultSet1.getString("groupID").equals(groupID)){
                groupName=resultSet1.getString("groupName");
            }
        }

        String content="photo";


        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage");
        boolean checkSender=false;
        while (resultSet2.next()){
            if(resultSet2.getInt("id")==messageID){
                if(resultSet2.getString("sender").equals(Main.currentUser.getUsername())){
                    checkSender=true;
                }
            }
        }

        if(checkSender){
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet3 = statement.executeQuery("SELECT * FROM groupsMessage");

            while(resultSet3.next()){
                if(resultSet3.getString("replyToSender").equals(Main.currentUser.getUsername()) && resultSet3.getString("replyToMessage").equals(content)){
                    resultSet3.updateString("replyToMessage" , "deleted");
                    resultSet3.updateRow();
                }
            }


            PreparedStatement preparedStatement2 = connection.prepareStatement(
                    "DELETE FROM groupsMessage WHERE id = ?"
            );
            preparedStatement2.setInt(1, messageID);
            preparedStatement2.execute();
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<String> showMembers(String groupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ArrayList<String> members = new ArrayList<>();

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupActivity");
        while(resultSet1.next()){
            if(resultSet1.getString("groupID").equals(groupID)){
                members.add(resultSet1.getString("username"));
            }
        }
        return members;
    }

    public static boolean groupSettingsCheck(String groupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
        boolean check=false;
        while(resultSet1.next()){
            if(resultSet1.getString("groupID").equals(groupID)){
                if(resultSet1.getString("owner").equalsIgnoreCase(Main.currentUser.getUsername()) || resultSet1.getString("admin1").equalsIgnoreCase(Main.currentUser.getUsername()) || resultSet1.getString("admin2").equalsIgnoreCase(Main.currentUser.getUsername()) || resultSet1.getString("admin3").equalsIgnoreCase(Main.currentUser.getUsername())){
                    check=true;
                }
            }
        }
        return check;
    }

    public static void changeGroupName(String groupID , String newGroupName , Connection connection) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsMessage");
        while(resultSet1.next()) {
            if (resultSet1.getString("groupID").equals(groupID)) {
                resultSet1.updateString("groupName" , newGroupName);
                resultSet1.updateRow();
            }
        }

        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupActivity");
        while(resultSet2.next()) {
            if (resultSet2.getString("groupID").equals(groupID)) {
                resultSet2.updateString("groupName" , newGroupName);
                resultSet2.updateRow();
            }
        }

        ResultSet resultSet3 = statement.executeQuery("SELECT * FROM groupsSettings");
        while(resultSet3.next()) {
            if (resultSet3.getString("groupID").equals(groupID)) {
                resultSet3.updateString("groupName" , newGroupName);
                resultSet3.updateRow();
            }
        }

    }

    public static void changeGroupID(String newGroupID , String oldGroupID, Connection connection) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsMessage");
        while(resultSet1.next()) {
            if (resultSet1.getString("groupID").equals(oldGroupID)) {
                resultSet1.updateString("groupID" , newGroupID);
                resultSet1.updateRow();
            }
        }

        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupActivity");
        while(resultSet2.next()) {
            if (resultSet2.getString("groupID").equals(oldGroupID)) {
                resultSet2.updateString("groupID" , newGroupID);
                resultSet2.updateRow();
            }
        }

        ResultSet resultSet3 = statement.executeQuery("SELECT * FROM groupsSettings");
        while(resultSet3.next()) {
            if (resultSet3.getString("groupID").equals(oldGroupID)) {
                resultSet3.updateString("groupID" , newGroupID);
                resultSet3.updateRow();
            }
        }
    }

    public static void leaveTheGroup(String username , String groupID ,Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
        String status="";
        while(resultSet1.next()){
            if(resultSet1.getString("owner").equals(username)){
                status="owner";
            } else if(resultSet1.getString("admin1").equals(username)){
                status="admin1";
            } else if(resultSet1.getString("admin2").equals(username)){
                status="admin2";
            } else if(resultSet1.getString("admin3").equals(username)){
                status="admin3";
            } else {
                status="nothing";
            }
        }

        if(status.equalsIgnoreCase("nothing")){
            PreparedStatement preparedStatement2 = connection.prepareStatement(
                    "DELETE FROM groupActivity WHERE username = ? AND groupID = ?"
            );
            preparedStatement2.setString(1 , username);
            preparedStatement2.setString(2 , groupID);
            preparedStatement2.execute();
        } else if(status.equalsIgnoreCase("owner")){
            statement = connection.createStatement();

            String admin1="";

            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsSettings");
            while(resultSet2.next()){
                if(resultSet2.getString("groupID").equalsIgnoreCase(groupID)){
                    admin1=resultSet2.getString("admin1");
                }
            }

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM groupsSettings");
            while(resultSet.next()) {
                if (resultSet.getString("groupID").equals(groupID)) {
                    resultSet.updateString("owner" , admin1);
                    resultSet.updateRow();
                    resultSet.updateString("admin1" , "nothing");
                    resultSet.updateRow();
                }
            }

            PreparedStatement preparedStatement2 = connection.prepareStatement(
                    "DELETE FROM groupActivity WHERE username = ? AND groupID = ?"
            );
            preparedStatement2.setString(1 , username);
            preparedStatement2.setString(2 , groupID);
            preparedStatement2.execute();

        } else if(status.equalsIgnoreCase("admin1")){
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM groupsSettings");
            while(resultSet.next()) {
                if (resultSet.getString("groupID").equals(groupID)) {
                    resultSet.updateString("admin1" , "nothing");
                    resultSet.updateRow();
                }
            }

            PreparedStatement preparedStatement2 = connection.prepareStatement(
                    "DELETE FROM groupActivity WHERE username = ? AND groupID = ?"
            );
            preparedStatement2.setString(1 , username);
            preparedStatement2.setString(2 , groupID);
            preparedStatement2.execute();
        } else if(status.equalsIgnoreCase("admin2")){
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM groupsSettings");
            while(resultSet.next()) {
                if (resultSet.getString("groupID").equals(groupID)) {
                    resultSet.updateString("admin2" , "nothing");
                    resultSet.updateRow();
                }
            }

            PreparedStatement preparedStatement2 = connection.prepareStatement(
                    "DELETE FROM groupActivity WHERE username = ? AND groupID = ?"
            );
            preparedStatement2.setString(1 , username);
            preparedStatement2.setString(2 , groupID);
            preparedStatement2.execute();
        } else if(status.equalsIgnoreCase("admin3")){
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM groupsSettings");
            while(resultSet.next()) {
                if (resultSet.getString("groupID").equals(groupID)) {
                    resultSet.updateString("admin3" , "nothing");
                    resultSet.updateRow();
                }
            }

            PreparedStatement preparedStatement2 = connection.prepareStatement(
                    "DELETE FROM groupActivity WHERE username = ? AND groupID = ?"
            );
            preparedStatement2.setString(1 , username);
            preparedStatement2.setString(2 , groupID);
            preparedStatement2.execute();
        }
    }

    public static void removeMember(String username , String groupID , Connection connection) throws SQLException {
        leaveTheGroup(username , groupID , connection);
    }

    public static void banMember(String username , String groupID ,Connection connection) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM groupActivity");
        while(resultSet.next()) {
            if (resultSet.getString("groupID").equals(groupID) && resultSet.getString("username").equals(username)) {
                resultSet.updateString("beingBan" , "yes");
                resultSet.updateRow();
            }
        }
    }

    public static boolean groupOwnerCheck(String groupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
        boolean check=false;
        while(resultSet1.next()){
            if(resultSet1.getString("groupID").equals(groupID)){
                if(resultSet1.getString("owner").equalsIgnoreCase(Main.currentUser.getUsername())){
                    check=true;
                }
            }
        }
        return check;
    }

    public static boolean setAdmin(String adminNumber , String username , String groupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        boolean usernameCheck=false;

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupActivity");
        while(resultSet1.next()){
            if(resultSet1.getString("groupID").equals(groupID) && resultSet1.getString("username").equals(username)){
                usernameCheck=true;
            }
        }

        if(usernameCheck){
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM groupsSettings");
            while(resultSet.next()) {
                if (resultSet.getString("groupID").equals(groupID)) {
                    resultSet.updateString(adminNumber , username);
                    resultSet.updateRow();
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void removeAdmin(String adminNumber , String groupID , Connection connection) throws SQLException {
        setAdmin(adminNumber , "nothing" , groupID , connection);
    }

    public static void searchByMessage(String groupID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ArrayList<String> foundMessages = new ArrayList<>();
        String temp ="";

        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage ORDER BY id DESC");
        while(resultSet2.next()){
            if(resultSet2.getString("groupID").equalsIgnoreCase(groupID)){
                temp=resultSet2.getString("content")+" - "+String.valueOf(resultSet2.getInt("id"))+" - "+resultSet2.getString("date")+" - "+resultSet2.getString("time");
                foundMessages.add(temp);
            }
        }
        SearchMessageInGroup_Controller.foundMessages=foundMessages;
    }

    public static void searchByID(String usernameID , String groupID , Connection connection , Scanner scan) throws SQLException {
        Statement statement = connection.createStatement();

        int counter=0;

        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage ORDER BY id DESC");
        while(resultSet2.next()){
            if(resultSet2.getString("sender").contains(usernameID) && resultSet2.getString("groupID").equalsIgnoreCase(groupID)){
                if(resultSet2.getString("replyToMessage").equals("nothing")){
                    if(resultSet2.getString("beingForwarded").equalsIgnoreCase("yes")){
                        System.out.println("Forwarded from " + resultSet2.getString("forwardedFrom") + " : ");

                    } else {
                        System.out.println(resultSet2.getString("sender") + " : ");
                    }
                    if(resultSet2.getString("content").length()>=10){
                        System.out.println(resultSet2.getString("content").substring(0 , 17)+" ... ");
                    } else {
                        System.out.println(resultSet2.getString("content"));
                    }

                    System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
                    if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
                        System.out.print("  " + "edited\n");
                    } else {
                        System.out.println();
                    }
                    System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                } else {
                    if(resultSet2.getString("replyToMessage").equalsIgnoreCase("deleted")){
                        System.out.println(resultSet2.getString("sender") + " : ");
                        System.out.println("  │ Deleted message");
                        if(resultSet2.getString("content").length()>=10){
                            System.out.println(resultSet2.getString("content").substring(0 , 17)+" ... ");
                        } else {
                            System.out.println(resultSet2.getString("content"));
                        }
                        System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
                        if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
                            System.out.print("  " + "edited\n");
                        } else {
                            System.out.println();
                        }
                        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                    } else {
                        System.out.println(resultSet2.getString("sender") + " : ");
                        System.out.println("  │ " + resultSet2.getString("replyToSender"));
                        if(resultSet2.getString("replyToMessage").length()>20){
                            System.out.println("  │ " + resultSet2.getString("replyToMessage").substring(0 , 17) + "...");
                        } else {
                            System.out.println("  │ " + resultSet2.getString("replyToMessage"));
                        }
                        if(resultSet2.getString("content").length()>=10){
                            System.out.println(resultSet2.getString("content").substring(0 , 17)+" ... ");
                        } else {
                            System.out.println(resultSet2.getString("content"));
                        }
                        System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
                        if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
                            System.out.print("  " + "edited\n");
                        } else {
                            System.out.println();
                        }
                        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                    }
                }
                counter++;
            }
        }

        if(counter==0){
            System.out.println("Nothing Found!");
        } else {
            String choosenID;
            System.out.println("Enter the ID to see the full message :");
            choosenID=scan.nextLine();
            resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage ORDER BY id DESC");
            while (resultSet2.next()){
                if(resultSet2.getInt("id")==Integer.parseInt(choosenID) && resultSet2.getString("groupID").equalsIgnoreCase(groupID)){
                    if(resultSet2.getString("replyToMessage").equals("nothing")){
                        if(resultSet2.getString("beingForwarded").equalsIgnoreCase("yes")){
                            System.out.println("Forwarded from " + resultSet2.getString("forwardedFrom") + " : ");

                        } else {
                            System.out.println(resultSet2.getString("sender") + " : ");
                        }
                        System.out.println(resultSet2.getString("content"));
                        System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
                        if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
                            System.out.print("  " + "edited\n");
                        } else {
                            System.out.println();
                        }
                        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                    } else {
                        if(resultSet2.getString("replyToMessage").equalsIgnoreCase("deleted")){
                            System.out.println(resultSet2.getString("sender") + " : ");
                            System.out.println("  │ Deleted message");
                            System.out.println(resultSet2.getString("content"));
                            System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
                            if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
                                System.out.print("  " + "edited\n");
                            } else {
                                System.out.println();
                            }
                            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                        } else {
                            System.out.println(resultSet2.getString("sender") + " : ");
                            System.out.println("  │ " + resultSet2.getString("replyToSender"));
                            if(resultSet2.getString("replyToMessage").length()>20){
                                System.out.println("  │ " + resultSet2.getString("replyToMessage").substring(0 , 17) + "...");
                            } else {
                                System.out.println("  │ " + resultSet2.getString("replyToMessage"));
                            }
                            System.out.println(resultSet2.getString("content"));
                            System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
                            if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
                                System.out.print("  " + "edited\n");
                            } else {
                                System.out.println();
                            }
                            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                        }
                    }
                }
            }
        }

    }

    public static void searchByDate(String date , String groupID , Connection connection , Scanner scan) throws SQLException {
        Statement statement = connection.createStatement();

        int counter=0;

        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage ORDER BY id DESC");
        while(resultSet2.next()){
            if(resultSet2.getString("date").equalsIgnoreCase(date) && resultSet2.getString("groupID").equalsIgnoreCase(groupID)){
                if(resultSet2.getString("replyToMessage").equals("nothing")){
                    if(resultSet2.getString("beingForwarded").equalsIgnoreCase("yes")){
                        System.out.println("Forwarded from " + resultSet2.getString("forwardedFrom") + " : ");

                    } else {
                        System.out.println(resultSet2.getString("sender") + " : ");
                    }
                    if(resultSet2.getString("content").length()>=10){
                        System.out.println(resultSet2.getString("content").substring(0 , 17)+" ... ");
                    } else {
                        System.out.println(resultSet2.getString("content"));
                    }

                    System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
                    if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
                        System.out.print("  " + "edited\n");
                    } else {
                        System.out.println();
                    }
                    System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                } else {
                    if(resultSet2.getString("replyToMessage").equalsIgnoreCase("deleted")){
                        System.out.println(resultSet2.getString("sender") + " : ");
                        System.out.println("  │ Deleted message");
                        if(resultSet2.getString("content").length()>=10){
                            System.out.println(resultSet2.getString("content").substring(0 , 17)+" ... ");
                        } else {
                            System.out.println(resultSet2.getString("content"));
                        }
                        System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
                        if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
                            System.out.print("  " + "edited\n");
                        } else {
                            System.out.println();
                        }
                        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                    } else {
                        System.out.println(resultSet2.getString("sender") + " : ");
                        System.out.println("  │ " + resultSet2.getString("replyToSender"));
                        if(resultSet2.getString("replyToMessage").length()>20){
                            System.out.println("  │ " + resultSet2.getString("replyToMessage").substring(0 , 17) + "...");
                        } else {
                            System.out.println("  │ " + resultSet2.getString("replyToMessage"));
                        }
                        if(resultSet2.getString("content").length()>=10){
                            System.out.println(resultSet2.getString("content").substring(0 , 17)+" ... ");
                        } else {
                            System.out.println(resultSet2.getString("content"));
                        }
                        System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
                        if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
                            System.out.print("  " + "edited\n");
                        } else {
                            System.out.println();
                        }
                        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                    }
                }
                counter++;
            }
        }

        if(counter==0){
            System.out.println("Nothing Found!");
        } else {
            String choosenID;
            System.out.println("Enter the ID to see the full message :");
            choosenID=scan.nextLine();
            resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage ORDER BY id DESC");
            while (resultSet2.next()){
                if(resultSet2.getInt("id")==Integer.parseInt(choosenID) && resultSet2.getString("groupID").equalsIgnoreCase(groupID)){
                    if(resultSet2.getString("replyToMessage").equals("nothing")){
                        if(resultSet2.getString("beingForwarded").equalsIgnoreCase("yes")){
                            System.out.println("Forwarded from " + resultSet2.getString("forwardedFrom") + " : ");

                        } else {
                            System.out.println(resultSet2.getString("sender") + " : ");
                        }
                        System.out.println(resultSet2.getString("content"));
                        System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
                        if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
                            System.out.print("  " + "edited\n");
                        } else {
                            System.out.println();
                        }
                        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                    } else {
                        if(resultSet2.getString("replyToMessage").equalsIgnoreCase("deleted")){
                            System.out.println(resultSet2.getString("sender") + " : ");
                            System.out.println("  │ Deleted message");
                            System.out.println(resultSet2.getString("content"));
                            System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
                            if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
                                System.out.print("  " + "edited\n");
                            } else {
                                System.out.println();
                            }
                            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                        } else {
                            System.out.println(resultSet2.getString("sender") + " : ");
                            System.out.println("  │ " + resultSet2.getString("replyToSender"));
                            if(resultSet2.getString("replyToMessage").length()>20){
                                System.out.println("  │ " + resultSet2.getString("replyToMessage").substring(0 , 17) + "...");
                            } else {
                                System.out.println("  │ " + resultSet2.getString("replyToMessage"));
                            }
                            System.out.println(resultSet2.getString("content"));
                            System.out.print(" ID = "+resultSet2.getString("id") + "   " + resultSet2.getString("date") + "   " + resultSet2.getString("time"));
                            if(resultSet2.getString("beingEdited").equalsIgnoreCase("yes")){
                                System.out.print("  " + "edited\n");
                            } else {
                                System.out.println();
                            }
                            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                        }
                    }
                }
            }
        }
    }

    public static void joinGroup(String username , String groupID ,Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        boolean check=false;
        String groupName="";

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM groupsSettings");
        while(resultSet1.next()){
            if(resultSet1.getString("groupID").equals(groupID)){
                check=true;
                groupName=resultSet1.getString("groupName");
            }
        }

        if(check){
            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO groupActivity(username , groupID , groupName , beingBan , date , time )" +
                            "VALUES (?,?,?,?,?,?)"
            );

            preparedStatement.setString(1 , username);
            preparedStatement.setString(2 , groupID);
            preparedStatement.setString(3 , groupName);
            preparedStatement.setString(4 , "no");
            preparedStatement.setString(5 , localDate.toString());
            preparedStatement.setString(6 , localTime.toString());

            preparedStatement.executeUpdate();
        }

    }

    public static int addMember(String username , String groupID ,Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        boolean checkUsername=false;
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM users");
        while(resultSet1.next()){
            if(resultSet1.getString("username").equalsIgnoreCase(username)){
                checkUsername=true;
            }
        }

        if(checkUsername){

            boolean checkBeingInGroup=true;
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupActivity");
            while(resultSet2.next()){
                if(resultSet2.getString("username").equalsIgnoreCase(username) && resultSet2.getString("groupID").equalsIgnoreCase(groupID)){
                    checkBeingInGroup=false;
                }
            }

            if(checkBeingInGroup){
                joinGroup(username , groupID , connection);
                return 1;
            } else {
                return 2;
            }

        } else {
            return 3;
        }

    }

    public static void findMessage(String messageID , Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM groupsMessage ORDER BY id DESC");

        while(resultSet2.next()){
            if(resultSet2.getInt("id")==Integer.parseInt(messageID)){
                ShowSearchedMessage_Controller.content=resultSet2.getString("content");
                ShowSearchedMessage_Controller.username1=resultSet2.getString("sender");
                ShowSearchedMessage_Controller.dat1=resultSet2.getString("date");
                ShowSearchedMessage_Controller.time1=resultSet2.getString("time");
                ShowSearchedMessage_Controller.photoDirectory=photoDirectory(resultSet2.getString("sender") , connection);
            }
        }
    }

}
