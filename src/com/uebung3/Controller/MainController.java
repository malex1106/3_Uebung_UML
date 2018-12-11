package com.uebung3.Controller;

import com.uebung3.Classes.SchuleClass;
import com.uebung3.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ListView<String> listViewAbteilungen;

    private static SchuleClass schule;

    private static ObservableList<String> abteilungslist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            schule = SchuleController.getSchule();

            abteilungslist.add("Elektronik und Technische Informatik");
            abteilungslist.add("Elektrotechnik");
            abteilungslist.add("Informatik");
            abteilungslist.add("Maschinenbau");
            abteilungslist.add("Wirtschaftingeniere");

            listViewAbteilungen.setItems(abteilungslist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SchuleClass getSchule() { return schule; }
}
