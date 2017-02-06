/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.programacion.clases.controladores.administracion;

import ec.edu.epn.programacion.clases.gui.DialogAdministracion;
import ec.edu.epn.programacion.clases.gui.DialogOpciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlDialogAdministracion
    implements ActionListener {

    private DialogAdministracion dlgAdmin;

    public CtrlDialogAdministracion(DialogAdministracion dlgAdmin) {
        this.dlgAdmin = dlgAdmin;

        this.dlgAdmin.getBtnUsuarios().addActionListener(this);
        this.dlgAdmin.getBtnClientes().addActionListener(this);
        this.dlgAdmin.getBtnCuentas().addActionListener(this);
        this.dlgAdmin.getBtnRegresar().addActionListener(this);
    }

    public void start(){
        this.dlgAdmin.setLocationRelativeTo(this.dlgAdmin.getRootPane());
        this.dlgAdmin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dlgAdmin.getBtnUsuarios()) {
            DialogOpciones dialogOpcionesUsuario =
                    new DialogOpciones(this.dlgAdmin, true);
            CtrlDialogUsuarios ctrlDialogUsuarios =
                    new CtrlDialogUsuarios(dialogOpcionesUsuario);
            ctrlDialogUsuarios.start();
        }
        if(e.getSource() == this.dlgAdmin.getBtnClientes()){
            DialogOpciones dialogOpcionesCliente =
                    new DialogOpciones(this.dlgAdmin, true);
            CtrlDialogClientes ctrlDialogClientes =
                    new CtrlDialogClientes(dialogOpcionesCliente);
            ctrlDialogClientes.start();
        }
        if(e.getSource() == this.dlgAdmin.getBtnCuentas()){

        }
        if (e.getSource() == this.dlgAdmin.getBtnRegresar()) {
            this.dlgAdmin.dispose();
        }
    }
}
