package Modelo;

public class Evaluacion {
	
	private TipoEvaluacion tipo;
    private Double nota;
    private boolean ausente;
    

	public Evaluacion(TipoEvaluacion tipo, Double nota, boolean ausente) {
		super();
		this.tipo = tipo;
		this.nota = nota;
		this.ausente = ausente;
	}


	@Override
	public String toString() {
		return  tipo +"\t"+ "Nota: ->" + nota ;
	}


	public TipoEvaluacion getTipo() {
		return tipo;
	}


	public Double getNota() {
		return nota;
	}


	public boolean isAusente() {
		return ausente;
	}

	
	
	

}
