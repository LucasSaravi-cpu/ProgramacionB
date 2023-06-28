package modelo;

public class TrabajoInvestigacion extends Trabajo {


	private boolean paperPublicado;
	private double VALOR;
	private Universidad universidad;


	public TrabajoInvestigacion(String titulo, int fecha, AreaTematica areatematica, boolean paperPublicado,
			double vALOR , Universidad universidad) {
		super(titulo, fecha, areatematica);
		this.paperPublicado = paperPublicado;
		this.VALOR = vALOR;
		this.universidad = universidad;
	}


	
	



	public boolean isPaperPublicado() {
		return paperPublicado;
	}







	public void setPaperPublicado(boolean paperPublicado) {
		this.paperPublicado = paperPublicado;
	}







	public double getVALOR() {
		return VALOR;
	}







	public void setVALOR(double vALOR) {
		VALOR = vALOR;
	}







	@Override
	public double CalcularTarifa() {
		
		if (paperPublicado==true) {
		return VALOR=2000+(2000*0.5);
		}
		else {
			return VALOR=2000;
		}
		
		
		
	}







	@Override
	public String toString() {
		return "Investigacion"+ super.toString() +"\n" +"Unversidad : "+universidad  + "  Paper publicado" + paperPublicado + ", VALOR=" + VALOR ; 
	}






	
	

}
