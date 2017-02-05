package ec.edu.epn.programacion.clases.controladores.usuario;

import ec.edu.epn.programacion.clases.gui.usuario.DialogOpcionesUsuario;
import ec.edu.epn.programacion.clases.modelos.ModeloUsuario;
import ec.edu.epn.programacion.pojos.UsuarioSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
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

    public CtrlOpcionesUsuario(DialogOpcionesUsuario dialogOpcionesUsuario) {
        this.dialogOpcionesUsuario = dialogOpcionesUsuario;
        this.modeloUsuario = new ModeloUsuario();
        this.dialogOpcionesUsuario.getTextFieldBuscar().addKeyListener(this);
        this.dialogOpcionesUsuario.getBtnCancelar().addActionListener(this);
        this.dialogOpcionesUsuario.getBtnOpcion().setVisible(false);
    }

    public void start(){
        List<UsuarioSistema> usuarios = this.modeloUsuario.listar();
        TableModel tableModel = listToModel(usuarios);
        this.dialogOpcionesUsuario.setTableUsuarios(tableModel);
        this.dialogOpcionesUsuario.setLocationRelativeTo(null);
        this.dialogOpcionesUsuario.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogOpcionesUsuario.getBtnCancelar()) {
            this.dialogOpcionesUsuario.dispose();
        }
    }

    private TableModel listToModel(List<UsuarioSistema> usuarios) {
        Object [] columns = {"Nombre", "Edad", "Fecha Nac.", "Email"};
        Object [][] data = new Object[usuarios.size()][4];
        for (int i = 0; i < usuarios.size(); i++) {
            data[i][0] = usuarios.get(i).getNombre();
            data[i][1] = usuarios.get(i).getEdad();
            data[i][2] = usuarios.get(i).getFechaNacimiento();
            data[i][3] = usuarios.get(i).getEmail();
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
