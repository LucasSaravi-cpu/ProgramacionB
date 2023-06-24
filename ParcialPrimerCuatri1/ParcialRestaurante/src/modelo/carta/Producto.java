package modelo.carta;

import java.io.Serializable;

import modelo.carta.parametricas.TipoItem;
import modelo.carta.parametricas.ParametrosValorizacion;

public class Producto extends ItemCartaGastronomica {
	
	private static final long serialVersionUID = 8072416325076633029L;
	private float costo;

	public Producto(String descripcion, TipoItem categoria, float costo) {
		super(descripcion, categoria);
		this.costo = costo;
	}

	@Override
	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		return sb.toString();
	}

	@Override
	public float getPrecioVenta(ParametrosValorizacion parametros) {
		return getCosto() * parametros.getMargenProductos();
	}

}
