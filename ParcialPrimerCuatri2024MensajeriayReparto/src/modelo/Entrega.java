package modelo;

import java.time.LocalDate;

import modelo.Zonas.Zona;


public class Entrega {
	
	  private LocalDate fechaRecepcion;
	  private String num;
	  private String nombreDestinatoario;
	  private String domicilio;
	  private float distancia;
	  private float peso;
	  private float temperaturaRecomendada;
      private Zonas.Zona zona;
      
     
   
      
      
      public Entrega(String num, String nombreDestinatoario, String domicilio, float distancia, float peso,
			 Zona zona,float temperaturaRecomendada) {
		super();
		this.num = num;
		this.nombreDestinatoario = nombreDestinatoario;
		this.domicilio = domicilio;
		this.distancia = distancia;
		this.peso = peso;
		this.temperaturaRecomendada = temperaturaRecomendada;
		this.zona = zona;
	}









	public LocalDate getFechaRecepcion() {
		return LocalDate.of(2024, 6, 28);
	}





	public void setFechaRecepcion(LocalDate fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}





	public String getNum() {
		return num;
	}





	public void setNum(String num) {
		this.num = num;
	}





	public String getNombreDestinatoario() {
		return nombreDestinatoario;
	}





	public void setNombreDestinatoario(String nombreDestinatoario) {
		this.nombreDestinatoario = nombreDestinatoario;
	}





	public String getDomicilio() {
		return domicilio;
	}





	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}





	public float getDistancia() {
		return distancia;
	}





	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}





	public float getPeso() {
		return peso;
	}





	public void setPeso(float peso) {
		this.peso = peso;
	}





	public float getTemperaturaRecomendada() {
		return temperaturaRecomendada;
	}





	public void setTemperaturaRecomendada(float temperaturaRecomendada) {
		this.temperaturaRecomendada = temperaturaRecomendada;
	}





	public Zonas.Zona getZona() {
		return zona;
	}





	public void setZona(Zonas.Zona zona) {
		this.zona = zona;
	}





	@Override
	public String toString() {
		return   num + " - "+ nombreDestinatoario + "  -  " + domicilio + "  km:  " + distancia + "  kg: " + peso+ "  °C : " + temperaturaRecomendada ;
	}
      
      
      
	  


	

	  
	  

}
