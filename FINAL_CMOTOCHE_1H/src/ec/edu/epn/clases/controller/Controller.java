/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller;

import ec.edu.epn.clases.Main;
import ec.edu.epn.pojos.Usuario;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

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
            e.printStackTrace();
        }
    }
}