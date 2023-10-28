
public class Aportante extends Colaborador {
	
	private double aporteMensual;
	

   



	public Aportante(String nombre, int anioIngreso, double aporteMensual) {
		super(nombre, anioIngreso);
		this.aporteMensual = aporteMensual;
	}


   @Override
	public String tipo() {
		
		return "APORTANTE";
	}

	
	@Override
	public String aporte() {
		
	String categoria="";
		
		if (aporteMensual>= 30000) {
			
			categoria="PADRINO";
			
			
		}
		else
			if (aporteMensual<30000) {
				
				
				categoria="BENEFACTOR";
			}
		
		
		return categoria;
	}
	
	@Override
	public String toString() {
		return super.toString() +"\t"+aporteMensual ;
	}



	public double getAporteMensual() {
		return aporteMensual;
	}



	public void setAporteMensual(double aporteMensual) {
		this.aporteMensual = aporteMensual;
	}

	
	
	
}
