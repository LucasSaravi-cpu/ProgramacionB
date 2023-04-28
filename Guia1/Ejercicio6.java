/*Escribir un programa que imprima los factoriales de los primeros diez números naturales. (n! = 
n * (n-1) * (n-2) * ... * 2 * 1 */


public class Ejercicio6 {

	public static void main(String[] args) {
	
	Integer numero;
	Integer fact;
	Integer i;
	
	for (numero=0; numero<=9 ; numero++  ) {
		
		fact=1;	
		
		if(numero<0) {
		   fact =0;}
		   else 
			  if(numero==0) {
				  fact=1;}
		        else {
		             for (i = 1; i <= numero; i++){
		                 fact = fact*i;
		                
		              }
		        }
		
		System.out.println(" Para el numero " + numero + " su factorial es "+ fact);
		             

	}
	}
}
