/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.pojos;

import java.util.ArrayList;

/**
 *
 * @author Cristhian Motoche
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private ArrayList<Persona> personas;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, ArrayList<Persona> personas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.personas = personas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
}
