import java.util.ArrayList;

public class Uso_Empresa {

	public static void main(String[] args) {
	
		Empresa empresa = new Empresa();
		
	    Cliente cliente1 = new Cliente("Carlos", "14/01/1990", "996991992", 900.0);
	    Cliente cliente2 = new Cliente("Juan", "22/12/1995", "225447411", 0.0);
	    
	    Empleado empleado1 = new Empleado("Fernando", "12/11/1986", 11111.0);
        Empleado empleado2 = new Empleado("Andrea","12/11/1955", 22222.0);
        Empleado empleado3 = new Empleado("Mario", ":01/11/1986",44444.0);
	       
        
        
	    empresa.getListaCliente().add(cliente1);
	    empresa.getListaCliente().add(cliente2);	    
	    empresa.getListaEmpleado().add(empleado1);
	    empresa.getListaEmpleado().add(empleado2);
	    empresa.getListaEmpleado().add(empleado3);
	    
	    
	    Directivo directivo1 = new Directivo("Macherano", "30/08/1960",  33333.0 , "DIRECTIVO");
	    Directivo directivo2 = new Directivo("Clara", "12/12/197", 55555.0, "GerenciaDIRECTIVO");
	    
	    directivo1.getEmpleadosACargo().add(empleado1);
	    directivo2.getEmpleadosACargo().add(empleado2);
	    directivo2.getEmpleadosACargo().add(empleado3);
	    
	    
		
	 //Se crea una lista de personas general
	    
	 ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	 
	 listaPersonas.add(cliente1);
	 listaPersonas.add(cliente2);
	 listaPersonas.add(empleado1);
	 listaPersonas.add(empleado2);
	 listaPersonas.add(empleado3);
     listaPersonas.add(directivo1);
	 listaPersonas.add(directivo2);

	  System.out.println("PERSONAS");
      for (Persona persona : listaPersonas) {
    	  
    	  //Cada objeto llama a su propio metodo
          System.out.println(persona.toString());
      }
	   
   // Mostrar información dividida por tipo
      System.out.println("CLIENTES");
      for (Persona persona :  listaPersonas) {
          if (persona instanceof Cliente) {
              System.out.println(persona.toString());
          }
      }

      System.out.println("\nEMPLEADOS");
      for (Persona persona : listaPersonas) {
          if (persona instanceof Empleado || (persona instanceof Directivo)) {
              System.out.println(persona.toString());
          }
      }     
	        
	        
	}
}
	    
	
		        
		
	


