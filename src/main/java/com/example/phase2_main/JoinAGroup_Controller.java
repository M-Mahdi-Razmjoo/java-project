package com.example.phase2_main;

import com.example.phase2_main.repository.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class JoinAGroup_Controller implements Initializable {

    public static ArrayList<String> groups;

    @FXML
    private TextField searchText;
    @FXML
    private TreeView groupNames;
    @FXML
    private Label joinGroup_warning;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            groupRepository.showGroupToJoin(Main.currentUser.getUsername() , Main.mainConnection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TreeItem<String> rootItem = new TreeItem<>("Groups");

        for(int i=0 ; i<groups.size() ; i++){
            TreeItem<String> branchItem = new TreeItem<>(groups.get(i));
            rootItem.getChildren().add(branchItem);
        }
        if(groupNames != null){
            groupNames.setRoot(rootItem);
            groupNames.setShowRoot(false);
        }
    }

    public void join(ActionEvent event) throws SQLException {
        boolean check = false;
        String groupID="";
        for(int i=0 ; i<groups.size() ; i++){
            if(groups.get(i).split("\\s")[2].equalsIgnoreCase(searchText.getText())){
                check=true;
                groupID=groups.get(i).split("\\s")[2];
            }
        }
        if(check){
            groupRepository.joinGroup(Main.currentUser.getUsername() , groupID , Main.mainConnection);
        } else {
            joinGroup_warning.setText("There is no such group!");
        }
    }

    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("GroupNames.fxml");
    }
}
