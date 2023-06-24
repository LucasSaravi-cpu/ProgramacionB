package modelo.carta.parametricas;

public class Ingrediente {
	
	private String descripcion;
	private float costo;
	private UnidadMedida unidadMedida;
	
	public Ingrediente(String descripcion, float costo, UnidadMedida unidadMedida) {
		super();
		this.descripcion = descripcion;
		this.costo = costo;
		this.unidadMedida = unidadMedida;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	@Override
	public String toString() {
		return descripcion + " (" + unidadMedida.getDescripcion() + ")";
	}
	
}
