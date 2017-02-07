package ec.edu.epn.programacion.principal;

import ec.edu.epn.programacion.clases.controladores.CtrlLogin;
import ec.edu.epn.programacion.clases.gui.FrmLogin;

/**
 * Clase principal que ejecuta la aplicación
 * @author Cristhian Motoche
 */
public class Principal {

    /**
     *
     * @param args
     */
    public static void main(String args[]){
        FrmLogin frmLogin = new FrmLogin();
        CtrlLogin ctrlLogin = new CtrlLogin(frmLogin);
        ctrlLogin.start();
    }
}
