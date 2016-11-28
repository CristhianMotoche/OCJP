/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller.dialogs;

import ec.edu.epn.clases.controller.DialogController;
import ec.edu.epn.pojos.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author camm
 */
public class SearchItemsDialogController
        extends DialogController
        implements Initializable {

    @FXML
    private TextField filterField;
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
        // Initialize the columns
        columnNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columnEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf((int) cellData.getValue().getEdad())));
        columnFecha.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getFechaNacimiento())));
        columnSalario.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSueldo())));
        columnEmail.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getEmail())));
    }

    @FXML
    private void handleKeyreleased() {
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Persona> filteredData = new FilteredList<>(this.personTable.getItems(), p -> true);

        // Set the filter Predicate whenever the filter changes.
        this.filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (person.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Persona> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(personTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        personTable.setItems(sortedData);
    }
}
