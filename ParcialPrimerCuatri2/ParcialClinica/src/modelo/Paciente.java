package modelo;

public class Paciente {

	private String historiaClinica;
	private String nombre;
	
	public Paciente (String nombre, String historiaClinica) {
		this.nombre = nombre;
		this.setHistoriaClinica(historiaClinica);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return getHistoriaClinica() + " - " + getNombre();
	}

	public String getHistoriaClinica() {
		return historiaClinica;
	}

	public void setHistoriaClinica(String historiaClinica) {
		this.historiaClinica = historiaClinica;
	}
}
