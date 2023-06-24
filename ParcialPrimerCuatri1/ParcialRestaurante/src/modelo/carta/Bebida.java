package modelo.carta;

import java.io.Serializable;

import modelo.carta.parametricas.TipoItem;

public class Bebida extends Producto {

	private static final long serialVersionUID = 2511611651946263856L;
	private float volumen;

	public Bebida(String descripcion, TipoItem categoria, float costo, float volumen) {
		super(descripcion, categoria, costo);
		this.volumen = volumen;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(" (");
		sb.append(getVolumen());
		sb.append(") ");
		return sb.toString();
	}

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

}
