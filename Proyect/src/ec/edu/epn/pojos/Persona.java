/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.pojos;

import java.util.Date;

/**
 *
 * @author Cristhian Motoche
 */
public class Persona {
    private int id;
    private String nombre;
    private byte edad;
    private Date fechaNacimiento;
    private Double sueldo;
    private String email;
    private static char PAIS = 'E';

    public Persona() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public String getEmail() {
        return email;
    }
}
