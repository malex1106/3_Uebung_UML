package com.uebung3.Controller;

import com.uebung3.Classes.*;
import com.uebung3.Enumerations.Raumtyp;
import com.uebung3.Enumerations.Unterrichtstag;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
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

    private ArrayList<BelegungClass> belegungsarraylist;
    private ArrayList<LehrerClass> n_lehrerlist;
    private ArrayList<SchuelerClass> n_schuelerlist;

    ///////////////////////////////////////////

    @FXML
    private BorderPane schoolPanel;

    @FXML
    private AnchorPane abtAddPanel;

    @FXML
    public ListView<AbteilungClass> listViewAbteilungen;

    @FXML
    private Label schoolName;

    @FXML
    private Label schoolMitarbeiterAnzahl;

    ////////////////////////////////////////////
    // Info - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private TextField abtInfoNameTextfield;

    @FXML
    private TextField abtInfoKuerzelTextfield;

    @FXML
    private ListView<KlasseClass> abtInfoKlassenListView;

    @FXML
    private ListView<LehrerClass> abtInfoLehrerListView;

    @FXML
    private ListView<BelegungClass> abtInfoBelegungListView;

    private ObservableList<KlasseClass> klassenlist;
    private ObservableList<LehrerClass> lehrerlist;
    private ObservableList<LehrerClass> abteilungsvorstandslist;
    private ObservableList<SchuelerClass> abteilungssprecherlist;
    private ObservableList<BelegungClass> belegungenlist;

    @FXML
    private ChoiceBox<LehrerClass> abtInfoAbteilungsvorstandChoiceBox;

    @FXML
    private ChoiceBox<SchuelerClass> abtInfoAbteilungssprecherChoiceBox;

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

    private boolean isNichtLehrpersonal = false;

    @FXML
    private AnchorPane perAdresse;

    @FXML
    private ChoiceBox<AdresseClass> perAdresseChoiceBox;

    @FXML
    private Button perHinzuefuegenButton;

    @FXML
    private ChoiceBox<FachClass> perFachChoiceBox;

    @FXML
    private Button perExportStundenplanButton;

    ////////////////////////////////////////////
    // Auswahl treffen - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private AnchorPane ausPanel;

    @FXML
    private AnchorPane ausLehrerPanel;

    @FXML
    private Button ausLehrerAbteilungButton;

    ////////////////////////////////////////////////
    // Nicht zugeordnete Lehrer - Panel - Attribute
    ///////////////////////////////////////////////

    @FXML
    private ChoiceBox<LehrerClass> nzlChoiceBox;

    @FXML
    private AnchorPane nzlPanel;

    ///////////////////////////////////////////////
    // Aus anderen Abteilungen - Panel - Attribute
    //////////////////////////////////////////////

    @FXML
    private AnchorPane aaaPanel;

    @FXML
    private ChoiceBox<LehrerClass> aaaChoiceBox;

    ///////////////////////////////////////////////
    // Nicht zugeordnete Schüler - Panel - Attribute
    //////////////////////////////////////////////

    @FXML
    private AnchorPane nzsPanel;

    @FXML
    private ChoiceBox<SchuelerClass> nzsChoiceBox;

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
    private ChoiceBox<RaumClass> klaStammklasseChoiceBox;

    @FXML
    private ChoiceBox<LehrerClass> klaKlassenvorstandChoiceBox;

    @FXML
    private ChoiceBox<SchuelerClass> klaKlassensprecherChoiceBox;

    @FXML
    private ListView<SchuelerClass> klaSchuelerListView;

    private ObservableList<SchuelerClass> schuelerlist;

    /////////////////////////////////////////////
    // Unterrichtende Fächer - Panel - Attribute
    /////////////////////////////////////////////

    @FXML
    private AnchorPane falPanel;

    @FXML
    private ListView<FachClass> falAlleFaecherChoiceBox;

    @FXML
    private ListView<FachClass> falUnterrichtendeLehrerChoiceBox;

    private ArrayList<FachClass> l_faecher;

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

    private ObservableList<AdresseClass> adresslist;

    ////////////////////////////////////////////
    // Raum Hinzufügen - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private AnchorPane raumPanel;

    @FXML
    private TextField rauRaumnummerTextfield;

    @FXML
    private TextField rauSitzplaetzeTextfield;

    @FXML
    private ChoiceBox<Raumtyp> rauRaumtypChoiceBox;

    private ObservableList<RaumClass> raumlist;

    ////////////////////////////////////////////
    // Abteilung Hinzufügen - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private TextField abtAddTextfield;

    @FXML
    private TextField abtAddKuerzelTextfield;

    private static SchuleClass schule;
    private static AbteilungClass selectedAbteilung;

    private ObservableList<AbteilungClass> abteilungslist;

    ////////////////////////////////////////////
    // Belegung Hinzufügen - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private AnchorPane belegungsPanel;

    @FXML
    private ChoiceBox<KlasseClass> belKlasseChoiceBox;

    @FXML
    private ChoiceBox<FachClass> belFachChoiceBox;

    @FXML
    private ChoiceBox<LehrerClass> belLehrerChoiceBox;

    @FXML
    private ChoiceBox<Unterrichtstag> belUnterrichtstagChoiceBox;

    @FXML
    private ChoiceBox<Integer> belStundeChoiceBox;

    @FXML
    private ChoiceBox<RaumClass> belRaumChoiceBox;

    @FXML
    private Button belHinzufuegenButton;

    private boolean isBelegung = false;

    private ObservableList<BelegungClass> belegungslist;

    ////////////////////////////////////////////
    // Fach Hinzufügen - Panel - Attribute
    ////////////////////////////////////////////

    @FXML
    private AnchorPane fachPanel;

    @FXML
    private TextField facNameTextfield;

    @FXML
    private ChoiceBox<Raumtyp> facRaumanforderungChoiceBox;

    private ObservableList<FachClass> faecherlist;

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
    private ChoiceBox<LehrerClass> schDirektorChoiceBox;

    @FXML
    private ChoiceBox<SchuelerClass> schSchulsprecherChoiceBox;

    private ObservableList<LehrerClass> direktorlist;
    private ObservableList<SchuelerClass> schulsprecherlist;

    @FXML
    private ListView<NichtLehrpersonal> schNichtLehrpersonalListView;

    private ObservableList<NichtLehrpersonal> nichtpersonallist;

    ////////////////////////////////////////////////////////////////////////////////////

    /**
     * Initialisierung des Programmes.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            schule = SchuleController.getSchule();

            this.klassenlist = FXCollections.observableArrayList();
            this.lehrerlist = FXCollections.observableArrayList();
            this.abteilungsvorstandslist = FXCollections.observableArrayList();
            this.abteilungssprecherlist = FXCollections.observableArrayList();
            this.schuelerlist = FXCollections.observableArrayList();
            this.raumlist = FXCollections.observableArrayList();
            this.abteilungslist = FXCollections.observableArrayList();
            this.direktorlist = FXCollections.observableArrayList();
            this.schulsprecherlist = FXCollections.observableArrayList();
            this.belegungenlist = FXCollections.observableArrayList();
            this.faecherlist = FXCollections.observableArrayList();
            this.adresslist = FXCollections.observableArrayList();
            this.nichtpersonallist = FXCollections.observableArrayList();

            this.n_lehrerlist = new ArrayList<LehrerClass>();
            this.n_schuelerlist = new ArrayList<SchuelerClass>();
            this.l_faecher = new ArrayList<FachClass>();
            this.belegungsarraylist = new ArrayList<BelegungClass>();

            schoolName.setText("Schule - " + schule.getName());

            this.listViewAbteilungen.getSelectionModel().selectedItemProperty()
                    .addListener(new ChangeListener<AbteilungClass>() {

                        public void changed(
                                ObservableValue<? extends AbteilungClass> observable, AbteilungClass oldValue, AbteilungClass newValue) {
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
                                    klassenlist.add(klasse);

                                for (LehrerClass lehrer : selectedAbteilung.getLehrer()) {
                                    lehrerlist.add(lehrer);
                                    if (lehrer != schule.getDirektor())
                                        abteilungsvorstandslist.add(lehrer);
                                }

                                for (SchuelerClass schueler1: selectedAbteilung.getSchueler())
                                    abteilungssprecherlist.add(schueler1);

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

            /* Abteilungen */
            this.listViewAbteilungen.setItems(this.abteilungslist);
            /* Personen */
            this.perAdresseChoiceBox.setItems(this.adresslist);
            /* Infopanel */
            this.abtInfoKlassenListView.setItems(this.klassenlist);
            this.abtInfoLehrerListView.setItems(this.lehrerlist);
            this.abtInfoAbteilungsvorstandChoiceBox.setItems(this.abteilungsvorstandslist);
            this.abtInfoAbteilungssprecherChoiceBox.setItems(this.abteilungssprecherlist);
            this.abtInfoBelegungListView.setItems(this.belegungenlist);
            /* Schulpanel */
            this.schSchulsprecherChoiceBox.setItems(this.schulsprecherlist);
            this.schDirektorChoiceBox.setItems(this.direktorlist);
            this.schNichtLehrpersonalListView.setItems(this.nichtpersonallist);
            /* Klassenpanel */
            this.klaKlassensprecherChoiceBox.setItems(this.schuelerlist);
            this.klaStammklasseChoiceBox.setItems(this.raumlist);
            this.klaSchuelerListView.setItems(this.schuelerlist);
            this.klaKlassenvorstandChoiceBox.setItems(this.abteilungsvorstandslist);
            /* Raumpanel */
            this.rauRaumtypChoiceBox.setItems(FXCollections.observableArrayList(Raumtyp.values()));
            /* Belegungspanel */
            this.belKlasseChoiceBox.setItems(this.klassenlist);
            this.belLehrerChoiceBox.setItems(this.lehrerlist);
            this.belRaumChoiceBox.setItems(this.raumlist);
            this.belFachChoiceBox.setItems(this.faecherlist);
            for (int i=1; i<=10; i++)
                this.belStundeChoiceBox.getItems().add(i);
            this.belUnterrichtstagChoiceBox.setItems(FXCollections.observableArrayList(Unterrichtstag.values()));
            /* Fachpanel */
            this.facRaumanforderungChoiceBox.setItems(FXCollections.observableArrayList(Raumtyp.values()));

            ///////////////////////////////////////////////////

            this.schoolPanel.setDisable(true);
            this.abtAddPanel.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Home/Schule - Panel
    //////////////////////////////////////////////////////////////////////////

    /**
     * Abteilung hinzufügen. (Panel)
     * @param event
     */
    @FXML
    void abtAddButtonClicked(ActionEvent event) {
        this.schoolPanel.setDisable(true);
        this.abtAddPanel.setVisible(true);
    }

    /**
     * Abteilung löschen.
     * @param event
     */
    @FXML
    void schuleAbteilungLoeschen(ActionEvent event) {
        AbteilungClass abteilung = this.listViewAbteilungen.getSelectionModel().getSelectedItem();

        /* Lehrer können nicht direkt über die Abteilung gelöscht werden. */
        /* Es wird abgefragt, ob der Lehrer auch einer anderen Abteilung zugeordnet ist. */

        for (AbteilungClass abteil: schule.getAbteilungen())
            for (LehrerClass lehrer: abteilung.getLehrer())
                if ((abteil != abteilung) && (!abteil.getLehrer().contains(lehrer)))
                    this.n_lehrerlist.add(lehrer);

        schule.getAbteilungen().remove(abteilung);
        this.abteilungslist.remove(abteilung);
    }

    /**
     * Schulinformationen anzeigen
     * @param event
     */
    @FXML
    void schuleInfo(ActionEvent event) {
        /* Grafische Benutzeroberfläche */
        this.schoolPanel.setDisable(true);

        this.schNameTextfield.setText(schule.getName());
        this.schSchulkennzahlTextfield.setText(Long.toString(schule.getSchulkennzahl()));
        this.schSchultypTextfield.setText(schule.getSchultyp());
        this.schMitarbeiteranzahlTextfield.setText(Integer.toString(schule.getPersonal().size() + schule.getLehrer().size()));
        this.schSchueleranzahlTextfield.setText(Integer.toString(schule.getSchuelerAnzahl()));

        this.direktorlist.clear();
        this.schulsprecherlist.clear();

        /* DIREKTOR: Herausfinden der Direktorkandidaten */

        ArrayList<LehrerClass> direktorkandidaten = schule.getLehrer();
        ArrayList<LehrerClass> abteilungsvorstaende = new ArrayList<LehrerClass>();
        ArrayList<LehrerClass> klassenvorstaende = new ArrayList<LehrerClass>();

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

        /* DIREKTOR: Grafische Benutzeroberfläche - ChoiceBox */

        for (LehrerClass direktorkandidat: direktorkandidaten)
            this.direktorlist.add(direktorkandidat);

        try {
            schDirektorChoiceBox.getSelectionModel().select(schule.getDirektor());
        } catch (Exception e) {
            System.out.println("Kein Direktor gefunden: " + e.getMessage());
        }

        /* SCHULSPRECHER: Alle Schüler können Schulsprecher werden. */

        ArrayList<SchuelerClass> schueler = schule.getSchueler();

        /* SCHULSPRECHER: Grafische Benutzeroberfläche - ChoiceBox */

        for (SchuelerClass schueler1: schueler)
            this.schulsprecherlist.add(schueler1);

        try {
            schSchulsprecherChoiceBox.getSelectionModel().select(schule.getSchulsprecher());
        } catch (Exception e) {
            System.out.println("Kein Schulsprecher gefunden: " + e.getMessage());
        }

        /* Das Schulpanel, welches alle Schulinformationen enthält soll angezeigt werden. */

        this.schulPanel.setVisible(true);
    }

    /**
     * Panel für die Schulinformationen ausblenden.
     * @param event
     */
    @FXML
    void schExit(ActionEvent event) {
        this.schulPanel.setVisible(false);
        this.schoolPanel.setDisable(false);
    }

    /**
     * Schulinformationen speichern.
     * @param event
     */
    @FXML
    void schSpeichern(ActionEvent event) {
        try {
            /* DIREKTOR: Erneutes herausfinden der Kandidaten. */

            ArrayList<LehrerClass> direktorkandidaten = new ArrayList<LehrerClass>();
            ArrayList<LehrerClass> lehrer = schule.getLehrer();
            ArrayList<LehrerClass> abteilungsvorstaende = new ArrayList<LehrerClass>();

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

            /* DIREKTOR: Der Direktor wird der Instanz "schule" übergeben und gespeichert. */

            try {
                schule.setDirektor(this.schDirektorChoiceBox.getSelectionModel().getSelectedItem());
            } catch (Exception e) {
                System.out.println("Kein Direktor ausgewählt: " + e.getMessage());
            }

            /* SCHULSPRECHER: Der Schulsprecher wird der Instanz "schule" übergeben und gespeichert. */

            try {
                schule.setSchulsprecher(this.schSchulsprecherChoiceBox.getSelectionModel().getSelectedItem());
            } catch (Exception e) {
                System.out.println("Kein Schulsprecher ausgewählt: " + e.getMessage());
            }

            /* Für die Grafische Benutzeroberfläche wird nun die Listen geupdatet. => Abteilungsvorstand */

            this.abteilungsvorstandslist.clear();
            this.lehrerlist.clear();
            this.klassenlist.clear();

            if (this.selectedAbteilung != null) {
                for (KlasseClass klasse : this.selectedAbteilung.getKlassen())
                    this.klassenlist.add(klasse);
                for (LehrerClass lehrer2 : this.selectedAbteilung.getLehrer()) {
                    if (lehrer2 != schule.getDirektor())
                        this.abteilungsvorstandslist.add(lehrer2);
                    this.lehrerlist.add(lehrer2);
                }
            }

            /* Sobald die Abteilungsvorstandsliste geupdatet wurde, soll der Abteilungsvorstand der ausgewählten Abteilung selektiert werden. */

            try {
                LehrerClass abteilungsvorstand = this.selectedAbteilung.getAbteilungsvorstand();
                this.abtInfoAbteilungsvorstandChoiceBox.getSelectionModel().select(abteilungsvorstand);
            } catch (Exception e) {
                System.out.println("Kein Abteilungsvorstand gefunden: " + e.getMessage());
            }

            System.out.println("Schule gespeichert!");

            /* Das MainPanel anzeigen lassen. */

            this.schulPanel.setVisible(false);
            this.schoolPanel.setDisable(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    /**
     * NichtLehrpersonal hinzufügen. (Panel)
     * @param event
     */
    @FXML
    void schNichtLehrpersonalHinzufuegen(ActionEvent event) {
        this.isNichtLehrpersonal = true;
        this.speichernHinzufuegen = true;

        this.perLehrerPanel.setVisible(false);
        this.perSchuelerPanel.setVisible(false);

        this.personenPanel.setMinHeight(350);
        this.personenPanel.setMaxHeight(350);

        this.schulPanel.setDisable(true);
        this.personenPanel.setVisible(true);
    }

    /**
     * NichtLehrpersonal löschen.
     * @param event
     */
    @FXML
    void schNichtLehrpersonalLoeschen(ActionEvent event) {
        try {
            NichtLehrpersonal personal = this.schNichtLehrpersonalListView.getSelectionModel().getSelectedItem();
            schule.getPersonal().remove(personal);

            this.nichtpersonallist.remove(personal);

            this.schMitarbeiteranzahlTextfield.setText(Integer.toString(schule.getPersonal().size() + schule.getLehrer().size()));
            this.schoolMitarbeiterAnzahl.setText("Mitarbeiter: " + Integer.toString(schule.getPersonal().size() + schule.getLehrer().size()));

            System.out.println("NichtLehrpersonal gelöscht!");
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }


    /**
     * Mehr Informationen von NichtLehrpersonal anzeigen. (PersonenPanel)
     * @param event
     */
    @FXML
    void schNichtLehrpersonalMehrInfos(ActionEvent event) {
        try {
            this.isBelegung = false;
            this.isNichtLehrpersonal = false;

            this.personenPanel.setMinHeight(350);
            this.personenPanel.setMaxHeight(350);

            /* Lehrer herausfiltern. */

            NichtLehrpersonal nichtLehrpersonal = this.schNichtLehrpersonalListView.getSelectionModel().getSelectedItem();

            /* Daten des Lehrers in das PersonenPanel hinzufügen. */

            this.perSVNRTextfield.setText(Long.toString(nichtLehrpersonal.getSvnr()));
            this.perVornameTextfield.setText(nichtLehrpersonal.getVorname());
            this.perNachnameTextfield.setText(nichtLehrpersonal.getNachname());
            this.perGeburtsdatumDatePicker.setValue(nichtLehrpersonal.getGeburtsdatum());
            this.perEmailTextfield.setText(nichtLehrpersonal.getEmail());
            this.perAdresseChoiceBox.getSelectionModel().select(nichtLehrpersonal.getWohnort());

            this.perHinzuefuegenButton.setText("Speichern");

            /* SchülerPanel aktivieren. */

            this.perLehrerPanel.setVisible(false);
            this.perSchuelerPanel.setVisible(false);

            /* Lehrer- und Speichermodus aktivieren. */

            this.isNichtLehrpersonal = true;
            this.speichernHinzufuegen = false;

            /* Personenpanel anzeigen. */

            this.schulPanel.setDisable(true);
            this.personenPanel.setVisible(true);

        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Info - Panel
    //////////////////////////////////////////////////////////////////////////

    /**
     * Abteilung speichern.
     * @param event
     */
    @FXML
    void abtInfoSpeichern(ActionEvent event) {
        try {
            /* Name und Kürzel der Abteilung werden geupdatet. */

            this.selectedAbteilung.setName(this.abtInfoNameTextfield.getText());
            this.selectedAbteilung.setKuerzel(this.abtInfoKuerzelTextfield.getText());

            /* ABTEILUNGSVORSTAND: Herausfinden des Indizes von der Lehrerliste => Direktor wird nicht berücksichtigt. */

            ArrayList<LehrerClass> lehrer = new ArrayList<LehrerClass>();

            for (LehrerClass lehrer1: this.selectedAbteilung.getLehrer())
                lehrer.add(lehrer1);

            try {
                lehrer.remove(schule.getDirektor());
            } catch (Exception e) {
                System.out.println("Der Direktor befindet sich nicht in dieser Abteilung: " + e.getMessage());
            }

            /* ABTEILUNGSVORSTAND: Abteilungsvorstand setzen. */

            try {
                this.selectedAbteilung.setAbteilungsvorstand(abtInfoAbteilungsvorstandChoiceBox.getSelectionModel().getSelectedItem());
            } catch (Exception e) {
                System.out.println("Kein Abteilungsvorstand ausgewählt: " + e.getMessage());
            }

            /* ABTEILUNGSSPRECHER: Abteilungssprecher setzen => können alle Schüler sein.*/

            try {
                this.selectedAbteilung.setAbteilungssprecher(this.abtInfoAbteilungssprecherChoiceBox.getSelectionModel().getSelectedItem());
            } catch (Exception e) {
                System.out.println("Kein Abteilungssprecher ausgewählt: " + e.getMessage());
            }

            /* Abteilungsliste in der Grafischen Benutzeroberfläche soll geändert werden, falls sich Name geändert hat. */

            this.listViewAbteilungen.refresh();

            System.out.println("Abteilung gespeichert!");
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    /**
     * Klasse hinzufügen. (Panel)
     * @param event
     */
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

        this.isBelegung = false;
    }

    /**
     * Lehrer hinzufügen. (Panel)
     * @param event
     */
    @FXML
    void abtInfoLehrerHinzufuegen(ActionEvent event) {
        this.schoolPanel.setDisable(true);
        //this.personenPanel.setVisible(true);
        this.ausPanel.setVisible(true);
        this.ausLehrerPanel.setVisible(true);

        this.perLehrerPanel.setVisible(true);
        this.perSchuelerPanel.setVisible(false);
        this.perHinzuefuegenButton.setText("Hinzufügen");

        this.ausLehrerAbteilungButton.setDisable(false);

        this.personenPanel.setMinHeight(476);
        this.personenPanel.setMaxHeight(476);

        this.schuelerLehrer = true;             //Lehrer
        this.speichernHinzufuegen = true;       //neuen Lehrer hinzufügen
        this.isBelegung = false;
        this.isNichtLehrpersonal = false;
    }

    /**
     * Lehrer löschen.
     * @param event
     */
    @FXML
    void abtInfoLehrerLoeschen(ActionEvent event) {
        try {
            /* Lehrer herausfiltern. */

            ArrayList<LehrerClass> lehrerlist = this.selectedAbteilung.getLehrer();
            LehrerClass lehrer = lehrerlist.get(this.abtInfoLehrerListView.getSelectionModel().getSelectedIndex());

            /* Lehrer aus der Abteilungsvorstandsliste des GUIs löschen. */

            this.abteilungsvorstandslist.remove(lehrer.getNachname() + " " + lehrer.getVorname());

            /* Lehrer aus der Abteilung löschen. */

            lehrerlist.remove(this.abtInfoLehrerListView.getSelectionModel().getSelectedIndex());

            /* Lehrer aus der Lehrerlist des GUIs löschen. */

            this.lehrerlist.remove(this.abtInfoLehrerListView.getSelectionModel().getSelectedIndex());
            this.schoolMitarbeiterAnzahl.setText("Mitarbeiter: " + Integer.toString(schule.getPersonal().size() + schule.getLehrer().size()));
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    /**
     * Lehrerinformationen anzeigen.
     * @param event
     */
    @FXML
    void abtInfoLehrerInfo(ActionEvent event) {
        try {
            this.isBelegung = false;
            this.isNichtLehrpersonal = false;

            this.personenPanel.setMinHeight(476);
            this.personenPanel.setMaxHeight(476);

            /* Lehrer herausfiltern. */

            LehrerClass lehrer = selectedAbteilung.getLehrer().get(this.abtInfoLehrerListView.getSelectionModel().getSelectedIndex());

            /* Fächer in den Zwischenspeicher. */

            this.l_faecher.clear();
            for (FachClass fach: lehrer.getFaecher())
                this.l_faecher.add(fach);

            /* Daten des Lehrers in das PersonenPanel hinzufügen. */

            this.perSVNRTextfield.setText(Long.toString(lehrer.getSvnr()));
            this.perVornameTextfield.setText(lehrer.getVorname());
            this.perNachnameTextfield.setText(lehrer.getNachname());
            this.perGeburtsdatumDatePicker.setValue(lehrer.getGeburtsdatum());
            this.perEmailTextfield.setText(lehrer.getEmail());
            this.perKuerzelTextfield.setText(lehrer.getKuerzel());
            this.perAdresseChoiceBox.getSelectionModel().select(lehrer.getWohnort());

            this.perHinzuefuegenButton.setText("Speichern");

            /* SchülerPanel aktivieren. */

            this.perLehrerPanel.setVisible(true);
            this.perSchuelerPanel.setVisible(false);

            /* Lehrer- und Speichermodus aktivieren. */

            this.speichernHinzufuegen = false;
            this.schuelerLehrer = true;

            /* Personenpanel anzeigen. */

            this.schoolPanel.setDisable(true);
            this.personenPanel.setVisible(true);

        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    /**
     * Klasseninformationen anzeigen.
     * @param event
     */
    @FXML
    void abtInfoKlassenInfo(ActionEvent event) {
        try {
            this.isBelegung = false;

            /* Layout des KlassenPanels anpassen. */

            this.klassePanel.setMinHeight(633);
            this.klassePanel.setMaxHeight(633);
            this.klassePanel.setLayoutY(40);

            /* Vorherige Selektionen und Listen löschen. */

            this.klaStammklasseChoiceBox.getSelectionModel().clearSelection();
            this.klaKlassensprecherChoiceBox.getSelectionModel().clearSelection();
            this.schuelerlist.clear();

            /* Klasse mit Schüler herausfiltern und in die Schülerliste eintragen. */

            KlasseClass klasse = this.abtInfoKlassenListView.getSelectionModel().getSelectedItem();

            for (SchuelerClass schueler : klasse.getSchueler())
                this.schuelerlist.add(schueler);

            /* Zusätzliche Klassenpanels aktivieren. */

            this.klaPanel1.setVisible(false);
            this.klaPanel2.setVisible(true);
            this.klaPanel3.setVisible(true);

            /* Diverse Daten in das GUI schreiben. */

            this.klaBezeichnungTextfield.setText(klasse.getBezeichnung());
            this.klaSchulstufeTextfield.setText(Integer.toString(klasse.getSchulstufe()));

            /* STAMMKLASSE */

            try {
                this.klaStammklasseChoiceBox.getSelectionModel().select(klasse.getStammklasse());
            } catch (Exception e) {
                System.out.println("Keine Stammklasse gefunden: " + e.getMessage());
            }

            /* LEHRER OHNE DIREKTOR */

            ArrayList<LehrerClass> lehrer = new ArrayList<LehrerClass>();

            for (LehrerClass lehrer1: this.selectedAbteilung.getLehrer())
                lehrer.add(lehrer1);

            try {
                lehrer.remove(schule.getDirektor());
            } catch (Exception e) {
                System.out.println("Der Direktor stammt nicht von dieser Abteilung: " + e.getMessage());
            }

            /* KLASSENVORSTAND */

            try {
                this.klaKlassenvorstandChoiceBox.getSelectionModel().select(lehrer.indexOf(klasse.getKlassenvorstand()));
            } catch (Exception e) {
                System.out.println("Keinen Klassenvorstand gefunden: " + e.getMessage());
            }

            /* KLASSENSPRECHER */

            try {
                SchuelerClass klassensprecher = klasse.getKlassensprecher();
                this.klaKlassensprecherChoiceBox.getSelectionModel().select(klassensprecher);
            } catch (Exception e) {
                System.out.println("Keinen Klassensprecher gefunden: " + e.getMessage());
            }

            /* Klassenpanel anzeigen. */

            this.klassePanel.setVisible(true);
            this.schoolPanel.setDisable(true);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    /**
     * Klasse löschen.
     * @param event
     */
    @FXML
    void abtInfoKlassenLoeschen(ActionEvent event) {
        try {
            KlasseClass klasse = this.abtInfoKlassenListView.getSelectionModel().getSelectedItem();

            for (SchuelerClass schueler: klasse.getSchueler())
                this.n_schuelerlist.add(schueler);

            this.klassenlist.remove(klasse);
            this.selectedAbteilung.getKlassen().remove(klasse);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    /**
     * Belegung hinzufügen. (Panel)
     * @param event
     */
    @FXML
    void abtInfoBelegungHinzufuegen(ActionEvent event) {
        this.belHinzufuegenButton.setDisable(false);

        this.schoolPanel.setDisable(true);
        this.belegungsPanel.setVisible(true);
    }

    /**
     * Belegungsinformationen anzeigen.
     * @param event
     */
    @FXML
    void abtInfoBelegungInfo(ActionEvent event) {
        try {
            BelegungClass belegung = this.abtInfoBelegungListView.getSelectionModel().getSelectedItem();

            this.belKlasseChoiceBox.getSelectionModel().select(belegung.getKlasse());
            this.belFachChoiceBox.getSelectionModel().select(belegung.getFach());
            this.belLehrerChoiceBox.getSelectionModel().select(belegung.getLehrer());
            this.belUnterrichtstagChoiceBox.getSelectionModel().select(belegung.getWochentag());
            this.belStundeChoiceBox.getSelectionModel().select(belegung.getStunde());
            this.belRaumChoiceBox.getSelectionModel().select(belegung.getRaum());

            this.belHinzufuegenButton.setDisable(true);

            this.belegungsPanel.setVisible(true);
            this.schoolPanel.setDisable(true);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    /**
     * Belegung löschen.
     * @param event
     */
    @FXML
    void abtInfoBelegungLoeschen(ActionEvent event) {
        try {
            BelegungClass belegung = this.abtInfoBelegungListView.getSelectionModel().getSelectedItem();
            this.belegungenlist.remove(belegung);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Abteilung Hinzufügen - Panel
    //////////////////////////////////////////////////////////////////////////

    /**
     * Abteilung hinzufügen.
     * @param event
     */
    @FXML
    void abtAddAddButton(ActionEvent event) {
        try {
            AbteilungClass abteilung = schule.addAbteilung(this.abtAddTextfield.getText(), this.abtAddKuerzelTextfield.getText());
            abteilung.setSchule(schule);

            this.abteilungslist.add(abteilung);

            this.listViewAbteilungen.getSelectionModel().select(abteilung);

            this.abtAddPanel.setVisible(false);
            this.schoolPanel.setDisable(false);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    /**
     * Panel für das Hinzufügen einer Abteilung schließen.
     * @param event
     */
    @FXML
    void abtAddExitButtonClicked(ActionEvent event) {
        this.abtAddPanel.setVisible(false);
        this.schoolPanel.setDisable(false);
    }

    //////////////////////////////////////////////////////////////////////////
    // Klasse Hinzufügen - Panel
    /////////////////////////////////////////////////////////////////////////

    /**
     * Klasse hinzufügen.
     * @param event
     */
    @FXML
    void klaHinzufuegen(ActionEvent event) {
        try {
            KlasseClass klasse = new KlasseClass(this.klaBezeichnungTextfield.getText(), Integer.parseInt(this.klaSchulstufeTextfield.getText()), selectedAbteilung);
            selectedAbteilung.addKlasse(klasse);

            this.klassenlist.add(klasse);

            if (!isBelegung) {
                this.klassePanel.setVisible(false);
                this.schoolPanel.setDisable(false);
            } else {
                this.klassePanel.setVisible(false);
                this.belegungsPanel.setDisable(false);
            }

            System.out.println("Klasse hinzugefügt!");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    /**
     * Klasse speichern.
     * @param event
     */
    @FXML
    void klaSpeichern(ActionEvent event) {
        try {
            /* Klasse herausfiltern. */

            KlasseClass klasse = this.abtInfoKlassenListView.getSelectionModel().getSelectedItem();

            /* Bezeichnung und Schulstufe updaten. */

            klasse.setBezeichnung(this.klaBezeichnungTextfield.getText());
            klasse.setSchulstufe(Integer.parseInt(this.klaSchulstufeTextfield.getText()));

            /* Klassenindex herausfinden. */

            int klassenindex = this.abtInfoKlassenListView.getSelectionModel().getSelectedIndex();

            /* Liste des GUIS updaten. */

            abtInfoKlassenListView.refresh();

            /* STAMMKLASSE */

            try {
                klasse.setStammklasse(this.klaStammklasseChoiceBox.getSelectionModel().getSelectedItem());
            } catch (Exception e) {
                System.out.println("Keinen Stammraum ausgewählt:" + e.getMessage());
            }

            /* Lehrer herausfinden für den Index des ausgewählten Klassenvorstands. */

            ArrayList<LehrerClass> lehrer = new ArrayList<LehrerClass>();

            for (LehrerClass lehrer1: this.selectedAbteilung.getLehrer())
                lehrer.add(lehrer1);

            try {
                lehrer.remove(schule.getDirektor());
            } catch (Exception e) {
                System.out.println("Der Direktor stammt nicht von dieser Abteilung: " + e.getMessage());
            }

            /* KLASSENVORSTAND */

            try {
                klasse.setKlassenvorstand(lehrer.get(this.klaKlassenvorstandChoiceBox.getSelectionModel().getSelectedIndex()));
            } catch (Exception e) {
                System.out.println("Keinen Klassenvorstand ausgewählt: " + e.getMessage());
            }

            /* KLASSENSPRECHER */

            try {
                klasse.setKlassensprecher(klasse.getSchueler().get(this.klaKlassensprecherChoiceBox.getSelectionModel().getSelectedIndex()));
            } catch (Exception e) {
                System.out.println("Keinen Klassensprecher ausgewählt: " + e.getMessage());
            }

            System.out.println("Klasse gespeichert!");

            /* Klassenpanel ausblenden. */

            this.klassePanel.setVisible(false);
            this.schoolPanel.setDisable(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    /**
     * Klassenpanel schließen.
     * @param event
     */
    @FXML
    void klaExit(ActionEvent event) {
        if (!isBelegung) {
            this.schoolPanel.setDisable(false);
            this.klassePanel.setVisible(false);
        } else {
            this.klassePanel.setVisible(false);
            this.belegungsPanel.setDisable(false);
        }
    }

    /**
     * Schüler zu einer Klasse hinzufügen und erzeugen.
     * @param event
     */
    @FXML
    void klaSchuelerHinzufuegen(ActionEvent event) {
        this.schuelerLehrer = false;
        this.speichernHinzufuegen = true;

        this.personenPanel.setMinHeight(476);
        this.personenPanel.setMaxHeight(476);

        this.perSchuelerPanel.setVisible(true);
        this.perLehrerPanel.setVisible(false);

        this.perHinzuefuegenButton.setText("Hinzufügen");

        this.isBelegung = false;
        this.isNichtLehrpersonal = false;

        this.ausLehrerAbteilungButton.setDisable(true);

        this.klassePanel.setDisable(true);
        this.ausPanel.setVisible(true);
        //this.personenPanel.setVisible(true);
    }

    /**
     * Schüler in einer Klasse löschen.
     * @param event
     */
    @FXML
    void klaSchuelerLoeschen(ActionEvent event) {
        try {
            SchuelerClass schueler = this.klaSchuelerListView.getSelectionModel().getSelectedItem();
            this.schuelerlist.remove(schueler);
            KlasseClass klasse = selectedAbteilung.getKlassen().get(this.abtInfoKlassenListView.getSelectionModel().getSelectedIndex());
            klasse.getSchueler().remove(schueler);

            this.abteilungssprecherlist.clear();
            for (SchuelerClass schueler1: this.selectedAbteilung.getSchueler())
                this.abteilungssprecherlist.add(schueler1);

            System.out.println("Schüler gelöscht!");
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    /**
     * Schülerinformationen anzeigen.
     * @param event
     */
    @FXML
    void klaSchuelerMehrInfos(ActionEvent event) {
        try {
            this.personenPanel.setMinHeight(476);
            this.personenPanel.setMaxHeight(476);

            SchuelerClass schueler = this.klaSchuelerListView.getSelectionModel().getSelectedItem();

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
            this.perAdresseChoiceBox.getSelectionModel().select(schueler.getWohnort());

            this.perHinzuefuegenButton.setText("Speichern");

            this.isBelegung = false;

            this.klassePanel.setDisable(true);
            this.personenPanel.setVisible(true);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    /**
     * Neuen Raum erstellen.
     * @param event
     */
    @FXML
    void klaStammklasseNeu(ActionEvent event) {
        this.klassePanel.setDisable(true);
        this.raumPanel.setVisible(true);

        this.isBelegung = false;
    }

    @FXML
    void klaExportStundenplan(ActionEvent event) {
        try {
            KlasseClass klasse = this.abtInfoKlassenListView.getSelectionModel().getSelectedItem();
            klasse.exportStundenplan(this.belegungsarraylist);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Personen Hinzufügen - Panel
    /////////////////////////////////////////////////////////////////////////

    /**
     * Personenpanel schließen.
     * @param event
     */
    @FXML
    void perExit(ActionEvent event) {
        if (!this.isNichtLehrpersonal) {
            if (this.schuelerLehrer) {
                this.personenPanel.setVisible(false);
                this.schoolPanel.setDisable(false);
            } else {
                this.personenPanel.setVisible(false);
                this.klassePanel.setDisable(false);
            }
        } else {
            this.personenPanel.setVisible(false);
            this.schulPanel.setDisable(false);
        }
    }

    /**
     * Person hinzufügen.
     * @param event
     */
    @FXML
    void perHinzufuegen(ActionEvent event) {
        if (!isNichtLehrpersonal) {
            /* Lehrer / Hinzufügen. */
            if (this.schuelerLehrer && this.speichernHinzufuegen) {
                try {
                    LehrerClass lehrer = new LehrerClass(Long.parseLong(this.perSVNRTextfield.getText()), this.perVornameTextfield.getText(), this.perNachnameTextfield.getText(),
                            this.perGeburtsdatumDatePicker.getValue(), this.perEmailTextfield.getText(), this.perKuerzelTextfield.getText());
                    lehrer.setWohnort(this.perAdresseChoiceBox.getSelectionModel().getSelectedItem());

                    for (FachClass fach: this.l_faecher) {
                        lehrer.addFach(fach);
                        fach.addLehrer(lehrer);
                    }

                    this.selectedAbteilung.addLehrer(lehrer);

                    this.lehrerlist.add(lehrer);
                    this.abteilungsvorstandslist.add(lehrer);

                    if (!isBelegung) {
                        this.personenPanel.setVisible(false);
                        this.schoolPanel.setDisable(false);
                    } else {
                        this.personenPanel.setVisible(false);
                        this.belegungsPanel.setDisable(false);
                    }

                    this.schoolMitarbeiterAnzahl.setText("Mitarbeiter: " + Integer.toString(schule.getPersonal().size() + schule.getLehrer().size()));

                    System.out.println("Lehrer hinzugefügt!");
                } catch (Exception e) {
                    //e.printStackTrace();
                    System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
                }
            }

            /* Lehrer / Speichern */

            else if (this.schuelerLehrer && !this.speichernHinzufuegen) {
                try {
                    LehrerClass lehrer = this.abtInfoLehrerListView.getSelectionModel().getSelectedItem();

                    if (lehrer == this.selectedAbteilung.getAbteilungsvorstand())
                        this.abtInfoAbteilungsvorstandChoiceBox.getSelectionModel().select(lehrer);

                    lehrer.setSvnr(Long.parseLong(this.perSVNRTextfield.getText()));
                    lehrer.setVorname(this.perVornameTextfield.getText());
                    lehrer.setNachname(this.perNachnameTextfield.getText());
                    lehrer.setGeburtsdatum(this.perGeburtsdatumDatePicker.getValue());
                    lehrer.setEmail(this.perEmailTextfield.getText());
                    lehrer.setWohnort(this.perAdresseChoiceBox.getSelectionModel().getSelectedItem());

                    lehrer.getFaecher().clear();
                    for (FachClass fach: this.l_faecher) {
                        lehrer.addFach(fach);
                        if (!fach.getLehrer().contains(lehrer))
                            fach.addLehrer(lehrer);
                    }

                    this.abtInfoLehrerListView.refresh();

                    if (schule.getDirektor() != lehrer)
                        this.abteilungsvorstandslist.set(this.abtInfoLehrerListView.getSelectionModel().getSelectedIndex(), lehrer);

                    if (!isBelegung) {
                        this.personenPanel.setVisible(false);
                        this.schoolPanel.setDisable(false);
                    } else {
                        this.personenPanel.setVisible(false);
                        this.belegungsPanel.setDisable(false);
                    }

                    System.out.println("Lehrer gespeichert!");
                } catch (Exception e) {
                    System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
                }
            }

            /* Schüler / Hinzufügen */

            else if (!this.schuelerLehrer && this.speichernHinzufuegen) {
                try {
                    SchuelerClass schueler = new SchuelerClass(Long.parseLong(this.perSVNRTextfield.getText()), this.perVornameTextfield.getText(), this.perNachnameTextfield.getText(),
                            this.perGeburtsdatumDatePicker.getValue(), this.perEmailTextfield.getText());
                    schueler.setWohnort(this.perAdresseChoiceBox.getSelectionModel().getSelectedItem());
                    schueler.setKatalognummer(Integer.parseInt(this.perKatalognummerTextfield.getText()));
                    schueler.setEintrittsdatum(this.perEintrittsdatumTextfield.getValue());

                    KlasseClass klasse = this.selectedAbteilung.getKlassen().get(this.abtInfoKlassenListView.getSelectionModel().getSelectedIndex());
                    klasse.addSchueler(schueler);

                    schueler.setKlasse(klasse);

                    this.schuelerlist.add(schueler);

                    this.abteilungssprecherlist.clear();
                    for (SchuelerClass schueler1 : this.selectedAbteilung.getSchueler())
                        this.abteilungssprecherlist.add(schueler1);

                    SchuelerClass abteilungssprecher = this.selectedAbteilung.getAbteilungssprecher();

                    try {
                        this.abtInfoAbteilungssprecherChoiceBox.getSelectionModel().select(abteilungssprecher);
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
            }

            /* Schüler / Speichern */

            else if (!this.schuelerLehrer && !this.speichernHinzufuegen) {
                try {
                    ArrayList<SchuelerClass> schuelerlist = this.selectedAbteilung.getKlassen().get(this.abtInfoKlassenListView.getSelectionModel().getSelectedIndex()).getSchueler();
                    int schuelerindex = this.klaSchuelerListView.getSelectionModel().getSelectedIndex();

                    SchuelerClass schueler = schuelerlist.get(schuelerindex);

                    schueler.setSvnr(Long.parseLong(this.perSVNRTextfield.getText()));
                    schueler.setVorname(this.perVornameTextfield.getText());
                    schueler.setNachname(this.perNachnameTextfield.getText());
                    schueler.setGeburtsdatum(this.perGeburtsdatumDatePicker.getValue());
                    schueler.setEmail(this.perEmailTextfield.getText());
                    schueler.setWohnort(this.perAdresseChoiceBox.getSelectionModel().getSelectedItem());
                    schueler.setEintrittsdatum(this.perEintrittsdatumTextfield.getValue());
                    schueler.setKatalognummer(Integer.parseInt(this.perKatalognummerTextfield.getText()));

                    //this.abteilungssprecherlist.set(abteilungssprecherindex, this.perNachnameTextfield.getText() + " " + this.perVornameTextfield.getText());

                    if (schueler == this.selectedAbteilung.getAbteilungssprecher())
                        this.abtInfoAbteilungssprecherChoiceBox.getSelectionModel().select(schueler);

                    this.personenPanel.setVisible(false);
                    this.klassePanel.setDisable(false);

                    System.out.println("Schüler gespeichert!");
                } catch (Exception e) {
                    System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
                }
            }
        }
        /* NICHTLEHRPERSONAL */
        else {
            /* Hinzufügen */
            if (this.speichernHinzufuegen) {
                try {
                    NichtLehrpersonal personal = new NichtLehrpersonal(Long.parseLong(this.perSVNRTextfield.getText()), this.perVornameTextfield.getText(), this.perNachnameTextfield.getText(),
                            this.perGeburtsdatumDatePicker.getValue(), this.perEmailTextfield.getText());
                    personal.setWohnort(this.perAdresseChoiceBox.getSelectionModel().getSelectedItem());

                    schule.addPersonal(personal);
                    this.nichtpersonallist.add(personal);

                    this.schoolMitarbeiterAnzahl.setText("Mitarbeiter: " + Integer.toString(schule.getPersonal().size() + schule.getLehrer().size()));
                    this.schMitarbeiteranzahlTextfield.setText(Integer.toString(schule.getPersonal().size() + schule.getLehrer().size()));

                    this.personenPanel.setVisible(false);
                    this.schulPanel.setDisable(false);

                    System.out.println("Nicht Lehrpersonal hinzugefügt!");
                } catch (Exception e) {
                    //e.printStackTrace();
                    System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
                }
            }
            /* Speichern */
            else {
                try {
                    NichtLehrpersonal personal = this.schNichtLehrpersonalListView.getSelectionModel().getSelectedItem();

                    personal.setSvnr(Long.parseLong(this.perSVNRTextfield.getText()));
                    personal.setVorname(this.perVornameTextfield.getText());
                    personal.setNachname(this.perNachnameTextfield.getText());
                    personal.setGeburtsdatum(this.perGeburtsdatumDatePicker.getValue());
                    personal.setEmail(this.perEmailTextfield.getText());
                    personal.setWohnort(this.perAdresseChoiceBox.getSelectionModel().getSelectedItem());

                    this.schNichtLehrpersonalListView.refresh();

                    this.personenPanel.setVisible(false);
                    this.schulPanel.setDisable(false);
                } catch (Exception e) {
                    System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Neue Adresse erstellen.
     * @param event
     */
    @FXML
    void perAdresseNeu(ActionEvent event) {
        this.personenPanel.setDisable(true);
        this.ortPanel.setVisible(true);
    }

    /**
     * Lehrer Stundenplan exportieren als Excel-Dok.
     * @param event
     */
    @FXML
    void perExportStundenplan(ActionEvent event) {
        try {
            LehrerClass lehrer = this.abtInfoLehrerListView.getSelectionModel().getSelectedItem();
            lehrer.exportStundenplan(this.belegungsarraylist);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    @FXML
    void perFaecherVerwalten(ActionEvent event) {
        try {
            ObservableList<FachClass> l_faecher;

            if (!speichernHinzufuegen) {
                LehrerClass lehrer = this.abtInfoLehrerListView.getSelectionModel().getSelectedItem();
                l_faecher = FXCollections.observableArrayList(lehrer.getFaecher());
            } else
                l_faecher = FXCollections.observableArrayList();
            ObservableList<FachClass> a_faecher = FXCollections.observableArrayList();

            for (FachClass fach: this.faecherlist)
                if (!l_faecher.contains(fach))
                    a_faecher.add(fach);

            this.falAlleFaecherChoiceBox.setItems(a_faecher);
            this.falUnterrichtendeLehrerChoiceBox.setItems(l_faecher);

            this.personenPanel.setDisable(true);
            this.falPanel.setVisible(true);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Ort Hinzufügen - Panel
    /////////////////////////////////////////////////////////////////////////

    /**
     * Ortspanel schließen.
     * @param event
     */
    @FXML
    void ortExit(ActionEvent event) {
        this.ortPanel.setVisible(false);
        this.personenPanel.setDisable(false);
    }

    /**
     * Ort hinzufügen.
     * @param event
     */
    @FXML
    void ortHinzufuegen(ActionEvent event) {
        try {
            AdresseClass adresse = new AdresseClass(this.ortOrtTextfield.getText(), this.ortStrasseTextfield.getText(), Integer.parseInt(this.ortHausnummerTextfield.getText()), Integer.parseInt(this.ortPLZTextfield.getText()));
            this.adresslist.add(adresse);

            this.ortPanel.setVisible(false);
            this.personenPanel.setDisable(false);

            System.out.println("Ort hinzugefügt!");
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten!");
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Raum Hinzufügen - Panel
    /////////////////////////////////////////////////////////////////////////

    /**
     * Raumpanel schließen.
     * @param event
     */
    @FXML
    void rauExit(ActionEvent event) {
        if (!isBelegung) {
            this.raumPanel.setVisible(false);
            this.klassePanel.setDisable(false);
        } else {
            this.raumPanel.setVisible(false);
            this.belegungsPanel.setDisable(false);
        }
    }

    /**
     * Raum hinzufügen.
     * @param event
     */
    @FXML
    void rauHinzufuegen(ActionEvent event) {
        try {
            RaumClass raum = new RaumClass(this.rauRaumnummerTextfield.getText(), Integer.parseInt(this.rauSitzplaetzeTextfield.getText()), this.rauRaumtypChoiceBox.getSelectionModel().getSelectedItem());

            this.raumlist.add(raum);

            if (!isBelegung) {
                this.raumPanel.setVisible(false);
                this.klassePanel.setDisable(false);
            } else {
                this.raumPanel.setVisible(false);
                this.belegungsPanel.setDisable(false);
            }

            System.out.println("Raum hinzugefügt.");
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten!");
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Fach Hinzufügen - Panel
    //////////////////////////////////////////////////////////////////////////

    /**
     * Fachpanel ausblenden.
     * @param event
     */
    @FXML
    void facExit(ActionEvent event) {
        this.fachPanel.setVisible(false);
        this.belegungsPanel.setDisable(false);
    }

    /**
     * Fach hinzufügen.
     * @param event
     */
    @FXML
    void facHinzufuegen(ActionEvent event) {
        try {
            FachClass fach = new FachClass(this.facNameTextfield.getText(), 0, this.facRaumanforderungChoiceBox.getSelectionModel().getSelectedItem());
            this.faecherlist.add(fach);
            this.falAlleFaecherChoiceBox.getItems().add(fach);

            this.fachPanel.setVisible(false);
            this.belegungsPanel.setDisable(false);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    //////////////////////////////////////////////////////////////////////////
    // Belegung Hinzufügen - Panel
    /////////////////////////////////////////////////////////////////////////

    /**
     * Belegungspanel ausblenden.
     * @param event
     */
    @FXML
    void belExit(ActionEvent event) {
        this.belegungsPanel.setVisible(false);
        this.schoolPanel.setDisable(false);
    }

    /**
     * Belegung hinzufügen.
     * @param event
     */
    @FXML
    void belHinzufuegen(ActionEvent event) {
        try {
            KlasseClass klasse = this.belKlasseChoiceBox.getSelectionModel().getSelectedItem();
            FachClass fach = this.belFachChoiceBox.getSelectionModel().getSelectedItem();
            LehrerClass lehrer = this.belLehrerChoiceBox.getSelectionModel().getSelectedItem();
            Unterrichtstag unterrichtstag = this.belUnterrichtstagChoiceBox.getSelectionModel().getSelectedItem();
            int stunde = this.belStundeChoiceBox.getSelectionModel().getSelectedItem();
            RaumClass raum = this.belRaumChoiceBox.getSelectionModel().getSelectedItem();

            BelegungClass belegung = new BelegungClass(klasse, fach, lehrer, unterrichtstag, stunde, raum);
            this.belegungenlist.add(belegung);
            this.belegungsarraylist.add(belegung);

            this.belegungsPanel.setVisible(false);
            this.schoolPanel.setDisable(false);

            System.out.println("Belegung hinzugefügt!");

        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    /**
     * Klasse hinzufügen.
     * @param event
     */
    @FXML
    void belKlasseNeu(ActionEvent event) {
        this.klassePanel.setMaxHeight(210);
        this.klassePanel.setMinHeight(210);
        this.klassePanel.setLayoutY(210);

        this.belegungsPanel.setDisable(true);
        this.klassePanel.setVisible(true);

        this.klaPanel1.setVisible(true);
        this.klaPanel2.setVisible(false);
        this.klaPanel3.setVisible(false);

        this.isBelegung = true;
    }

    /**
     * Lehrer hinzufügen.
     * @param event
     */
    @FXML
    void belLehrerNeu(ActionEvent event) {
        this.belegungsPanel.setDisable(true);
        this.personenPanel.setVisible(true);
        this.perLehrerPanel.setVisible(true);
        this.perSchuelerPanel.setVisible(false);
        this.perHinzuefuegenButton.setText("Hinzufügen");

        this.schuelerLehrer = true;             //Lehrer
        this.speichernHinzufuegen = true;       //neuen Lehrer hinzufügen
        this.isBelegung = true;
        this.isNichtLehrpersonal = false;
    }

    /**
     * Raum hinzufügen.
     * @param event
     */
    @FXML
    void belRaumNeu(ActionEvent event) {
        this.belegungsPanel.setDisable(true);
        this.raumPanel.setVisible(true);

        this.isBelegung = true;
    }

    /**
     * Fach hinzufügen.
     * @param event
     */
    @FXML
    void belFachNeu(ActionEvent event) {
        this.belegungsPanel.setDisable(true);
        this.fachPanel.setVisible(true);
    }

    ////////////////////////////////////////////////////
    // Auswahl treffen - Panel
    ////////////////////////////////////////////////////

    @FXML
    void ausLehrerAbteilung(ActionEvent event) {
        try {
            ObservableList<LehrerClass> lehrer = FXCollections.observableArrayList();
            for (AbteilungClass abteilung : schule.getAbteilungen())
                if (abteilung != this.selectedAbteilung)
                    for (LehrerClass lehr : abteilung.getLehrer())
                        if ((!this.selectedAbteilung.getLehrer().contains(lehr)) && (!lehrer.contains(lehr)))
                            lehrer.add(lehr);

            this.aaaChoiceBox.setItems(lehrer);

            this.aaaPanel.setVisible(true);
            this.ausPanel.setVisible(false);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    @FXML
    void ausLehrerHinzufuegen(ActionEvent event) {
        this.ausPanel.setVisible(false);
        this.personenPanel.setVisible(true);
    }

    @FXML
    void ausLehrerNichtZugeordnet(ActionEvent event) {
        if (schuelerLehrer) {
            this.nzlChoiceBox.setItems(FXCollections.observableArrayList(this.n_lehrerlist));
            this.ausPanel.setVisible(false);
            this.nzlPanel.setVisible(true);
        }
        else {
            this.nzsChoiceBox.setItems(FXCollections.observableArrayList(this.n_schuelerlist));
            this.ausPanel.setVisible(false);
            this.nzsPanel.setVisible(true);
        }

    }

    @FXML
    void ausExit(ActionEvent event) {
        if (schuelerLehrer) {
            this.ausPanel.setVisible(false);
            this.schoolPanel.setDisable(false);
        } else {
            this.ausPanel.setVisible(false);
            this.klassePanel.setDisable(false);
        }
    }

    ////////////////////////////////////////////////////
    // Nicht zugeordnete Lehrer - Panel
    ////////////////////////////////////////////////////

    @FXML
    void nzlExit(ActionEvent event) {
        this.nzlPanel.setVisible(false);
        this.schoolPanel.setDisable(false);
    }

    @FXML
    void nzlHinzufuegen(ActionEvent event) {
        try {
            LehrerClass lehrer = this.nzlChoiceBox.getSelectionModel().getSelectedItem();

            this.selectedAbteilung.addLehrer(lehrer);

            this.lehrerlist.add(lehrer);
            this.abteilungsvorstandslist.add(lehrer);

            this.n_lehrerlist.remove(lehrer);

            this.nzlPanel.setVisible(false);
            this.schoolPanel.setDisable(false);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetaucht: " + e.getMessage());
        }
    }

    ////////////////////////////////////////////////////
    // Nicht zugeordnete Schüler - Panel
    ////////////////////////////////////////////////////

    @FXML
    void nzsExit(ActionEvent event) {
        this.nzsPanel.setVisible(false);
        this.klassePanel.setDisable(false);
    }

    @FXML
    void nzsHinzufuegen(ActionEvent event) {
        try {
            SchuelerClass schueler = this.nzsChoiceBox.getSelectionModel().getSelectedItem();

            KlasseClass klasse = this.abtInfoKlassenListView.getSelectionModel().getSelectedItem();

            klasse.addSchueler(schueler);
            schueler.setKlasse(klasse);

            this.schuelerlist.add(schueler);

            this.abteilungssprecherlist.clear();
            for (SchuelerClass schueler1 : this.selectedAbteilung.getSchueler())
                this.abteilungssprecherlist.add(schueler1);

            SchuelerClass abteilungssprecher = this.selectedAbteilung.getAbteilungssprecher();

            try {
                this.abtInfoAbteilungssprecherChoiceBox.getSelectionModel().select(abteilungssprecher);
            } catch (Exception e) {
                System.out.println("Keinen Abteilungssprecher gefunden: " + e.getMessage());
            }

            this.n_schuelerlist.remove(schueler);

            this.nzsPanel.setVisible(false);
            this.klassePanel.setDisable(false);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetaucht: " + e.getMessage());
        }
    }

    ////////////////////////////////////////////////////
    // Aus anderen Abteilungen - Panel
    ////////////////////////////////////////////////////

    @FXML
    void aaaExit(ActionEvent event) {
        this.aaaPanel.setVisible(false);
        this.schoolPanel.setDisable(false);
    }

    @FXML
    void aaaHinzufuegen(ActionEvent event) {
        try {
            LehrerClass lehrer = this.aaaChoiceBox.getSelectionModel().getSelectedItem();

            this.selectedAbteilung.addLehrer(lehrer);

            this.lehrerlist.add(lehrer);
            this.abteilungsvorstandslist.add(lehrer);

            this.aaaPanel.setVisible(false);
            this.schoolPanel.setDisable(false);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetaucht: " + e.getMessage());
        }
    }

    ////////////////////////////////////////////////////
    // Unterrichtende Fächer - Panel
    ////////////////////////////////////////////////////

    @FXML
    void falExit(ActionEvent event) {
        this.falPanel.setVisible(false);
        this.personenPanel.setDisable(false);
    }

    @FXML
    void falSpeichern(ActionEvent event) {
        try {
            this.l_faecher.clear();
            for (FachClass fach : this.falUnterrichtendeLehrerChoiceBox.getItems())
                this.l_faecher.add(fach);

            this.falPanel.setVisible(false);
            this.personenPanel.setDisable(false);
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    @FXML
    void falNeu(ActionEvent event) {
        this.falPanel.setDisable(false);
        this.fachPanel.setVisible(true);
    }

    @FXML
    void falToLeft(ActionEvent event) {
        try {
            if (this.falUnterrichtendeLehrerChoiceBox.getSelectionModel().getSelectedItem() != null) {
                FachClass fach = this.falUnterrichtendeLehrerChoiceBox.getSelectionModel().getSelectedItem();
                this.falUnterrichtendeLehrerChoiceBox.getItems().remove(fach);
                this.falAlleFaecherChoiceBox.getItems().add(fach);
            } else
                System.out.println("Nichts ausgewählt!");
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }

    @FXML
    void falToRight(ActionEvent event) {
        try {
            if (this.falAlleFaecherChoiceBox.getSelectionModel().getSelectedItem() != null) {
                FachClass fach = this.falAlleFaecherChoiceBox.getSelectionModel().getSelectedItem();
                this.falUnterrichtendeLehrerChoiceBox.getItems().add(fach);
                this.falAlleFaecherChoiceBox.getItems().remove(fach);
            } else
                System.out.println("Nichts ausgewählt!");
        } catch (Exception e) {
            System.out.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }
}