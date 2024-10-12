
public class Colaboracion {
	
	private String descripcion;
	private double CostomesxVoluntario;
	
	 
	 
	public Colaboracion(String descripcion, double costomesxVoluntario) {
		super();
		this.descripcion = descripcion;
		this.CostomesxVoluntario = costomesxVoluntario;
	}



	public double getCostomesxVoluntario() {
		return CostomesxVoluntario;
	}



	public void setCostomesxVoluntario(double costomesxVoluntario) {
		CostomesxVoluntario = costomesxVoluntario;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	@Override
	public String toString() {
		return  descripcion + CostomesxVoluntario;
	}


	
	
	

}
