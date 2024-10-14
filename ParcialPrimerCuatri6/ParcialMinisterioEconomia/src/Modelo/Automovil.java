package Modelo;

public abstract class Automovil {
	
    private String patente;
    private int anioFabricacion;
    private double valuacionFiscal;

    public Automovil(String patente, int anioFabricacion, double valuacionFiscal) {
        this.patente = patente;
        this.anioFabricacion = anioFabricacion;
        this.valuacionFiscal = valuacionFiscal;
    }

    public String getPatente() {
        return patente;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public double getValuacionFiscal() {
        return valuacionFiscal;
    }

    public double calcularImpuesto() {
        if (anioFabricacion < 2000) {
            return 0; 
        }
        return 0.05 * valuacionFiscal; 
    }
    
    public abstract String getTipo();
    
    
    
    
	public void setPatente(String patente) {
		this.patente = patente;
	}

	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public void setValuacionFiscal(double valuacionFiscal) {
		this.valuacionFiscal = valuacionFiscal;
	}

	@Override
	public String toString() {
		return  patente + "\t" +"Anio" +anioFabricacion + "\t"+"ValuacionFiscal : " +valuacionFiscal + "\t";
	}


	
    
    
    
    
    
}

