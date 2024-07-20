package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class HojaRuta {
	
	private LocalDate fecha;
	private float pesoTotal;
	private float distanciaTotal;
	private Movil movil;
 	
	 private ArrayList<Entrega> entregas;
	 private static float VALOR_ENTREGA= 200;
	 private static float VALOR_KG= 10;
	 private static float VALOR_KM= 100;
	
	
	

	
	public HojaRuta(LocalDate fecha, float pesoTotal, float distanciaTotal, Movil movil) {
		super();
		this.fecha = fecha;
		this.pesoTotal = pesoTotal;
		this.distanciaTotal = distanciaTotal;
		this.movil = movil;
	    this.entregas = new ArrayList<>(); // Inicialización de la lista de entregas
	    
	}


	public double getCosto() {
		return this.entregas.size() * VALOR_ENTREGA + 
			this.pesoTotal * VALOR_KG +
			this.distanciaTotal * 0.25 * VALOR_KM +
			(entregas.isEmpty()?0:entregas.get(entregas.size()-1).getDistancia()*VALOR_KM);	
	}


	
	public boolean agregar(Entrega entrega) {
	
		
		if (pesoTotal + entrega.getPeso() > movil.getCapacidadCarga()) {
			return false;
		}
		else
		{
			entregas.add(entrega);
			pesoTotal = pesoTotal + entrega.getPeso();
			distanciaTotal = distanciaTotal + entrega.getDistancia();
			
			return true;
		}
	}
	
	
	public abstract String tipoHojaRuta() ;

	
	public Movil getMovil() {
		return movil;
	}


	public void setMovil(Movil movil) {
		this.movil = movil;
	}


	public ArrayList<Entrega> getEntregas() {
		return entregas;
	}


	public void setEntregas(ArrayList<Entrega> entregas) {
		this.entregas = entregas;
	}


	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(float pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public float getDistanciaTotal() {
		return distanciaTotal;
	}

	public void setDistanciaTotal(float distanciaToal) {
		this.distanciaTotal = distanciaToal;
	}


	

	public static float getVALOR_ENTREGA() {
		return VALOR_ENTREGA;
	}


	public static void setVALOR_ENTREGA(float vALOR_ENTREGA) {
		VALOR_ENTREGA = vALOR_ENTREGA;
	}


	public static float getVALOR_KG() {
		return VALOR_KG;
	}


	public static void setVALOR_KG(float vALOR_KG) {
		VALOR_KG = vALOR_KG;
	}


	public static float getVALOR_KM() {
		return VALOR_KM;
	}


	public static void setVALOR_KM(float vALOR_KM) {
		VALOR_KM = vALOR_KM;
	}



	
	
	
	@Override
	public String toString() {
		return   "Capacidad "+ movil.getCapacidadCarga() + " Peso " + pesoTotal+ " Km " + distanciaTotal;
				
	}

	
	
	

}
