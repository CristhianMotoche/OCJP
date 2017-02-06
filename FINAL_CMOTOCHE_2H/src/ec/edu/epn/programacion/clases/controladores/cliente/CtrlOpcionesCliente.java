package ec.edu.epn.programacion.clases.controladores.cliente;

import ec.edu.epn.programacion.clases.gui.cliente.DialogOpcionesCliente;
import ec.edu.epn.programacion.clases.modelos.ModeloUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlOpcionesCliente
    implements ActionListener, KeyListener {
    private DialogOpcionesCliente dialogOpcionesCliente;
    private ModeloUsuario modeloUsuario;
    private boolean remover;
    private boolean editar;

    public CtrlOpcionesCliente(DialogOpcionesCliente dialogOpcionesCliente, boolean remover, boolean editar) {
        this.dialogOpcionesCliente = dialogOpcionesCliente;
        this.modeloUsuario = new ModeloUsuario();
        this.remover = remover;
        this.editar = editar;

        if (remover) {
            this.dialogOpcionesCliente.getBtnOpcion().setText("Eliminar");
        } else if (editar) {
            this.dialogOpcionesCliente.getBtnOpcion().setText("Editar");
        } else {
            this.dialogOpcionesCliente.getBtnOpcion().setVisible(false);
        }
        this.dialogOpcionesCliente.getBtnOpcion().addActionListener(this);
        this.dialogOpcionesCliente.getTextFieldBuscar().addKeyListener(this);
        this.dialogOpcionesCliente.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) this.dialogOpcionesCliente.getTableUsuarios().getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm);
        this.dialogOpcionesCliente.getTableUsuarios().setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(this.dialogOpcionesCliente.getTextFieldBuscar().getText()));
    }

    public void start() {
        this.dialogOpcionesCliente.setLocationRelativeTo(null);
        this.dialogOpcionesCliente.setVisible(true);
    }
}
