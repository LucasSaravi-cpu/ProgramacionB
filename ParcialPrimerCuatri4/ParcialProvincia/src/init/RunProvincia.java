package init;

import controlador.Provincia;
import modelo.provincia.parametricas.Propietario;
import vista.VentanaPrincipal;
import modelo.provincia.parametricas.ParametrosLiquidacion;

public class RunProvincia {

	public static void main(String[] args) {
		ParametrosLiquidacion parametrosValorizacion = new ParametrosLiquidacion((float)0.01, 10, 100);
		Provincia provincia = new Provincia("Provincia de GOOD AIRS", parametrosValorizacion);
				
		provincia.agregar(new Propietario("11111", "Eva Sora"));
		provincia.agregar(new Propietario("22222", "Yanni Pago"));
		provincia.agregar(new Propietario("33333", "Carito Limpuesto"));
		provincia.agregar(new Propietario("44444", "Joni Aporto"));
		provincia.agregar(new Propietario("55555", "Novak Acobrar"));
	
		VentanaPrincipal ventana = new VentanaPrincipal(provincia); 
		ventana.setVisible(true);
	}

}
