package persistencia;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 2224376226125647874L;
	
	private String nombre;
	private String domicilio;
	private BigDecimal saldo;

	public Cliente(String nombre, String domicilio, BigDecimal saldo) {
		super();
		this.setNombre(nombre);
		this.setDomicilio(domicilio);
		this.setSaldo(saldo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return nombre + " / " + domicilio +  " / " + saldo.toString();
	}
	
}
