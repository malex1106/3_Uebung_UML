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
    private ObservableList<String> abteilungssprecherlist;

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

    @FXML
    private ChoiceBox<String> schSchulsprecherChoiceBox;

    private ObservableList<String> direktorlist;

    private ObservableList<String> schulsprecherlist;

    ////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            schule = SchuleController.getSchule();

            klassenlist = FXCollections.observableArrayList();
            lehrerlist = FXCollections.observableArrayList();
            abteilungsvorstandslist = FXCollections.observableArrayList();
            abteilungssprecherlist = FXCollections.observableArrayList();
            schuelerlist = FXCollections.observableArrayList();
            raumlist = FXCollections.observableArrayList();
            abteilungslist = FXCollections.observableArrayList();
            direktorlist = FXCollections.observableArrayList();
            schulsprecherlist = FXCollections.observableArrayList();

            this.adressarraylist = new ArrayList<AdresseClass>();
            this.raumarraylist = new ArrayList<RaumClass>();

            schoolName.setText("Schule - " + schule.getName());

            this.listViewAbteilungen.getSelectionModel().selectedItemProperty()
                    .addListener(new ChangeListener<String>() {

                        public void changed(
                                ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            try {
                                System.out.println("New Selection: " + newValue + " | Old Selection: " + oldValue + " | Index: " + listViewAbteilungen.getSelectionModel().getSelectedIndex());

                                selectedAbteilung = schule.getAbteilungen().get(listViewAbteilungen.getSelectionModel().getSelectedIndex());
                                LehrerClass abteilungsvorstand = selectedAbteilung.getAbteilungsvorstand();
                                SchuelerClass abteilungssprecher = selectedAbteilung.getAbteilungssprecher();

                                abtInfoNameTextfield.setText(selectedAbteilung.getName());
                                abtInfoKuerzelTextfield.setText(selectedAbteilung.getKuerzel());

                                klassenlist.clear();
                                lehrerlist.clear();
                                abteilungsvorstandslist.clear();
                                abteilungssprecherlist.clear();

                                for (KlasseClass klasse : selectedAbteilung.getKlassen())
                                    klassenlist.add(klasse.getBezeichnung());

                                for (LehrerClass lehrer : selectedAbteilung.getLehrer()) {
                                    lehrerlist.add(lehrer.getNachname() + " " + lehrer.getVorname());
                                    if (lehrer != schule.getDirektor())
                                        abteilungsvorstandslist.add(lehrer.getNachname() + " " + lehrer.getVorname());
                                }

                                for (SchuelerClass schueler1: selectedAbteilung.getSchueler())
                                    abteilungssprecherlist.add(schueler1.getNachname() + " " + schueler1.getVorname());

                                try {
                                    abtInfoAbteilungsvorstandChoiceBox.getSelectionModel().select(abteilungsvorstandslist.indexOf(abteilungsvorstand.getNachname() + " " + abteilungsvorstand.getVorname()));
                                } catch (Exception e) {
                                    System.out.println("Kein Abteilungsvorstand gefunden: " + e.getMessage());
                                }

                                try {
                                    abtInfoAbteilungssprecherChoiceBox.getSelectionModel().select(abteilungssprecherlist.indexOf(abteilungssprecher.getNachname() + " " + abteilungssprecher.getVorname()));
                                } catch (Exception e) {
                                    System.out.println("Kein Abteilungssprecher gefunden: " + e.getMessage());
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
            this.abtInfoAbteilungssprecherChoiceBox.setItems(this.abteilungssprecherlist);
            this.schSchulsprecherChoiceBox.setItems(this.schulsprecherlist);
            this.schDirektorChoiceBox.setItems(this.direktorlist);
            this.klaKlassensprecherChoiceBox.setItems(this.schuelerlist);
            this.klaStammklasseChoiceBox.setItems(this.raumlist);
            this.klaSchuelerListView.setItems(this.schuelerlist);
            this.klaKlassenvorstandChoiceBox.setItems(this.abteilungsvorstandslist);
            this.rauRaumtypChoiceBox.setItems(FXCollections.observableArrayList(Raumtyp.values()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Home/Schule - Panel
    //////////////////////////////////////////////////////////////////////////

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
        this.schulsprecherlist.clear();

        ArrayList<LehrerClass> direktorkandidaten = schule.getLehrer();
        ArrayList<LehrerClass> abteilungsvorstaende = new ArrayList<LehrerClass>();
        ArrayList<LehrerClass> klassenvorstaende = new ArrayList<LehrerClass>();
        ArrayList<SchuelerClass> schueler = schule.getSchueler();

        for (SchuelerClass schueler1: schueler)
            this.schulsprecherlist.add(schueler1.getNachname() + " " + schueler1.getVorname());

        for (AbteilungClass abteilung: schule.getAbteilungen()) {
            abteilungsvorstaende.add(abteilung.getAbteilungsvorstand());
            for (KlasseClass klasse: abteilung.getKlassen())
                klassenvorstaende.add(klasse.getKlassenvorstand());
        }

        try {
            for (LehrerClass abteilungsvorstand: abteilungsvorstaende)
                direktorkandidaten.remove(abteilungsvorstand);
            for (LehrerClass klassenvorstand: klassenvorstaende)
                direktorkandidaten.remove(klassenvorstand);
        } catch (Exception e) {
            System.out.println("Keine Daten: " + e.getMessage());
        }

        for (LehrerClass direktorkandidat: direktorkandidaten)
            this.direktorlist.add(direktorkandidat.getNachname() + " " + direktorkandidat.getVorname());

        try {
            schDirektorChoiceBox.getSelectionModel().select(direktorkandidaten.indexOf(schule.getDirektor()));
        } catch (Exception e) {
            System.out.println("Kein Direktor gefunden: " + e.getMessage());
        }

        try {
            schSchulsprecherChoiceBox.getSelectionModel().select(schueler.indexOf(schule.getSchulsprecher()));
        } catch (Exception e) {
            System.out.println("Kein Schulsprecher gefunden: " + e.getMessage());
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
        try {
            ArrayList<LehrerClass> direktorkandidaten = new ArrayList<LehrerClass>();
            ArrayList<LehrerClass> lehrer = schule.getLehrer();
            ArrayList<LehrerClass> abteilungsvorstaende = new ArrayList<LehrerClass>();
            ArrayList<SchuelerClass> schueler = schule.getSchueler();

            LehrerClass abteilungsvorstand = this.selectedAbteilung.getAbteilungsvorstand();

            direktorkandidaten.clear();
            abteilungsvorstaende.clear();

            for (AbteilungClass abteilung : schule.getAbteilungen())
                abteilungsvorstaende.add(abteilung.getAbteilungsvorstand());

            for (LehrerClass abteilungsvorstand1 : abteilungsvorstaende) {
                for (LehrerClass lehrer1 : lehrer) {
                    if (lehrer1 != abteilungsvorstand1)
                        direktorkandidaten.add(lehrer1);
                }
            }
            try {
                schule.setDirektor(direktorkandidaten.get(this.schDirektorChoiceBox.getSelectionModel().getSelectedIndex()));
            } catch (Exception e) {
                System.out.println("Kein Direktor ausgewählt: " + e.getMessage());
            }
            try {
                schule.setSchulsprecher(schueler.get(this.schSchulsprecherChoiceBox.getSelectionModel().getSelectedIndex()));
            } catch (Exception e) {
                System.out.println("Kein Schulsprecher ausgewählt: " + e.getMessage());
            }

            this.abteilungsvorstandslist.clear();
            this.lehrerlist.clear();
            this.klassenlist.clear();

            for (KlasseClass klasse : this.selectedAbteilung.getKlassen())
                this.klassenlist.add(klasse.getBezeichnung());
            for (LehrerClass lehrer2 : this.selectedAbteilung.getLehrer()) {
                if (lehrer2 != schule.getDirektor())
                    this.abteilungsvorstandslist.add(lehrer2.getNachname() + " " + lehrer2.getVorname());
                this.lehrerlist.add(lehrer2.getNachname() + " " + lehrer2.getVorname());
            }

            try {
                this.abtInfoAbteilungsvorstandChoiceBox.getSelectionModel().select(this.abteilungsvorstandslist.indexOf(abteilungsvorstand.getNachname() + " " + abteilungsvorstand.getVorname()));
            } catch (Exception e) {
                System.out.println("Kein Abteilungsvorstand gefunden: " + e.getMessage());
            }

            System.out.println("Schule gespeichert!");

            this.schulPanel.setVisible(false);
            this.schoolPanel.setDisable(false);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Info - Panel
    //////////////////////////////////////////////////////////////////////////

    @FXML
    void abtInfoSpeichern(ActionEvent event) {
        try {
            this.selectedAbteilung.setName(this.abtInfoNameTextfield.getText());
            this.selectedAbteilung.setKuerzel(this.abtInfoKuerzelTextfield.getText());

            int abteilungsindex = schule.getAbteilungen().indexOf(this.selectedAbteilung);

            ArrayList<LehrerClass> lehrer = new ArrayList<LehrerClass>();

            for (LehrerClass lehrer1: this.selectedAbteilung.getLehrer())
                lehrer.add(lehrer1);

            try {
                lehrer.remove(schule.getDirektor());
            } catch (Exception e) {
                System.out.println("Der Direktor befindet sich nicht in dieser Abteilung: " + e.getMessage());
            }

            try {
                this.selectedAbteilung.setAbteilungsvorstand(lehrer.get(abtInfoAbteilungsvorstandChoiceBox.getSelectionModel().getSelectedIndex()));
            } catch (Exception e) {
                System.out.println("Kein Abteilungsvorstand ausgewählt: " + e.getMessage());
            }

            try {
                this.selectedAbteilung.setAbteilungssprecher(this.selectedAbteilung.getSchueler().get(this.abtInfoAbteilungssprecherChoiceBox.getSelectionModel().getSelectedIndex()));
            } catch (Exception e) {
                System.out.println("Kein Abteilungssprecher ausgewählt: " + e.getMessage());
            }

            try {
                this.abteilungslist.set(this.listViewAbteilungen.getSelectionModel().getSelectedIndex(), this.selectedAbteilung.getName());
            } catch (Exception e) {
                System.out.println("Keine Abteilung ausgewählt: " + e.getMessage());
            }

            this.listViewAbteilungen.getSelectionModel().select(abteilungsindex);

            System.out.println("Abteilung gespeichert!");
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
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
        try {
            this.klassePanel.setMinHeight(633);
            this.klassePanel.setMaxHeight(633);
            this.klassePanel.setLayoutY(40);

            this.klaStammklasseChoiceBox.getSelectionModel().clearSelection();
            this.klaKlassensprecherChoiceBox.getSelectionModel().clearSelection();
            this.schuelerlist.clear();

            KlasseClass klasse = this.selectedAbteilung.getKlassen().get(this.abtInfoKlassenListView.getSelectionModel().getSelectedIndex());

            for (SchuelerClass schueler : klasse.getSchueler())
                this.schuelerlist.add(schueler.getNachname() + " " + schueler.getVorname());

            this.klaPanel1.setVisible(false);
            this.klaPanel2.setVisible(true);
            this.klaPanel3.setVisible(true);

            this.klaBezeichnungTextfield.setText(klasse.getBezeichnung());
            this.klaSchulstufeTextfield.setText(Integer.toString(klasse.getSchulstufe()));

            try {
                this.klaStammklasseChoiceBox.getSelectionModel().select(this.raumarraylist.indexOf(klasse.getStammklasse()));
            } catch (Exception e) {
                System.out.println("Keine Stammklasse gefunden: " + e.getMessage());
            }

            ArrayList<LehrerClass> lehrer = new ArrayList<LehrerClass>();

            for (LehrerClass lehrer1: this.selectedAbteilung.getLehrer())
                lehrer.add(lehrer1);

            try {
                lehrer.remove(schule.getDirektor());
            } catch (Exception e) {
                System.out.println("Der Direktor stammt nicht von dieser Abteilung: " + e.getMessage());
            }

            try {
                this.klaKlassenvorstandChoiceBox.getSelectionModel().select(lehrer.indexOf(klasse.getKlassenvorstand()));
            } catch (Exception e) {
                System.out.println("Keinen Klassenvorstand gefunden: " + e.getMessage());
            }

            try {
                SchuelerClass klassensprecher = klasse.getKlassensprecher();
                int klassensprecherindex = this.schuelerlist.indexOf(klassensprecher.getNachname() + " " + klassensprecher.getVorname());
                this.klaKlassensprecherChoiceBox.getSelectionModel().select(klassensprecherindex);
            } catch (Exception e) {
                System.out.println("Keinen Klassensprecher gefunden: " + e.getMessage());
            }

            this.klassePanel.setVisible(true);
            this.schoolPanel.setDisable(true);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    @FXML
    void abtInfoKlassenLoeschen(ActionEvent event) {
        int klassenindex = this.abtInfoKlassenListView.getSelectionModel().getSelectedIndex();
        this.klassenlist.remove(klassenindex);
        KlasseClass klasse = this.selectedAbteilung.getKlassen().get(klassenindex);
        for(SchuelerClass schueler: klasse.getSchueler())
            this.abteilungssprecherlist.remove(schueler.getNachname() + " " + schueler.getVorname());
        this.selectedAbteilung.getKlassen().remove(klassenindex);
    }

    //////////////////////////////////////////////////////////////////////////
    // Abteilung Hinzufügen - Panel
    //////////////////////////////////////////////////////////////////////////

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

            int klassenindex = this.abtInfoKlassenListView.getSelectionModel().getSelectedIndex();

            this.klassenlist.set(klassenindex, this.klaBezeichnungTextfield.getText());
            this.abtInfoKlassenListView.getSelectionModel().select(klassenindex);

            try {
                klasse.setStammklasse(this.raumarraylist.get(this.klaStammklasseChoiceBox.getSelectionModel().getSelectedIndex()));
            } catch (Exception e) {
                System.out.println("Keinen Stammraum ausgewählt:" + e.getMessage());
            }

            ArrayList<LehrerClass> lehrer = new ArrayList<LehrerClass>();

            for (LehrerClass lehrer1: this.selectedAbteilung.getLehrer())
                lehrer.add(lehrer1);

            try {
                lehrer.remove(schule.getDirektor());
            } catch (Exception e) {
                System.out.println("Der Direktor stammt nicht von dieser Abteilung: " + e.getMessage());
            }

            try {
                klasse.setKlassenvorstand(lehrer.get(this.klaKlassenvorstandChoiceBox.getSelectionModel().getSelectedIndex()));
            } catch (Exception e) {
                System.out.println("Keinen Klassenvorstand ausgewählt: " + e.getMessage());
            }

            try {
                klasse.setKlassensprecher(klasse.getSchueler().get(this.klaKlassensprecherChoiceBox.getSelectionModel().getSelectedIndex()));
            } catch (Exception e) {
                System.out.println("Keinen Klassensprecher ausgewählt: " + e.getMessage());
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

        this.perHinzuefuegenButton.setText("Hinzufügen");

        this.klassePanel.setDisable(true);
        this.personenPanel.setVisible(true);
    }

    @FXML
    void klaSchuelerLoeschen(ActionEvent event) {
        try {
            int schuelerindex = this.klaSchuelerListView.getSelectionModel().getSelectedIndex();
            this.schuelerlist.remove(schuelerindex);
            KlasseClass klasse = selectedAbteilung.getKlassen().get(this.abtInfoKlassenListView.getSelectionModel().getSelectedIndex());
            klasse.getSchueler().remove(schuelerindex);

            this.abteilungssprecherlist.clear();
            for (SchuelerClass schueler1: this.selectedAbteilung.getSchueler())
                this.abteilungssprecherlist.add(schueler1.getNachname() + " " + schueler1.getVorname());

            System.out.println("Schüler gelöscht!");
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    @FXML
    void klaSchuelerMehrInfos(ActionEvent event) {
        try {
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

            this.perHinzuefuegenButton.setText("Speichern");

            this.klassePanel.setDisable(true);
            this.personenPanel.setVisible(true);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
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

                this.abteilungssprecherlist.clear();
                for (SchuelerClass schueler1: this.selectedAbteilung.getSchueler())
                    this.abteilungssprecherlist.add(schueler1.getNachname() + " " + schueler1.getVorname());

                SchuelerClass abteilungssprecher = this.selectedAbteilung.getAbteilungssprecher();

                try {
                    this.abtInfoAbteilungssprecherChoiceBox.getSelectionModel().select(abteilungssprecher.getNachname() + " " + abteilungssprecher.getVorname());
                } catch (Exception e) {
                    System.out.println("Keinen Abteilungssprecher gefunden: " + e.getMessage());
                }

                this.personenPanel.setVisible(false);
                this.klassePanel.setDisable(false);

                System.out.println("Schüler hinzugefügt!");
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
            }
        } else if (!this.schuelerLehrer && !this.speichernHinzufuegen) {
            try {
                ArrayList<SchuelerClass> schuelerlist = this.selectedAbteilung.getKlassen().get(this.abtInfoKlassenListView.getSelectionModel().getSelectedIndex()).getSchueler();
                int schuelerindex = this.klaSchuelerListView.getSelectionModel().getSelectedIndex();

                SchuelerClass schueler = schuelerlist.get(schuelerindex);
                int abteilungssprecherindex = abteilungssprecherlist.indexOf(schueler.getNachname() + " " + schueler.getVorname());

                schueler.setSvnr(Long.parseLong(this.perSVNRTextfield.getText()));
                schueler.setVorname(this.perVornameTextfield.getText());
                schueler.setNachname(this.perNachnameTextfield.getText());
                schueler.setGeburtsdatum(this.perGeburtsdatumDatePicker.getValue());
                schueler.setEmail(this.perEmailTextfield.getText());
                schueler.setWohnort(this.adressarraylist.get(this.perAdresseChoiceBox.getSelectionModel().getSelectedIndex()));
                schueler.setEintrittsdatum(this.perEintrittsdatumTextfield.getValue());
                schueler.setKatalognummer(Integer.parseInt(this.perKatalognummerTextfield.getText()));

                this.schuelerlist.set(schuelerindex, this.perNachnameTextfield.getText() + " " + this.perVornameTextfield.getText());
                this.abteilungssprecherlist.set(abteilungssprecherindex, this.perNachnameTextfield.getText() + " " + this.perVornameTextfield.getText());

                if (schueler == this.selectedAbteilung.getAbteilungssprecher())
                    this.abtInfoAbteilungssprecherChoiceBox.getSelectionModel().select(abteilungssprecherindex);

                this.personenPanel.setVisible(false);
                this.klassePanel.setDisable(false);

                System.out.println("Schüler gespeichert!");
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
