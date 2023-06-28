package modelo;

public class Profesional {
	private String nombre;
	private int matricula;

	private String especialidad;
	
	public Profesional(String nombre, int matricula, String especialidad) {
		this.setNombre(nombre);
		this.setMatricula(matricula);
		this.setEspecialidad(especialidad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	
	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return getNombre() + " - " + getEspecialidad() + " (Mat. " + String.format("%d", matricula) + " )";
	}

}
