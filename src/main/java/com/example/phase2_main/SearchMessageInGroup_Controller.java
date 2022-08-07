package com.example.phase2_main;

import com.example.phase2_main.repository.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SearchMessageInGroup_Controller implements Initializable {
    public static ArrayList<String> foundMessages;

    @FXML
    private TextField searchBox;
    @FXML
    private TreeView treeView;
    @FXML
    private ListView<String> listView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            groupRepository.searchByMessage(MessagingInGroup_Controller.groupID , Main.mainConnection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        listView.getItems().addAll(foundMessages);
    }

    public void search(ActionEvent event){
        listView.getItems().clear();
        listView.getItems().addAll(searchList(searchBox.getText(),foundMessages));
    }

    private List<String> searchList(String searchWords, List<String> listOfStrings) {

        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }


    public void selectItem() throws IOException {
        EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
            try {
                handleMouseClicked(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        listView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);
    }


    private void handleMouseClicked(MouseEvent event) throws IOException {
        Node node = event.getPickResult().getIntersectedNode();
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
            String name = listView.getSelectionModel().toString();
//            String name = (String) (listView.getSelectionModel().getSelectedItem()).getValue();
            ShowSearchedMessage_Controller.messageID = name.split("\\s")[2];

            Main main = new Main();
            main.changeScene("ShowSearchedMessage.fxml");
        }
    }

    public void back(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MessagingInGroup.fxml");
    }

    public void newPost(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("NewPost.fxml");
    }

    public void messages(ActionEvent event){
        Main main = new Main();
        //main.changeScene("");
    }

    public void groups(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("GroupNames.fxml");
    }

    public void searchOthers(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("SearchOthersPage.fxml");
    }

    public void myPage(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("MyPage.fxml");
    }

    public void settings(ActionEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Settings.fxml");
    }

    public void exit(ActionEvent event){
        System.exit(0);
    }

}
