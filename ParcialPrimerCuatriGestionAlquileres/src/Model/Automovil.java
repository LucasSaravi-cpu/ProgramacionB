package Model;

import java.math.BigDecimal;

public class Automovil {
	
	
	private String patente;
    private String marcaModelo;
    private BigDecimal costoPorDiaLimitado;
    private BigDecimal costoPorDiaLibre;

    public Automovil(String patente, String marcaModelo,BigDecimal costoPorDiaLimitado,BigDecimal costoPorDiaLibre) {
        this.patente = patente;
        this.marcaModelo = marcaModelo;
        this.costoPorDiaLimitado = costoPorDiaLimitado;
        this.costoPorDiaLibre = costoPorDiaLibre;
    }

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	public BigDecimal getCostoPorDiaLimitado() {
		return costoPorDiaLimitado;
	}

	public void setCostoPorDiaLimitado(BigDecimal costoPorDiaLimitado) {
		this.costoPorDiaLimitado = costoPorDiaLimitado;
	}

	public BigDecimal getCostoPorDiaLibre() {
		return costoPorDiaLibre;
	}

	public void setCostoPorDiaLibre(BigDecimal costoPorDiaLibre) {
		this.costoPorDiaLibre = costoPorDiaLibre;
	}

	@Override
	public String toString() {
		return "Automovil Patente:" + patente + ", Modelo :" + marcaModelo ;
	}
    
    
    

}
