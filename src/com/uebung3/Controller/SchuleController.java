package com.uebung3.Controller;

import com.uebung3.Classes.SchuleClass;
import com.uebung3.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SchuleController {

    @FXML
    private TextField schulSchulname;

    @FXML
    private TextField schulSchulkennzahl;

    @FXML
    private TextField schulSchultyp;

    @FXML
    private Button schulResetButton;

    @FXML
    private Button schulErzeugenButton;

    @FXML
    private Label schuleError;

    private static SchuleClass schule;

    @FXML
    private void schuleErzeugen(ActionEvent event) {
        if(this.schulSchulname.getText().isEmpty() || this.schulSchulkennzahl.getText().isEmpty() || this.schulSchultyp.getText().isEmpty() || !this.schulSchulkennzahl.getText().matches("^[0-9]*$")) this.schuleError.setVisible(true);
        else {
            try {
                schule = new SchuleClass(this.schulSchulname.getText(), Long.parseLong(this.schulSchulkennzahl.getText()), this.schulSchultyp.getText());
                new Main().start(new Stage());
                Stage stage = (Stage) schulSchulname.getScene().getWindow();
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void schulReset(ActionEvent event) {
        this.schulSchulname.setText("");
        this.schulSchulkennzahl.setText("");
        this.schulSchultyp.setText("");
    }

    public static SchuleClass getSchule() {
        return schule;
    }
}
