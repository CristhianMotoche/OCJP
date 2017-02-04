package ec.edu.epn.programacion.clases.validador;

import ec.edu.epn.programacion.interfaces.Validador;
import ec.edu.epn.programacion.pojos.UsuarioSistema;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class ValidadorUsuario
    implements Validador {

    @Override
    public String validar(Object obj) {
        UsuarioSistema user = (UsuarioSistema) obj;
        String messages = "";
        if (user.getLogin().isEmpty()) {
            messages += "\nEl nombre de usuario no puede estar vacio";
        }
        return messages;
    }
}
