package ec.edu.epn.programacion.pojos;

import java.util.Date;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class Cliente
    extends Persona {

    private String celular;
    private double sueldo;

    public Cliente() {
        super.setId();
    }

    public Cliente(String nombre){
        this.setNombre(nombre);
    }

    public Cliente(String celular, double sueldo) {
        this.celular = celular;
        this.sueldo = sueldo;
    }

    public Cliente(String celular, double sueldo, String nombre, byte edad, Date fechaNacimiento, String email) {
        super(nombre, edad, fechaNacimiento, email);
        this.celular = celular;
        this.sueldo = sueldo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object obj) {
        Cliente cliente = (Cliente) obj;
        return cliente.getNombre().equals(this.getNombre());
    }
}
