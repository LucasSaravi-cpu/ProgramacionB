package Modelo;

	
	public class AutomovilElectrico extends Automovil {
	    private double kilowattsHora;

	    public AutomovilElectrico(String patente, int anioFabricacion, double valuacionFiscal, double kilowattsHora) {
	        super(patente, anioFabricacion, valuacionFiscal);
	        this.kilowattsHora = kilowattsHora;
	    }

	    public double getKilowattsHora() {
	        return kilowattsHora;
	    }

	    @Override
	    public double calcularImpuesto() {
	        double impuesto = super.calcularImpuesto();
	        return impuesto;
	    }

		@Override
		public String toString() {
			return "AutomovilElectrico [kilowattsHora=" + kilowattsHora + ", getPatente()=" + getPatente()
					+ ", getAnioFabricacion()=" + getAnioFabricacion() + ", getValuacionFiscal()="
					+ getValuacionFiscal() + "]";
		}
	}


