package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HojaRutaCamion extends HojaRuta{

	 private static float VALOR_AYUDANTE = 1000;
	 private boolean requiereayudante;
	 
	 


	public HojaRutaCamion(LocalDate fecha, float pesoTotal, float distanciaTotal, Movil movil) {
		super(fecha, pesoTotal, distanciaTotal, movil);
		   this.requiereayudante = requiereayudante;
		  
	}

	@Override
	public boolean agregar(Entrega entrega) {

			if (super.agregar(entrega)) { 
				if (entrega.getPeso()>20) 
					this.requiereayudante = true;
				return true;
			}
			else 
				return false;
		}

	@Override
	public double getCosto() {
		double costo = super.getCosto() + (requiereayudante?VALOR_AYUDANTE:0);
		return costo;
	}




	@Override
	public String toString() {
		
		String rte="";
		
		if (requiereayudante) {
			
		  rte="Si";
		}
		else {
			rte ="no";
		}
		
		
		return super.toString() + " requiere ayudante " + rte;
	}
	

@Override
	
	public String tipoHojaRuta() {
		
		return "CAMION";
	}

public static float getVALOR_AYUDANTE() {
	return VALOR_AYUDANTE;
}

public static void setVALOR_AYUDANTE(float vALOR_AYUDANTE) {
	VALOR_AYUDANTE = vALOR_AYUDANTE;
}

public boolean isRequiereayudante() {
	return requiereayudante;
}

public void setRequiereayudante(boolean requiereayudante) {
	this.requiereayudante = requiereayudante;
}
	
		
}
