package Modelo;


	public class AutomovilCombustible extends Automovil {
	    private int cilindrada;
	    private Combustible Combustible;

	    public AutomovilCombustible(String patente, int anioFabricacion, double valuacionFiscal, int cilindrada, Combustible Combustible) {
	        super(patente, anioFabricacion, valuacionFiscal);
	        this.cilindrada = cilindrada;
	        this.Combustible = Combustible;
	    }

	    public int getCilindrada() {
	        return cilindrada;
	    }

	    public Combustible getCombustible() {
	        return Combustible;
	    }

	    @Override
	    public double calcularImpuesto() {
	        double impuesto = super.calcularImpuesto();
	        if (Combustible ==  Combustible.NAFTA && cilindrada > 4) {
	            impuesto += 0.1 * (cilindrada - 4) * super.getValuacionFiscal();
	        } else if (Combustible == Combustible.DIESEL && cilindrada > 6) {
	            impuesto += 0.1 * (cilindrada - 6) * super.getValuacionFiscal();
	        }
	        return impuesto;
	    }

		public void setCilindrada(int cilindrada) {
			this.cilindrada = cilindrada;
		}

		public void setCombustible(Combustible combustible) {
			Combustible = combustible;
		}

		@Override
		public String toString() {
			return "AutomovilCombustible [cilindrada=" + cilindrada + ", Combustible=" + Combustible + ", getPatente()="
					+ getPatente() + ", getAnioFabricacion()=" + getAnioFabricacion() + ", getValuacionFiscal()="
					+ getValuacionFiscal() + "]";
		}

		

		
	}
	
	


