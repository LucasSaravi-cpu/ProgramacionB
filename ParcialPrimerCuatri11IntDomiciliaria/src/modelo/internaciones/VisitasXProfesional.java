package modelo.internaciones;

import java.util.List;

import modelo.parametricas.DiasSemana;
import modelo.parametricas.DiasSemana.Dia;
import modelo.personas.Profesional;
import utils.FuncionesVarias;

public class VisitasXProfesional {
	private Profesional profesional;
	private List<Dia> diasAtencion;
	
	public VisitasXProfesional(Profesional profesional, List<Dia> diasAtencion) {
		super();
		this.setProfesional(profesional);
		this.setDiasAtencion(diasAtencion);
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public List<Dia> getDiasAtencion() {
		return diasAtencion;
	}

	public void setDiasAtencion(List<Dia> diasAtencion) {
		this.diasAtencion = diasAtencion;
	}
	
	public float getCostoSemanal() {
		return profesional.getCostoSemanal(diasAtencion);
	}
	
	@Override
	public String toString() {
		return profesional.toString() + "\t" + diasAtencion.toString() + 
				"\t Costo Semanal: " + FuncionesVarias.formateaImporte(getCostoSemanal()) + "\n"; 
	}
}
