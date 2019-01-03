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
import java.time.LocalDate;
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

    @FXML
    private Label schoolMitarbeiterAnzahl;

    private ArrayList<AdresseClass> adressarraylist;        //Eventuell direkt eine ObservableListe schreiben!

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
    private ObservableList<String> abteilungsvorstandslist = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> abtInfoAbteilungsvorstandChoiceBox;

    @FXML
    private ChoiceBox<String> abtInfoAbteilungssprecherChoiceBox;


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

    private boolean speichernHinzufuegen = false;

    @FXML
    private AnchorPane perAdresse;

    @FXML
    private ChoiceBox<String> perAdresseChoiceBox;

    @FXML
    private Button perHinzuefuegenButton;

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

    ////////////////////////////////////////////
    // Schul - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private AnchorPane schulPanel;

    @FXML
    private TextField schNameTextfield;

    @FXML
    private TextField schSchulkennzahlTextfield;

    @FXML
    private TextField schSchultypTextfield;

    @FXML
    private TextField schSchueleranzahlTextfield;

    @FXML
    private TextField schMitarbeiteranzahlTextfield;

    @FXML
    private ChoiceBox<String> schDirektorChoiceBox;

    private ObservableList<String> direktorlist = FXCollections.observableArrayList();

    ////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            schule = SchuleController.getSchule();

            this.adressarraylist = new ArrayList<AdresseClass>();

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
                            abteilungsvorstandslist.clear();

                            int i = 0;
                            int abteilungsvorstandIndex = 0;
                            boolean getAbteilungsvorstand = false;

                            for (KlasseClass klasse : selectedAbteilung.getKlassen())
                                klassenlist.add(klasse.getBezeichnung());
                            for (LehrerClass lehrer: selectedAbteilung.getLehrer()) {
                                lehrerlist.add(lehrer.getNachname() + " " + lehrer.getVorname());
                                if (lehrer != schule.getDirektor()) {
                                    abteilungsvorstandslist.add(lehrer.getNachname() + " " + lehrer.getVorname());
                                    if (lehrer == selectedAbteilung.getAbteilungsvorstand()) {
                                        abteilungsvorstandIndex = i;
                                        getAbteilungsvorstand = true;
                                    }
                                    i++;
                                }
                            }

                            if (getAbteilungsvorstand)
                                abtInfoAbteilungsvorstandChoiceBox.getSelectionModel().select(abteilungsvorstandIndex);

                        }
                    });

            this.listViewAbteilungen.setItems(this.abteilungslist);
            this.abtInfoKlassenListView.setItems(this.klassenlist);
            this.abtInfoLehrerListView.setItems(this.lehrerlist);
            this.abtInfoAbteilungsvorstandChoiceBox.setItems(this.abteilungsvorstandslist);
            this.schDirektorChoiceBox.setItems(this.direktorlist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Home/Schule - Panel
    ////////////////////////////////////////////////////////////////////////

    @FXML
    void abtAddButtonClicked(ActionEvent event) {
        this.schoolPanel.setDisable(true);
        this.abtAddPanel.setVisible(true);
    }

    @FXML
    void schuleInfo(ActionEvent event) {
        this.schoolPanel.setDisable(true);

        this.schNameTextfield.setText(schule.getName());
        this.schSchulkennzahlTextfield.setText(Long.toString(schule.getSchulkennzahl()));
        this.schSchultypTextfield.setText(schule.getSchultyp());
        this.schMitarbeiteranzahlTextfield.setText(Integer.toString(schule.getPersonal().size() + schule.getLehrer().size()));
        this.schSchueleranzahlTextfield.setText(Integer.toString(schule.getSchuelerAnzahl()));

        this.direktorlist.clear();

        ArrayList<LehrerClass> direktorkandidaten = schule.getLehrer();
        ArrayList<LehrerClass> abteilungsvorstaende = new ArrayList<LehrerClass>();

        for(AbteilungClass abteilung: schule.getAbteilungen())
            abteilungsvorstaende.add(abteilung.getAbteilungsvorstand());

        try {
            for(LehrerClass abteilungsvorstand: abteilungsvorstaende)
                direktorkandidaten.remove(abteilungsvorstand);
        } catch (Exception e) {
            System.out.println("Keine Daten!");
        }

        int direktorIndex = 0;
        int i = 0;
        boolean getDirektor = false;

        for(LehrerClass direktorkandidat: direktorkandidaten) {
            this.direktorlist.add(direktorkandidat.getNachname() + " " + direktorkandidat.getVorname());
            if (direktorkandidat == schule.getDirektor()) {
                direktorIndex = i;
                getDirektor = true;
            }
            i++;
        }

        if(getDirektor)
            schDirektorChoiceBox.getSelectionModel().select(direktorIndex);

        this.schulPanel.setVisible(true);
    }

    @FXML
    void schExit(ActionEvent event) {
        this.schulPanel.setVisible(false);
        this.schoolPanel.setDisable(false);
    }

    @FXML
    void schSpeichern(ActionEvent event) {
        ArrayList<LehrerClass> direktorkandidaten = new ArrayList<LehrerClass>();
        ArrayList<LehrerClass> lehrer = schule.getLehrer();
        ArrayList<LehrerClass> abteilungsvorstaende = new ArrayList<LehrerClass>();

        for(AbteilungClass abteilung: schule.getAbteilungen())
            abteilungsvorstaende.add(abteilung.getAbteilungsvorstand());

        for(LehrerClass abteilungsvorstand: abteilungsvorstaende) {
            for (LehrerClass lehrer1 : lehrer) {
                if (lehrer1 != abteilungsvorstand)
                    direktorkandidaten.add(lehrer1);
            }
        }

        schule.setDirektor(direktorkandidaten.get(this.schDirektorChoiceBox.getSelectionModel().getSelectedIndex()));

        this.abteilungsvorstandslist.clear();
        this.lehrerlist.clear();

        int i = 0;
        int abteilungsvorstandIndex = 0;
        boolean getAbteilungsvorstand = false;

        for (KlasseClass klasse : selectedAbteilung.getKlassen())
            klassenlist.add(klasse.getBezeichnung());
        for (LehrerClass lehrer2: selectedAbteilung.getLehrer()) {
            if (lehrer2 != schule.getDirektor()) {
                abteilungsvorstandslist.add(lehrer2.getNachname() + " " + lehrer2.getVorname());
                if (lehrer2 == selectedAbteilung.getAbteilungsvorstand()) {
                    abteilungsvorstandIndex = i;
                    getAbteilungsvorstand = true;
                }
                i++;
            }
            lehrerlist.add(lehrer2.getNachname() + " " + lehrer2.getVorname());
        }

        if (getAbteilungsvorstand)
            abtInfoAbteilungsvorstandChoiceBox.getSelectionModel().select(abteilungsvorstandIndex);

        System.out.println("Schule gespeichert!");

        this.schulPanel.setVisible(false);
        this.schoolPanel.setDisable(false);
    }

    //////////////////////////////////////////////////////////////////////////
    // Info - Panel
    ////////////////////////////////////////////////////////////////////////

    @FXML
    void abtInfoSpeichern(ActionEvent event) {
        this.selectedAbteilung.setName(this.abtInfoNameTextfield.getText());
        this.selectedAbteilung.setKuerzel(this.abtInfoKuerzelTextfield.getText());

        ArrayList<LehrerClass> lehrer = new ArrayList<LehrerClass>();

        for (LehrerClass lehrer1: this.selectedAbteilung.getLehrer())
            lehrer.add(lehrer1);

        try {
            lehrer.remove(schule.getDirektor());
        } catch (Exception e) {
            System.out.println("Der Direktor befindet sich nicht in dieser Abteilung!");
        }

        try {
            this.selectedAbteilung.setAbteilungsvorstand(lehrer.get(abtInfoAbteilungsvorstandChoiceBox.getSelectionModel().getSelectedIndex()));
        } catch (Exception e) {
            System.out.println("Kein Abteilungsvorstand ausgewählt!");
        }

        this.abteilungslist.set(this.listViewAbteilungen.getSelectionModel().getSelectedIndex(), this.selectedAbteilung.getName());

        System.out.println("Abteilung gespeichert!");
    }

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
        this.perHinzuefuegenButton.setText("Hinzufügen");

        this.schuelerLehrer = true;             //Lehrer
        this.speichernHinzufuegen = true;       //neuen Lehrer hinzufügen
    }

    @FXML
    void abtInfoLehrerInfo(ActionEvent event) {
        try {
            LehrerClass lehrer = selectedAbteilung.getLehrer().get(this.abtInfoLehrerListView.getSelectionModel().getSelectedIndex());

            this.perSVNRTextfield.setText(Long.toString(lehrer.getSvnr()));
            this.perVornameTextfield.setText(lehrer.getVorname());
            this.perNachnameTextfield.setText(lehrer.getNachname());
            this.perGeburtsdatumDatePicker.setValue(lehrer.getGeburtsdatum());
            this.perEmailTextfield.setText(lehrer.getEmail());
            this.perKuerzelTextfield.setText(lehrer.getKuerzel());
            this.perAdresseChoiceBox.getSelectionModel().select(this.adressarraylist.indexOf(lehrer.getWohnort()));

            this.perHinzuefuegenButton.setText("Speichern");

            this.perLehrerPanel.setVisible(true);
            this.perSchuelerPanel.setVisible(false);

            this.speichernHinzufuegen = false;
            this.schuelerLehrer = true;

            this.schoolPanel.setDisable(true);
            this.personenPanel.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Es ist ein Fehler aufgetreten!");
        }
    }

    @FXML
    void abtInfoKlassenInfo(ActionEvent event) {
        try {

        } catch (Exception e) {

        }
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
    // Personen Hinzufügen - Panel
    /////////////////////////////////////////////////////////////////////////

    @FXML
    void perExit(ActionEvent event) {
        this.personenPanel.setVisible(false);
        this.schoolPanel.setDisable(false);
    }

    @FXML
    void perHinzufuegen(ActionEvent event) {
        if(this.schuelerLehrer && this.speichernHinzufuegen) {
            try {
                LehrerClass lehrer = new LehrerClass(Long.parseLong(this.perSVNRTextfield.getText()), this.perVornameTextfield.getText(), this.perNachnameTextfield.getText(),
                        this.perGeburtsdatumDatePicker.getValue(), this.perEmailTextfield.getText(), this.perKuerzelTextfield.getText());
                lehrer.setWohnort(this.adressarraylist.get(this.perAdresseChoiceBox.getSelectionModel().getSelectedIndex()));

                this.selectedAbteilung.addLehrer(lehrer);

                this.lehrerlist.add(this.perNachnameTextfield.getText() + " " + this.perVornameTextfield.getText());
                this.abteilungsvorstandslist.add(this.perNachnameTextfield.getText() + " " + this.perVornameTextfield.getText());

                this.personenPanel.setVisible(false);
                this.schoolPanel.setDisable(false);

                this.schoolMitarbeiterAnzahl.setText("Mitarbeiter: " + Integer.toString(schule.getPersonal().size() + schule.getLehrer().size()));

                System.out.println("Lehrer hinzugefügt!");
            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("Es ist ein Fehler aufgetreten!");
            }
        } else if(this.schuelerLehrer && !this.speichernHinzufuegen){
            try {
                LehrerClass lehrer = this.selectedAbteilung.getLehrer().get(this.abtInfoLehrerListView.getSelectionModel().getSelectedIndex());

                int abteilungsindex = this.abteilungsvorstandslist.indexOf((lehrer.getNachname() + " " + lehrer.getVorname()));
                this.abteilungsvorstandslist.set(abteilungsindex, this.perNachnameTextfield.getText() + " " + this.perVornameTextfield.getText());
                this.abtInfoAbteilungsvorstandChoiceBox.getSelectionModel().select(abteilungsindex);

                lehrer.setSvnr(Long.parseLong(this.perSVNRTextfield.getText()));
                lehrer.setVorname(this.perVornameTextfield.getText());
                lehrer.setNachname(this.perNachnameTextfield.getText());
                lehrer.setGeburtsdatum(this.perGeburtsdatumDatePicker.getValue());
                lehrer.setEmail(this.perEmailTextfield.getText());
                lehrer.setWohnort(this.adressarraylist.get(this.perAdresseChoiceBox.getSelectionModel().getSelectedIndex()));

                this.lehrerlist.set(this.abtInfoLehrerListView.getSelectionModel().getSelectedIndex(), this.perNachnameTextfield.getText() + " " + this.perVornameTextfield.getText());

                this.personenPanel.setVisible(false);
                this.schoolPanel.setDisable(false);

                System.out.println("Lehrer gespeichert!");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Es ist ein Fehler aufgetreten!");
            }
        }
    }

    @FXML
    void perAdresseNeu(ActionEvent event) {
        this.personenPanel.setDisable(true);
        this.ortPanel.setVisible(true);
    }

    //////////////////////////////////////////////////////////////////////////
    // Ort Hinzufügen - Panel
    /////////////////////////////////////////////////////////////////////////

    @FXML
    void ortExit(ActionEvent event) {
        this.ortPanel.setVisible(false);
        this.personenPanel.setDisable(false);
    }

    @FXML
    void ortHinzufuegen(ActionEvent event) {
        try {
            this.adressarraylist.add(new AdresseClass(this.ortOrtTextfield.getText(), this.ortStrasseTextfield.getText(),
                    Integer.parseInt(this.ortHausnummerTextfield.getText()), Integer.parseInt(this.ortPLZTextfield.getText())));

            this.perAdresseChoiceBox.getItems().add(this.ortStrasseTextfield.getText() + " " + this.ortHausnummerTextfield.getText() +  ", "
                    + this.ortPLZTextfield.getText() + " " + this.ortOrtTextfield.getText());

            this.ortPanel.setVisible(false);
            this.personenPanel.setDisable(false);

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
