
public class Colaborador {
	
	private String nombre;
	private int anioIngreso;
	
	
	
	
	public Colaborador(String nombre, int anioIngreso) {
		super();
		this.nombre = nombre;
		this.anioIngreso = anioIngreso;
		
	}





	public  String aporte() {
		return "";
	};

	
	
	public  String tipo() {
		return null;
	}



	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public int getAnioIngreso() {
		return anioIngreso;
	}




	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;
	}




	@Override
	public String toString() {
		return nombre +"\t" + anioIngreso ;
	}
	
	
	

}
