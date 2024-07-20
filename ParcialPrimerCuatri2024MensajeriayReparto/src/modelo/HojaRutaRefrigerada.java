package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class HojaRutaRefrigerada extends HojaRutaCamion {
	
	private float temperatura;
	private static double  PORC_INCREMENTO_REFRIGERACION=1.4;

	public HojaRutaRefrigerada(LocalDate fecha, float pesoTotal, float distanciaTotal, Movil movil) {
		super(fecha, pesoTotal, distanciaTotal, movil);
		this.temperatura = temperatura;
		
	}

	
	@Override
	public boolean agregar(Entrega entrega) {
			if (super.agregar(entrega)) {
				if (entrega.getTemperaturaRecomendada() < this.temperatura)
					this.temperatura = entrega.getTemperaturaRecomendada();
				return true;
			}
			else 
				return false;
		}

	@Override
	public double getCosto() {
		double costo = super.getCosto() * PORC_INCREMENTO_REFRIGERACION;
		return costo;
	}



	
	@Override
	public String toString() {
		return super.toString() + " Temperatura " + temperatura ;
	}

	
@Override
	
	public String tipoHojaRuta() {
		
		return "REFRIGERADA";
	}


public float getTemperatura() {
	return temperatura;
}


public void setTemperatura(float temperatura) {
	this.temperatura = temperatura;
}




}
