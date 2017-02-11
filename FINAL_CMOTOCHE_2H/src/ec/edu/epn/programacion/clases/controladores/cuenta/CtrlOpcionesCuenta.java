package ec.edu.epn.programacion.clases.controladores.cuenta;

import ec.edu.epn.programacion.clases.gui.cuenta.DialogCrearCuenta;
import ec.edu.epn.programacion.clases.gui.cuenta.DialogListaCuenta;
import ec.edu.epn.programacion.clases.gui.cuenta.DialogOpcionesCuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Javier Utreras
 */
public class CtrlOpcionesCuenta
        implements ActionListener {
    private DialogOpcionesCuenta dialogOpcionesCuenta;

    /**
     *
     * @param dialogOpcionesCuenta
     */
    public CtrlOpcionesCuenta(DialogOpcionesCuenta dialogOpcionesCuenta) {
        this.dialogOpcionesCuenta = dialogOpcionesCuenta;

        this.dialogOpcionesCuenta.getLblPOJO().setText("Cuentas");
        this.dialogOpcionesCuenta.getBtnNuevo().addActionListener(this);
        this.dialogOpcionesCuenta.getBtnListar().addActionListener(this);
        this.dialogOpcionesCuenta.getBtnBuscar().addActionListener(this);
        this.dialogOpcionesCuenta.getBtnRegresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogOpcionesCuenta.getBtnNuevo()) {
            DialogCrearCuenta dialogCrearCuenta =
                    new DialogCrearCuenta(this.dialogOpcionesCuenta, true);
            CtrlNuevaCuenta ctrlNuevaCuenta = new CtrlNuevaCuenta(dialogCrearCuenta);
            ctrlNuevaCuenta.start();
        }
        if (e.getSource() == this.dialogOpcionesCuenta.getBtnListar()) {
            DialogListaCuenta dialogListaCuenta =
                    new DialogListaCuenta(dialogOpcionesCuenta, true);
            CtrlListarCuentas ctrlListarCuentas =
                    new CtrlListarCuentas(dialogListaCuenta);
            ctrlListarCuentas.start();
        }
        if (e.getSource() == this.dialogOpcionesCuenta.getBtnBuscar()) {
            DialogListaCuenta dialogListaCuenta =
                    new DialogListaCuenta(dialogOpcionesCuenta, true);
            CtrlListarCuentas ctrlListarCuentas =
                    new CtrlListarCuentas(dialogListaCuenta);
            ctrlListarCuentas.start();
        }
        if (e.getSource() == this.dialogOpcionesCuenta.getBtnRegresar()) {
            this.dialogOpcionesCuenta.dispose();
        }
    }

    /**
     * Permite iniciar la visualización de la ventana
     */
    public void start() {
        this.dialogOpcionesCuenta.setLocationRelativeTo(null);
        this.dialogOpcionesCuenta.setVisible(true);
    }
}
