package Logico;

import java.io.Serializable;

public class Planificador extends Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7389099020093531489L;
	private int frecuencia;
	
	public Planificador(String nombre, String apellidos, String sexo, int edad, String direccion, float salarioHora, int frecuencia) {
		super(nombre, apellidos, sexo, edad, direccion, salarioHora);
		this.frecuencia = frecuencia;
		
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}

	@Override
	String identificador() {
		return "PLN-";
	}

	@Override
	protected String getOcupacion() {
		return "Planificador";
	}

}
