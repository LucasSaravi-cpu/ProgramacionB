package modelo.categorias;

import java.time.LocalDate;

public class Ejemplar {

	private int codigoBarra;
	private float anioProduccion;
	private Especie especie;
	
	public Ejemplar(int codigoBarra, float anioProduccion, Especie especie) {
		this.codigoBarra = codigoBarra;
		this.anioProduccion = anioProduccion;
		this.especie = especie;
	}
	/**
	 * si la antiguedad del ejemplar supera la mitad de la vida para la especie,
	 * @return true
	 */
	public boolean esAntiguo () {
		if (LocalDate.now().getYear() - anioProduccion < especie.getVidaEsperada()*0.5) {
			return true;
		}
		return false;	
	}
	
	public float GetPrecioVenta() {
		float precio = especie.getPrecioVenta();
		
		if (this.esAntiguo()) { //si es antiguo, se le aplica un 50% de descuento
			precio = (float) (precio * 0.5); 
		}
		return precio;
	}
	public Object getEspecie() {
		return this.especie;
	}
	@Override
	public String toString() {
		return "codigoBarra: " + codigoBarra + ", año de produccion: " + anioProduccion + ", especie:" + especie.toString()
				+ "\n";
	}
	
	
}
