/*Definir una clase que posea un método al que se le pasen 2 números enteros como 
parámetros y devuelva el resultado de la suma, el producto y la resta de los mismos. */


public class Ejercicio5 {

	public static void main(String[] args) {
		
		float num1 = 45;
		float num2 = 20;
		
		Ejercicio5 Resultado= new Ejercicio5();
		
		System.out.println(Resultado.Devuelve(num1, num2));

	}

	
	
	public String Devuelve(float num1 , float num2) {
		
		float suma = num1+num2;
		float resta = num1-num2;
		float multi = num1*num2;
		
   return "la suma es igual a " +suma +" la resta es igual a " +resta + "y la multipliccacion es igual a " +multi;

}
}