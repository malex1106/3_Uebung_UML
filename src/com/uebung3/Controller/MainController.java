package com.uebung3.Controller;

import com.uebung3.Classes.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ArrayList;
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

    private ArrayList<AdresseClass> adressarraylist;

    ////////////////////////////////////////////
    // Info - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private TextField abtInfoNameTextfield;

    @FXML
    private TextField abtInfoKuerzelTextfield;

    @FXML
    private ListView<String> abtInfoKlassenListView;

    @FXML
    private ListView<String> abtInfoLehrerListView;

    private ObservableList<String> klassenlist = FXCollections.observableArrayList();
    private ObservableList<String> lehrerlist = FXCollections.observableArrayList();


    ////////////////////////////////////////////
    // Person - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private AnchorPane personenPanel;

    @FXML
    private AnchorPane perLehrerPanel;

    @FXML
    private AnchorPane perSchuelerPanel;

    @FXML
    private TextField perSVNRTextfield;

    @FXML
    private TextField perVornameTextfield;

    @FXML
    private TextField perNachnameTextfield;

    @FXML
    private DatePicker perGeburtsdatumDatePicker;

    @FXML
    private TextField perEmailTextfield;

    @FXML
    private TextField perKuerzelTextfield;

    @FXML
    private TextField perKatalognummerTextfield;

    @FXML
    private DatePicker perEintrittsdatumTextfield;

    @FXML
    private CheckBox perEigenberechtigtCheckBox;

    private boolean schuelerLehrer = false;

    ////////////////////////////////////////////
    // Klasse Hinzufügen - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private AnchorPane abtAddKlassePanel;

    @FXML
    private TextField abtAddKlasseBezeichnungTextfield;

    @FXML
    private TextField abtAddKlasseSchulstufeTextfield;

    ////////////////////////////////////////////
    // Ort Hinzufügen - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private AnchorPane ortPanel;

    @FXML
    private TextField ortOrtTextfield;

    @FXML
    private TextField ortStrasseTextfield;

    @FXML
    private TextField ortHausnummerTextfield;

    @FXML
    private TextField ortPLZTextfield;

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
                            klassenlist.clear();
                            lehrerlist.clear();
                            for (KlasseClass klasse : selectedAbteilung.getKlassen())
                                klassenlist.add(klasse.getBezeichnung());
                            for (LehrerClass lehrer: selectedAbteilung.getLehrer())
                                lehrerlist.add(lehrer.getNachname() + " " + lehrer.getVorname());

                        }
                    });

            this.listViewAbteilungen.setItems(this.abteilungslist);
            this.abtInfoKlassenListView.setItems(this.klassenlist);
            this.abtInfoLehrerListView.setItems(this.lehrerlist);
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
    void abtInfoReset(ActionEvent event) {
        this.abtInfoNameTextfield.clear();
        this.abtInfoKuerzelTextfield.clear();
    }

    @FXML
    void abtInfoKlasseHinzuefuegen(ActionEvent event) {
        this.schoolPanel.setDisable(true);
        this.abtAddKlassePanel.setVisible(true);
    }

    @FXML
    void abtInfoLehrerHinzufuegen(ActionEvent event) {
        this.schoolPanel.setDisable(true);
        this.personenPanel.setVisible(true);
        this.perLehrerPanel.setVisible(true);
        this.perSchuelerPanel.setVisible(false);

        this.schuelerLehrer = true;             //Lehrer
    }

    //////////////////////////////////////////////////////////////////////////
    // Abteilung Hinzufügen - Panel
    ////////////////////////////////////////////////////////////////////////

    @FXML
    void abtAddAddButton(ActionEvent event) {
        AbteilungClass abteilung = schule.addAbteilung(this.abtAddTextfield.getText(), this.abtAddKuerzelTextfield.getText());
        abteilung.setSchule(schule);

        this.abteilungslist.add(this.abtAddTextfield.getText());

        this.abtAddPanel.setVisible(false);
        this.schoolPanel.setDisable(false);
    }

    @FXML
    void abtAddExitButtonClicked(ActionEvent event) {
        this.abtAddPanel.setVisible(false);
        this.schoolPanel.setDisable(false);
    }

    //////////////////////////////////////////////////////////////////////////
    // Klasse Hinzufügen - Panel
    /////////////////////////////////////////////////////////////////////////

    @FXML
    void abtAddKlasseAddButton(ActionEvent event) {
        try {
            selectedAbteilung.addKlasse(new KlasseClass(this.abtAddKlasseBezeichnungTextfield.getText(), Integer.parseInt(this.abtAddKlasseSchulstufeTextfield.getText()),
                    selectedAbteilung));

            this.klassenlist.add(this.abtAddKlasseBezeichnungTextfield.getText());

            this.abtAddKlassePanel.setVisible(false);
            this.schoolPanel.setDisable(false);

            System.out.println("Klasse hinzugefügt!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Es ist ein Fehler aufgetreten!");
        }
    }

    @FXML
    void abtAddKlasseExit(ActionEvent event) {
        this.schoolPanel.setDisable(false);
        this.abtAddKlassePanel.setVisible(false);
    }

    //////////////////////////////////////////////////////////////////////////
    // Lehrer Hinzufügen - Panel
    /////////////////////////////////////////////////////////////////////////

    @FXML
    void perExit(ActionEvent event) {
        this.personenPanel.setVisible(false);
        this.schoolPanel.setDisable(false);
    }

    @FXML
    void perHinzufuegen(ActionEvent event) {
        if(this.schuelerLehrer) {
            try {
                selectedAbteilung.addLehrer(new LehrerClass(Long.parseLong(this.perSVNRTextfield.getText()), this.perVornameTextfield.getText(), this.perNachnameTextfield.getText(),
                        null, this.perEmailTextfield.getText(), this.perKuerzelTextfield.getText()));

                this.lehrerlist.add(this.perNachnameTextfield.getText() + " " + this.perVornameTextfield.getText());

                this.personenPanel.setVisible(false);
                this.schoolPanel.setDisable(false);

                System.out.println("Lehrer hinzugefügt!");

            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("Es ist ein Fehler aufgetreten!");
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Ort Hinzufügen - Panel
    /////////////////////////////////////////////////////////////////////////

    @FXML
    void ortExit(ActionEvent event) {
        this.ortPanel.setVisible(false);
    }

    @FXML
    void ortHinzufuegen(ActionEvent event) {
        try {
            this.adressarraylist.add(new AdresseClass(this.ortOrtTextfield.getText(), this.ortStrasseTextfield.getAccessibleHelp(),
                    Integer.parseInt(this.ortHausnummerTextfield.getText()), Integer.parseInt(this.ortPLZTextfield.getText())));

            this.ortPanel.setVisible(false);

            System.out.println("Ort hinzugefügt!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Es ist ein Fehler aufgetreten!");
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Schule
    /////////////////////////////////////////////////////////////////////////

    public static SchuleClass getSchule() { return schule; }
}
