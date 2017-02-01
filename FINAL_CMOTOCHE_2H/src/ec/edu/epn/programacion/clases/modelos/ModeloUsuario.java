package ec.edu.epn.programacion.clases.modelos;

import ec.edu.epn.programacion.interfaces.InterfazAdministracion;
import ec.edu.epn.programacion.pojos.UsuarioSistema;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class ModeloUsuario
        implements InterfazAdministracion {

    private File archivoUsuarios;
    private FileReader fr;
    private BufferedReader br;
    private ArrayList<UsuarioSistema> usuarios;

    public ModeloUsuario() {
        try {
            this.usuarios = new ArrayList();
            this.archivoUsuarios = new File("./usuarios.txt");
            fr = new FileReader(this.archivoUsuarios);
            br = new BufferedReader(fr);

            try {
                String linea;
                while((linea = br.readLine())!= null){
                    String contenidoLinea [] = linea.split(" ");
                    String nombre = contenidoLinea[0];
                    String contrasena = contenidoLinea[1];
                    usuarios.add(new UsuarioSistema(nombre, contrasena));
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al leer el archivo");
                System.err.println("Ocurrió un error al leer el archivo: \n" + ex);
                System.exit(0);
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No existe el fichero de usuarios");
            System.err.println("No existe el fichero.");
            System.exit(0);
        }
    }

    public UsuarioSistema buscarUsuario(String userName, String password) {
        UsuarioSistema usuario = new UsuarioSistema(userName, password);
        if(this.usuarios.contains(usuario)){
            return usuario;
        } else {
            return null;
        }
    }

    @Override
    public String crear(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String borrar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscarPorParametro(List lista, Object parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
