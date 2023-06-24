package modelo.carta.parametricas;

public class TipoItem {

	private String descripcion;
	private int ordenEnCarta;
	
	public TipoItem(String descripcion, int ordenEnCarta) {
		super();
		this.descripcion = descripcion;
		this.ordenEnCarta = ordenEnCarta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getOrdenEnCarta() {
		return ordenEnCarta;
	}

	public void setOrdenEnCarta(int ordenEnCarta) {
		this.ordenEnCarta = ordenEnCarta;
	}
	
	@Override
	public String toString() {
		return this.descripcion;
	}
	
}
