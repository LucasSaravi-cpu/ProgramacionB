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

	   
	    
	    public double calcularTotalRecaudado(List<Automovil> automovilesFiltrados) {
	        double total = 0;
	        for (Automovil automovil : automovilesFiltrados) {
	            total += automovil.calcularImpuesto();
	        }
	        return total;
	    }

	    public double calcularImpuestoPromedio(List<Automovil> automovilesFiltrados) {
	        if (automovilesFiltrados.isEmpty()) {
	            return 0;
	        }
	        double total = calcularTotalRecaudado(automovilesFiltrados);
	        return total / automovilesFiltrados.size();
	    }
	    
	    public String Listar(List<Automovil> automovilesFiltrados) {
	    	 
	    	 StringBuilder sb = new StringBuilder();
	    	 
	    	 for (Automovil auto : automovilesFiltrados) {
	    	 
	    		
	    		 sb.append(auto.toString() +"\t"+ " impuesto a pagar $" + auto.calcularImpuesto()+ "\n");
	    	 }
	    	 
	    	 sb.append("calcular Total Recaudado $"+ calcularTotalRecaudado(automovilesFiltrados) + "\n");
	    	 sb.append("calcular Total Recaudado $"+ calcularImpuestoPromedio(automovilesFiltrados)+"\n");
	    	 
	    	
	    	 
	    	 return sb.toString();
	    	 
	     }
	    
	}


