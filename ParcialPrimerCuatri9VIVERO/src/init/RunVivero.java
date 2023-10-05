package init;

import java.time.LocalDate;
import java.util.Date;

import controlador.Empresa;
import vista.VentanaStock;

public class RunVivero {

	public static void main(String[] args) {
		Empresa empresa = new Empresa("Vivero LA SEQUÍA");		
		VentanaStock ventana = new VentanaStock(empresa);
		ventana.setVisible(true);
	}

}
