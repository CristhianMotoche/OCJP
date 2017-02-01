/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.programacion.clases.controladores;

import ec.edu.epn.programacion.clases.gui.DialogAdministracion;
import ec.edu.epn.programacion.clases.gui.FrmMenuPrincipal;
import ec.edu.epn.programacion.pojos.UsuarioSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlMenuPrincipal
    implements ActionListener {
    private FrmMenuPrincipal frmMenuPrincipal;
    private UsuarioSistema user;

    public CtrlMenuPrincipal(FrmMenuPrincipal frmMenuPrincipal, UsuarioSistema user) {
        this.frmMenuPrincipal = frmMenuPrincipal;
        this.user = user;
    }

    public void start(){
        this.frmMenuPrincipal.setVisible(true);
        this.frmMenuPrincipal.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.frmMenuPrincipal.getBtnAdministracion()){
            DialogAdministracion dlgAdministracion
                    = new DialogAdministracion(this.frmMenuPrincipal, true);
            CtrlDialogAdministracion ctrlDialogAdministracion
                    = new CtrlDialogAdministracion(dlgAdministracion);
            ctrlDialogAdministracion.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getBtnTransacciones()) {

        }
        if(e.getSource() == this.frmMenuPrincipal.getBtnSalir()){
            System.exit(0);
        }
    }
}