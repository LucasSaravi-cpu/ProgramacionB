package ini;

import Controlador.MinisterioEconomia;
import Modelo.Automovil;
import Modelo.AutomovilCombustible;
import Modelo.AutomovilElectrico;
import Modelo.Combustible;

public class RunMinisterioEconomia {

	public static void main(String[] args) {
	
		        MinisterioEconomia ministerio = new MinisterioEconomia();

		        // Agregar algunos autos de combustible
		        AutomovilCombustible auto1 = new AutomovilCombustible("ABC123", 2015, 100000, 4, Combustible.NAFTA);
		        AutomovilCombustible auto2 = new AutomovilCombustible("DEF456", 2020, 150000, 6, Combustible.DIESEL);
		        ministerio.agregarAutomovil(auto1);
		        ministerio.agregarAutomovil(auto2);

		        // Agregar algunos autos eléctricos
		        AutomovilElectrico auto3 = new AutomovilElectrico("GHI789", 2022, 200000, 50);
		        ministerio.agregarAutomovil(auto3);

		        // Mostrar listado completo
		        System.out.println("Listado completo de automóviles:");
		        for (Automovil auto : ministerio.getAutomoviles()) {
		            System.out.println(auto.toString() + " - Impuesto a pagar: $" + auto.calcularImpuesto());
		        }
		    }

	}


