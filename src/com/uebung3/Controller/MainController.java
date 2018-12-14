package com.uebung3.Controller;

import com.uebung3.Classes.SchuleClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private BorderPane schoolPanel;

    @FXML
    private AnchorPane abtAddPanel;

    @FXML
    private TextField abtAddTextfield;

    @FXML
    private ListView<String> listViewAbteilungen;

    @FXML
    private Label schoolName;

    private static SchuleClass schule;

    private ObservableList<String> abteilungslist = FXCollections.observableArrayList();

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

    @FXML
    void abtAddButtonClicked(ActionEvent event) {
        this.schoolPanel.setDisable(true);
        this.abtAddPanel.setVisible(true);
    }

    //////////////////////////////////////////////////////////////////////////
    // Abteilung Hinzufügen - Panel
    ////////////////////////////////////////////////////////////////////////

    @FXML
    void abtAddAddButton(ActionEvent event) {
        this.abteilungslist.add(abtAddTextfield.getText());

        this.abtAddPanel.setVisible(false);
        this.schoolPanel.setDisable(false);
    }

    @FXML
    void abtAddExitButtonClicked(ActionEvent event) {
        this.abtAddPanel.setVisible(false);
        this.schoolPanel.setDisable(false);
    }

    public static SchuleClass getSchule() { return schule; }
}
