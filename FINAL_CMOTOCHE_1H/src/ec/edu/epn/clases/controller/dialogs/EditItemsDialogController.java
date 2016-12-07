/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller.dialogs;

import ec.edu.epn.clases.Main;
import ec.edu.epn.clases.controller.DialogController;
import ec.edu.epn.pojos.Persona;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author camm
 */
public class EditItemsDialogController
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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columnEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf((int) cellData.getValue().getEdad())));
        columnFecha.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getFechaNacimiento())));
        columnSalario.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSueldo())));
        columnEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
    }

    @FXML
    private void handleEdit() {
        Persona selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            showPersonEditDialog(selectedPerson);
            personTable.refresh();
        } else {
            // Nothing selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    public Optional<Persona> showPersonEditDialog(Persona person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/dialogs/EditItemDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            EditItemDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
        controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return Optional.ofNullable(controller.getPerson());
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
