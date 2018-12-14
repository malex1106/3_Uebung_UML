package com.uebung3.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AbteilungController {

    @FXML
    private TextField abtName;

    @FXML
    private TextField abtKuerzel;

    @FXML
    private Button abtLöschenButton;

    @FXML
    private Button abtBearbeitenButton;

    private boolean bearbeitenBool = false;

    @FXML
    void abtBearbeiten(ActionEvent event) {
        if(!bearbeitenBool) {
            this.abtBearbeitenButton.setText("Speichern");
            this.abtName.setEditable(true);
            this.abtKuerzel.setEditable(true);
            bearbeitenBool = true;
        } else {
            this.abtBearbeitenButton.setText("Mehr Infos");
            this.abtName.setEditable(false);
            this.abtKuerzel.setEditable(false);
            bearbeitenBool = false;
        }
    }

}
