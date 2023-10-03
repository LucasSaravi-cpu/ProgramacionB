package model;

public class Peliculas {
	
	private String nombre;
	private String año;
	private String tipo;
	private int entradas;
	
	
	
	
	
	
	public Peliculas(String nombre, String año, String tipo, int entradas) {
		super();
		this.nombre = nombre;
		this.año = año;
		this.tipo = tipo;
		this.entradas = entradas;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getEntradas() {
		return entradas;
	}
	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}
	
	
	@Override
	public String toString() {
		return  nombre +  "\t" + año + "\t" + tipo +  "\t        "  + entradas;
	}


	public float costoEntrada () {
		return 0;
	}

}
