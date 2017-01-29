package ec.edu.epn.programacion.pojos;

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

    public Cliente(String celular, double sueldo) {
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
}
