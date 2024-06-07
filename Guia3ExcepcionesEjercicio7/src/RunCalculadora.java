import java.util.Scanner;

public class RunCalculadora {

	public static void main(String[] args) {
	
		 Scanner scanner = new Scanner(System.in);
		try {
			
			
			
			
			 System.out.print("Ingrese el primer n�mero: ");
	            double num1 = scanner.nextDouble();

	            System.out.print("Ingrese el segundo n�mero: ");
	            double num2 = scanner.nextDouble();

            Calculadora calculadora = new Calculadora();
            
            
            System.out.println("Suma: " + calculadora.sumar(num1, num2));
            System.out.println("Resta: " + calculadora.restar(num1, num2));
            System.out.println("Multiplicaci�n: " + calculadora.multiplicar(num1, num2));
            System.out.println("Divisi�n: " + calculadora.dividir(num1, num2));
        } catch (NumberFormatException e) {
            System.err.println("Error: Ingreso de caracteres no num�ricos.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Se esperan dos argumentos num�ricos.");
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }
	
		
}

