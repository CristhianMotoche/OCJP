package ec.edu.epn.programacion.clases.validador;

import ec.edu.epn.programacion.pojos.UsuarioSistema;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class ValidadorLogin {
    public boolean validar(UsuarioSistema user){
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }
}
