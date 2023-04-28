import java.util.Scanner;

/*Crear una sentencia switch dentro de un programa que imprima un mensaje para cada caso. 
Colocar un break en cada caso y testearlo. Luego remover el break y verificar que sucede. */

public class Ejercicio8 {

	public static void main(String[] args) {
	
		
		
        Scanner entrada=new Scanner(System.in);
		
		System.out.println("introduce numero");
		int dia=entrada.nextInt();
				
		switch(dia) {
			
			case 1: 
				System.out.println("lunes");
				break;                          //El break corta si no es correcto y sigue con el otro , si no esta copia todo
			case 2: 
				System.out.println("Martes");
				break;
			case 3: 
				System.out.println("Miercoles");
				break;
			case 4: 
				System.out.println("jueves");
				break;
			case 5: 
				System.out.println("Viernes");
			   break;
				
			default:
				System.out.println("No es un dia de la semana");
				break;
		}

	}

}
