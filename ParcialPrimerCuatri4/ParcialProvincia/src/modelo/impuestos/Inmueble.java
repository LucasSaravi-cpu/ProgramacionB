package modelo.impuestos;

import modelo.provincia.parametricas.ParametrosLiquidacion;
import modelo.provincia.parametricas.Propietario;

public class Inmueble extends Propiedad {
	
	private String domicilioInmueble;
	private int m2Terreno;
	private int m2Edificado;

	public Inmueble(String idCatastral, Propietario propietario, float valuacionFiscal, String domicilioInmueble, int m2Terreno, int m2Edificado) {
		super(idCatastral, propietario, valuacionFiscal);
		this.domicilioInmueble = domicilioInmueble;
		this.m2Terreno = m2Terreno;
		this.m2Edificado = m2Edificado;
	}

	public String getDomicilioInmueble() {
		return domicilioInmueble;
	}

	public void setDomicilioInmueble(String domicilioInmueble) {
		this.domicilioInmueble = domicilioInmueble;
	}

	public int getM2Terreno() {
		return m2Terreno;
	}

	public void setM2Terreno(int m2Terreno) {
		this.m2Terreno = m2Terreno;
	}

	public int getM2Edificado() {
		return m2Edificado;
	}

	public void setM2Edificado(int m2Edificado) {
		this.m2Edificado = m2Edificado;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\n");
		sb.append("\t");
		sb.append(String.format("Domicilio: %s \tTerreno(m2): %d \tEdificado(m2): %d", domicilioInmueble, m2Terreno, m2Edificado));
		return sb.toString();
	}

	@Override
	public ImpuestoAnual calcularImpuesto(int anio, ParametrosLiquidacion parametrosLiquidacion) {
		float valorImpuesto = calcularImpuestoBase(parametrosLiquidacion) + m2Edificado * parametrosLiquidacion.getValorM2Edificado();
		if (valorImpuesto > 0) {
			return new ImpuestoAnual(anio, valorImpuesto, this);
		}
		return null;
	}
}
