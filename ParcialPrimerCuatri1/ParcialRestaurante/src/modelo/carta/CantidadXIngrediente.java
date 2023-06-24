package modelo.carta;

import modelo.carta.parametricas.Ingrediente;

public class CantidadXIngrediente {

	private Ingrediente ingrediente;
	private float cantidad;
	
	public CantidadXIngrediente(Ingrediente ingrediente, float cantidad) {
		super();
		this.ingrediente = ingrediente;
		this.cantidad = cantidad;
	}
	
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ingrediente.getDescripcion());
		sb.append(": ");
		sb.append(cantidad + " " + ingrediente.getUnidadMedida().getDescripcion());
		sb.append(" (costo $" + ingrediente.getCosto() * cantidad + ")");
		return sb.toString();
	}
	
}
