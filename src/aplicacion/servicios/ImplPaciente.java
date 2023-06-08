package aplicacion.servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import aplicacion.entidades.Paciente;

/**
 * Implementación de la interfaz paciente
 * @author csi22
 *
 */
public class ImplPaciente implements InterfazPaciente {

	@Override
	public void mostrarTodos(List<Paciente> listaPacientes) {
		
		for (Paciente aux : listaPacientes) {
			String fechaIngreso=aux.getFechaIngreso().toString();
			int diaIngreso=Integer.parseInt(fechaIngreso.split("-")[2]);
			int mesIngreso=Integer.parseInt(fechaIngreso.split("-")[1]);
			int anyoIngreso=Integer.parseInt(fechaIngreso.split("-")[0]);
			
			String fechaAlta=aux.getFechaAlta().toString();
			int diaAlta=Integer.parseInt(fechaAlta.split("-")[2]);
			int mesAlta=Integer.parseInt(fechaAlta.split("-")[1]);
			int anyoAlta=Integer.parseInt(fechaAlta.split("-")[0]);
			
			System.out.print("Nombre:"+aux.getNombre()+";Telefono:"+aux.getNumeroTelefono()+";FechaIngreso:"+diaIngreso+"-"+mesIngreso+"-"+anyoIngreso);
			if(anyoAlta==0 && mesAlta==1 && diaAlta==1) {
				System.out.println(";FechaAlta:-");
			}
			else
				System.out.println(";FechaAlta:"+diaAlta+"-"+mesAlta+"-"+anyoAlta);
			
		}
		
		
	}

	@Override
	public List<Paciente> ingresoPaciente(List<Paciente> listaPacientes) {
		
		// Scanner para leer los datos
        Scanner sc = new Scanner(System.in);

        // Pedimos el nombre de la mascota
        System.out.print("Introduzca el nombre de la mascota: ");
        String nombreMascota = sc.nextLine();

        // Pedimos el numero de telefono del dueño
        System.out.print("Introduzca el numero de telefono: ");
        int numTelefono = Integer.parseInt(sc.nextLine());

        // Pedimos la fecha de ingreso
        System.out.print("Introduzca la fecha de ingreso [dd-mm-yyyy]: ");
        String fechaIngresoString = sc.nextLine();
        int anyo = Integer.parseInt(fechaIngresoString.split("-")[2]);
        int mes = Integer.parseInt(fechaIngresoString.split("-")[1]);
        int dia = Integer.parseInt(fechaIngresoString.split("-")[0]);
        LocalDate fechaIngreso = LocalDate.of(anyo, mes, dia);

        // Preguntamos si se ha producido la fecha de alta
        LocalDate fechaAlta;
        if(preguntaSiNo("Introduzca si se ha producido la fecha de alta")) {
            // Pedimos la fecha de alta
            System.out.print("Introduzca la fecha de alta [dd-mm-yyyy]: ");
            String fechaAltaString = sc.nextLine();
            anyo = Integer.parseInt(fechaAltaString.split("-")[2]);
            mes = Integer.parseInt(fechaAltaString.split("-")[1]);
            dia = Integer.parseInt(fechaAltaString.split("-")[0]);
            fechaAlta = LocalDate.of(anyo, mes, dia);
        }
        else
            fechaAlta = LocalDate.of(0, 1, 1);

        // Añadimos el objeto a la lista y la devolvemos
        listaPacientes.add(new Paciente(nombreMascota, numTelefono, fechaIngreso, fechaAlta));

        // Devolvemos la lista actualizada
        return listaPacientes;
	}
	

	@Override
	public List<Paciente> modificaPaciente(List<Paciente> listaPacientes) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduzca el numero de telefono:");
		int numeroTelefono=Integer.parseInt(sc.nextLine());
		
		for (Paciente aux : listaPacientes) {
			if(aux.getNumeroTelefono()==numeroTelefono) {
				String fechaIngreso=aux.getFechaIngreso().toString();
				int diaIngreso=Integer.parseInt(fechaIngreso.split("-")[2]);
				int mesIngreso=Integer.parseInt(fechaIngreso.split("-")[1]);
				int anyoIngreso=Integer.parseInt(fechaIngreso.split("-")[0]);
				
				String fechaAlta=aux.getFechaAlta().toString();
				int diaAlta=Integer.parseInt(fechaAlta.split("-")[2]);
				int mesAlta=Integer.parseInt(fechaAlta.split("-")[1]);
				int anyoAlta=Integer.parseInt(fechaAlta.split("-")[0]);
				
				System.out.print("Nombre:"+aux.getNombre()+";Telefono:"+aux.getNumeroTelefono()+";FechaIngreso:"+diaIngreso+"-"+mesIngreso+"-"+anyoIngreso);
				if(anyoAlta==0 && mesAlta==1 && diaAlta==1) {
					System.out.println(";FechaAlta:-");
				}
				else
					System.out.println(";FechaAlta:"+diaAlta+"-"+mesAlta+"-"+anyoAlta);
			
				
				// Preguntamos si quiere modificar la fecha de alta
                if(preguntaSiNo("¿Quiere modificar la fecha de alta del paciente?")) {
                    // Preguntamos la fecha de alta
                    System.out.print("Introduzca la fecha de alta [dd-mm-yyyy]: ");
                    String fechaAltaString = sc.nextLine();
                    int anyo = Integer.parseInt(fechaAltaString.split("-")[2]);
                    int mes = Integer.parseInt(fechaAltaString.split("-")[1]);
                    int dia = Integer.parseInt(fechaAltaString.split("-")[0]);
                    aux.setFechaAlta(LocalDate.of(anyo, mes, dia));
                }
                break; // Para salir del bucle for
			}
			
			
		}
		
		return listaPacientes;//Devolvemos la lista actualizada
	}
	
	
	
	/**
	 * Metodo que devuelve true o false dependiendo de lo que introduzca el usuario
	 * @param texto
	 * @return
	 */
	private boolean preguntaSiNo(String texto) {
		String opcion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(texto+" [s=Si/n=No]: ");
            opcion = sc.next().toLowerCase();

            if(!opcion.equals("s") && !opcion.equals("n"))
                System.err.println(" Error: No se ha introducido una opción válida ");
        } while (!opcion.equals("s") && !opcion.equals("n"));


        if(opcion.equals("s"))
            return true;

        return false;
	}

	
	
}
