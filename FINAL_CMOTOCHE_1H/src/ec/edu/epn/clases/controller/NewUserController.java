/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller;

import ec.edu.epn.clases.Main;
import ec.edu.epn.pojos.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author camm
 */
public class NewUserController
        extends Controller
        implements Initializable {

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    private void handleAcept(){
        Usuario user = new Usuario(txtUserName.getText(), txtPassword.getText(), null);
        Main.users.add(user);
        handleLoginController();
    }

    @FXML
    private void handleCancel(){
        handleLoginController();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    private void handleLoginController(){
        routeToController("view/Login.fxml", new LoginController());
    }
}
