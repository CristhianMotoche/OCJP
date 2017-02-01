/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.programacion.clases.controladores;

import ec.edu.epn.programacion.clases.gui.DialogAdministracion;
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
    }
    
     public void start(){
         this.dlgAdmin.setVisible(true);
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dlgAdmin.getBtnClientes()) {
            
        }
        if(e.getSource() == this.dlgAdmin.getBtnUsuarios()){
            
        }
        if(e.getSource() == this.dlgAdmin.getBtnCuentas()){
            
        }
        if (e.getSource() == this.dlgAdmin.getBtnRegresar()) {
            this.dlgAdmin.dispose();
        }
    }   
}
