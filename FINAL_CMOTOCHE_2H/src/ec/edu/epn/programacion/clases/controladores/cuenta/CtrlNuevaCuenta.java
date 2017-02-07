package ec.edu.epn.programacion.clases.controladores.cuenta;

import ec.edu.epn.programacion.clases.controladores.cliente.CtrlNuevoCliente;
import ec.edu.epn.programacion.clases.gui.cliente.DialogCrearCliente;
import ec.edu.epn.programacion.clases.gui.cuenta.DialogCrearCuenta;
import ec.edu.epn.programacion.excepciones.modelos.ModeloCliente;
import ec.edu.epn.programacion.excepciones.modelos.ModeloCuenta;
import ec.edu.epn.programacion.pojos.Cliente;
import ec.edu.epn.programacion.pojos.Cuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlNuevaCuenta
    implements ActionListener {
    private DialogCrearCuenta crearCuenta;
    private ModeloCuenta modeloCuenta;

    /**
     *
     * @param crearCuenta
     */
    public CtrlNuevaCuenta(DialogCrearCuenta crearCuenta) {
        this.crearCuenta = crearCuenta;
        this.modeloCuenta = new ModeloCuenta();

        this.crearCuenta.getBtnAceptar().addActionListener(this);
        this.crearCuenta.getBtnCancelar().addActionListener(this);
        this.crearCuenta.getBtnCrearCliente().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.crearCuenta.getBtnAceptar()) {
            String mensajesDeError = camposValidos();
            if (mensajesDeError.isEmpty()) {
                // Mapear cuenta
                Cuenta cuenta = new Cuenta();
                cuenta.setNombreCliente(this.crearCuenta.getCmbClientes());
                cuenta.setNumeroCta(this.crearCuenta.getTxtNumeroCuenta());
                double saldo = Double.parseDouble(this.crearCuenta.getTxtSaldoInicial());
                cuenta.setSaldoInicial(saldo);
                cuenta.setSaldoActual(saldo);

                // Crear cuenta
                String result = this.modeloCuenta.crear(cuenta);
                JOptionPane.showMessageDialog(crearCuenta, result);

                // Cerrar ventana
                this.crearCuenta.dispose();
            } else {
                JOptionPane
                        .showMessageDialog(this.crearCuenta
                        , mensajesDeError
                        , "Errores de usuario"
                        , JOptionPane.ERROR_MESSAGE
                        , null);
            }
        }
        if (e.getSource() == this.crearCuenta.getBtnCrearCliente()) {
            DialogCrearCliente dcc = new DialogCrearCliente(this.crearCuenta, true);
            CtrlNuevoCliente cnc = new CtrlNuevoCliente(dcc);
            cnc.start();
            updateCmb();
        }
        if (e.getSource() == this.crearCuenta.getBtnCancelar()) {
            this.crearCuenta.dispose();
        }
    }

    /**
     * Permite iniciar la visualización de la ventana
     */
    public void start(){
        updateCmb();
        this.crearCuenta.setLocationRelativeTo(null);
        this.crearCuenta.setVisible(true);
    }

    /**
     * Recarga el combobox después del cambio
     */
    private void updateCmb() {
        ModeloCliente modeloCliente = new ModeloCliente();
        List<String> nombres = new  ArrayList<>();
        List<Cliente> clientes = modeloCliente.listar();
        clientes.forEach(client -> nombres.add(client.getNombre()));
        this.crearCuenta.setCmbClientes(nombres);
    }

    private String camposValidos(){
        String numeroCuenta = this.crearCuenta.getTxtNumeroCuenta();
        String messages = "";

        if (numeroCuenta.isEmpty()) {
            messages += "El número de cuenta no puede estar vacio.";
        }

        try {
            double x_ = Double.parseDouble(this.crearCuenta.getTxtSaldoInicial());
        } catch (NumberFormatException e) {
            messages += "El saldo inicial deber ser un decimal.";
        }

        return messages;
    }
}
