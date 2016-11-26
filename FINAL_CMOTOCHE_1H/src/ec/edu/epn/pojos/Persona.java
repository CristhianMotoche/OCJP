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
    protected String nombre;
    protected byte edad;
    private Date fechaNacimiento;
    private Double sueldo;
    protected String email;
    public static char PAIS = 'E';

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

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
