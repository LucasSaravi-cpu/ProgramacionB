package ini;

import Controlador.MinisterioEconomia;
import Modelo.Automovil;
import Modelo.AutomovilCombustible;
import Modelo.AutomovilElectrico;
import Modelo.Combustible;
import Vista.VentanaPrincipal;

public class RunMinisterioEconomia {

	public static void main(String[] args) {
	
		        MinisterioEconomia ministerio = new MinisterioEconomia();

		        // Agregar algunos autos de combustible
		        Automovil auto1 = new AutomovilCombustible("ABC123", 2015, 100000, 4, Combustible.NAFTA);
		        Automovil auto2 = new AutomovilCombustible("DEF456", 2020, 150000, 6, Combustible.DIESEL);
		        ministerio.agregarAutomovil(auto1);
		        ministerio.agregarAutomovil(auto2);

		        // Agregar algunos autos el�ctricos
		        Automovil auto3 = new AutomovilElectrico("GHI789", 2022, 200000, 50);
		        ministerio.agregarAutomovil(auto3);
		        
		        VentanaPrincipal ventana = new VentanaPrincipal(ministerio);
		     
		  
		    }
	
	
	   
	
	
	
	

	}


