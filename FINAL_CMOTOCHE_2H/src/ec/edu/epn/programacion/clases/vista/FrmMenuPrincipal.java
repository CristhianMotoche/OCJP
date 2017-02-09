/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.programacion.clases.vista;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenuPrincipal
     */
    public FrmMenuPrincipal() {
        initComponents();
        this.setTitle("Menú de Administración");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAdministracion = new javax.swing.JMenu();
        menuUsuarios = new javax.swing.JMenu();
        menuItemNuevoUsuario = new javax.swing.JMenuItem();
        menuItemEditarUsuario = new javax.swing.JMenuItem();
        menuItemEliminarUsuario = new javax.swing.JMenuItem();
        menuItemListarUsuario = new javax.swing.JMenuItem();
        menuCliente = new javax.swing.JMenu();
        menuItemNuevoCliente = new javax.swing.JMenuItem();
        menuItemEditarCliente = new javax.swing.JMenuItem();
        menuItemEliminarCliente = new javax.swing.JMenuItem();
        menuItemListarClientes = new javax.swing.JMenuItem();
        menuCuentas = new javax.swing.JMenu();
        menuItemNuevaCuenta = new javax.swing.JMenuItem();
        menuItemListarCuenta = new javax.swing.JMenuItem();
        menuTransacciones = new javax.swing.JMenu();
        menuItemDepositar = new javax.swing.JMenuItem();
        menuItemRetirar = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        menuAdministracion.setText("Administración");
        menuAdministracion.setToolTipText("");
        menuAdministracion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        menuUsuarios.setText("Usuarios");
        menuUsuarios.setToolTipText("");

        menuItemNuevoUsuario.setText("Nuevo");
        menuItemNuevoUsuario.setToolTipText("");
        menuUsuarios.add(menuItemNuevoUsuario);

        menuItemEditarUsuario.setText("Editar");
        menuItemEditarUsuario.setToolTipText("");
        menuUsuarios.add(menuItemEditarUsuario);

        menuItemEliminarUsuario.setText("Eliminar");
        menuItemEliminarUsuario.setToolTipText("");
        menuUsuarios.add(menuItemEliminarUsuario);

        menuItemListarUsuario.setText("Listar");
        menuItemListarUsuario.setToolTipText("");
        menuUsuarios.add(menuItemListarUsuario);

        menuAdministracion.add(menuUsuarios);

        menuCliente.setText("Clientes");
        menuCliente.setToolTipText("");

        menuItemNuevoCliente.setText("Nuevo");
        menuItemNuevoCliente.setToolTipText("");
        menuCliente.add(menuItemNuevoCliente);

        menuItemEditarCliente.setText("Editar");
        menuItemEditarCliente.setToolTipText("");
        menuCliente.add(menuItemEditarCliente);

        menuItemEliminarCliente.setText("Eliminar");
        menuItemEliminarCliente.setToolTipText("");
        menuCliente.add(menuItemEliminarCliente);

        menuItemListarClientes.setText("Listar");
        menuItemListarClientes.setToolTipText("");
        menuCliente.add(menuItemListarClientes);

        menuAdministracion.add(menuCliente);

        menuCuentas.setText("Cuentas");
        menuCuentas.setToolTipText("");

        menuItemNuevaCuenta.setText("Nuevo");
        menuItemNuevaCuenta.setToolTipText("");
        menuCuentas.add(menuItemNuevaCuenta);

        menuItemListarCuenta.setText("Listar");
        menuItemListarCuenta.setToolTipText("");
        menuCuentas.add(menuItemListarCuenta);

        menuAdministracion.add(menuCuentas);

        jMenuBar1.add(menuAdministracion);

        menuTransacciones.setText("Transacciones");
        menuTransacciones.setToolTipText("");
        menuTransacciones.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        menuItemDepositar.setText("Depósitar");
        menuItemDepositar.setToolTipText("");
        menuTransacciones.add(menuItemDepositar);

        menuItemRetirar.setText("Retirar");
        menuItemRetirar.setToolTipText("");
        menuTransacciones.add(menuItemRetirar);

        jMenuBar1.add(menuTransacciones);

        menuSalir.setText("Opciones");
        menuSalir.setToolTipText("");
        menuSalir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuSalir.add(jMenuItem1);

        jMenuBar1.add(menuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuAdministracion;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuCuentas;
    private javax.swing.JMenuItem menuItemDepositar;
    private javax.swing.JMenuItem menuItemEditarCliente;
    private javax.swing.JMenuItem menuItemEditarUsuario;
    private javax.swing.JMenuItem menuItemEliminarCliente;
    private javax.swing.JMenuItem menuItemEliminarUsuario;
    private javax.swing.JMenuItem menuItemListarClientes;
    private javax.swing.JMenuItem menuItemListarCuenta;
    private javax.swing.JMenuItem menuItemListarUsuario;
    private javax.swing.JMenuItem menuItemNuevaCuenta;
    private javax.swing.JMenuItem menuItemNuevoCliente;
    private javax.swing.JMenuItem menuItemNuevoUsuario;
    private javax.swing.JMenuItem menuItemRetirar;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JMenu menuTransacciones;
    private javax.swing.JMenu menuUsuarios;
    // End of variables declaration//GEN-END:variables

    public JMenu getMenuAdministracion() {
        return menuAdministracion;
    }

    public JMenu getMenuCliente() {
        return menuCliente;
    }

    public JMenu getMenuCuentas() {
        return menuCuentas;
    }

    public JMenuItem getMenuItemEditarCliente() {
        return menuItemEditarCliente;
    }

    public JMenuItem getMenuItemEditarUsuario() {
        return menuItemEditarUsuario;
    }

    public JMenuItem getMenuItemEliminarCliente() {
        return menuItemEliminarCliente;
    }

    public JMenuItem getMenuItemEliminarUsuario() {
        return menuItemEliminarUsuario;
    }

    public JMenuItem getMenuItemListarClientes() {
        return menuItemListarClientes;
    }

    public JMenuItem getMenuItemListarCuenta() {
        return menuItemListarCuenta;
    }

    public JMenuItem getMenuItemListarUsuario() {
        return menuItemListarUsuario;
    }

    public JMenuItem getMenuItemNuevaCuenta() {
        return menuItemNuevaCuenta;
    }

    public JMenuItem getMenuItemNuevoCliente() {
        return menuItemNuevoCliente;
    }

    public JMenuItem getMenuItemNuevoUsuario() {
        return menuItemNuevoUsuario;
    }

    public JMenu getMenuSalir() {
        return menuSalir;
    }

    public JMenuItem getMenuItemDepositar() {
        return menuItemDepositar;
    }

    public JMenuItem getMenuItemRetirar() {
        return menuItemRetirar;
    }
}