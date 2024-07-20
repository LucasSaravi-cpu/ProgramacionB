package modelo;

public class Movil {
	
	private String propietario;
	private TipoMovil.tipoMovil tipomovil;
	private float capacidadCarga ;
	private Zonas.Zona zonas;

	
	
	
	
	




	public TipoMovil.tipoMovil getTipomovil() {
		return tipomovil;
	}









	public void setTipomovil(TipoMovil.tipoMovil tipomovil) {
		this.tipomovil = tipomovil;
	}









	public Zonas.Zona getZonas() {
		return zonas;
	}









	public void setZonas(Zonas.Zona zonas) {
		this.zonas = zonas;
	}









	public Movil(String propietario, TipoMovil.tipoMovil tipomovil, float capacidadCarga, Zonas.Zona zonas) {
		super();
		this.propietario = propietario;
		this.tipomovil = tipomovil;
		this.capacidadCarga = capacidadCarga;
		this.zonas = zonas;
		
	}









	public String getPropietario() {
		return propietario;
	}









	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}









	public float getCapacidadCarga() {
		return capacidadCarga;
	}









	public void setCapacidadCarga(float capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}









	@Override
	public String toString() {
		return  propietario + " - " + tipomovil + " - " + capacidadCarga + " - " + zonas +"\n" ;
	}
























	




	
	
	
	
	
	
	

}
