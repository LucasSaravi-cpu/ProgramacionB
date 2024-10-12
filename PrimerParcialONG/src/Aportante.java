
import java.util.ArrayList;
import java.util.List;

public class Aportante extends Colaborador {
	
	private double aporteMensual;
	
	


	public Aportante(String nombre, int anioIngreso, double aporteMensual) {
		super(nombre, anioIngreso);
		this.aporteMensual = aporteMensual;
	}


   

	
	@Override
	public String TipoColaborador() {
		
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
	
	


	public double getAporteMensual() {
		return aporteMensual;
	}



	public void setAporteMensual(double aporteMensual) {
		this.aporteMensual = aporteMensual;
	}

	
	 @Override
	    public List<Colaboracion> getColaboraciones() {
	        return new ArrayList<>();  // Los aportantes no tienen colaboraciones, devolvemos una lista vacía
	    }







	@Override
	public String toString() {
         StringBuilder sb = new StringBuilder();
		
		sb.append(getNombre()).append("\t").append(getAnioIngreso())
		.append("\t").append(TipoColaborador()).append("\t\t").append(aporteMensual).append("\n");
		
		return sb.toString();
	}





	@Override
	public double getCosto() {
		
	
		
		return aporteMensual;
	}


	
	
	
	
}
