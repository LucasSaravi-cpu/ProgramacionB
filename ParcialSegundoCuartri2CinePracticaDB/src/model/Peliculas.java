package model;

public class Peliculas {
	
	private String nombre;
	private String a�o;
	private String tipo;
	private int entradas;
	
	
	
	
	
	
	public Peliculas(String nombre, String a�o, String tipo, int entradas) {
		super();
		this.nombre = nombre;
		this.a�o = a�o;
		this.tipo = tipo;
		this.entradas = entradas;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getA�o() {
		return a�o;
	}
	public void setA�o(String a�o) {
		this.a�o = a�o;
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
		return  nombre +  "\t" + a�o + "\t" + tipo +  "\t        "  + entradas;
	}


	public float costoEntrada () {
		return 0;
	}

}
