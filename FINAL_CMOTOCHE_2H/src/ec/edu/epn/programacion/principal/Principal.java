package ec.edu.epn.programacion.principal;

import ec.edu.epn.programacion.clases.controladores.CtrlLogin;
import ec.edu.epn.programacion.clases.gui.FrmLogin;

/**
 *
 * @author Cristhian Motoche
 * 
 * Clase principal que ejecuta la aplicación
 */
public class Principal {
    public static void main(String args[]){
        FrmLogin frmLogin = new FrmLogin();
        CtrlLogin ctrlLogin = new CtrlLogin(frmLogin);
        ctrlLogin.start();
    }
}
