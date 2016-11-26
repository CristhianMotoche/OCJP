/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller;

import ec.edu.epn.clases.Main;
import ec.edu.epn.clases.controller.dialogs.AddItemDialogController;
import ec.edu.epn.pojos.Persona;
import ec.edu.epn.pojos.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author camm
 */
public class MainMenuController
        extends Controller
        implements Initializable {

    private Main main;

    public MainMenuController() {
    }

    public MainMenuController(Usuario user) {
        this.user = user;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    @FXML
    private void handleAddItem() {
        Optional<Persona> newPersona = showPersonEditDialog();
        newPersona.ifPresent(p -> { this.user.getPersonas().add(p); });
        this.user.getPersonas().forEach(p -> { System.out.println(p); });
    }

    public Optional<Persona> showPersonEditDialog() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/dialogs/AddItemDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AddItemDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();
            return Optional.of(controller.getPersona());
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    @FXML
    private void handleEditItem() {

    }

    @FXML
    private void handleRemoveItem() {

    }

    @FXML
    private void handleSearchItem() {

    }

    @FXML
    private void handlePrintItems() {

    }

    @FXML
    private void handleExit() {

    }
}
