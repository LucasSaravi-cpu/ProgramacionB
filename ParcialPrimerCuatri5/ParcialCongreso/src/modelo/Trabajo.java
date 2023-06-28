package modelo;

public abstract class Trabajo {
	
	

	private String titulo;
	private int Fecha;
	private AreaTematica areatematica;
	
	
	public Trabajo(String titulo, int fecha, AreaTematica areatematica) {
		super();
		this.titulo = titulo;
		this.setFecha(fecha);
		this.setAreatematica(areatematica);
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public abstract double CalcularTarifa ();


	public int getFecha() {
		return Fecha;
	}


	public void setFecha(int fecha) {
		Fecha = fecha;
	}


	public AreaTematica getAreatematica() {
		return areatematica;
	}


	public void setAreatematica(AreaTematica areatematica) {
		this.areatematica = areatematica;
	}


	


	@Override
	public String toString() {
		return "    " + titulo + ",   Fecha : " + Fecha + "   " + areatematica ;
	}





}
