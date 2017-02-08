package ec.edu.epn.programacion.clases.controladores;

import ec.edu.epn.programacion.clases.controladores.cliente.CtrlNuevoCliente;
import ec.edu.epn.programacion.clases.controladores.cliente.CtrlOpcionesCliente;
import ec.edu.epn.programacion.clases.controladores.cuenta.CtrlListarCuentas;
import ec.edu.epn.programacion.clases.controladores.cuenta.CtrlNuevaCuenta;
import ec.edu.epn.programacion.clases.controladores.usuario.CtrlNuevoUsuario;
import ec.edu.epn.programacion.clases.controladores.usuario.CtrlOpcionesUsuario;
import ec.edu.epn.programacion.clases.interfaz_grafica_usuario.DialogTransaccion;
import ec.edu.epn.programacion.clases.interfaz_grafica_usuario.FrmMenuPrincipal;
import ec.edu.epn.programacion.clases.interfaz_grafica_usuario.cliente.DialogCrearCliente;
import ec.edu.epn.programacion.clases.interfaz_grafica_usuario.cliente.DialogOpcionesCliente;
import ec.edu.epn.programacion.clases.interfaz_grafica_usuario.cuenta.DialogCrearCuenta;
import ec.edu.epn.programacion.clases.interfaz_grafica_usuario.cuenta.DialogListaCuenta;
import ec.edu.epn.programacion.clases.interfaz_grafica_usuario.usuario.DialogCrearUsuario;
import ec.edu.epn.programacion.clases.interfaz_grafica_usuario.usuario.DialogOpcionesUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlMenuPrincipal
        implements ActionListener {

    private FrmMenuPrincipal frmMenuPrincipal;

    public CtrlMenuPrincipal(FrmMenuPrincipal frmMenuPrincipal) {
        this.frmMenuPrincipal = frmMenuPrincipal;

        /* USUARIOS */
        this.frmMenuPrincipal.getMenuItemNuevoUsuario().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemEditarUsuario().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemEliminarUsuario().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemListarUsuario().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemBuscarUsuario().addActionListener(this);

        /* CLIENTES */
        this.frmMenuPrincipal.getMenuItemNuevoCliente().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemEditarCliente().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemEliminarCliente().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemListarClientes().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemBuscarClientes().addActionListener(this);

        /* CUENTAS */
        this.frmMenuPrincipal.getMenuItemNuevaCuenta().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemListarCuenta().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemBuscarCuenta().addActionListener(this);

        /* TRANSACCIONES */
        this.frmMenuPrincipal.getMenuItemDepositar().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemRetirar().addActionListener(this);

        /* SALIR */
        this.frmMenuPrincipal.getMenuSalir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* USUARIOS */
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemNuevoUsuario()) {
            DialogCrearUsuario dialogCrearUsuario =
                    new DialogCrearUsuario(this.frmMenuPrincipal, true);
            CtrlNuevoUsuario ctrlNuevoUsuario =
                    new CtrlNuevoUsuario(dialogCrearUsuario);
            ctrlNuevoUsuario.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemEditarUsuario()){
            DialogOpcionesUsuario dialogOpcionesUsuario =
                    new DialogOpcionesUsuario(this.frmMenuPrincipal, true);
            CtrlOpcionesUsuario ctrlOpcionesUsuario =
                    new CtrlOpcionesUsuario(dialogOpcionesUsuario, false, true);
            ctrlOpcionesUsuario.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemEliminarUsuario()) {
            DialogOpcionesUsuario dialogOpcionesUsuario =
                    new DialogOpcionesUsuario(this.frmMenuPrincipal, true);
            CtrlOpcionesUsuario ctrlOpcionesUsuario =
                    new CtrlOpcionesUsuario(dialogOpcionesUsuario, true, false);
            ctrlOpcionesUsuario.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemListarUsuario()) {
            DialogOpcionesUsuario dialogOpcionesUsuario =
                    new DialogOpcionesUsuario(this.frmMenuPrincipal, true);
            CtrlOpcionesUsuario ctrlOpcionesUsuario =
                    new CtrlOpcionesUsuario(dialogOpcionesUsuario, false, false);
            ctrlOpcionesUsuario.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemBuscarUsuario()) {
            DialogOpcionesUsuario dialogOpcionesUsuario =
                    new DialogOpcionesUsuario(this.frmMenuPrincipal, true);
            CtrlOpcionesUsuario ctrlOpcionesUsuario =
                    new CtrlOpcionesUsuario(dialogOpcionesUsuario, false, false);
            ctrlOpcionesUsuario.start();
        }

        /* USUARIOS */
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemNuevoCliente()) {
            DialogCrearCliente dialogCrearCliente =
                    new DialogCrearCliente(this.frmMenuPrincipal, true);
            CtrlNuevoCliente ctrlNuevoCliente =
                    new CtrlNuevoCliente(dialogCrearCliente);
            ctrlNuevoCliente.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemEditarCliente()){
            DialogOpcionesCliente dialogOpcionesCliente =
                    new DialogOpcionesCliente(frmMenuPrincipal, true);
            CtrlOpcionesCliente ctrlOpcionesCliente =
                    new CtrlOpcionesCliente(dialogOpcionesCliente, false, true);
            ctrlOpcionesCliente.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemEliminarCliente()) {
            DialogOpcionesCliente dialogOpcionesCliente =
                    new DialogOpcionesCliente(this.frmMenuPrincipal, true);
            CtrlOpcionesCliente ctrlOpcionesCliente =
                    new CtrlOpcionesCliente(dialogOpcionesCliente, true, false);
            ctrlOpcionesCliente.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemListarClientes()) {
            DialogOpcionesCliente dialogOpcionesCliente =
                    new DialogOpcionesCliente(this.frmMenuPrincipal, true);
            CtrlOpcionesCliente ctrlOpcionesCliente =
                    new CtrlOpcionesCliente(dialogOpcionesCliente, false, false);
            ctrlOpcionesCliente.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemBuscarClientes()) {
            DialogOpcionesCliente dialogOpcionesCliente =
                    new DialogOpcionesCliente(this.frmMenuPrincipal, true);
            CtrlOpcionesCliente ctrlOpcionesCliente =
                    new CtrlOpcionesCliente(dialogOpcionesCliente, false, false);
            ctrlOpcionesCliente.start();
        }

        /* CUENTAS */
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemNuevaCuenta()) {
            DialogCrearCuenta dialogCrearCuenta =
                    new DialogCrearCuenta(this.frmMenuPrincipal, true);
            CtrlNuevaCuenta ctrlNuevaCuenta = new CtrlNuevaCuenta(dialogCrearCuenta);
            ctrlNuevaCuenta.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemListarCuenta()) {
            DialogListaCuenta dialogListaCuenta =
                    new DialogListaCuenta(this.frmMenuPrincipal, true);
            CtrlListarCuentas ctrlListarCuentas =
                    new CtrlListarCuentas(dialogListaCuenta);
            ctrlListarCuentas.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemBuscarCuenta()) {
            DialogListaCuenta dialogListaCuenta =
                    new DialogListaCuenta(this.frmMenuPrincipal, true);
            CtrlListarCuentas ctrlListarCuentas =
                    new CtrlListarCuentas(dialogListaCuenta);
            ctrlListarCuentas.start();
        }

        /* TRANSACCIONES */
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemDepositar()) {
            DialogTransaccion dialogTransaccion =
                    new DialogTransaccion(this.frmMenuPrincipal, true);
            CtrlTransaccion ctrlTransaccion =
                    new CtrlTransaccion(dialogTransaccion, "deposito");
            ctrlTransaccion.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemRetirar()) {
            DialogTransaccion dialogTransaccion =
                    new DialogTransaccion(this.frmMenuPrincipal, true);
            CtrlTransaccion ctrlTransaccion =
                    new CtrlTransaccion(dialogTransaccion, "retiro");
            ctrlTransaccion.start();
        }
        /* SALIR */
        if (e.getSource() == this.frmMenuPrincipal.getMenuSalir()) {
            this.frmMenuPrincipal.dispose();
        }
    }

    void start() {
        this.frmMenuPrincipal.setLocationRelativeTo(null);
        this.frmMenuPrincipal.setVisible(true);
    }
}
