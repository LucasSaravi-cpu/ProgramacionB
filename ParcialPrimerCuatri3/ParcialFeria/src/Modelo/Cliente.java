package Modelo;

public class Cliente {
	private String cuit;
	private String nombre;
	
	public Cliente (String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return getCuit() + " - " + getNombre();
	}
}
