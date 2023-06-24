package modelo.carta;

import java.io.Serializable;

import modelo.carta.parametricas.TipoItem;

public class Vino extends Bebida {
	
	private static final long serialVersionUID = 3320319739084609654L;
	private String varietal;
	private String procedencia;


	public Vino(String descripcion, TipoItem categoria, float costo, float volumen, String varietal, String procedencia) {
		super(descripcion, categoria, costo, volumen);
		this.varietal = varietal;
		this.procedencia = procedencia;
	}

	public String getVarietal() {
		return varietal;
	}

	public void setVarietal(String varietal) {
		this.varietal = varietal;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(" - " + this.varietal + " / " + this.procedencia + "-");
		return sb.toString();
	}

}
