/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.programacion.pojos;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class UsuarioSistema
    extends Persona {

    private String login;
    private String password;

    public UsuarioSistema() {
    }

    public UsuarioSistema(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

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
