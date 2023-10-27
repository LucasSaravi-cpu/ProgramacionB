package model;

public abstract class Compartimento {

	String Identificacion;
	String descripcion ;
	int capacidad;
	String ubicacion;
	
	public Compartimento(String identificacion, String descripcion, int capacidad, String ubicacion) {
		super();
		Identificacion = identificacion;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return  Identificacion + " - " + descripcion + ", capacidad : " + capacidad + " ubicacion=: " + ubicacion ;
	}
	
	
	public abstract String tipocompartimento();

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	
	
}
