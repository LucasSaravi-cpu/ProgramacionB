

/*Escribir un programa que imprima tres argumentos tomados desde la l�nea de comando. 
Para hacer esto, necesitar� usar los �ndices del arreglo de strings que recibe como par�metro. 
Asegurarse de que se reciban al menos tres par�metros antes de imprimirlos. */


public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	String nombre = new String("Lucas");
		String apellido= new String("Saravi");
		Integer edad = new Integer (28);
		
		System.out.println("Mi nombre "+ nombre + apellido + " mi edad es " + edad +"a�os");
		

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
