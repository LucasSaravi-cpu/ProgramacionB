package modelo.personas;

import java.util.Date;
import java.util.List;

import modelo.parametricas.DiasSemana.Dia;
import modelo.parametricas.Especialidad;

public abstract class Profesional extends Persona {

	private String prefijo;
	private String matricula;
	private Especialidad especialidad;
	
	public Profesional(int dni, String nombre, Date fechaNacimiento, String prefijo, String matricula, Especialidad especialidad) {
		super(dni, nombre, fechaNacimiento);
		this.setPrefijo(prefijo);
		this.setMatricula(matricula);
		this.setEspecialidad(especialidad);
	}

	public abstract float getCostoSemanal(List<Dia> diasAtencion);
	
	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	@Override
	public String toString() {
		return prefijo + " " + getNombre() + " (" + getEspecialidad().getNombre() + ")";
	}
}
