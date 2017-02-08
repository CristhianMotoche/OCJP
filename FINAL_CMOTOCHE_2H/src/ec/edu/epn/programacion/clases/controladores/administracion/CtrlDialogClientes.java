/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package ec.edu.epn.programacion.clases.controladores.administracion;

import ec.edu.epn.programacion.clases.controladores.cliente.CtrlNuevoCliente;
import ec.edu.epn.programacion.clases.controladores.cliente.CtrlOpcionesCliente;
import ec.edu.epn.programacion.clases.gui.DialogOpciones;
import ec.edu.epn.programacion.clases.gui.cliente.DialogCrearCliente;
import ec.edu.epn.programacion.clases.gui.cliente.DialogOpcionesCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Javier Utreras
 */
public class CtrlDialogClientes
        implements ActionListener {
    private DialogOpciones dialogOpciones;

    /**
     *
     * @param dialogOpciones
     */
    public CtrlDialogClientes(DialogOpciones dialogOpciones) {
        this.dialogOpciones = dialogOpciones;

        this.dialogOpciones.getLblPOJO().setText("Clientes");
        this.dialogOpciones.getBtnNuevo().addActionListener(this);
        this.dialogOpciones.getBtnEditar().addActionListener(this);
        this.dialogOpciones.getBtnEliminar().addActionListener(this);
        this.dialogOpciones.getBtnListar().addActionListener(this);
        this.dialogOpciones.getBtnBuscar().addActionListener(this);
        this.dialogOpciones.getBtnRegresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogOpciones.getBtnNuevo()) {
            DialogCrearCliente dialogCrearCliente =
                    new DialogCrearCliente(this.dialogOpciones, true);
            CtrlNuevoCliente ctrlNuevoCliente =
                    new CtrlNuevoCliente(dialogCrearCliente);
            ctrlNuevoCliente.start();
        }
        if (e.getSource() == this.dialogOpciones.getBtnEditar()) {
            DialogOpcionesCliente dialogOpcionesCliente =
                    new DialogOpcionesCliente(dialogOpciones, true);
            CtrlOpcionesCliente ctrlOpcionesCliente =
                    new CtrlOpcionesCliente(dialogOpcionesCliente, false, true);
            ctrlOpcionesCliente.start();
        }
        if (e.getSource() == this.dialogOpciones.getBtnEliminar()) {
            DialogOpcionesCliente dialogOpcionesCliente =
                    new DialogOpcionesCliente(dialogOpciones, true);
            CtrlOpcionesCliente ctrlOpcionesCliente =
                    new CtrlOpcionesCliente(dialogOpcionesCliente, true, false);
            ctrlOpcionesCliente.start();
        }
        if (e.getSource() == this.dialogOpciones.getBtnListar()) {
            DialogOpcionesCliente dialogOpcionesCliente =
                    new DialogOpcionesCliente(dialogOpciones, true);
            CtrlOpcionesCliente ctrlOpcionesCliente =
                    new CtrlOpcionesCliente(dialogOpcionesCliente, false, false);
            ctrlOpcionesCliente.start();
        }
        if (e.getSource() == this.dialogOpciones.getBtnBuscar()) {
            DialogOpcionesCliente dialogOpcionesCliente =
                    new DialogOpcionesCliente(this.dialogOpciones, true);
            CtrlOpcionesCliente ctrlOpcionesCliente =
                    new CtrlOpcionesCliente(dialogOpcionesCliente, false, false);
            ctrlOpcionesCliente.start();
        }
        if (e.getSource() == this.dialogOpciones.getBtnRegresar()) {
            this.dialogOpciones.dispose();
        }
    }

    /**
     *
     */
    public void start() {
        this.dialogOpciones.setLocationRelativeTo(null);
        this.dialogOpciones.setVisible(true);
    }
}
