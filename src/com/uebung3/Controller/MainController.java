package com.uebung3.Controller;

import com.uebung3.Classes.SchuleClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ListView<String> listViewAbteilungen;

    @FXML
    private Label schoolName;

    private static SchuleClass schule;

    private static ObservableList<String> abteilungslist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            schule = SchuleController.getSchule();

            schoolName.setText("Schule - " + schule.getName());

            this.abteilungslist.add("Elektronik und Technische Informatik");
            this.abteilungslist.add("Elektrotechnik");
            this.abteilungslist.add("Informatik");
            this.abteilungslist.add("Maschinenbau");
            this.abteilungslist.add("Wirtschaftingeniere");

            this.listViewAbteilungen.setItems(this.abteilungslist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SchuleClass getSchule() { return schule; }
}
