/*Escribir un programa en el que se ingresen 2 cadenas e invocando a un método privado y 
estático de la clase, devuelva si son iguales o no. De acuerdo al resultado del método, mostrar 
en consola “Son iguales” o “Son distintas”. */

public class Ejercicio2 {

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
      
		String alumno1, alumno2;
	
        alumno1="lucas";
		
		alumno2="roberto";
		
		
		
	
		System.out.println(Ejercicio2.Devuelve(alumno1, alumno2)); // Puedo devolver Con clase o con objeto
	      
 		
	}
    
	
	private static String Devuelve(String alumno1 , String alumno2) {
		
		
		if (alumno1.equals(alumno2) ) {
			
			return "Son iguales";
	    
	 }
		else
			 return "Son diferentes";
	
}
}