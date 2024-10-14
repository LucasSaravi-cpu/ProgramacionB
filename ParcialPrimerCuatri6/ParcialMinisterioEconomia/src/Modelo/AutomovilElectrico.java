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
	        return super.calcularImpuesto(); 
	    }

	    
	    @Override
	    public String getTipo() {
	        return "Electrico"; 
	    }
		@Override
		public String toString() {
			return super.toString() +kilowattsHora+"kwh"+"\t\t" ;
		}

	
	}


