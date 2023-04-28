
import java.util.Scanner;

/*Escribir un programa que muestre los números del 1 a N uno al lado del otro, separados por un 
espacio. N es un valor entero ingresado por teclado. */


public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("introduce numero");
		int numero=entrada.nextInt();
		
		for (int x=0 ; x<numero ; x++)
			System.out.print(x+" ");
	}

}
