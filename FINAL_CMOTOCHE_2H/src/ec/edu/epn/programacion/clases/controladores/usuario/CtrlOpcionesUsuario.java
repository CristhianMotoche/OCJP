package ec.edu.epn.programacion.clases.controladores.usuario;

import ec.edu.epn.programacion.clases.gui.usuario.DialogCrearUsuario;
import ec.edu.epn.programacion.clases.gui.usuario.DialogOpcionesUsuario;
import ec.edu.epn.programacion.clases.modelos.ModeloUsuario;
import ec.edu.epn.programacion.pojos.UsuarioSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlOpcionesUsuario
        implements ActionListener, KeyListener {

    private DialogOpcionesUsuario dialogOpcionesUsuario;
    private ModeloUsuario modeloUsuario;
    private boolean remover;
    private boolean editar;

    public CtrlOpcionesUsuario(DialogOpcionesUsuario dialogOpcionesUsuario, boolean remover, boolean editar) {
        this.dialogOpcionesUsuario = dialogOpcionesUsuario;
        this.modeloUsuario = new ModeloUsuario();
        this.remover = remover;
        this.editar = editar;

        if (remover) {
            this.dialogOpcionesUsuario.getBtnOpcion().setText("Eliminar");
        } else if (editar) {
            this.dialogOpcionesUsuario.getBtnOpcion().setText("Editar");
        } else {
            this.dialogOpcionesUsuario.getBtnOpcion().setVisible(false);
        }
        this.dialogOpcionesUsuario.getBtnOpcion().addActionListener(this);
        this.dialogOpcionesUsuario.getTextFieldBuscar().addKeyListener(this);
        this.dialogOpcionesUsuario.getBtnCancelar().addActionListener(this);
    }

    public void start(){
        List<UsuarioSistema> usuarios = this.modeloUsuario.listar();
        TableModel tableModel = listToModel(usuarios);
        this.dialogOpcionesUsuario.setTableUsuarios(tableModel);
        TableColumnModel tcm = this.dialogOpcionesUsuario.getTableUsuarios().getColumnModel();
        tcm.removeColumn(tcm.getColumn(tcm.getColumnIndex("Login")));
        tcm.removeColumn(tcm.getColumn(tcm.getColumnIndex("Password")));
        this.dialogOpcionesUsuario.setLocationRelativeTo(null);
        this.dialogOpcionesUsuario.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogOpcionesUsuario.getBtnOpcion() && this.remover) {
            int row = this.dialogOpcionesUsuario.getTableUsuarios().getSelectedRow();
            int rows = this.dialogOpcionesUsuario.getTableUsuarios().getSelectedRowCount();
            if (row < 1 && rows == 0) {
                JOptionPane.showMessageDialog(dialogOpcionesUsuario
                        , "Debe seleccionar una sola fila"
                        , "Error"
                        , JOptionPane.ERROR_MESSAGE, null);
            } else {
                // Actualizar modelo
                List<UsuarioSistema> usuarios = this.modeloUsuario.listar();
                TableModel tableModel = listToModel(usuarios);
                this.dialogOpcionesUsuario.setTableUsuarios(tableModel);
                // Buscar usuario por login y password
                String login = this.dialogOpcionesUsuario.getTableUsuarios().getStringAt(row, 4);
                String pass = this.dialogOpcionesUsuario.getTableUsuarios().getStringAt(row, 5);
                UsuarioSistema user = new UsuarioSistema(login, pass);
                // Borrar usuario
                this.modeloUsuario.borrar(user);
                // Actualizar modelo
                usuarios = this.modeloUsuario.listar();
                tableModel = listToModel(usuarios);
                this.dialogOpcionesUsuario.setTableUsuarios(tableModel);
                this.dialogOpcionesUsuario.getTableUsuarios().updateUI();
            }
        }
        if (e.getSource() == this.dialogOpcionesUsuario.getBtnOpcion() && this.editar) {
            int row = this.dialogOpcionesUsuario.getTableUsuarios().getSelectedRow();
            int rows = this.dialogOpcionesUsuario.getTableUsuarios().getSelectedRowCount();
            if (row < 1 && rows == 0) {
                JOptionPane.showMessageDialog(dialogOpcionesUsuario
                        , "Debe seleccionar una sola fila"
                        , "Error"
                        , JOptionPane.ERROR_MESSAGE, null);
            } else {
                // Actualizar modelo
                List<UsuarioSistema> usuarios = this.modeloUsuario.listar();
                DefaultTableModel tableModel = listToModel(usuarios);
                this.dialogOpcionesUsuario.setTableUsuarios(tableModel);

                // Buscar usuario por login y password
                String login = this.dialogOpcionesUsuario.getTableUsuarios().getStringAt(row, 4);
                String pass = this.dialogOpcionesUsuario.getTableUsuarios().getStringAt(row, 5);
                UsuarioSistema user = new UsuarioSistema(login, pass);
                for (UsuarioSistema usuario : usuarios) {
                    if (user.equals(usuario)) {
                        user = usuario;
                    }
                }

                // Borrar usuario
                DialogCrearUsuario dcu = new DialogCrearUsuario(dialogOpcionesUsuario, true);
                CtrlNuevoUsuario cnu = new CtrlNuevoUsuario(dcu, user);
                cnu.start();

                // Actualizar modelo
                usuarios = this.modeloUsuario.listar();
                tableModel = listToModel(usuarios);
                this.dialogOpcionesUsuario.setTableUsuarios(tableModel);
                ((DefaultTableModel) this.dialogOpcionesUsuario.getTableUsuarios().getModel()).fireTableDataChanged();
            }
        }
        if (e.getSource() == this.dialogOpcionesUsuario.getBtnCancelar()) {
            this.dialogOpcionesUsuario.dispose();
        }
    }

    private DefaultTableModel listToModel(List<UsuarioSistema> usuarios) {
        Object [] columns = {"Nombre", "Edad", "Fecha Nac.", "Email", "Login", "Password"};
        Object [][] data = new Object[usuarios.size()][columns.length];
        for (int i = 0; i < usuarios.size(); i++) {
            data[i][0] = usuarios.get(i).getNombre();
            data[i][1] = usuarios.get(i).getEdad();
            data[i][2] = usuarios.get(i).getFechaNacimiento();
            data[i][3] = usuarios.get(i).getEmail();
            data[i][4] = usuarios.get(i).getLogin();
            data[i][5] = usuarios.get(i).getPassword();
        }
        return new DefaultTableModel(data, columns);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) this.dialogOpcionesUsuario.getTableUsuarios().getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm);
        this.dialogOpcionesUsuario.getTableUsuarios().setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(this.dialogOpcionesUsuario.getTextFieldBuscar().getText()));
    }
}
