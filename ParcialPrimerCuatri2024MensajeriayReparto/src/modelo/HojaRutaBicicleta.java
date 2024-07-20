package modelo;

import java.time.LocalDate;
import java.util.ArrayList;


public class HojaRutaBicicleta extends HojaRuta {

	public HojaRutaBicicleta(LocalDate fecha, float pesoTotal, float distanciaTotal, Movil movil) {
		super(fecha, pesoTotal, distanciaTotal, movil);
		
	}
	

	@Override
	public double getCosto() {
		double costo = super.getCosto()- super.getVALOR_KG() * super.getPesoTotal();

		return costo;
		
	}

	@Override
	public boolean agregar(Entrega entrega) {
			if (super.getEntregas().size() > 3) {
				
				
				return false;
			}
			else {
				
				return super.agregar(entrega);
			}
		}


	@Override
	public String toString() {
		return super.toString();
	}

	
	@Override
	
	public String tipoHojaRuta() {
		
		return "BICICLETA";
	}
	

}
