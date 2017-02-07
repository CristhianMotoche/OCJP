/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package ec.edu.epn.programacion.clases.controladores;

import ec.edu.epn.programacion.clases.gui.DialogTransaccion;
import ec.edu.epn.programacion.clases.gui.DialogTransacciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlMenuTransacciones
        implements ActionListener {

    private DialogTransacciones dialogTransacciones;

    /**
     *
     * @param dialogTransacciones
     */
    public CtrlMenuTransacciones(DialogTransacciones dialogTransacciones) {
        this.dialogTransacciones = dialogTransacciones;

        this.dialogTransacciones.getBtnDeposito().addActionListener(this);
        this.dialogTransacciones.getBtnRetiro().addActionListener(this);
        this.dialogTransacciones.getBtnSalir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogTransacciones.getBtnDeposito()) {
            DialogTransaccion dialogTransaccion =
                    new DialogTransaccion(dialogTransacciones, true);
            CtrlTransaccion ctrlTransaccion =
                    new CtrlTransaccion(dialogTransaccion, "deposito");
            ctrlTransaccion.start();
        }
        if (e.getSource() == this.dialogTransacciones.getBtnRetiro()) {
            DialogTransaccion dialogTransaccion =
                    new DialogTransaccion(dialogTransacciones, true);
            CtrlTransaccion ctrlTransaccion =
                    new CtrlTransaccion(dialogTransaccion, "retiro");
            ctrlTransaccion.start();
        }
        if (e.getSource() == this.dialogTransacciones.getBtnSalir()) {
            this.dialogTransacciones.dispose();
        }
    }

    /**
     * Permite iniciar la visualización de la ventana
     */
    public void start() {
        this.dialogTransacciones.setLocationRelativeTo(null);
        this.dialogTransacciones.setVisible(true);
    }
}
