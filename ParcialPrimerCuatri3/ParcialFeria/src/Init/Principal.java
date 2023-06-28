package Init;

import Controlador.Empresa;
import Modelo.Accesorio;
import Modelo.Cliente;
import Vista.VentanaStands;

public class Principal {
	public static void main(String[] args) {
		Empresa empresa = new Empresa("Alquiler de Stands");
		
		empresa.agregar(new Cliente("Los Muchachos", "1111"));
		empresa.agregar(new Cliente("Helados Grido","2222"));
		empresa.agregar(new Cliente("Autentika","3333"));
		empresa.agregar(new Cliente("La Casiana","4444"));
		
		empresa.agregar(new Accesorio("Mesa", 100f));
		empresa.agregar(new Accesorio("Silla",50f));
		empresa.agregar(new Accesorio("Sillon",80f));
		empresa.agregar(new Accesorio("Caja Registradora",230f));
		empresa.agregar(new Accesorio("Television 42''",1200f));
		
		VentanaStands ventanaStands = new VentanaStands(empresa);
		ventanaStands.setVisible(true);
	}
}
