/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller.dialogs;

import ec.edu.epn.clases.controller.DialogController;
import ec.edu.epn.pojos.Persona;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author camm
 */
public class EditItemDialogController
        extends DialogController
        implements Initializable {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEdad;

    @FXML
    private DatePicker dateDate;

    @FXML
    private TextField txtSueldo;

    @FXML
    private TextField txtEmail;

    private Stage dialogStage;

    private Persona person;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handleAcept() {
        this.person.setNombre(txtNombre.getText());
        this.person.setEdad(Byte.parseByte(txtEdad.getText()));
        this.person.setSueldo(Double.parseDouble(txtSueldo.getText()));
        Date date = Date.from(dateDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.person.setFechaNacimiento(date);
        this.person.setEmail(txtEmail.getText());

        dialogStage.close();
    }

    public void setPerson(Persona person) {
        this.person = person;

        txtNombre.setText(person.getNombre());
        txtEdad.setText(String.valueOf(person.getEdad()));
        txtEmail.setText(person.getEmail());
        txtSueldo.setText(String.valueOf(person.getSueldo()));
    }

    void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public Persona getPerson() {
        return person;
    }
}
