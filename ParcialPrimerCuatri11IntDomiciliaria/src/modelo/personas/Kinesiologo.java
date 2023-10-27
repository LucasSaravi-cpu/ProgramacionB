package modelo.personas;

import java.util.Date;
import java.util.List;

import modelo.parametricas.DiasSemana;
import modelo.parametricas.DiasSemana.Dia;
import modelo.parametricas.Especialidad;

public class Kinesiologo extends Profesional {
	
	private boolean fisiatra;

	public Kinesiologo(int dni, String nombre, Date fechaNacimiento, String prefijo, String matricula, Especialidad especialidad, boolean fisiatra) {
		super(dni, nombre, fechaNacimiento, prefijo, matricula, especialidad);
		this.setFisiatra(fisiatra);
	}

	public boolean isFisiatra() {
		return fisiatra;
	}

	public void setFisiatra(boolean fisiatra) {
		this.fisiatra = fisiatra;
	}
	
	
	//Fucion getCostoSemanal 	
	@Override
	public float getCostoSemanal(List<Dia> diasAtencion) {
		int x=0;
		for(int i=0; i< diasAtencion.size(); i++) {
			if (diasAtencion.get(i).equals(DiasSemana.Dia.DOMINGO)) { // Si es el Domingo entonces se incrementa en 800
				x+=800;
			}else { // Si es de lunes a sabados se incrementa en 600
				x+=600;
			}
		}

		return x;  //Luego se ve el costo final de la semana

	}

}
