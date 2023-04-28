
public class ClienteBancoPrincipal {
	
	
	public static void main(String[] args) {
		
		
		ClienteBanco lucas = new ClienteBanco("lucas",1234,1000);
		
		
		// Acceder al nombre
		String nombreCliente = lucas.getNombre();

		// Cambiar el PIN del cliente
		lucas.setPin(56789);

		// Deposito
		lucas.depositar(10000);

		// Extraer 
		lucas.extraer(1000);

		// Mostrar el estado de cuenta del cliente 
		lucas.mostrarEstadoCuenta(56789);
		
		
	}
	
	
	
	
	}

