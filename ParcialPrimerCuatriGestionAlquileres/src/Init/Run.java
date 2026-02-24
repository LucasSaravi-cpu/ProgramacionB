package Init;

import java.math.BigDecimal;
import java.util.Scanner;

import Control.Empresa;
import Model.Automovil;

public class Run {

	public static void main(String[] args) {
	
		
		Empresa empresa = new Empresa("Gestion de Alquier automovil",new BigDecimal("5000"),new BigDecimal("10"), new BigDecimal("2"), 300);
		
	    
		empresa.CrearInstancias();  
	    System.out.printf(empresa.listarAlquileres()+"\n");
	   
	    Scanner p= new Scanner(System.in);

	    System.out.println("Ingrese patente:");

	    String patente = p.nextLine().trim();
	    
	    
	    if(!empresa.existePatente(patente)){
	    	
	    	 System.out.println("Patente inexistente");	
	    }else {
	    	
	    	System.out.println("Cantidad de alquileres para a patente ingresada es : "+empresa.cantidadAlquileres(patente));
			System.out.println("Total facturado para la patente ingresada es :"+empresa.totalFacturado(patente));
			System.out.println("Promedios de kilometros para la patente ingresada son :" +empresa.promedioKms(patente));   
	    	
	    	
	    
	    }
	    
	    
	}

}
