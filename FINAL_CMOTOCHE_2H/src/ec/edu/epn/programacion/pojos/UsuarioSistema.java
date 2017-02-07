/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.programacion.pojos;

import java.util.Date;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class UsuarioSistema
    extends Persona {

    private String login;
    private String password;

    /**
     *
     */
    public UsuarioSistema() {
    }

    /**
     *
     * @param login
     * @param password
     * @param nombre
     * @param edad
     * @param fechaNacimiento
     * @param email
     */
    public UsuarioSistema(String login, String password, String nombre, byte edad, Date fechaNacimiento, String email) {
        super(nombre, edad, fechaNacimiento, email);
        this.login = login;
        this.password = password;
    }

    /**
     *
     * @param login
     * @param password
     */
    public UsuarioSistema(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        UsuarioSistema user = (UsuarioSistema) obj;
        return this.login.equals(user.login)
                && this.password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
