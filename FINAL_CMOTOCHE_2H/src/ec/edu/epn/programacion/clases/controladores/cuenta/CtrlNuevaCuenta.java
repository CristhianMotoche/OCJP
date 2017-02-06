package ec.edu.epn.programacion.clases.controladores.cuenta;

import ec.edu.epn.programacion.clases.controladores.cliente.CtrlNuevoCliente;
import ec.edu.epn.programacion.clases.gui.cliente.DialogCrearCliente;
import ec.edu.epn.programacion.clases.gui.cuenta.DialogCrearCuenta;
import ec.edu.epn.programacion.excepciones.modelos.ModeloCliente;
import ec.edu.epn.programacion.pojos.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlNuevaCuenta
    implements ActionListener {
    private DialogCrearCuenta crearCuenta;

    public CtrlNuevaCuenta(DialogCrearCuenta crearCuenta) {
        this.crearCuenta = crearCuenta;
        
        this.crearCuenta.getBtnAceptar().addActionListener(this);
        this.crearCuenta.getBtnCancelar().addActionListener(this);
        this.crearCuenta.getBtnCrearCliente().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.crearCuenta.getBtnAceptar()) {

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

    public void start(){
        updateCmb();
        this.crearCuenta.setLocationRelativeTo(null);
        this.crearCuenta.setVisible(true);
    }

    private void updateCmb() {
        ModeloCliente modeloCliente = new ModeloCliente();
        List<String> nombres = new  ArrayList<>();
        List<Cliente> clientes = modeloCliente.listar();
        for (Cliente client : clientes) {
            nombres.add(client.getNombre());
        }
        this.crearCuenta.setCmbClientes(nombres);
    }
}
