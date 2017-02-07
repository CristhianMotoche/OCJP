package ec.edu.epn.programacion.clases.controladores.usuario;

import ec.edu.epn.programacion.clases.gui.usuario.DialogCrearUsuario;
import ec.edu.epn.programacion.excepciones.modelos.ModeloUsuario;
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
    private boolean editar;

    /**
     *
     * @param dialogCrearUsuario
     */
    public CtrlNuevoUsuario(DialogCrearUsuario dialogCrearUsuario) {
        this.dialogCrearUsuario = dialogCrearUsuario;
        this.modeloUsuario = new ModeloUsuario();
        this.editar = false;

        this.dialogCrearUsuario.getBtnAceptar().addActionListener(this);
        this.dialogCrearUsuario.getBtnCancelar().addActionListener(this);
    }

    /**
     *
     * @param dialogCrearUsuario
     * @param usuarioEditar
     */
    public CtrlNuevoUsuario(DialogCrearUsuario dialogCrearUsuario, UsuarioSistema usuarioEditar) {
        this.dialogCrearUsuario = dialogCrearUsuario;
        this.modeloUsuario = new ModeloUsuario();
        this.editar = true;

        this.dialogCrearUsuario.setTxtNombre(usuarioEditar.getNombre());
        this.dialogCrearUsuario.setTxtEdad(Byte.toString(usuarioEditar.getEdad()));
        this.dialogCrearUsuario.setDateFechaNac(usuarioEditar.getFechaNacimiento());
        this.dialogCrearUsuario.setTxtEmail(usuarioEditar.getEmail());
        this.dialogCrearUsuario.setTxtLogin(usuarioEditar.getLogin());
        this.dialogCrearUsuario.setTxtPass(usuarioEditar.getPassword());

        this.dialogCrearUsuario.getBtnAceptar().addActionListener(this);
        this.dialogCrearUsuario.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogCrearUsuario.getBtnAceptar() && editar) {
            String mensajesDeError = camposValidos();
            if(mensajesDeError.isEmpty()){
                UsuarioSistema user = getDatosUsuario();
                String result = this.modeloUsuario.actualizar(user);
                JOptionPane.showMessageDialog(this.dialogCrearUsuario, result);
                this.dialogCrearUsuario.dispose();
            } else {
                JOptionPane.showMessageDialog(this.dialogCrearUsuario
                        , mensajesDeError
                        , "Errores de usuario"
                        , JOptionPane.ERROR_MESSAGE
                        , null);
            }
        }
        if (e.getSource() == this.dialogCrearUsuario.getBtnAceptar() && !editar) {
            String mensajesDeError = camposValidos();
            if(mensajesDeError.isEmpty()){
                UsuarioSistema user = getDatosUsuario();
                String result = this.modeloUsuario.crear(user);
                JOptionPane.showMessageDialog(this.dialogCrearUsuario, result);
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
        user.setEmail(this.dialogCrearUsuario.getTxtEmail());
        user.setLogin(this.dialogCrearUsuario.getTxtLogin());
        user.setPassword(this.dialogCrearUsuario.getPass());
        return user;
    }

    /**
     *
     */
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
