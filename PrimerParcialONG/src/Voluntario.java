import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Voluntario extends Colaborador {

	 private ArrayList<Colaboracion> colaboraciones;
	
	


	public Voluntario(String nombre, int anioIngreso) {
		super(nombre, anioIngreso);
		colaboraciones = new ArrayList<>();
		
	}




	@Override
	public String TipoColaborador() {
		
		return "VOLUNTARIO";
	}



	public void setColaboraciones(ArrayList<Colaboracion> colaboraciones) {
		this.colaboraciones = colaboraciones;
	}

	  @Override
	    public List<Colaboracion> getColaboraciones() {
	        return colaboraciones; 
	    }


	




	@Override
	public String toString() {
         StringBuilder sb = new StringBuilder();
		
		sb.append(getNombre()).append("\t").append(getAnioIngreso()).append("\t").append(TipoColaborador())
		.append("\t\t").append("\n");
		
		for (Colaboracion colaboracion : colaboraciones) {
            sb.append("\t\t\t\t\t\t\t").append(colaboracion.getDescripcion()).append("\t").append(colaboracion.getCostomesxVoluntario()).append("\n");
        }
		
		return sb.toString();
	}
	




	@Override
	public double getCosto() {
		
	 double totalCostos=0;
	 
		for (Colaboracion colaboracion : colaboraciones) {
			
			 totalCostos += colaboracion.getCostomesxVoluntario();
			
			
		}
		
		
		return totalCostos;
	}









	



	
	


	
	
	
	
	

}
