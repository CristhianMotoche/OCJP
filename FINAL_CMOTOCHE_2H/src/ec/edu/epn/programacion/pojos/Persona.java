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
    public static char PAIS = 'E';
    private static int count = 0;

    public Persona() {
        setId();
    }

    public Persona(String nombre, byte edad, Date fechaNacimiento, String email) {
        setId();
        this.nombre = nombre;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public final void setId() {
        this.id = Persona.count++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
