/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.principal;

import ec.edu.epn.clases.Main;
import ec.edu.epn.pojos.Usuario;
import java.util.ArrayList;

/**
 *
 * @author camm
 */
public class MainApp {
    public static void main(String[] args) {
        ArrayList<Usuario> users = new ArrayList<>();
        users.add(new Usuario("Cristhian", "Motoche"));
        Main.main(args, users);
    }
}
