/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller;

import ec.edu.epn.clases.Main;
import ec.edu.epn.pojos.Usuario;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author camm
 */
public abstract class Controller {
    protected Main main;
    protected Usuario user;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void routeToController(String fxml, Controller controller, Usuario user){
        try {
            // Load new user view.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(fxml));
            AnchorPane view = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            this.main.getRootLayout().setCenter(view);

            // Give the controller access to the main app.
            controller = loader.getController();
            controller.setMain(this.main);
            controller.setUser(user);
        } catch (IOException e) {
        }
    }

    public void showTable(String title, String pathView, TableController dialogController, ObservableList peopleData) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(pathView));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle(title);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            dialogController = loader.getController();
            dialogController.setPersonTableItems(peopleData);
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.showAndWait();
        } catch (IOException e) {
        }
    }

    public boolean hasErrors(String errorMessage){
        if (errorMessage.length() == 0) {
            return false;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            return true;
        }
    }
}
