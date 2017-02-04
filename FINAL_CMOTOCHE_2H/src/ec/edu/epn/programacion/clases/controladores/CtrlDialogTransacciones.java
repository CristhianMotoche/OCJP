/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.epn.programacion.clases.controladores;

import ec.edu.epn.programacion.clases.gui.DialogTransacciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlDialogTransacciones
    implements ActionListener {

    private DialogTransacciones dialogTransacciones;

    public CtrlDialogTransacciones(DialogTransacciones dialogTransacciones) {
        this.dialogTransacciones = dialogTransacciones;

        this.dialogTransacciones.getBtnDeposito().addActionListener(this);
        this.dialogTransacciones.getBtnRetiro().addActionListener(this);
        this.dialogTransacciones.getBtnSalir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogTransacciones.getBtnDeposito()) {

        }
        if (e.getSource() == this.dialogTransacciones.getBtnRetiro()) {

        }
        if (e.getSource() == this.dialogTransacciones.getBtnSalir()) {

        }
    }
}
