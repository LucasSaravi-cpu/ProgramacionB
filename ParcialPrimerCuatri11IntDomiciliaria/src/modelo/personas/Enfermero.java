package modelo.personas;

import java.util.Date;
import java.util.List;

import modelo.parametricas.Especialidad;
import modelo.parametricas.DiasSemana.Dia;

public class Enfermero extends Profesional {

	private boolean universitario;

	public Enfermero(int dni, String nombre, Date fechaNacimiento, String prefijo, String matricula, Especialidad especialidad, boolean universitario) {
		super(dni, nombre, fechaNacimiento, prefijo, matricula, especialidad);
		this.setUniversitario(universitario);
	}

	public boolean isUniversitario() {
		return universitario;
	}

	public void setUniversitario(boolean universitario) {
		this.universitario = universitario;
	}

	
	@Override
	public String toString() {
		return super.toString() + (isUniversitario() ? " (U)" : "");
	}
	
	
//Fucion getCostoSemanal 	
	
	@Override
	public float getCostoSemanal(List<Dia> diasAtencion) {
		int x=0, costoVisita= 500;
		for(int i=0; i< diasAtencion.size(); i++) { //calculo costo total de la semana 
			x+=costoVisita;
		}
		
		if (this.isUniversitario()) {
			return x=(int) (x*1.2); //Si el Enfermero es  UNIVERSITARIO entonces se incrementa un 20%
		}else {
			return x;
		}
	}
	
	

}
