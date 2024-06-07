import java.util.Scanner;

public class RunCalculadora {

	public static void main(String[] args) {
	
		 Scanner scanner = new Scanner(System.in);
		try {
			
			
			
			
			 System.out.print("Ingrese el primer número: ");
	            double num1 = scanner.nextDouble();

	            System.out.print("Ingrese el segundo número: ");
	            double num2 = scanner.nextDouble();

            Calculadora calculadora = new Calculadora();
            
            
            System.out.println("Suma: " + calculadora.sumar(num1, num2));
            System.out.println("Resta: " + calculadora.restar(num1, num2));
            System.out.println("Multiplicación: " + calculadora.multiplicar(num1, num2));
            System.out.println("División: " + calculadora.dividir(num1, num2));
        } catch (NumberFormatException e) {
            System.err.println("Error: Ingreso de caracteres no numéricos.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Se esperan dos argumentos numéricos.");
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }
	
		
}

