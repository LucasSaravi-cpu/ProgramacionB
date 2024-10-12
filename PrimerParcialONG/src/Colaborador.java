import java.util.List;

public abstract class Colaborador {
	
	private String nombre;
	private int anioIngreso;
	
	
	
	
	public Colaborador(String nombre, int anioIngreso) {
		super();
		this.nombre = nombre;
		this.anioIngreso = anioIngreso;
		
	}

	
   


	public abstract String TipoColaborador() ;	
	public abstract double getCosto();
    public abstract List<Colaboracion> getColaboraciones();


	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public int getAnioIngreso() {
		return anioIngreso;
	}




	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;
	}




	

}
