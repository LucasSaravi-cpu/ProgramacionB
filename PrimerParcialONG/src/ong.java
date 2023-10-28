import java.util.ArrayList;


public class ong {
	
	private String nombre;
	 private ArrayList<Colaborador> colaboradores;
	 private ArrayList<Colaboracion> colaboraciones;

	 
	 
	 
	




	public ong(String nombre) {
		super();
		this.nombre = nombre;
		colaboradores = new ArrayList<>();
		colaboraciones = new ArrayList<>();
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	@Override
	public String toString() {
		return nombre ;
	}




	public ArrayList<Colaborador> getColaboradores() {
		return colaboradores;
	}




	public void setColaboradores(ArrayList<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}




	public ArrayList<Colaboracion> getColaboraciones() {
		return colaboraciones;
	}




	public void setColaboraciones(ArrayList<Colaboracion> colaboraciones) {
		this.colaboraciones = colaboraciones;
	}






	 
	 

	
	 
	 
	 

}
