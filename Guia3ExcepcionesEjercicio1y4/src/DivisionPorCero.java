
public class DivisionPorCero extends Exception{

	
	// Constructor que toma un mensaje como parámetro y lo pasa al constructor de la clase base (Exception)
	public DivisionPorCero(String mensaje) {
        super(mensaje);
    }
	
	
	
	public class PracticaExcepciones {

	    public static void main(String[] args) {
	        try {
	        	// Llamada al método 
	            dividir(10, 2);
	            dividir(10, 0);
	        } catch (DivisionPorCero e) {
	        	// Captura de la excepción DivisionPorCero y muestra el mensaje de la excepción
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    /*El throws  indica que este método puede lanzar una  excepción 
	     del tipo DivisionPorCero. En este caso, si el divisor es cero, se lanzará
	     una excepción DivisionPorCero. Al agregar throws DivisionPorCero, 
	     estamos informando a cualquier método que llame a dividir que deberá manejar una posible  excepción DivisionPorCero 
	    que pueda ser lanzada durante la ejecución de este método*/

	    // Método estático dividir que puede lanzar la excepción DivisionPorCero
	    public static void dividir(int dividendo, int divisor) throws DivisionPorCero {
	    	// Verifica si el divisor es cero
	    	if (divisor == 0) {
	    		// Si es cero, lanzar una instancia de DivisionPorCero con un mensaje de error
	            throw new DivisionPorCero("Error: No se puede dividir por cero.");
	        }
	    	 // Si el divisor no es cero, realizar la división y mostrar el resultado
	        int resultado = dividendo / divisor;
	        System.out.println("El resultado de la división es: " + resultado);
	    }
	}
	
	
	
}
