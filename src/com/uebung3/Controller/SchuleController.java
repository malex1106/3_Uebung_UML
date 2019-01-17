package com.uebung3.Controller;

import com.uebung3.Classes.SchuleClass;
import com.uebung3.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SchuleController implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.schulSchulname.setText("HTL");
        this.schulSchulkennzahl.setText("1234");
        this.schulSchultyp.setText("BS");
    }

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
