package aplicacion.servicios;

import java.util.List;

import aplicacion.entidades.Paciente;

/**
 * Interfaz que define los métodos que darán servicio a Paciente
 * @author csi22
 *
 */
public interface InterfazPaciente {

	/**
	 * Método que muestra todos los pacientes
	 * @param listaPacientes
	 */
	public void mostrarTodos(List<Paciente> listaPacientes); 
	
	/**
	 * Método que añade pacientes a la lista
	 * @param listaPacientes
	 * @return
	 */
	public List<Paciente> ingresoPaciente(List<Paciente> listaPacientes);
	
	/**
	 * Método que modifica la fecha de alta de paciente
	 * @param listaPacientes
	 * @return
	 */
	public List<Paciente> modificaPaciente(List<Paciente> listaPacientes);
	
	
}
