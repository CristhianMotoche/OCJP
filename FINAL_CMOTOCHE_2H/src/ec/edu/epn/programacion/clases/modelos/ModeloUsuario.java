package ec.edu.epn.programacion.clases.modelos;

import ec.edu.epn.programacion.interfaces.InterfazAdministracion;
import ec.edu.epn.programacion.pojos.UsuarioSistema;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
                br.close();
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

    public boolean registrarUsuarios(){
        try{
            FileWriter fw = new FileWriter(this.archivoUsuarios, false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (UsuarioSistema usuario : this.usuarios) {
                bw.write(usuario.getLogin() + " " + usuario.getPassword());
                bw.newLine();
            }
            bw.close();
            return true;
        } catch(IOException io){
            JOptionPane.showMessageDialog(null, "Error en la escritura del archivo.");
            System.err.println("No existe el fichero.\n" + io);
            System.exit(0);
        }
        return false;
    }

    @Override
    public String crear(Object obj) {
        UsuarioSistema user = (UsuarioSistema) obj;
        this.usuarios.add(user);
        if (registrarUsuarios()) {
            return "Se creó el usuario " + user;
        } else {
            return "No se creó el usuario";
        }
    }

    @Override
    public String actualizar(Object obj) {
        UsuarioSistema user = (UsuarioSistema) obj;
        for (int i = 0; i < this.usuarios.size(); i++) {
            if (this.usuarios.get(i).equals(user)) {
                this.usuarios.get(i).setNombre(user.getNombre());
                this.usuarios.get(i).setEmail(user.getEmail());
                this.usuarios.get(i).setFechaNacimiento(user.getFechaNacimiento());
                this.usuarios.get(i).setEdad(user.getEdad());
                this.usuarios.get(i).setLogin(user.getLogin());
                this.usuarios.get(i).setPassword(user.getPassword());
            }
        }

        if (registrarUsuarios()) {
            return "Se actualizó el usuario";
        } else {
            return "No se actualizó el usuario";
        }
    }

    @Override
    public String borrar(Object obj) {
        UsuarioSistema user = (UsuarioSistema) obj;
        for (int i = 0; i < this.usuarios.size(); i++) {
            if (this.usuarios.get(i).equals(user)) {
                this.usuarios.remove(i);
            }
        }

        if (registrarUsuarios()) {
            return "Se eliminó al  usuario";
        } else {
            return "No se eliminó al usuario";
        }
    }

    @Override
    public Object buscarPorParametro(List lista, Object parametro) {
        return buscarUsuario((String) parametro, (String) parametro);
    }

    @Override
    public List listar() {
        return this.usuarios;
    }
}
