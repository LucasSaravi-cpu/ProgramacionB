
/* Crear una clase PracticaExcepciones con un método estático dividir(int dividendo, int 
divisor). Invocarlo pasando 10 y 2 como parámetros, y luego 10 y 0. Analizar lo sucedido. 
Implementar algún cambio para que el programa no finalice abruptamente su ejecución y 
muestre un mensaje más claro para el usuario.*/

public class PracticaExcepciones {
	

	    public static void dividir(int dividendo, int divisor) {
	        try {
	            int resultado = dividendo / divisor;
	            System.out.println("El resultado de la división es: " + resultado);
	        } catch (ArithmeticException e) {
	            System.out.println("Error: No se puede dividir por cero.");
	        }
	    }
	    
	    
	    public static void main(String[] args) {
	        dividir(10, 2);
	        dividir(10, 0);
	    }
}



