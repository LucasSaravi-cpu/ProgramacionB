package modelo;

public class TrabajoEmpresarial extends Trabajo {

	
	
	private boolean comercializable;
	private int aniocarrera;
	private double VALOR;
	private Empresa empresa;
	

	public TrabajoEmpresarial(String titulo, int fecha, AreaTematica areatematica, boolean comercializable,
			int aniocarrera, double valor ,Empresa empresa) {
		super(titulo, fecha, areatematica);
		this.comercializable = comercializable;
		this.aniocarrera = aniocarrera;
		this.VALOR = valor;
		this.empresa=empresa;
	}

	public boolean isComercializable() {
		return comercializable;
	}




	public void setComercializable(boolean comercializable) {
		this.comercializable = comercializable;
	}





	public int getAniocarrera() {
		return aniocarrera;
	}





	public void setAniocarrera(int aniocarrera) {
		this.aniocarrera = aniocarrera;
	}





	public double getVALOR() {
		return VALOR;
	}





	public void setVALOR(double vALOR) {
		VALOR = vALOR;
	}










	@Override
	public double CalcularTarifa() {
		

		if (comercializable=true){
		return VALOR=5000+(5000*0.2);
		}
		else {
			return VALOR=5000;
		}
		
	}

	@Override
	public String toString() {
		return "Empresarial "+super.toString()+"\n" +"Empresa "+empresa+ "Comercializable "+ comercializable + ", aniocarrera: " + aniocarrera + "VALOR:"+ VALOR ;
	}






}
