package Modelo;

public class Automovil {
	
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
        double impuesto = 0;
        if (anioFabricacion >= 2000) {
            impuesto = 0.05 * valuacionFiscal;
        }
        return impuesto;
    }

    
    
    
    
    
    
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
		return "Automovil [patente=" + patente + ", anioFabricacion=" + anioFabricacion + ", valuacionFiscal="
				+ valuacionFiscal + "]";
	}

	
    
    
    
    
    
}

