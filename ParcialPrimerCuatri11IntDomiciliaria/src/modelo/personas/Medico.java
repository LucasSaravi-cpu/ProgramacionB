package modelo.personas;

import java.util.Date;
import java.util.List;

import modelo.parametricas.Especialidad;
import modelo.parametricas.DiasSemana.Dia;

public class Medico extends Profesional {
	
	public Medico(int dni, String nombre, Date fechaNacimiento, String prefijo, String matricula, Especialidad especialidad) {
		super(dni, nombre, fechaNacimiento, prefijo, matricula, especialidad);
	}

	//Fucion getCostoSemanal 	
	@Override
	public float getCostoSemanal(List<Dia> diasAtencion) {
		int x=0; int y = 1000; //costo inicial para los primeros dos días
		for (int i=0; i<diasAtencion.size(); i++) {
			if (i<2) {
				x+=y;
			}else {
				x+=y*1.1; //Si lo visita más de 2 veces por semana, el valor a partir de la 3era. visita se incrementa en un 10%				
			}
		}
			return x;
	}

}
	
	
	

