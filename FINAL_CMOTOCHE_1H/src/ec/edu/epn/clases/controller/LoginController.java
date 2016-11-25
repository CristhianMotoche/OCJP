/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ec.edu.epn.clases.Main;
import ec.edu.epn.pojos.Usuario;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author camm
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField passPassword;

    // Reference to the main Window.
    private Main main;

    public LoginController() {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handleLogin(){
        Usuario user = new Usuario(txtUserName.getText(), passPassword.getText(), null);
        if (Main.users.contains(user)) {
            handleMainMenuController();
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("The user is not registered.");
            alert.setContentText("Please make sure you are registered in the system.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewUser(){
        handleNewUserController();
    }

    private void handleNewUserController(){
        try {
            // Load new user view.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/NewUser.fxml"));
            AnchorPane newUserView = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            main.getRootLayout().setCenter(newUserView);

            // Give the controller access to the main app.
            NewUserController controller = loader.getController();
            controller.setMain(this.main);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleMainMenuController(){
        try {
            // Load new user view.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainMenu.fxml"));
            AnchorPane newUserView = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            main.getRootLayout().setCenter(newUserView);
            main.getPrimaryStage().setWidth(400);
            main.getPrimaryStage().setHeight(380);

            // Give the controller access to the main app.
            MainMenuController controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
