package Controlador;


	
	import java.util.ArrayList;
	import java.util.List;

import Modelo.Automovil;

	public class MinisterioEconomia {
	    private List<Automovil> automoviles;

	    public MinisterioEconomia() {
	        automoviles = new ArrayList<>();
	    }

	    public void agregarAutomovil(Automovil automovil) {
	        automoviles.add(automovil);
	    }

	    public List<Automovil> getAutomoviles() {
	        return automoviles;
	    }

	    public double calcularTotalRecaudado() {
	        double total = 0;
	        for (Automovil automovil : automoviles) {
	            total += automovil.calcularImpuesto();
	        }
	        return total;
	    }

	    public double calcularImpuestoPromedio() {
	        if (automoviles.isEmpty()) {
	            return 0;
	        }
	        double total = calcularTotalRecaudado();
	        return total / automoviles.size();
	    }
	}


