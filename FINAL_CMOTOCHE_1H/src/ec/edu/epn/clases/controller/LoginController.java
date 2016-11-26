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
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author camm
 */
public class LoginController
        extends Controller
        implements Initializable {

    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField passPassword;

    private Usuario user;

    public LoginController() {}

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    @FXML
    private void handleLogin(){
        this.user = new Usuario(txtUserName.getText(), passPassword.getText());
        if (Main.users.contains(user)) {
            routeToMainMenuController();
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
        routeToNewUserController();
    }

    private void routeToNewUserController(){
        routeToController("view/NewUser.fxml", new NewUserController(), null);
    }

    private void routeToMainMenuController(){
        this.main.getPrimaryStage().setWidth(400);
        this.main.getPrimaryStage().setHeight(400);
        MainMenuController controller = new MainMenuController();
        routeToController("view/MainMenu.fxml", controller, this.user);
    }
}
