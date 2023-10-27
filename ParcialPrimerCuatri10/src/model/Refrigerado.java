package model;

public class Refrigerado extends  Compartimento{
	private int tempmax;
	private int tempmin;
	
	public Refrigerado(String identificacion, String descripcion, int capacidad, String ubicacion, int tempmax,
			int tempmin) {
		super(identificacion, descripcion, capacidad, ubicacion);
		this.tempmax = tempmax;
		this.tempmin = tempmin;
	}

	public int getTempmax() {
		return tempmax;
	}

	public void setTempmax(int tempmax) {
		this.tempmax = tempmax;
	}

	public int getTempmin() {
		return tempmin;
	}

	public void setTempmin(int tempmin) {
		this.tempmin = tempmin;
	}

	@Override
	public String toString() {
		return super.toString() + "Rango Temperatura" + tempmax + "  a  " + tempmin + "\n" ;
	}
	

	 public String tipocompartimento() {
		 return "Refrigerado";
	 }

}
