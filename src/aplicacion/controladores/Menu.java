package aplicacion.controladores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aplicacion.entidades.Paciente;
import aplicacion.servicios.ImplFicheros;
import aplicacion.servicios.ImplMenu;
import aplicacion.servicios.ImplPaciente;
import aplicacion.servicios.InterfazFicheros;
import aplicacion.servicios.InterfazMenu;
import aplicacion.servicios.InterfazPaciente;

public class Menu {

	public static void main(String[] args) {
		
		// Inicializamos la interfaz menu y pacientes
		InterfazMenu intM=new ImplMenu();
		InterfazPaciente intP=new ImplPaciente();
		InterfazFicheros intF=new ImplFicheros();
    
		int opcion=-1;
		
		//Lista donde guardaremos los objetos de tipo Paciente
		List<Paciente> listaPaciente= intF.leeFichero("C:\\Users\\csi22\\OneDrive\\Escritorio\\Prueba.txt");
		
		//listaPaciente.add(new Paciente("David", 634589554, LocalDate.now(), LocalDate.now()));
		
		do {
			try {
				opcion=intM.mostrarMenu();
			} catch (Exception e) {
				System.err.println("**Error: No se ha introducido el formato correcto**");
			}
			
			
			switch (opcion) {
			case 1:
				//Mostrar Pacientes
				try {
					intP.mostrarTodos(listaPaciente);
				} catch (Exception e) {
					System.err.println("**Error: No se ha podido mostrar todos los pacientes**");
				}
				break;
			case 2:
				//IngresarPacientes
				try {
					listaPaciente=intP.ingresoPaciente(listaPaciente);
					intF.escribeFichero("C:\\Users\\csi22\\OneDrive\\Escritorio\\Prueba.txt", listaPaciente);
				} catch (Exception e) {
					System.err.println("**Error: No se ha podido ingresar un paciente**");
				}
				
				break;
			case 3:
                //ModificarPacientes
				try {
					listaPaciente=intP.modificaPaciente(listaPaciente);
					intF.escribeFichero("C:\\Users\\csi22\\OneDrive\\Escritorio\\Prueba.txt", listaPaciente);
				} catch (Exception e) {
					System.err.println("**Error: No se ha podido dar de alta a un paciente**");
				}
				
				break;
				
			
			}
			
			
		}while(opcion!=0);
	}

}
