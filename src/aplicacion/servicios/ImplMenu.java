package aplicacion.servicios;

import java.util.Scanner;

/**
 * Implementacion de la interfaz Menu
 * @author csi22
 *
 */
public class ImplMenu implements InterfazMenu{

	@Override
	public int mostrarMenu() {
		
		// Scanner para leer
        Scanner sc = new Scanner(System.in);

        // Mostramos el menu
        int opcion = -1;
        do {
            System.out.println("1. Muestra todos los pacientes");
            System.out.println("2. Ingreso paciente");
            System.out.println("3. Modificar alta paciente");
            System.out.println("0. Salir");
            System.out.print("Introduzca una opción: ");
            opcion = sc.nextInt();

            if(opcion < 0 || opcion > 3)
                System.err.println(" Error: El valor no está dentro del rango ");
        } while (opcion < 0 || opcion > 3);

        // Devolvemos la opcion
        return opcion;
		
	}
	
	

}
