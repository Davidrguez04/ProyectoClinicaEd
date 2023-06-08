package aplicacion.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aplicacion.entidades.Paciente;

/**
 * Implementacion de la interfaz ficheros
 * @author csi22
 *
 */
public class ImplFicheros implements InterfazFicheros {

	@Override
    public List<Paciente> leeFichero(String ruta) {
        // Lista que devolveremos con los objetos creados a partir del fichero
        List<Paciente> lista = new ArrayList<>();

        // Variables para leer el fichero
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String[] vAux;
            // Leemos la primera linea
            linea = br.readLine(); // cabecera
            while((linea = br.readLine()) != null) {
                // Ej linea: David;654654645;2023-12-28;2023-12-29
                vAux = linea.split(";"); // Guardamos la linea separada por ";" en un vector

                // Añadimos a la lista el objeto creado
                lista.add(new Paciente(vAux[0], Integer.parseInt(vAux[1]), LocalDate.parse(vAux[2]), LocalDate.parse(vAux[3])));

            }
        } catch (Exception e) {
            System.err.println(" Error: No se ha podido abrir el fichero ");
        } finally {
            // Cerramos el fichero
            try {
                if(fr != null)
                    fr.close();
            } catch (Exception e) {
                System.err.println(" Error: No se ha podido cerrar el fichero ");
            }
        }

        return lista;
    }
	
	
	@Override
    public void escribeFichero(String ruta, List<Paciente> listaPacientes) {

        // Variables necesarias para escribir en un fichero
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(ruta);
            pw = new PrintWriter(fw);

            // Escribimos la cabecera;
            pw.println("Nombre;Telefono;FechaIngreso;FechaAlta");
            // Escribimos los datos de la lista
            for (Paciente aux : listaPacientes) {
                pw.println(aux.getNombre()+";"+aux.getNumeroTelefono()+";"+aux.getFechaIngreso()+";"+aux.getFechaAlta());
            }

        } catch (Exception e) {
            System.err.println(" Error: No se ha podido abrir el fichero ");
        } finally {
            // Cerramos el fichero
            try {
                if(fw != null)
                    fw.close();
            } catch (Exception e) {
                System.err.println(" Error: No se ha podido cerrar el fichero ");
            }
        }

    }
}
