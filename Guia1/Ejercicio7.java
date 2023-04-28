/*Escriba un programa que utilize el método static getProperty() de la clase System para 
obtener información del sistema. La información que se desea obtener es: versión de Java, 
sistema operativo y su versión*/


public class Ejercicio7  {

	public static void main(String[] args) {
		 String javaVersion = System.getProperty("java.version");
	        String osName = System.getProperty("os.name");
	        String osVersion = System.getProperty("os.version");
	        
	        System.out.println("Java version: " + javaVersion);
	        System.out.println("Operating system: " + osName);
	        System.out.println("Operating system version: " + osVersion);
		
		
		
		
	}

	
	}

