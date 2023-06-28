package modelo;

public class Universidad {
	
	private int idUniversidad;
	private String nombre;
	private boolean publica;
	
	public Universidad(int idUniversidad, String nombre, boolean publica) {
		super();
		this.setIdUniversidad(idUniversidad);
		this.setNombre(nombre);
		this.setPublica(publica);
	}
	public int getIdUniversidad() {
		return idUniversidad;
	}
	public void setIdUniversidad(int idUniversidad) {
		this.idUniversidad = idUniversidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isPublica() {
		return publica;
	}
	public void setPublica(boolean publica) {
		this.publica = publica;
	}
	
	@Override
	public String toString() {
		
		
		
		return nombre ;
	}
}
