package modelo.carta.parametricas;

public class ParametrosValorizacion {

	private float costoMinutoPreparacion;
	private float margenProductos;
	private float margenRecetas;
	
	public ParametrosValorizacion(float costoMinutoPreparacion, float margenProductos, float margenRecetas) {
		this.costoMinutoPreparacion = costoMinutoPreparacion;
		this.margenProductos = margenProductos;
		this.margenRecetas = margenRecetas;
	}

	public float getCostoMinutoPreparacion() {
		return costoMinutoPreparacion;
	}

	public void setCostoMinutoPreparacion(float costoMinutoPreparacion) {
		this.costoMinutoPreparacion = costoMinutoPreparacion;
	}

	public float getMargenProductos() {
		return margenProductos;
	}

	public void setMargenProductos(float margenProductos) {
		this.margenProductos = margenProductos;
	}

	public float getMargenRecetas() {
		return margenRecetas;
	}

	public void setMargenRecetas(float margenRecetas) {
		this.margenRecetas = margenRecetas;
	}

}
