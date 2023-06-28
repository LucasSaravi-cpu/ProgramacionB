package modelo.provincia.parametricas;

public class ParametrosLiquidacion {

	private float tasaSobreValuacionFiscal;
	private float valorM2Edificado;
	private float valorADescontarXAnioAntiguedadAutomotor;
	
	public ParametrosLiquidacion(float tasaSobreValuacionFiscal, float valorM2Edificado, float valorADescontarXAnioAntiguedadAutomotor) {
		this.setTasaSobreValuacionFiscal(tasaSobreValuacionFiscal);
		this.setValorM2Edificado(valorM2Edificado);
		this.setValorADescontarXAnioAntiguedadAutomotor(valorADescontarXAnioAntiguedadAutomotor);
	}

	public float getTasaSobreValuacionFiscal() {
		return tasaSobreValuacionFiscal;
	}

	public void setTasaSobreValuacionFiscal(float tasaSobreValuacionFiscal) {
		this.tasaSobreValuacionFiscal = tasaSobreValuacionFiscal;
	}

	public float getValorM2Edificado() {
		return valorM2Edificado;
	}

	public void setValorM2Edificado(float valorM2Edificado) {
		this.valorM2Edificado = valorM2Edificado;
	}

	public float getValorADescontarXAnioAntiguedadAutomotor() {
		return valorADescontarXAnioAntiguedadAutomotor;
	}

	public void setValorADescontarXAnioAntiguedadAutomotor(float valorADescontarXAnioAntiguedad) {
		this.valorADescontarXAnioAntiguedadAutomotor = valorADescontarXAnioAntiguedad;
	}

}
