package modelo.internaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Internacion {
	private Date fechaInicio;
	private Date fechaFin;
	private String diagnostico;
	private String domicilio;
	private List<VisitasXProfesional> listPlanVisitas = new ArrayList<VisitasXProfesional>();
	
	public Internacion(Date fechaInicio, Date fechaFin, String diagnostico, String domicilio, List<VisitasXProfesional> listPlanVisitas) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.diagnostico = diagnostico;
		this.domicilio = domicilio;
		this.listPlanVisitas = listPlanVisitas;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public String getTipoInternacion() {		
		return "Internacion de adulto";
	}

	public List<VisitasXProfesional> getListPlanVisitas() {
		return listPlanVisitas;
	}

	public void setListPlanVisitas(List<VisitasXProfesional> listPlanVisitas) {
		this.listPlanVisitas = listPlanVisitas;
	}

	@Override
	public String toString() {
		String s = "Tipo de internacion: " + this.getTipoInternacion() + "\nFecha de inicio: " + fechaInicio + 
				".\tFecha de finalizacion: " + fechaFin + ".\nDiagnostico: " + diagnostico + ".\nDomicilio: " + domicilio
				+ "\nPlan de visitas: \n" ;
		for (int i = 0; i<this.listPlanVisitas.size(); i++) {
			s+= "\t"+listPlanVisitas.get(i).toString();
		}
		return s;
	}
	
	
	
	
	
}
