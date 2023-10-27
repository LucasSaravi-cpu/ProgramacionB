package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FuncionesVarias {
	
	public static String formateaFecha(Date fecha) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    return sdf.format(fecha);
	}
	
	public static String formateaFechaHora(Date fechaHora) {
	    SimpleDateFormat sdfCompleto = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	    return sdfCompleto.format(fechaHora);

	}

	public static String formateaImporte(float importe) {
		return String.format("%.2f", importe);
	}

	
	
}
