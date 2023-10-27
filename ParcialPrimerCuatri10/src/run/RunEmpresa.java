package run;

import control.Empresa;
import view.Windows;


public class RunEmpresa {

	public static void main(String[] args) {
	
		Empresa empresa = new Empresa();
		
		empresa.crearEmpresa();
		
		Windows windows = new Windows();
		
		windows.setVisible(true);
	
	
	
	}

}
