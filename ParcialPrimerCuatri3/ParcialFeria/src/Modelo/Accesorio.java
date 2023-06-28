package Modelo;

public class Accesorio {
	private String descripcion;
	private float valorAlquiler;
	
	public Accesorio(String descripcion, float valorAlquiler) {
		this.setDescripcion(descripcion);
		this.setValorAlquiler(valorAlquiler);
	}

	public float getValorAlquiler() {
		return valorAlquiler;
	}

	public void setValorAlquiler(float valorAlquiler) {
		this.valorAlquiler = valorAlquiler;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return getDescripcion() + " ($ " + String.format("%.2f", valorAlquiler) + " )";
	}
}
