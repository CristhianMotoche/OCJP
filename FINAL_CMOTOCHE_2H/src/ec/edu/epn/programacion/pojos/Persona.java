package ec.edu.epn.programacion.pojos;

import java.util.Date;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class Persona {
    private int id;
    private String nombre;
    private byte edad;
    private Date fechaNacimiento;
    private String email;

    /**
     *
     */
    public static char PAIS = 'E';
    private static int count = 0;

    /**
     *
     */
    public Persona() {
        setId();
    }

    /**
     *
     * @param nombre
     * @param edad
     * @param fechaNacimiento
     * @param email
     */
    public Persona(String nombre, byte edad, Date fechaNacimiento, String email) {
        setId();
        this.nombre = nombre;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    /**
     *
     */
    public final void setId() {
        this.id = Persona.count++;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public byte getEdad() {
        return edad;
    }

    /**
     *
     * @param edad
     */
    public void setEdad(byte edad) {
        this.edad = edad;
    }

    /**
     *
     * @return
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }
}
