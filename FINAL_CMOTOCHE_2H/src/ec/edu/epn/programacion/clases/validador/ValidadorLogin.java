package ec.edu.epn.programacion.clases.validador;

import ec.edu.epn.programacion.pojos.UsuarioSistema;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class ValidadorLogin {

    /**
     *
     * @param obj
     * @return
     */
    public String validar(Object obj){
        UsuarioSistema user = (UsuarioSistema) obj;
        if (user == null) {
            return "\nEl usuario o contaseña no son válidos.";
        } else {
            return "";
        }
    }
}
