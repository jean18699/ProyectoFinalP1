package Logico;

import java.util.ArrayList;

public class Programador extends Empleado {
	
	private ArrayList<String> especialidades;

	public Programador(String nombre, String apellidos, String sexo, int edad, String direccion, float salarioHora,
			String evaluacionAnual, ArrayList<String> especialidades) {
		super(nombre, apellidos, sexo, edad, direccion, salarioHora, evaluacionAnual);
		this.especialidades = especialidades;
		// TODO Auto-generated constructor stub
	}

		@Override
		String identificador() {
			
			return "PRG-";
		}



}
