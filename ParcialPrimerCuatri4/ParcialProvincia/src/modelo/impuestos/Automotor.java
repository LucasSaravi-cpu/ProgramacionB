package modelo.impuestos;

import modelo.provincia.parametricas.ParametrosLiquidacion;
import modelo.provincia.parametricas.Propietario;

public class Automotor extends Propiedad {
	
	private String marcaModelo;
	private int anioFabricacion;

	public Automotor(String idCatastral, Propietario propietario, float valuacionFiscal, String marcaModelo, int anioFabricacion) {
		super(idCatastral, propietario, valuacionFiscal);
		this.setMarcaModelo(marcaModelo);
		this.setAnioFabricacion(anioFabricacion);
	}

	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	public int getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\n");
		sb.append("\t");
		sb.append(String.format("Marca/Modelo: %s \tAño: %d", marcaModelo, anioFabricacion));
		return sb.toString();
	}

	@Override
	public ImpuestoAnual calcularImpuesto(int anio, ParametrosLiquidacion parametrosLiquidacion) {
		float impuestoBase = calcularImpuestoBase(parametrosLiquidacion);
		float valorImpuesto =  impuestoBase - ((anio - anioFabricacion) * parametrosLiquidacion.getValorADescontarXAnioAntiguedadAutomotor());
		if (valorImpuesto > 0) {
			return new ImpuestoAnual(anio, valorImpuesto, this);
		}
		return null;
	}

}
