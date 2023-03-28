/*Escribir un programa que en el método main, solicite un nombre y muestre “Hola <nombre 
ingresado>” y debajo, la fecha y hora actual con el siguiente formato de ejemplo “viernes 
20/04/2018 18:00”. Validar que el mensaje no se muestre hasta tanto no se haya ingresado un 
nombre.*/

import java.time.LocalDateTime;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduce el nombre");
		
		String nombre=entrada.nextLine();
		
		if (nombre.length()>2)
		System.out.println("hola "+ nombre + "La hora y la fecha actual"+ LocalDateTime.now () );
		else
		System.out.println("No se ingreso ningun nombre");

}
}