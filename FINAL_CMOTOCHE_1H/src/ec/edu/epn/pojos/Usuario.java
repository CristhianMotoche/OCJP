/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.pojos;

import java.util.Date;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Cristhian Motoche
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private ArrayList<Persona> personas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.personas.add(new Persona("Juan", (byte) 25, new Date("1994/10/10"), 323.23, "jc@gmail.ec"));
        this.personas.add(new Persona("José", (byte) 22, new Date("1991/12/4"), 223.23, "jj@hotmail.ec"));
        this.personas.add(new Persona("Laura", (byte) 24, new Date("1992/1/4"), 433.23, "lj@epn.edu.ec"));
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

    @Override
    public boolean equals(Object usr_) {
        Usuario usr = (Usuario) usr_;
        return this.nombre.equals(usr.nombre)
                && this.apellido.equals(usr.apellido);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.nombre);
        hash = 43 * hash + Objects.hashCode(this.apellido);
        return hash;
    }
}
