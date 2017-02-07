package ec.edu.epn.programacion.clases.controladores.cliente;

import ec.edu.epn.programacion.clases.gui.cliente.DialogCrearCliente;
import ec.edu.epn.programacion.excepciones.modelos.ModeloCliente;
import ec.edu.epn.programacion.pojos.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlNuevoCliente
        implements ActionListener {

    private DialogCrearCliente dialogCrearCliente;
    private ModeloCliente modeloCliente;
    private boolean editar;

    /**
     *
     * @param dialogCrearCliente
     */
    public CtrlNuevoCliente(DialogCrearCliente dialogCrearCliente) {
        this.dialogCrearCliente = dialogCrearCliente;
        this.modeloCliente = new ModeloCliente();
        this.editar = false;

        this.dialogCrearCliente.getBtnAceptar().addActionListener(this);
        this.dialogCrearCliente.getBtnCancelar().addActionListener(this);
    }

    /**
     *
     * @param dialogCrearCliente
     * @param cliente
     */
    public CtrlNuevoCliente(DialogCrearCliente dialogCrearCliente, Cliente cliente) {
        this.dialogCrearCliente = dialogCrearCliente;
        this.modeloCliente = new ModeloCliente();
        this.editar = true;
        this.dialogCrearCliente.getTextFieldCliente().setEditable(false);

        this.dialogCrearCliente.setTxtNombre(cliente.getNombre());
        this.dialogCrearCliente.setTxtEdad(Byte.toString(cliente.getEdad()));
        this.dialogCrearCliente.setTxtEmail(cliente.getEmail());
        this.dialogCrearCliente.setDateFechaNac(cliente.getFechaNacimiento());
        this.dialogCrearCliente.setTxtCelular(cliente.getCelular());
        this.dialogCrearCliente.setTxtSueldo(Double.toString(cliente.getSueldo()));

        this.dialogCrearCliente.getBtnAceptar().addActionListener(this);
        this.dialogCrearCliente.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogCrearCliente.getBtnAceptar() && this.editar) {
            String mensajesDeError = camposValidos();
            if(mensajesDeError.isEmpty()){
                Cliente cliente = getDatosCliente();
                String result = this.modeloCliente.actualizar(cliente);
                JOptionPane.showMessageDialog(this.dialogCrearCliente, result);
                this.dialogCrearCliente.dispose();
            } else {
                JOptionPane.showMessageDialog(this.dialogCrearCliente
                        , mensajesDeError
                        , "Errores de usuario"
                        , JOptionPane.ERROR_MESSAGE
                        , null);
            }
        }
        if (e.getSource() == this.dialogCrearCliente.getBtnAceptar() && !this.editar) {
            String mensajesDeError = camposValidos();
            if(mensajesDeError.isEmpty()){
                Cliente cliente = getDatosCliente();
                String result = this.modeloCliente.crear(cliente);
                JOptionPane.showMessageDialog(this.dialogCrearCliente, result);
                this.dialogCrearCliente.dispose();
            } else {
                JOptionPane.showMessageDialog(this.dialogCrearCliente
                        , mensajesDeError
                        , "Errores de usuario"
                        , JOptionPane.ERROR_MESSAGE
                        , null);
            }
        }
        if (e.getSource() == this.dialogCrearCliente.getBtnCancelar()) {
            this.dialogCrearCliente.dispose();
        }
    }

    /*
    * String con los mensajes de error
    */
    private String camposValidos() {
        String messages = "";
        String nombre = this.dialogCrearCliente.getTxtNombre();
        String celular = this.dialogCrearCliente.getTxtCelular();

        if (nombre.isEmpty()) {
            messages += "\n*El nombre no puede estar vacio.";
        }
        if (celular.isEmpty()) {
            messages += "\n*El número de celular no puede estar vacio.";
        }

        double sueldo = 0;
        try {
            sueldo = new Double(this.dialogCrearCliente.getTxtSueldo());
        } catch (NumberFormatException e){
            messages += "\n*El sueldo debe ser un número decimal";
        }

        if (sueldo <= 0) {
            messages += "\n*El sueldo debe ser un decimal positivo";
        }

        byte edad = 0;
        try {
            edad = new Byte(this.dialogCrearCliente.getTxtEdad());
        } catch (NumberFormatException e){
            messages += "\n*La edad debe ser un número";
        }

        if (edad <= 0) {
            messages += "\n*La edad debe ser un número entero positivo";
        }

        return messages;
    }

    private Cliente getDatosCliente() {
        Cliente cliente = new Cliente();
        cliente.setId();
        cliente.setNombre(this.dialogCrearCliente.getTxtNombre());
        cliente.setEdad(new Byte(this.dialogCrearCliente.getTxtEdad()));
        cliente.setFechaNacimiento(this.dialogCrearCliente.getDateFechaNac());
        cliente.setEmail(this.dialogCrearCliente.getTxtEmail());
        cliente.setCelular(this.dialogCrearCliente.getTxtCelular());
        cliente.setSueldo(new Double(this.dialogCrearCliente.getTxtSueldo()));
        return cliente;
    }

    /**
     * Permite iniciar la visualización de la ventana
     */
    public void start() {
        this.dialogCrearCliente.setLocationRelativeTo(null);
        this.dialogCrearCliente.setVisible(true);
    }
}
