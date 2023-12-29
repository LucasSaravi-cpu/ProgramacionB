package persistencia;

import java.math.BigDecimal;

public class MainPersistencia {
	
	public static void main(String[] args) {
		
		System.out.println(args[0]);
		System.out.println("");
		if (args[0].equals("serializar")) {
			Controlador controlador = new Controlador();
			Cliente a = new Cliente("Juan", "Luro", new BigDecimal(1000));
			controlador.add(a);
			Cliente b = new Cliente("Luis", "Peña", new BigDecimal(2000));
			controlador.add(b);
			Persistencia.persistirControlador(controlador);
			System.out.println(controlador.listar());
		}
		if (args[0].equals("deserializar")) {
			Controlador controlador = Persistencia.instanciarControlador();
			System.out.println(controlador.listar());
            controlador.sumar(new BigDecimal(100));
			System.out.println(controlador.listar());
			Persistencia.persistirControlador(controlador);			
		}
	}

}
