package modelo;

public class Alumno {
	
	private int id;
	private String nombre;
	private Universidad universidad;
	
	public Alumno(int id, String nombre, Universidad universidad) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setUniversidad(universidad);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

	@Override
	public String toString() {
		return nombre + " - " + universidad.getNombre();
	}

}
