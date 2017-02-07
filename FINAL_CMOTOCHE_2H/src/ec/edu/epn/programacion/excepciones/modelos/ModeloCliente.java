package ec.edu.epn.programacion.excepciones.modelos;

import ec.edu.epn.programacion.interfaces.InterfazAdministracion;
import ec.edu.epn.programacion.pojos.Cliente;
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
public class ModeloCliente
    implements InterfazAdministracion {

    private File archivoClientes;
    private FileReader fr;
    private BufferedReader br;
    private ArrayList<Cliente> clientes;

    /**
     *
     */
    public ModeloCliente() {
        cargarClientes();
    }

    /**
     *
     * @return
     */
    public boolean registrarClientes(){
        try{
            FileWriter fw = new FileWriter(this.archivoClientes, false);
            BufferedWriter bw = new BufferedWriter(fw);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            for (Cliente cliente : this.clientes) {
                bw.write(cliente.getCelular()+ " "
                        + cliente.getSueldo()+ " "
                        + cliente.getNombre() + " "
                        + cliente.getEdad() + " "
                        + sdf.format(cliente.getFechaNacimiento()) + " "
                        + cliente.getEmail()
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
        Cliente cliente = (Cliente) obj;
        this.clientes.add(cliente);
        if (registrarClientes()) {
            return "Se ha creado un nuevo cliente";
        } else {
            return "Existió un error interno.\nNo se creó el cliente";
        }
    }

    @Override
    public String actualizar(Object obj) {
        Cliente cliente = (Cliente) obj;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).equals(cliente)) {
                this.clientes.get(i).setNombre(cliente.getNombre());
                this.clientes.get(i).setEmail(cliente.getEmail());
                this.clientes.get(i).setFechaNacimiento(cliente.getFechaNacimiento());
                this.clientes.get(i).setEdad(cliente.getEdad());
                this.clientes.get(i).setCelular(cliente.getCelular());
                this.clientes.get(i).setSueldo(cliente.getSueldo());
            }
        }

        if (registrarClientes()) {
            return "Se actualizó el cliente";
        } else {
            return "Existió un error interno.\nNo se actualizó el cliente";
        }
    }

    @Override
    public String borrar(Object obj) {
        Cliente cliente  = (Cliente) obj;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).equals(cliente )) {
                this.clientes.remove(i);
            }
        }

        if (registrarClientes()) {
            return "Se eliminó al  cliente";
        } else {
            return "No se eliminó al cliente";
        }
    }

    @Override
    public Object buscarPorParametro(List lista, Object parametro) {
        return new Object();
    }

    @Override
    public List listar() {
        cargarClientes();
        return this.clientes;
    }

    private void cargarClientes(){
        try {
            this.clientes = new ArrayList();
            this.archivoClientes = new File("./clientes.txt");
            fr = new FileReader(this.archivoClientes);
            br = new BufferedReader(fr);

            try {
                String linea;
                while((linea = br.readLine())!= null){
                    String contenidoLinea [] = linea.split(" ");
                    String telefono = contenidoLinea[0];
                    Double sueldo = Double.parseDouble(contenidoLinea[1]);
                    String nombre = contenidoLinea[2];
                    byte edad = new Byte(contenidoLinea[3]);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaNac = sdf.parse(contenidoLinea[4]);
                    String email = contenidoLinea[5];
                    Cliente cliente = new Cliente(telefono, sueldo, nombre, edad, fechaNac, email);
                    clientes.add(cliente);
                }
                br.close();
            } catch (IOException | NumberFormatException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al leer el archivo");
                System.err.println("Ocurrió un error al leer el archivo: \n" + ex);
                System.exit(0);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No existe el fichero de clientes");
            System.err.println("No existe el fichero.");
            System.exit(0);
        }
    }
}
