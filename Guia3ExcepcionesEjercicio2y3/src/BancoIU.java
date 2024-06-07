import java.util.Scanner;

public class BancoIU {
	
	 private ClienteBanco cliente;
	    private Scanner scanner;

	    public BancoIU(ClienteBanco cliente) {
	        this.cliente = cliente;
	        this.scanner = new Scanner(System.in);
	    }

	    public void iniciarOperaciones() {
	        try {
	            System.out.println("Ingrese su PIN: ");
	            int pinIngresado = scanner.nextInt();

	            if (pinIngresado == cliente.getPIN()) {
	                System.out.println("Bienvenido, " + cliente.getNombre() + "!");

	                System.out.println("1. Consultar saldo");
	                System.out.println("2. Depositar dinero");
	                System.out.println("3. Extraer dinero");
	                System.out.println("4. Salir");

	                int opcion = scanner.nextInt();

	                switch (opcion) {
	                    case 1:
	                         System.out.println(cliente.toString());
	                        break;
	                    case 2:
	                        System.out.println("Ingrese la cantidad a depositar: ");
	                        double cantidadDeposito = scanner.nextDouble();
	                        cliente.depositar(cantidadDeposito);
	                        System.out.println("Depósito exitoso.");
	                        break;
	                    case 3:
	                        System.out.println("Ingrese la cantidad a extraer: ");
	                        double cantidadExtraccion = scanner.nextDouble();
	                        cliente.extraer(cantidadExtraccion);
	                        System.out.println("Extracción exitosa.");
	                        break;
	                    case 4:
	                        System.out.println("Gracias por utilizar nuestros servicios. Hasta luego!");
	                        break;
	                    default:
	                        System.out.println("Opción inválida.");
	                }
	            } else {
	                throw new PINErroneo();
	            }
	        } catch (PINErroneo e) {
	            System.out.println(e.getMessage());
	        } catch (SaldoInsuficiente e) {
	            System.out.println("Error: " + e.getMessage() + ". Saldo actual: " + e.getSaldoActual() + ", Cantidad solicitada: " + e.getCantidadSolicitada());
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    public static void main(String[] args) {
	        ClienteBanco cliente = new ClienteBanco("Juan", 1234, 1000.0);
	        BancoIU bancoIU = new BancoIU(cliente);
	        bancoIU.iniciarOperaciones();
	    }

}
