package modelo;

public class Medicamento {
	
	private String codBarra;
	private String descripcion;
	private String presentacion;
	
	public Medicamento(String codBarra, String descripcion, String presentacion) {
		this.codBarra = codBarra;
		this.descripcion = descripcion;
		this.presentacion = presentacion;
	}
	
	public String getCodBarra() {
		return codBarra;
	}
	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	@Override
	public String toString() {
		return descripcion + " - " + presentacion;
	}
	
}
