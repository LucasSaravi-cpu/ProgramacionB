import java.util.ArrayList;
import java.util.HashMap;



public class Voluntario extends Colaborador {

	 private ArrayList<Colaboracion> colaboraciones;

	




	




	public Voluntario(String nombre, int anioIngreso) {
		super(nombre, anioIngreso);
		colaboraciones = new ArrayList<>();
		
	}





	public  String tipo() {
		
		return "VOLUNTARIO";
	}





	@Override
	public String toString() {
		return super.toString()   ;
	}





	@Override
	public String aporte() {
		
		return " ";//No tiene aportes 
	}





	public ArrayList<Colaboracion> getColaboraciones() {
		return colaboraciones;
	}





	public void setColaboraciones(ArrayList<Colaboracion> colaboraciones) {
		this.colaboraciones = colaboraciones;
	}





	
	


	
	
	
	
	

}
