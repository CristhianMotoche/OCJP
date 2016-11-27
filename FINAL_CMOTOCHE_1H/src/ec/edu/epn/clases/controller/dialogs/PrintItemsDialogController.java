/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller.dialogs;

import ec.edu.epn.pojos.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author camm
 */
public class PrintItemsDialogController implements Initializable {
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columnEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf((int) cellData.getValue().getEdad())));
        columnFecha.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getFechaNacimiento())));
        columnSalario.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSueldo())));
        columnEmail.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getEmail())));
    }

    public void setPersonTableItems(ObservableList<Persona> peopleData) {
        this.personTable.setItems(peopleData);
    }
}
