import java.util.Scanner;

/*Escribir un programa que calcule la ra�z cuadrada de un n�mero real y muestre su parte 
entera. �C�mo modificar�a el programa para que el resultado se redondee al entero m�s 
pr�ximo?*/


public class Ejercicio9 {

	public static void main(String[] args) {

        Scanner entrada=new Scanner(System.in);
		
		System.out.println("introduce numero");
		float num=entrada.nextInt();
		
	
		
		System.out.println("La raiz cuadrada del numero "+num + " es " + (int)Math.sqrt(num) );


}
}
