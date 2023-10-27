package modelo.personas;

import java.util.Date;

public class Paciente extends Persona {
	private String domicilio;

	public Paciente(int dni, String nombre, Date fechaNacimiento, String domicilio) {
		super(dni, nombre, fechaNacimiento);
		this.setDomicilio(domicilio);
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getDescripcionTipoPaciente() {
		if (getEdad() >= 18) {
			return "Adulto";
		}
		else {
			return "Pediatrico";
		}
	}

}
