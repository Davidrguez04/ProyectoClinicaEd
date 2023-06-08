package aplicacion.servicios;

import java.util.List;

import aplicacion.entidades.Paciente;

/**
 * Interfaz que define los metodos que daran servicio a los ficheros
 * @author csi22
 *
 */
public interface InterfazFicheros {

	/**
	 * Metodo que lee un fichero y devuelve una lista con los objetos de tipo paciente creados a partir del fichero
	 * @param ruta
	 * @return
	 */
	public List<Paciente> leeFichero(String ruta);
	
	/**
	 * Metodo que recibe la ruta de un fichero y escribira los datos de la lista pasada por parametros
	 * @param ruta
	 * @param listaPacientes
	 */
	public void escribeFichero(String ruta, List<Paciente> listaPacientes);
}
