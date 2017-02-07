package ec.edu.epn.programacion.excepciones.modelos;

import ec.edu.epn.programacion.interfaces.InterfazAdministracion;
import ec.edu.epn.programacion.pojos.UsuarioSistema;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    /**
     *
     */
    public ModeloUsuario() {
        cargarUsuarios();
    }

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    public UsuarioSistema buscarUsuario(String userName, String password) {
        UsuarioSistema usuario = new UsuarioSistema(userName, password);
        if(this.usuarios.contains(usuario)){
            return usuario;
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    public boolean registrarUsuarios(){
        try{
            FileWriter fw = new FileWriter(this.archivoUsuarios, false);
            BufferedWriter bw = new BufferedWriter(fw);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            for (UsuarioSistema usuario : this.usuarios) {
                bw.write(usuario.getLogin() + " "
                        + usuario.getPassword() + " "
                        + usuario.getNombre() + " "
                        + usuario.getEdad() + " "
                        + sdf.format(usuario.getFechaNacimiento()) + " "
                        + usuario.getEmail()
                );
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
            return "Se ha creado un nuevo usuario.";
        } else {
            return "Existió un error interno.\nNo se creó el usuario";
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
            return "Existió un error interno.\nNo se actualizó el usuario";
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
        cargarUsuarios();
        return this.usuarios;
    }

    private void cargarUsuarios(){
        try {
            this.usuarios = new ArrayList();
            this.archivoUsuarios = new File("./usuarios.txt");
            fr = new FileReader(this.archivoUsuarios);
            br = new BufferedReader(fr);

            try {
                String linea;
                while((linea = br.readLine())!= null){
                    String contenidoLinea [] = linea.split(" ");
                    String login = contenidoLinea[0];
                    String contrasena = contenidoLinea[1];
                    String nombre = contenidoLinea[2];
                    byte edad = new Byte(contenidoLinea[3]);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaNac = sdf.parse(contenidoLinea[4]);
                    String email = contenidoLinea[5];
                    UsuarioSistema user = new UsuarioSistema(login, contrasena, nombre, edad, fechaNac, email);
                    usuarios.add(user);
                }
                br.close();
            } catch (IOException | NumberFormatException | ParseException ex) {
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
}
