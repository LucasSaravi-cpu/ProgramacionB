
/* Crear una clase PracticaExcepciones con un m�todo est�tico dividir(int dividendo, int 
divisor). Invocarlo pasando 10 y 2 como par�metros, y luego 10 y 0. Analizar lo sucedido. 
Implementar alg�n cambio para que el programa no finalice abruptamente su ejecuci�n y 
muestre un mensaje m�s claro para el usuario.*/

public class PracticaExcepciones {
	

	    public static void dividir(int dividendo, int divisor) {
	        try {
	            int resultado = dividendo / divisor;
	            System.out.println("El resultado de la divisi�n es: " + resultado);
	        } catch (ArithmeticException e) {
	            System.out.println("Error: No se puede dividir por cero.");
	        }
	    }
	    
	    
	    public static void main(String[] args) {
	        dividir(10, 2);
	        dividir(10, 0);
	    }
}



