package aplicacion.entidades;

import java.time.LocalDate;

public class Paciente {
	//Atributos
    private String nombre;
    private int numeroTelefono;
    private LocalDate fechaIngreso;
    private LocalDate fechaAlta;
	
    
	
	//Constructores
    public Paciente(String nombre, int numeroTelefono, LocalDate fechaIngreso, LocalDate fechaAlta) {
		super();
		this.nombre = nombre;
		this.numeroTelefono = numeroTelefono;
		this.fechaIngreso = fechaIngreso;
		this.fechaAlta = fechaAlta;
	}



	
	//Getters y setters
    public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getNumeroTelefono() {
		return numeroTelefono;
	}



	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}



	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}



	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}



	public LocalDate getFechaAlta() {
		return fechaAlta;
	}



	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	
	
    
	
}
