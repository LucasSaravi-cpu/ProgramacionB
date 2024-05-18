
public class DivisionPorCero extends Exception{

	
	// Constructor que toma un mensaje como par�metro y lo pasa al constructor de la clase base (Exception)
	public DivisionPorCero(String mensaje) {
        super(mensaje);
    }
	
	
	
	public class PracticaExcepciones {

	    public static void main(String[] args) {
	        try {
	        	// Llamada al m�todo 
	            dividir(10, 2);
	            dividir(10, 0);
	        } catch (DivisionPorCero e) {
	        	// Captura de la excepci�n DivisionPorCero y muestra el mensaje de la excepci�n
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    /*El throws  indica que este m�todo puede lanzar una  excepci�n 
	     del tipo DivisionPorCero. En este caso, si el divisor es cero, se lanzar�
	     una excepci�n DivisionPorCero. Al agregar throws DivisionPorCero, 
	     estamos informando a cualquier m�todo que llame a dividir que deber� manejar una posible  excepci�n DivisionPorCero 
	    que pueda ser lanzada durante la ejecuci�n de este m�todo*/

	    // M�todo est�tico dividir que puede lanzar la excepci�n DivisionPorCero
	    public static void dividir(int dividendo, int divisor) throws DivisionPorCero {
	    	// Verifica si el divisor es cero
	    	if (divisor == 0) {
	    		// Si es cero, lanzar una instancia de DivisionPorCero con un mensaje de error
	            throw new DivisionPorCero("Error: No se puede dividir por cero.");
	        }
	    	 // Si el divisor no es cero, realizar la divisi�n y mostrar el resultado
	        int resultado = dividendo / divisor;
	        System.out.println("El resultado de la divisi�n es: " + resultado);
	    }
	}
	
	
	
}
