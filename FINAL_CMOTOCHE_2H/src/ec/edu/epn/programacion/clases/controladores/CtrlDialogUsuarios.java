package ec.edu.epn.programacion.clases.controladores;

import ec.edu.epn.programacion.clases.controladores.usuario.CtrlNuevoUsuario;
import ec.edu.epn.programacion.clases.controladores.usuario.CtrlOpcionesUsuario;
import ec.edu.epn.programacion.clases.gui.DialogOpciones;
import ec.edu.epn.programacion.clases.gui.usuario.DialogCrearUsuario;
import ec.edu.epn.programacion.clases.gui.usuario.DialogOpcionesUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlDialogUsuarios
    implements ActionListener {
    private DialogOpciones dialogOpciones;

    public CtrlDialogUsuarios(DialogOpciones dialogOpciones) {
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
            DialogCrearUsuario dialogCrearUsuario =
                    new DialogCrearUsuario(this.dialogOpciones, true);
            CtrlNuevoUsuario ctrlNuevoUsuario =
                    new CtrlNuevoUsuario(dialogCrearUsuario);
            ctrlNuevoUsuario.start();
        }
        if (e.getSource() == this.dialogOpciones.getBtnEditar()) {
            DialogOpcionesUsuario dialogOpcionesUsuario =
                    new DialogOpcionesUsuario(this.dialogOpciones, true);
            CtrlOpcionesUsuario ctrlOpcionesUsuario =
                    new CtrlOpcionesUsuario(dialogOpcionesUsuario, false, true);
            ctrlOpcionesUsuario.start();
        }
        if (e.getSource() == this.dialogOpciones.getBtnEliminar()) {
            DialogOpcionesUsuario dialogOpcionesUsuario =
                    new DialogOpcionesUsuario(this.dialogOpciones, true);
            CtrlOpcionesUsuario ctrlOpcionesUsuario =
                    new CtrlOpcionesUsuario(dialogOpcionesUsuario, true, false);
            ctrlOpcionesUsuario.start();
        }
        if (e.getSource() == this.dialogOpciones.getBtnListar()) {
            DialogOpcionesUsuario dialogOpcionesUsuario =
                    new DialogOpcionesUsuario(this.dialogOpciones, true);
            CtrlOpcionesUsuario ctrlOpcionesUsuario =
                    new CtrlOpcionesUsuario(dialogOpcionesUsuario, false, false);
            ctrlOpcionesUsuario.start();
        }
        if (e.getSource() == this.dialogOpciones.getBtnBuscar()) {

        }
        if (e.getSource() == this.dialogOpciones.getBtnRegresar()) {
            this.dialogOpciones.dispose();
        }
    }

    public void start() {
        this.dialogOpciones.setLocationRelativeTo(null);
        this.dialogOpciones.setVisible(true);
    }
}
