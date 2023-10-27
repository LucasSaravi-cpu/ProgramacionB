package modelo.internaciones;

import java.util.Date;
import java.util.List;

public class InternacionPediatrica extends Internacion {
	
	private float peso;
	private int altura;
	
	public InternacionPediatrica(Date fechaInicio, Date fechaFin, String diagnostico, String domicilio, List<VisitasXProfesional> listPlanVisitas,
			float peso, int altura) {
		super(fechaInicio, fechaFin, diagnostico, domicilio, listPlanVisitas);
		this.altura= altura;
		this.peso= peso;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public String getTipoInternacion() {
		return "Internacion pediátrica";
	}

	@Override
	public String toString() {
		return "Tipo de Internacion= " + getTipoInternacion() + super.toString() + ", peso=" + peso + ", altura=" + altura + "." ;
	}
	
	
}
