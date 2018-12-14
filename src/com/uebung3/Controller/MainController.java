package com.uebung3.Controller;

import com.uebung3.Classes.AbteilungClass;
import com.uebung3.Classes.SchuleClass;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    public ListView<String> listViewAbteilungen;

    @FXML
    private Label schoolName;

    ////////////////////////////////////////////
    // Info - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private TextField abtInfoNameTextfield;

    @FXML
    private TextField abtInfoKuerzelTextfield;

    ////////////////////////////////////////////
    // Abteilung Hinzufügen - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private TextField abtAddTextfield;

    @FXML
    private TextField abtAddKuerzelTextfield;

    private static SchuleClass schule;
    private static AbteilungClass selectedAbteilung;

    private ObservableList<String> abteilungslist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            schule = SchuleController.getSchule();

            schoolName.setText("Schule - " + schule.getName());

            this.listViewAbteilungen.getSelectionModel().selectedItemProperty()
                    .addListener(new ChangeListener<String>() {

                        public void changed(
                                ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            System.out.println("New Selection: " + newValue + " | Old Selection: " + oldValue + " | Index: " + listViewAbteilungen.getSelectionModel().getSelectedIndex());
                            selectedAbteilung = schule.getAbteilungen().get(listViewAbteilungen.getSelectionModel().getSelectedIndex());
                            abtInfoNameTextfield.setText(selectedAbteilung.getName());
                            abtInfoKuerzelTextfield.setText(selectedAbteilung.getKuerzel());
                        }
                    });

            this.listViewAbteilungen.setItems(this.abteilungslist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Home - Panel
    ////////////////////////////////////////////////////////////////////////

    @FXML
    void abtAddButtonClicked(ActionEvent event) {
        this.schoolPanel.setDisable(true);
        this.abtAddPanel.setVisible(true);
    }

    //////////////////////////////////////////////////////////////////////////
    // Info - Panel
    ////////////////////////////////////////////////////////////////////////

    @FXML
    void abtInfoSpeichern(ActionEvent event) {

    }

    @FXML
    void abtInfoReset(ActionEvent event) {
        this.abtInfoNameTextfield.clear();
        this.abtInfoKuerzelTextfield.clear();
    }

    //////////////////////////////////////////////////////////////////////////
    // Abteilung Hinzufügen - Panel
    ////////////////////////////////////////////////////////////////////////

    @FXML
    void abtAddAddButton(ActionEvent event) {
        schule.addAbteilung(this.abtAddTextfield.getText(), this.abtAddKuerzelTextfield.getText());
        this.abteilungslist.add(this.abtAddTextfield.getText());

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
