package modeloclases;

public class Estanteria  extends  Compartimento{
	
	
	private int cantidadNiveles;
	

	
	

	public Estanteria(String idcompartimento, String descripcion, int capacidad, int cartocupada, Area area,
			int cantidadNiveles) {
		super(idcompartimento, descripcion, capacidad, cartocupada, area);
		this.cantidadNiveles = cantidadNiveles;
	}

	public int getCantidadNiveles() {
		return cantidadNiveles;
	}

	public void setCantidadNiveles(int cantidadNiveles) {
		this.cantidadNiveles = cantidadNiveles;
	}

	
	
	public double costoEstanteria() {
		
		double costo =Compartimento.COSTO_DIARIO_ESTANTERIA+cantidadNiveles*Compartimento.COSTO_DIARIO_NIVEL;
		
		return costo;
		
	}
	
	@Override
	public String toString() {
		return super.toString()+ " cantidadNiveles : " + cantidadNiveles ;
	}












	
	

}
