package modelo.categorias;

import modelo.parametricas.Meses.Mes;

public class Floral extends Especie {

	Mes mesFloracion;
	
	public Floral(String nombre, int vida, int alturaMax, float precioBase, Mes mesFloracion) {
		super(nombre, vida, alturaMax, precioBase);
		this.mesFloracion = mesFloracion;
	}

	@Override
	public float getPrecioVenta() {
		return super.getPrecioBase();
	}

	public Mes getMesFloracion() {
		return mesFloracion;
	}

	public void setMesFloracion(Mes mesFloracion) {
		this.mesFloracion = mesFloracion;
	}

	@Override
	public String toString() {
		return "Floral mes de floracion: " + mesFloracion +  super.toString() + "\n";
	}
	
	
}
