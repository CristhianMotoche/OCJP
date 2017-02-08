package ec.edu.epn.programacion.pojos;

import java.util.Date;

/**
 * POJO Cliente
 * @author Javier Utreras
 */
public class Cliente
    extends Persona {

    // Atributos de la clase
    private String celular;
    private double sueldo;

    /**
     * Constructor sin parámetros
     */
    public Cliente() {
        super.setId();
    }

    /**
     * Constructor
     * @param nombre Nombre del cliente
     */
    public Cliente(String nombre){
        this.setNombre(nombre);
    }

    /**
     * Constructor con todos los parámetros para crear un cliente
     * @param celular
     * @param sueldo
     * @param nombre Nombre del cliente
     * @param edad
     * @param fechaNacimiento
     * @param email
     */
    public Cliente(String celular, double sueldo, String nombre, byte edad, Date fechaNacimiento, String email) {
        super(nombre, edad, fechaNacimiento, email);
        this.celular = celular;
        this.sueldo = sueldo;
    }

    /**
     * get celular
     * @return Celular del usuario
     */
    public String getCelular() {
        return celular;
    }

    /**
     * set celular
     * @param celular
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * get celular
     * @return Celular del usuario
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     *
     * @param sueldo
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object obj) {
        Cliente cliente = (Cliente) obj;
        return cliente.getNombre().equals(this.getNombre());
    }
}
