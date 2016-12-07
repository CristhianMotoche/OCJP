/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller.dialogs;

import ec.edu.epn.clases.controller.DialogController;
import ec.edu.epn.clases.utils.Utils;
import ec.edu.epn.pojos.Persona;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author camm
 */
public class DeleteItemsDialogController
        extends DialogController
        implements Initializable {

    @FXML
    private TableView<Persona> personTable;
    @FXML
    private TableColumn<Persona, String> columnNombre;
    @FXML
    private TableColumn<Persona, String> columnEdad;
    @FXML
    private TableColumn<Persona, String> columnFecha;
    @FXML
    private TableColumn<Persona, String> columnSalario;
    @FXML
    private TableColumn<Persona, String> columnEmail;

    private Stage dialogStage;

    private ArrayList<Persona> people;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnNombre.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columnEdad.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf((int) cellData.getValue().getEdad())));
        columnFecha.setCellValueFactory(cellData
                -> new SimpleStringProperty(Utils.formatDate(cellData.getValue().getFechaNacimiento())));
        columnSalario.setCellValueFactory(cellData
                -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSueldo())));
        columnEmail.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getEmail()));
    }

    @FXML
    private void handleDeletePerson() {
        Persona selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
            personTable.getItems().remove(selectedIndex);
            people.remove(selectedIndex);
        } else {
            // Nothing selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }

    public ArrayList<Persona> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Persona> people) {
        this.people = people;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
