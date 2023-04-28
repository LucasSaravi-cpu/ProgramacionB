

/*Escribir un programa que imprima tres argumentos tomados desde la línea de comando. 
Para hacer esto, necesitará usar los índices del arreglo de strings que recibe como parámetro. 
Asegurarse de que se reciban al menos tres parámetros antes de imprimirlos. */


public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	String nombre = new String("Lucas");
		String apellido= new String("Saravi");
		Integer edad = new Integer (28);
		
		System.out.println("Mi nombre "+ nombre + apellido + " mi edad es " + edad +"años");
		

	}*/
	
		
		 if (args.length < 3) {
	            System.out.println("Se necesitan al menos tres argumentos.");
	            return;
	        }
	        System.out.println("Argumento 1: " + args[0]);
	        System.out.println("Argumento 2: " + args[1]);
	        System.out.println("Argumento 3: " + args[2]);
		
	}

}
