package modeloclases;
import java.util.ArrayList;
import java.util.List;


public class Area {
	
	
	private String idArea;
	private String descripcion;
	 private List<Compartimento> compartimentos;
	
	
	
	
	
	
	public Area(String idArea, String descripcion) {
		super();
		this.idArea = idArea;
		this.descripcion = descripcion;
		
		compartimentos = new ArrayList<>();
	}
	public String getIdArea() {
		return idArea;
	}
	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public void agregarCompartimento(Compartimento compartimento) {
		   compartimentos.add(compartimento);
		}

		public List<Compartimento> getCompartimento() {
		    return compartimentos;
		}
	
	
	@Override
	public String toString() {
		return  idArea  +" - "+ descripcion;
	}
	

}
