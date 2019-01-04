package com.uebung3.Controller;

import com.uebung3.Classes.*;
import com.uebung3.Enumerations.Raumtyp;
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

    @FXML
    private Label schoolMitarbeiterAnzahl;

    private ArrayList<AdresseClass> adressarraylist;
    private ArrayList<RaumClass> raumarraylist;

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

    private ObservableList<String> klassenlist;
    private ObservableList<String> lehrerlist;
    private ObservableList<String> abteilungsvorstandslist;

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
    private TextField perEigenberechtigtTextfield;

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
    private AnchorPane klassePanel;

    @FXML
    private TextField klaBezeichnungTextfield;

    @FXML
    private TextField klaSchulstufeTextfield;

    @FXML
    private AnchorPane klaPanel1;

    @FXML
    private AnchorPane klaPanel2;

    @FXML
    private AnchorPane klaPanel3;

    @FXML
    private Button klaHinzufuegenButton;

    @FXML
    private ChoiceBox<String> klaStammklasseChoiceBox;

    @FXML
    private ChoiceBox<String> klaKlassenvorstandChoiceBox;

    @FXML
    private ChoiceBox<String> klaKlassensprecherChoiceBox;

    @FXML
    private ListView<String> klaSchuelerListView;

    private ObservableList<String> schuelerlist;

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
    // Raum Hinzufügen - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private AnchorPane raumPanel;

    @FXML
    private Label rauTitelLabel;

    @FXML
    private TextField rauRaumnummerTextfield;

    @FXML
    private Button rauHinzufuegenButton;

    @FXML
    private TextField rauSitzplaetzeTextfield;

    @FXML
    private ChoiceBox<Raumtyp> rauRaumtypChoiceBox;

    private ObservableList<String> raumlist;

    ////////////////////////////////////////////
    // Abteilung Hinzufügen - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private TextField abtAddTextfield;

    @FXML
    private TextField abtAddKuerzelTextfield;

    private static SchuleClass schule;
    private static AbteilungClass selectedAbteilung;

    private ObservableList<String> abteilungslist;

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

    private ObservableList<String> direktorlist;

    ////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            schule = SchuleController.getSchule();

            klassenlist = FXCollections.observableArrayList();
            lehrerlist = FXCollections.observableArrayList();
            abteilungsvorstandslist = FXCollections.observableArrayList();
            schuelerlist = FXCollections.observableArrayList();
            raumlist = FXCollections.observableArrayList();
            abteilungslist = FXCollections.observableArrayList();
            direktorlist = FXCollections.observableArrayList();

            this.adressarraylist = new ArrayList<AdresseClass>();
            this.raumarraylist = new ArrayList<RaumClass>();

            this.rauRaumtypChoiceBox.setItems(FXCollections.observableArrayList(Raumtyp.values()));

            schoolName.setText("Schule - " + schule.getName());

            this.listViewAbteilungen.getSelectionModel().selectedItemProperty()
                    .addListener(new ChangeListener<String>() {

                        public void changed(
                                ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            try {
                                System.out.println("New Selection: " + newValue + " | Old Selection: " + oldValue + " | Index: " + listViewAbteilungen.getSelectionModel().getSelectedIndex());

                                selectedAbteilung = schule.getAbteilungen().get(listViewAbteilungen.getSelectionModel().getSelectedIndex());
                                LehrerClass abteilungsvorstand = selectedAbteilung.getAbteilungsvorstand();

                                abtInfoNameTextfield.setText(selectedAbteilung.getName());
                                abtInfoKuerzelTextfield.setText(selectedAbteilung.getKuerzel());

                                klassenlist.clear();
                                lehrerlist.clear();
                                abteilungsvorstandslist.clear();

                                for (KlasseClass klasse : selectedAbteilung.getKlassen())
                                    klassenlist.add(klasse.getBezeichnung());

                                for (LehrerClass lehrer : selectedAbteilung.getLehrer()) {
                                    lehrerlist.add(lehrer.getNachname() + " " + lehrer.getVorname());
                                    if (lehrer != schule.getDirektor())
                                        abteilungsvorstandslist.add(lehrer.getNachname() + " " + lehrer.getVorname());
                                }

                                try {
                                    abtInfoAbteilungsvorstandChoiceBox.getSelectionModel().select(abteilungsvorstandslist.indexOf(abteilungsvorstand.getNachname() + " " + abteilungsvorstand.getVorname()));
                                } catch (Exception e) {
                                    System.out.println("Kein Abteilungsvorstand gefunden: " + e.getMessage());
                                }
                            } catch (Exception e) {
                                //e.printStackTrace();
                                System.out.println("Keine Abteilungen: " + e.getMessage());
                            }

                        }
                    });

            this.listViewAbteilungen.setItems(this.abteilungslist);
            this.abtInfoKlassenListView.setItems(this.klassenlist);
            this.abtInfoLehrerListView.setItems(this.lehrerlist);
            this.abtInfoAbteilungsvorstandChoiceBox.setItems(this.abteilungsvorstandslist);
            this.schDirektorChoiceBox.setItems(this.direktorlist);
            this.klaStammklasseChoiceBox.setItems(this.raumlist);
            this.klaSchuelerListView.setItems(this.schuelerlist);
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
    void schuleAbteilungLoeschen(ActionEvent event) {
        schule.getAbteilungen().remove(this.listViewAbteilungen.getSelectionModel().getSelectedIndex());
        this.abteilungslist.remove(this.listViewAbteilungen.getSelectionModel().getSelectedIndex());
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
            System.out.println("Keine Daten: " + e.getMessage());
        }

        for(LehrerClass direktorkandidat: direktorkandidaten)
            this.direktorlist.add(direktorkandidat.getNachname() + " " + direktorkandidat.getVorname());

        try {
            schDirektorChoiceBox.getSelectionModel().select(direktorkandidaten.indexOf(schule.getDirektor()));
        } catch (Exception e) {
            System.out.println("Kein Direktor gefunden: " + e.getMessage());
        }

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

        direktorkandidaten.clear();
        abteilungsvorstaende.clear();

        for(AbteilungClass abteilung: schule.getAbteilungen())
            abteilungsvorstaende.add(abteilung.getAbteilungsvorstand());

        for(LehrerClass abteilungsvorstand: abteilungsvorstaende) {
            for (LehrerClass lehrer1 : lehrer) {
                if (lehrer1 != abteilungsvorstand)
                    direktorkandidaten.add(lehrer1);
            }
        }

        schule.setDirektor(direktorkandidaten.get(this.schDirektorChoiceBox.getSelectionModel().getSelectedIndex()));

        LehrerClass abteilungsvorstand = selectedAbteilung.getAbteilungsvorstand();

        this.abteilungsvorstandslist.clear();
        this.lehrerlist.clear();
        this.klassenlist.clear();

        for (KlasseClass klasse : selectedAbteilung.getKlassen())
            klassenlist.add(klasse.getBezeichnung());
        for (LehrerClass lehrer2: selectedAbteilung.getLehrer()) {
            if (lehrer2 != schule.getDirektor())
                abteilungsvorstandslist.add(lehrer2.getNachname() + " " + lehrer2.getVorname());
            lehrerlist.add(lehrer2.getNachname() + " " + lehrer2.getVorname());
        }

        try {
            abtInfoAbteilungsvorstandChoiceBox.getSelectionModel().select(abteilungsvorstandslist.indexOf(abteilungsvorstand.getNachname() + " " + abteilungsvorstand.getVorname()));
        } catch (Exception e) {
            System.out.println("Kein Abteilungsvorstand gefunden: " + e.getMessage());
        }
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

        int abteilungsindex = schule.getAbteilungen().indexOf(this.selectedAbteilung);

        ArrayList<LehrerClass> lehrer = new ArrayList<LehrerClass>();

        for (LehrerClass lehrer1: this.selectedAbteilung.getLehrer())
            lehrer.add(lehrer1);

        try {
            lehrer.remove(schule.getDirektor());
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Der Direktor befindet sich nicht in dieser Abteilung: " + e.getMessage());
        }

        try {
            this.selectedAbteilung.setAbteilungsvorstand(lehrer.get(abtInfoAbteilungsvorstandChoiceBox.getSelectionModel().getSelectedIndex()));
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Kein Abteilungsvorstand ausgewählt: " + e.getMessage());
        }

        try {
            this.abteilungslist.set(this.listViewAbteilungen.getSelectionModel().getSelectedIndex(), this.selectedAbteilung.getName());
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Keine Abteilung ausgewählt: " + e.getMessage());
        }
        this.listViewAbteilungen.getSelectionModel().select(abteilungsindex);
        System.out.println("Abteilung gespeichert!");
    }

    @FXML
    void abtInfoKlasseHinzuefuegen(ActionEvent event) {
        this.klassePanel.setMaxHeight(210);
        this.klassePanel.setMinHeight(210);
        this.klassePanel.setLayoutY(210);

        this.schoolPanel.setDisable(true);
        this.klassePanel.setVisible(true);

        this.klaPanel1.setVisible(true);
        this.klaPanel2.setVisible(false);
        this.klaPanel3.setVisible(false);
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
    void abtInfoLehrerLoeschen(ActionEvent event) {
        try {
            ArrayList<LehrerClass> lehrerlist = this.selectedAbteilung.getLehrer();
            LehrerClass lehrer = lehrerlist.get(this.abtInfoLehrerListView.getSelectionModel().getSelectedIndex());

            this.abteilungsvorstandslist.remove(lehrer.getNachname() + " " + lehrer.getVorname());

            lehrerlist.remove(this.abtInfoLehrerListView.getSelectionModel().getSelectedIndex());

            this.lehrerlist.remove(this.abtInfoLehrerListView.getSelectionModel().getSelectedIndex());
            this.schoolMitarbeiterAnzahl.setText("Mitarbeiter: " + Integer.toString(schule.getPersonal().size() + schule.getLehrer().size()));
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
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
            //e.printStackTrace();
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    @FXML
    void abtInfoKlassenInfo(ActionEvent event) {
        this.klassePanel.setMinHeight(633);
        this.klassePanel.setMaxHeight(633);
        this.klassePanel.setLayoutY(40);

        this.klaStammklasseChoiceBox.getSelectionModel().clearSelection();

        KlasseClass klasse = this.selectedAbteilung.getKlassen().get(this.abtInfoKlassenListView.getSelectionModel().getSelectedIndex());

        this.klaPanel1.setVisible(false);
        this.klaPanel2.setVisible(true);
        this.klaPanel3.setVisible(true);

        this.klaBezeichnungTextfield.setText(klasse.getBezeichnung());
        this.klaSchulstufeTextfield.setText(Integer.toString(klasse.getSchulstufe()));

        int i = 0;
        int stammklassenindex = 0;
        boolean getStammklasse = false;

        for(RaumClass raum: this.raumarraylist) {
            if(raum == klasse.getStammklasse()) {
                stammklassenindex = i;
                getStammklasse = true;
            }
            i++;
        }

        if (getStammklasse)
            this.klaStammklasseChoiceBox.getSelectionModel().select(stammklassenindex);

        this.klassePanel.setVisible(true);
        this.schoolPanel.setDisable(true);
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
    void klaHinzufuegen(ActionEvent event) {
        try {
            selectedAbteilung.addKlasse(new KlasseClass(this.klaBezeichnungTextfield.getText(), Integer.parseInt(this.klaSchulstufeTextfield.getText()),
                    selectedAbteilung));

            this.klassenlist.add(this.klaBezeichnungTextfield.getText());

            this.klassePanel.setVisible(false);
            this.schoolPanel.setDisable(false);

            System.out.println("Klasse hinzugefügt!");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    @FXML
    void klaSpeichern(ActionEvent event) {
        try {
            KlasseClass klasse = this.selectedAbteilung.getKlassen().get(this.abtInfoKlassenListView.getSelectionModel().getSelectedIndex());

            klasse.setBezeichnung(this.klaBezeichnungTextfield.getText());
            klasse.setSchulstufe(Integer.parseInt(this.klaSchulstufeTextfield.getText()));

            try {
                klasse.setStammklasse(this.raumarraylist.get(this.klaStammklasseChoiceBox.getSelectionModel().getSelectedIndex()));
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Keinen Stammraum ausgewählt!");
            }

            System.out.println("Klasse gespeichert!");

            this.klassePanel.setVisible(false);
            this.schoolPanel.setDisable(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    @FXML
    void klaExit(ActionEvent event) {
        this.schoolPanel.setDisable(false);
        this.klassePanel.setVisible(false);
    }

    @FXML
    void klaSchuelerHinzufuegen(ActionEvent event) {
        this.schuelerLehrer = false;
        this.speichernHinzufuegen = true;

        this.perSchuelerPanel.setVisible(true);
        this.perLehrerPanel.setVisible(false);

        this.klassePanel.setDisable(true);
        this.personenPanel.setVisible(true);
    }

    @FXML
    void klaSchuelerLoeschen(ActionEvent event) {

    }

    @FXML
    void klaSchuelerMehrInfos(ActionEvent event) {
        ArrayList<SchuelerClass> schuelerlist = selectedAbteilung.getKlassen().get(this.abtInfoKlassenListView.getSelectionModel().getSelectedIndex()).getSchueler();
        SchuelerClass schueler = schuelerlist.get(this.klaSchuelerListView.getSelectionModel().getSelectedIndex());

        this.schuelerLehrer = false;
        this.speichernHinzufuegen = false;

        this.perSchuelerPanel.setVisible(true);
        this.perLehrerPanel.setVisible(false);

        this.perSVNRTextfield.setText(Long.toString(schueler.getSvnr()));
        this.perVornameTextfield.setText(schueler.getVorname());
        this.perNachnameTextfield.setText(schueler.getNachname());
        this.perGeburtsdatumDatePicker.setValue(schueler.getGeburtsdatum());
        this.perEmailTextfield.setText(schueler.getEmail());
        this.perEintrittsdatumTextfield.setValue(schueler.getEintrittsdatum());
        this.perKatalognummerTextfield.setText(Integer.toString(schueler.getKatalognummer()));
        this.perEigenberechtigtTextfield.setText(Boolean.toString(schueler.isEigenberechtigt()));
        this.perAdresseChoiceBox.getSelectionModel().select(this.adressarraylist.indexOf(schueler.getWohnort()));

    }

    @FXML
    void klaStammklasseNeu(ActionEvent event) {
        this.klassePanel.setDisable(true);
        this.raumPanel.setVisible(true);
    }

    //////////////////////////////////////////////////////////////////////////
    // Personen Hinzufügen - Panel
    /////////////////////////////////////////////////////////////////////////

    @FXML
    void perExit(ActionEvent event) {
        if(this.schuelerLehrer) {
            this.personenPanel.setVisible(false);
            this.schoolPanel.setDisable(false);
        } else {
            this.personenPanel.setVisible(false);
            this.klassePanel.setDisable(false);
        }
    }

    @FXML
    void perHinzufuegen(ActionEvent event) {
        if (this.schuelerLehrer && this.speichernHinzufuegen) {
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
                //e.printStackTrace();
                System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
            }
        } else if (this.schuelerLehrer && !this.speichernHinzufuegen){
            try {
                LehrerClass lehrer = this.selectedAbteilung.getLehrer().get(this.abtInfoLehrerListView.getSelectionModel().getSelectedIndex());

                int abteilungsindex = this.abteilungsvorstandslist.indexOf((lehrer.getNachname() + " " + lehrer.getVorname()));
                if (schule.getDirektor() != lehrer)
                    this.abteilungsvorstandslist.set(abteilungsindex, this.perNachnameTextfield.getText() + " " + this.perVornameTextfield.getText());

                if (lehrer == this.selectedAbteilung.getAbteilungsvorstand())
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
                //e.printStackTrace();
                System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
            }
        } else if (!this.schuelerLehrer && this.speichernHinzufuegen) {
            try {
                SchuelerClass schueler = new SchuelerClass(Long.parseLong(this.perSVNRTextfield.getText()), this.perVornameTextfield.getText(), this.perNachnameTextfield.getText(),
                        this.perGeburtsdatumDatePicker.getValue(), this.perEmailTextfield.getText());
                schueler.setWohnort(this.adressarraylist.get(this.perAdresseChoiceBox.getSelectionModel().getSelectedIndex()));
                schueler.setKatalognummer(Integer.parseInt(this.perKatalognummerTextfield.getText()));
                schueler.setEintrittsdatum(this.perEintrittsdatumTextfield.getValue());

                KlasseClass klasse = this.selectedAbteilung.getKlassen().get(this.abtInfoKlassenListView.getSelectionModel().getSelectedIndex());
                klasse.addSchueler(schueler);

                schueler.setKlasse(klasse);

                this.schuelerlist.add(this.perNachnameTextfield.getText() + " " + this.perVornameTextfield.getText());

                this.personenPanel.setVisible(false);
                this.klassePanel.setDisable(false);

                System.out.println("Schüler hinzugefügt!");
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
            }
        } else if (!this.schuelerLehrer && !this.speichernHinzufuegen) {
            try {

            } catch (Exception e) {
                System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
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
            //e.printStackTrace();
            System.out.println("Es ist ein Fehler aufgetreten!");
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Raum Hinzufügen - Panel
    /////////////////////////////////////////////////////////////////////////

    @FXML
    void rauExit(ActionEvent event) {
        this.raumPanel.setVisible(false);
        this.klassePanel.setDisable(false);
    }

    @FXML
    void rauHinzufuegen(ActionEvent event) {
        try {
            RaumClass raum = new RaumClass(this.rauRaumnummerTextfield.getText(), Integer.parseInt(this.rauSitzplaetzeTextfield.getText()), this.rauRaumtypChoiceBox.getSelectionModel().getSelectedItem());

            this.raumarraylist.add(raum);

            this.raumlist.add(this.rauRaumnummerTextfield.getText() + " - " + this.rauSitzplaetzeTextfield.getText() + " - " + this.rauRaumtypChoiceBox.getSelectionModel().getSelectedItem().toString());

            this.raumPanel.setVisible(false);
            this.klassePanel.setDisable(false);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Es ist ein Fehler aufgetreten!");
        }
    }
}
