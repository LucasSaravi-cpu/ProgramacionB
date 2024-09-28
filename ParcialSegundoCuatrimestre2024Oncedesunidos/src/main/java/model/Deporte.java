package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class Deporte {
	
	private long idDeporte;
	private String descripcion;
	private BigDecimal valor;
	
	
	
	
	
	public Deporte(long idDeporte, String description, BigDecimal bigDecimal) {
		super();
		this.idDeporte = idDeporte;
		this.descripcion = description;
		this.valor = bigDecimal;
	}
	public long getIdDeporte() {
		return idDeporte;
	}
	public void setIdDeporte(long idDeporte) {
		this.idDeporte = idDeporte;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String description) {
		this.descripcion = description;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	

	
	
	@Override
	public String toString() {
		return "Deporte [idDeporte=" + idDeporte + ", description=" + descripcion + ", valor=" + valor + "]";
	}
	
	
	

}
