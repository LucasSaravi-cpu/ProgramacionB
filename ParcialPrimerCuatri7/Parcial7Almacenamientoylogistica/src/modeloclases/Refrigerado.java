package modeloclases;

public class Refrigerado  extends  Compartimento {
	
	private int temperatura;
	private int kilowatts;

	
	public Refrigerado(String idcompartimento, String descripcion, int capacidad, int cartocupada, Area area,
			int temperatura, int kilowatts) {
		super(idcompartimento, descripcion, capacidad, cartocupada, area);
		this.temperatura = temperatura;
		this.kilowatts = kilowatts;
	}

	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	public int getKilowatts() {
		return kilowatts;
	}
	public void setKilowatts(int kilowatts) {
		this.kilowatts = kilowatts;
	}
	
	@Override
	public double CalculaCostoDiario() {
		double factortemperatura=0;
		if (temperatura<=-5) 
			
			 factortemperatura =1.5;
		
		else  
			if (-5<temperatura && temperatura<=3) 
				factortemperatura=1.2;
			 else 
			      if (temperatura>3)
					factortemperatura =1;
				
			
		
	
		double costo = Compartimento.COSTO_KILOWATT_DIA*kilowatts*factortemperatura;
			
		return costo+super.CalculaCostoDiario();
		
	}
	
	
	

	
	
	@Override
	public String toString() {
		return super.toString()+ " temperatura " + temperatura + " kilowatts " + kilowatts;
	}

	
	
	

}
