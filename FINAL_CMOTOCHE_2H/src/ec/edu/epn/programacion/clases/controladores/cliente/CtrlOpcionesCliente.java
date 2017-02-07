package ec.edu.epn.programacion.clases.controladores.cliente;

import ec.edu.epn.programacion.clases.gui.cliente.DialogCrearCliente;
import ec.edu.epn.programacion.clases.gui.cliente.DialogOpcionesCliente;
import ec.edu.epn.programacion.excepciones.modelos.ModeloCliente;
import ec.edu.epn.programacion.pojos.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
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
    private ModeloCliente modeloCliente;
    private boolean remover;
    private boolean editar;

    /**
     *
     * @param dialogOpcionesCliente
     * @param remover
     * @param editar
     */
    public CtrlOpcionesCliente(DialogOpcionesCliente dialogOpcionesCliente, boolean remover, boolean editar) {
        this.dialogOpcionesCliente = dialogOpcionesCliente;
        this.modeloCliente = new ModeloCliente();
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
        if (e.getSource() == this.dialogOpcionesCliente.getBtnOpcion() && this.remover) {
            int row = this.dialogOpcionesCliente.getTableClientes().getSelectedRow();
            int rows = this.dialogOpcionesCliente.getTableClientes().getSelectedRowCount();
            if (row < 1 && rows == 0) {
                JOptionPane.showMessageDialog(dialogOpcionesCliente
                        , "Debe seleccionar una sola fila"
                        , "Error"
                        , JOptionPane.ERROR_MESSAGE, null);
            } else {
                // Actualizar modelo
                List<Cliente> clientes = this.modeloCliente.listar();
                TableModel tableModel = listToModel(clientes);
                this.dialogOpcionesCliente.setTableClientes(tableModel);

                // Buscar usuario por login y password
                String nombre = this.dialogOpcionesCliente.getTableClientes().getStringAt(row, 0);
                Cliente cliente = new Cliente(nombre);

                // Borrar usuario
                this.modeloCliente.borrar(cliente);
                // Actualizar modelo
                clientes = this.modeloCliente.listar();
                tableModel = listToModel(clientes);
                this.dialogOpcionesCliente.setTableClientes(tableModel);
                this.dialogOpcionesCliente.getTableClientes().updateUI();
            }
        }
        if(e.getSource() == this.dialogOpcionesCliente.getBtnOpcion() && this.editar){
            int row = this.dialogOpcionesCliente.getTableClientes().getSelectedRow();
            int rows = this.dialogOpcionesCliente.getTableClientes().getSelectedRowCount();
            if (row < 1 && rows == 0) {
                JOptionPane.showMessageDialog(dialogOpcionesCliente
                        , "Debe seleccionar una sola fila"
                        , "Error"
                        , JOptionPane.ERROR_MESSAGE, null);
            } else {
                // Actualizar modelo
                List<Cliente> clientes = this.modeloCliente.listar();
                TableModel tableModel = listToModel(clientes);
                this.dialogOpcionesCliente.setTableClientes(tableModel);

                // Buscar usuario por login y password
                String nombre = this.dialogOpcionesCliente.getTableClientes().getStringAt(row, 0);
                Cliente clienteBusqueda = new Cliente(nombre);
                for (Cliente cliente : clientes) {
                    if (cliente.equals(clienteBusqueda)) {
                        clienteBusqueda = cliente;
                    }
                }
                DialogCrearCliente dcc = new DialogCrearCliente(dialogOpcionesCliente, true);
                CtrlNuevoCliente cnc = new CtrlNuevoCliente(dcc, clienteBusqueda);
                cnc.start();

                // Actualizar modelo
                clientes = this.modeloCliente.listar();
                tableModel = listToModel(clientes);
                this.dialogOpcionesCliente.setTableClientes(tableModel);
                ((DefaultTableModel) this.dialogOpcionesCliente.getTableClientes().getModel()).fireTableDataChanged();
            }
        }
        if (e.getSource() == this.dialogOpcionesCliente.getBtnCancelar()) {
            this.dialogOpcionesCliente.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) this.dialogOpcionesCliente.getTableClientes().getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm);
        this.dialogOpcionesCliente.getTableClientes().setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(this.dialogOpcionesCliente.getTextFieldBuscar().getText()));
    }

    /**
     * Permite iniciar la visualización de la ventana
     */
    public void start() {
        List<Cliente> clientes = this.modeloCliente.listar();
        TableModel tableModel = listToModel(clientes);
        this.dialogOpcionesCliente.setTableClientes(tableModel);
        this.dialogOpcionesCliente.setLocationRelativeTo(null);
        this.dialogOpcionesCliente.setVisible(true);
    }

    private DefaultTableModel listToModel(List<Cliente> clientes) {
        Object [] columns = {"Nombre", "Edad", "Fecha Nac.", "Email", "Teléfono", "Sueldo"};
        Object [][] data = new Object[clientes.size()][columns.length];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < clientes.size(); i++) {
            data[i][0] = clientes.get(i).getNombre();
            data[i][1] = clientes.get(i).getEdad();
            data[i][2] = sdf.format(clientes.get(i).getFechaNacimiento());
            data[i][3] = clientes.get(i).getEmail();
            data[i][4] = clientes.get(i).getCelular();
            data[i][5] = clientes.get(i).getSueldo();
        }
        return new DefaultTableModel(data, columns);
    }
}
