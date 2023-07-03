package controlador;
import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.List;

import model.RunEmpresa;
import modeloclases.Area;
import modeloclases.Compartimento;
import modeloclases.Estanteria;
import modeloclases.Refrigerado;

public class Empresa {
	
	private String nombre;
	private List<Area> areas;
	
	
	
	
	
	public Empresa(String nombre) {
		super();
		this.nombre = nombre;
		areas = new ArrayList<>();
	}



	public void agregarArea(Area area) {
		   areas.add(area);
		}

		public List<Area> getAreas() {
		    return areas;
		}


public String ShowInformationCostosDiarios() {	
	StringBuilder result = new StringBuilder();
	DecimalFormat decimalFormat = new DecimalFormat("#0.00");
	double costoTotal=0;
	double max=0;
	for (Area a: areas) {
		result.append(a.toString()+ "\n");
		RunEmpresa.agregarCantidadesRandom(a);
	   for (Compartimento com : a.getCompartimento()) {
			double costodiario=0;
		   if (com instanceof Estanteria) {
			   costodiario = ((Estanteria) com).costoEstanteria() + com.costoBase();
			  
			   result.append(com.toString() + " costo " +  decimalFormat.format(costodiario)+"\n");  	    	
		   }
		   else
			   if(com instanceof Refrigerado) {
				   costodiario = ((Refrigerado) com).costoRefrigerado() + com.costoBase();
				   result.append(com.toString() + " Costo " +  decimalFormat.format(costodiario)+"\n");
				  
			   }
		   
		   if (costodiario>max) {
			   max=costodiario;
		   }
		   
		   costoTotal = costoTotal+ costodiario;
	   }
	}
	
	result.append("COSTO TOTAL  " +decimalFormat.format(costoTotal)+"\n");	
	result.append("El maximo costo diario es " +decimalFormat.format(max) + "\n");
	return result.toString();
}
	

	


public void agregar(Area area) {
   areas.add(area);
}

public List<Area> getArea() {
    return areas;
}


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}









	
	
	
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", areas=" + areas + "]";
	}
	
	
	
	
	

}
