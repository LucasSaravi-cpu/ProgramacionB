package modelo.carta;

import java.util.List;

import modelo.carta.parametricas.TipoItem;
import modelo.carta.parametricas.ParametrosValorizacion;

public class Receta extends ItemCartaGastronomica {
	private int tiempoPreparacion;
	private List<CantidadXIngrediente> ingredientes; 

	public Receta(String descripcion, TipoItem categoria, int tiempoPreparacion,
			List<CantidadXIngrediente> ingredientes) {
		super(descripcion, categoria);
		this.tiempoPreparacion = tiempoPreparacion;
		this.ingredientes = ingredientes;
	}

	@Override
	public float getPrecioVenta(ParametrosValorizacion parametros) {
		return (getCosto() + getTiempoPreparacion() * parametros.getCostoMinutoPreparacion()) * parametros.getMargenRecetas();
	}

	@Override
	public float getCosto() {
		float costo = 0;
		for(CantidadXIngrediente ingrediente : ingredientes) {
			costo = costo + ingrediente.getCantidad() * ingrediente.getIngrediente().getCosto();
		}
		return costo;
	}

	public int getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	public void setTiempoPreparacion(int tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}

	public List<CantidadXIngrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<CantidadXIngrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(" -");
		String delimiter = " ";
		for (CantidadXIngrediente ingrediente: this.ingredientes) {
			sb.append(delimiter);
			sb.append(ingrediente.getIngrediente().getDescripcion());
			delimiter = ", ";
		}
		sb.append("- ");
		return sb.toString();
	}
}
