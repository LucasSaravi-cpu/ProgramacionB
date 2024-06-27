import java.util.ArrayList;

public class Uso_Empresa {

	public static void main(String[] args) {
	
		  ArrayList<Persona> listaPersonas = new ArrayList<>(); // Se crea una lista de personas en general 

		    
		    Empleado empleado1 = new Empleado("Fernando", "12/11/1986", 11111.0);
	        Empleado empleado2 = new Empleado("Andrea","12/11/1955", 22222.0);
	        Directivo directivo1 = new Directivo("Macherano", "30/08/1960",  33333.0 , "DIRECTIVO", new ArrayList<>());
	        ArrayList<Empleado> empleadosACargo = new ArrayList<>();
	        
	        empleadosACargo.add(empleado1);
	        empleadosACargo.add(empleado2);
	        
	        directivo1.getEmpleadosACargo().addAll(empleadosACargo);  //El directivo1 tiene una lista de empleadosAcargo

	       

	        Empleado empleado3 = new Empleado("Mario", ":01/11/1986",44444.0);
	       
	        Directivo directivo2 = new Directivo("Clara", "12/12/197", 55555.0, "GerenciaDIRECTIVO", new ArrayList<>());

	        
	        
	        Cliente cliente1 = new Cliente("Carlos", "14/01/1990", "996991992", 900.0);
	        Cliente cliente2 = new Cliente("Juan", "22/12/1995", "225447411", 0.0);

	        ArrayList<Empleado> empleadosACargo2 = new ArrayList<>();
	        empleadosACargo2.add(empleado3);
	        directivo2.getEmpleadosACargo().addAll(empleadosACargo2);

	        listaPersonas.add(empleado1); // Se agregan a la lista en general de personas
	        listaPersonas.add(empleado2);
	        listaPersonas.add(directivo1);
	        
	        listaPersonas.add(empleado3);
	        listaPersonas.add(directivo2);
	        listaPersonas.add(cliente1);
	        listaPersonas.add(cliente2);
	    

	   
	        System.out.println("Clientes:");
	        for (Persona persona : listaPersonas) {
	            if (persona instanceof Cliente) {
	                System.out.println(persona.toString());
	            }
	        }
	        System.out.println();
	        System.out.println("Empleados ");
	        for (Persona persona : listaPersonas) {
	            if (persona instanceof Empleado || persona instanceof Directivo) {
	                System.out.println(persona.toString());
	            }
	        }
	       
	        
	        
	}
}
	    
	
		        
		
	


