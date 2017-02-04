package ec.edu.epn.programacion.clases.controladores.usuario;

import ec.edu.epn.programacion.clases.gui.usuario.DialogCrearUsuario;
import ec.edu.epn.programacion.clases.modelos.ModeloUsuario;
import ec.edu.epn.programacion.pojos.UsuarioSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlNuevoUsuario
    implements ActionListener {

    private DialogCrearUsuario dialogCrearUsuario;
    private ModeloUsuario modeloUsuario;

    public CtrlNuevoUsuario(DialogCrearUsuario dialogCrearUsuario) {
        this.dialogCrearUsuario = dialogCrearUsuario;
        this.modeloUsuario = new ModeloUsuario();

        this.dialogCrearUsuario.getBtnAceptar().addActionListener(this);
        this.dialogCrearUsuario.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogCrearUsuario.getBtnAceptar()) {
            String mensajesDeError = camposValidos();
            if(mensajesDeError.isEmpty()){
                UsuarioSistema user = getDatosUsuario();
                this.modeloUsuario.crear(user);
                this.dialogCrearUsuario.dispose();
            } else {
                JOptionPane.showMessageDialog(this.dialogCrearUsuario
                        , mensajesDeError
                        , "Errores de usuario"
                        , JOptionPane.ERROR_MESSAGE
                        , null);
            }
        }
        if (e.getSource() == this.dialogCrearUsuario.getBtnCancelar()) {
            this.dialogCrearUsuario.dispose();
        }
    }

    private UsuarioSistema getDatosUsuario() {
        UsuarioSistema user = new UsuarioSistema();
        user.setId();
        user.setNombre(this.dialogCrearUsuario.getTxtNombre());
        user.setEdad(new Byte(this.dialogCrearUsuario.getTxtEdad()));
        user.setFechaNacimiento(this.dialogCrearUsuario.getDateFechaNac());
        user.setLogin(this.dialogCrearUsuario.getTxtLogin());
        user.setPassword(this.dialogCrearUsuario.getPass());
        return user;
    }

    public void start() {
        this.dialogCrearUsuario.setLocationRelativeTo(null);
        this.dialogCrearUsuario.setVisible(true);
    }

    private String camposValidos(){
        String messages = "";
        String nombre = this.dialogCrearUsuario.getTxtNombre();
        String login = this.dialogCrearUsuario.getTxtLogin();
        String password = this.dialogCrearUsuario.getPass();

        if (nombre.isEmpty()) {
            messages += "\n*El nombre no puede estar vacio.";
        }
        if (login.isEmpty()) {
            messages += "\n*El login no puede estar vacio.";
        }
        if (password.isEmpty()) {
            messages += "\n*La contraseña no puede estar vacia.";
        }

        try {
            byte edad = new Byte(this.dialogCrearUsuario.getTxtEdad());
        } catch (NumberFormatException e){
            messages += "\n*La edad debe ser un número";
        }
        return messages;
    }
}
