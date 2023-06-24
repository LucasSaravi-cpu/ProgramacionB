package modelo.carta;

import java.io.Serializable;

import modelo.carta.parametricas.TipoItem;
import modelo.carta.parametricas.ParametrosValorizacion;

public abstract class ItemCartaGastronomica {

	private String descripcion;
	private TipoItem categoria;
	
	public abstract float getPrecioVenta(ParametrosValorizacion parametros);
	public abstract float getCosto();
	
	public ItemCartaGastronomica(String descripcion, TipoItem categoria) {
		super();
		this.descripcion = descripcion;
		this.categoria = categoria;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public TipoItem getCategoria() {
		return categoria;
	}
	
	public void setCategoria(TipoItem categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.descripcion);
		return sb.toString();
	}

	
}
