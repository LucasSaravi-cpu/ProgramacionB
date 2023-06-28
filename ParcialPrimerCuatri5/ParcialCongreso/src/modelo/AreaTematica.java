package modelo;

public class AreaTematica {

	private int idAreaTematica;
	private String descripcion;
	
	public AreaTematica(int idAreaTematica, String descripcion) {
		super();
		this.setIdAreaTematica(idAreaTematica);
		this.setDescripcion(descripcion);
	}


	public int getIdAreaTematica() {
		return idAreaTematica;
	}

	public void setIdAreaTematica(int idAreaTematica) {
		this.idAreaTematica = idAreaTematica;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return  descripcion ;
	}
	
	
	
}


