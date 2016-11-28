/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.clases.controller;

import ec.edu.epn.pojos.Persona;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

/**
 *
 * @author camm
 */
public class DialogController
        extends Controller {

    @FXML
    private TableView<Persona> personTable;

    public void setPersonTableItems(ObservableList<Persona> peopleData) {
        this.personTable.setItems(peopleData);
    }
}
