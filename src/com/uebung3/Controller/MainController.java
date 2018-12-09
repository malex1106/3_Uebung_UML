package com.uebung3.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ListView<AnchorPane> listViewAbteilungen;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../FXMLs/abteilung.fxml"));
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("../FXMLs/abteilung.fxml"));
            AnchorPane pane3 = FXMLLoader.load(getClass().getResource("../FXMLs/abteilung.fxml"));

            ObservableList<AnchorPane> observableList = FXCollections.observableArrayList();
            observableList.add(pane);
            observableList.add(pane2);
            observableList.add(pane3);
            listViewAbteilungen.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
