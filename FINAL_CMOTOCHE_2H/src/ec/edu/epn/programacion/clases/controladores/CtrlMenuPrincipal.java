/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.programacion.clases.controladores;

import ec.edu.epn.programacion.clases.controladores.administracion.CtrlDialogClientes;
import ec.edu.epn.programacion.clases.controladores.administracion.CtrlDialogUsuarios;
import ec.edu.epn.programacion.clases.controladores.cuenta.CtrlOpcionesCuenta;
import ec.edu.epn.programacion.clases.gui.DialogOpciones;
import ec.edu.epn.programacion.clases.gui.DialogTransaccion;
import ec.edu.epn.programacion.clases.gui.FormPrincipal;
import ec.edu.epn.programacion.clases.gui.cuenta.DialogOpcionesCuenta;
import ec.edu.epn.programacion.pojos.UsuarioSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Javier Utreras
 */
public class CtrlMenuPrincipal
    implements ActionListener {
    private FormPrincipal frmPrincipal;
    private UsuarioSistema user;

    /**
     *
     * @param frmMenuPrincipal
     * @param user
     */
    public CtrlMenuPrincipal(FormPrincipal frmMenuPrincipal, UsuarioSistema user) {
        this.frmPrincipal = frmMenuPrincipal;
        this.user = user;

        this.frmPrincipal.getBtnClientes().addActionListener(this);
        this.frmPrincipal.getBtnCuentas().addActionListener(this);
        this.frmPrincipal.getBtnDeposito().addActionListener(this);
        this.frmPrincipal.getBtnRetiro().addActionListener(this);
        this.frmPrincipal.getBtnUsuarios().addActionListener(this);
    }

    /**
     * Permite iniciar la visualización de la ventana
     */
    public void start(){
        this.frmPrincipal.setVisible(true);
        this.frmPrincipal.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmPrincipal.getBtnUsuarios()) {
            DialogOpciones dialogOpcionesUsuario = new DialogOpciones(this.frmPrincipal, true);
            CtrlDialogUsuarios ctrlDialogUsuarios = new CtrlDialogUsuarios(dialogOpcionesUsuario);
            ctrlDialogUsuarios.start();
        }
        if(e.getSource() == this.frmPrincipal.getBtnClientes()){
            DialogOpciones dialogOpcionesCliente = new DialogOpciones(this.frmPrincipal, true);
            CtrlDialogClientes ctrlDialogClientes = new CtrlDialogClientes(dialogOpcionesCliente);
            ctrlDialogClientes.start();
        }
        if(e.getSource() == this.frmPrincipal.getBtnCuentas()){
            DialogOpcionesCuenta dialogOpcionesCuenta = new DialogOpcionesCuenta(this.frmPrincipal, true);
            CtrlOpcionesCuenta ctrlOpcionesCuenta = new CtrlOpcionesCuenta(dialogOpcionesCuenta);
            ctrlOpcionesCuenta.start();
        }
        if (e.getSource() == this.frmPrincipal.getBtnDeposito()) {
            DialogTransaccion dialogTransaccion = new DialogTransaccion(frmPrincipal, true);
            CtrlTransaccion ctrlTransaccion = new CtrlTransaccion(dialogTransaccion, "deposito");
            ctrlTransaccion.start();
        }
        if (e.getSource() == this.frmPrincipal.getBtnRetiro()) {
            DialogTransaccion dialogTransaccion = new DialogTransaccion(frmPrincipal, true);
            CtrlTransaccion ctrlTransaccion = new CtrlTransaccion(dialogTransaccion, "retiro");
            ctrlTransaccion.start();
        }
    }
}
