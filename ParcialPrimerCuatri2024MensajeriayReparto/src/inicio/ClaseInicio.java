package inicio;

import controlador.Empresa;
import modelo.Entrega;
import modelo.Movil;
import modelo.TipoMovil.tipoMovil;
import modelo.Zonas.Zona;


public class ClaseInicio {
	
	public static void main(String[] args) {
		
		// Crear la empresa
		Empresa empresa = new Empresa("TeLoLlevo S.A");
		
		//2°) Agregar los móviles a la empresa
		
		empresa.agregar(new Movil("Diego", tipoMovil.BICICLETA, 8.5f, Zona.ESTE));		
		empresa.agregar(new Movil("Pedro", tipoMovil.CAMION, 250.0f, Zona.ESTE));	
		empresa.agregar(new Movil("Elena", tipoMovil.REFRIGERADO, 300.0f, Zona.ESTE));
		empresa.agregar(new Movil("Pilar", tipoMovil.BICICLETA, 10.0f, Zona.OESTE));
		empresa.agregar(new Movil("Pablo", tipoMovil.CAMION, 150.0f, Zona.OESTE));		
		empresa.agregar(new Movil("Amira", tipoMovil.REFRIGERADO, 300.0f, Zona.OESTE));
		empresa.agregar(new Movil("Osmar", tipoMovil.BICICLETA, 9.0f, Zona.NORTE));
		empresa.agregar(new Movil("Irene", tipoMovil.CAMION, 280.0f, Zona.NORTE));		
		empresa.agregar(new Movil("Maris", tipoMovil.REFRIGERADO, 350.0f, Zona.NORTE));	
		empresa.agregar(new Movil("Clara", tipoMovil.BICICLETA, 9.0f, Zona.SUR));
		empresa.agregar(new Movil("Mario", tipoMovil.CAMION, 220.0f, Zona.SUR));		
		empresa.agregar(new Movil("Mayra", tipoMovil.REFRIGERADO, 280.0f, Zona.SUR));

		
	
	
		//3°) Agregar entregas a Hojas de Ruta

		empresa.agregar(new Entrega("800", "Lopez", "Luro   4433", 1.0f, 30.0f, Zona.OESTE,15));
		empresa.agregar(new Entrega("801", "Perez", "Manso  4500", 10.0f, 1.5f, Zona.NORTE,15));
		empresa.agregar(new Entrega("802", "Rubio", "Luro   5544", 5.0f, 18.0f, Zona.OESTE,15));
		empresa.agregar(new Entrega("803", "Lopez", "Luro   4433", 1.0f, 25.0f, Zona.OESTE, 5.0f));
		empresa.agregar(new Entrega("804", "Jerez", "Edison 5025", 35.0f, 12.0f, Zona.SUR,15));
		empresa.agregar(new Entrega("805", "Muniz", "Moreno 2233", 1.0f, 30.0f, Zona.ESTE,15));
		empresa.agregar(new Entrega("806", "Ramal", "Alice  6677", 7.0f, 2.5f, Zona.NORTE,15));
		empresa.agregar(new Entrega("807", "Lemos", "Rejon  7788", 11.5f, 3.5f, Zona.NORTE,15));
		empresa.agregar(new Entrega("808", "Landi", "Garay  5432", 5.0f, 25.0f, Zona.OESTE, -1.0f));
		empresa.agregar(new Entrega("809", "Remon", "Funes   155", 8.5f, 2.8f, Zona.NORTE,15));		
		empresa.agregar(new Entrega("810", "Brady", "Jara    260", 9.5f, 3.0f, Zona.NORTE,15));
		empresa.agregar(new Entrega("811", "Lucky", "Colon  6732", 25.0f, 110.0f, Zona.OESTE, 8.0f));
		empresa.agregar(new Entrega("812", "Matta", "Irala  6044", 10.0f, 15.0f, Zona.SUR,15));
		empresa.agregar(new Entrega("813", "Kruck", "Ayolas 5777", 12.0f, 11.0f, Zona.SUR,15));
		empresa.agregar(new Entrega("814", "Reino", "Alsina 2888", 3.5f, 40.0f, Zona.ESTE,15));
		empresa.agregar(new Entrega("815", "Muniz", "Alsina 3000", 3.55f, 100.0f, Zona.ESTE,15));
		empresa.agregar(new Entrega("816", "Muniz", "Alsina 3000", 3.55f, 150.0f, Zona.ESTE,15));
		empresa.agregar(new Entrega("817", "Muniz", "Alsina 3000", 3.55f, 80.0f, Zona.ESTE,15));
		empresa.agregar(new Entrega("818", "Russo", "Strobel 667", 7.0f, 2.5f, Zona.NORTE,15));

		
		System.out.println(empresa.listarHojasRuta());
	}
}
