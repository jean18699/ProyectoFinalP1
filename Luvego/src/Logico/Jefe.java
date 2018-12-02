package Logico;

import java.io.Serializable;

public class Jefe extends Empleado implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 655412545224648646L;
	private int cantTrabajadores;
	
	public Jefe(String nombre, String apellidos, String sexo, int edad, String direccion, float salarioHora) {
		super(nombre, apellidos, sexo, edad, direccion, salarioHora);
		
	}

	public int getCantTrabajadores() {
		return cantTrabajadores;
	}

	public void setCantTrabajadores(int cantTrabajadores) {
		this.cantTrabajadores = cantTrabajadores;
	}

	public String getOcupacion() {
		return "Jefe de proyectos";
	}

	@Override
	String identificador() {
		
		return "JFE-";
	}

	
}
