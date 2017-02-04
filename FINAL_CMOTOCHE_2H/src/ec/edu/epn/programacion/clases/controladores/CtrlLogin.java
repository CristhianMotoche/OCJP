package ec.edu.epn.programacion.clases.controladores;

import ec.edu.epn.programacion.clases.gui.FrmLogin;
import ec.edu.epn.programacion.clases.gui.FrmMenuPrincipal;
import ec.edu.epn.programacion.clases.modelos.ModeloUsuario;
import ec.edu.epn.programacion.clases.validador.ValidadorLogin;
import ec.edu.epn.programacion.pojos.UsuarioSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlLogin
    implements ActionListener {

    private FrmLogin frmLogin;
    private ValidadorLogin validador;
    private ModeloUsuario modelo;

    public CtrlLogin(FrmLogin frmLogin) {
        this.validador = new ValidadorLogin();
        this.modelo = new ModeloUsuario();
        this.frmLogin = frmLogin;
        this.frmLogin.getBtnAceptar().addActionListener(this);
        this.frmLogin.getBtnCerrar().addActionListener(this);
    }

    public void start(){
        this.frmLogin.setLocationRelativeTo(null);
        this.frmLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmLogin.getBtnAceptar()) {
            String userName = this.frmLogin.getUsername();
            String password = this.frmLogin.getPassword();

            UsuarioSistema user = this.modelo.buscarUsuario(userName, password);
            String mensajesDeError = validador.validar(user);
            if (mensajesDeError.isEmpty()) {
                FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
                CtrlMenuPrincipal ctrlMenuPrincipal = new CtrlMenuPrincipal(frmMenuPrincipal, user);
                ctrlMenuPrincipal.start();
                this.frmLogin.dispose();
            } else {
                JOptionPane.showMessageDialog(this.frmLogin, mensajesDeError);
            }
        }
        if (e.getSource() == this.frmLogin.getBtnCerrar()) {
            System.exit(0);
        }
    }
}
