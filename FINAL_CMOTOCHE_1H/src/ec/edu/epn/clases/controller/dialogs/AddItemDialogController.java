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
import java.util.ResourceBundle;
import java.util.Date;
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
public class AddItemDialogController
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

    private Persona persona;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPersona(Persona persona){
        this.persona = persona;
    }

    public Persona getPersona() {
        return this.persona;
    }

    @FXML
    private void handleAcept(){
        this.persona = new Persona();
        this.persona.setNombre(txtNombre.getText());
        this.persona.setEdad(Byte.parseByte(txtEdad.getText()));
        this.persona.setSueldo(Double.parseDouble(txtSueldo.getText()));
        Date date = Date.from(dateDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.persona.setFechaNacimiento(date);
        this.persona.setEmail(txtEmail.getText());

        dialogStage.close();
    }
}
