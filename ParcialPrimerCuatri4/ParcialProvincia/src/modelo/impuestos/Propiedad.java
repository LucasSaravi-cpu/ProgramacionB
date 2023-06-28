package modelo.impuestos;

import modelo.provincia.parametricas.ParametrosLiquidacion;
import modelo.provincia.parametricas.Propietario;

public abstract class Propiedad {
	
	private String idCatastral;
	private float valuacionFiscal;
	private Propietario propietario;

	public Propiedad(String idCatastral, Propietario propietario, float valuacionFiscal) {
		this.setIdCatastral(idCatastral);
		this.setValuacionFiscal(valuacionFiscal);
		this.setPropietario(propietario);
	}
	
	public String getIdCatastral() {
		return idCatastral;
	}

	public void setIdCatastral(String idCatastral) {
		this.idCatastral = idCatastral;
	}

	public float getValuacionFiscal() {
		return valuacionFiscal;
	}

	public void setValuacionFiscal(float valuacionFiscal) {
		this.valuacionFiscal = valuacionFiscal;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	public float calcularImpuestoBase(ParametrosLiquidacion parametrosLiquidacion) {
		return valuacionFiscal * parametrosLiquidacion.getTasaSobreValuacionFiscal(); 
	}
	
	public abstract ImpuestoAnual calcularImpuesto(int anio, ParametrosLiquidacion parametrosLiquidacion);
	
	public String toString() {
		return String.format("Id.Catastral: %s \t Val.Fiscal: %f \t Propietario: %s", idCatastral, valuacionFiscal, propietario.toString());
	}

}
