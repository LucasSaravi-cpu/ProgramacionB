package modeloclases;

import java.util.List;

public class Compartimento {

	
  private String idcompartimento;
  private String descripcion;
  private int capacidad;
  private int cartocupada;
  private Area area;
  public static final double COSTO_DIARIO_COMPARTIMENTO = 1000;
  public static final double COSTO_DIARIO_NIVEL = 10;
  public static final double COSTO_DIARIO_ESTANTERIA = 100;
  public static final double COSTO_KILOWATT_DIA = 10;
  
public Compartimento(String idcompartimento, String descripcion, int cantidad, int cartocupada,Area area) {
	super();
	this.idcompartimento = idcompartimento;
	this.descripcion = descripcion;
	this.capacidad = cantidad;
	this.cartocupada = cartocupada;
	this.area=area;
}






public String getIdcompartimento() {
	return idcompartimento;
}






public void setIdcompartimento(String idcompartimento) {
	this.idcompartimento = idcompartimento;
}






public String getDescripcion() {
	return descripcion;
}






public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}






public int getCantidad() {
	return capacidad;
}






public void setCantidad(int cantidad) {
	this.capacidad = cantidad;
}






public int getCartocupada() {
	return cartocupada;
}






public void setCartocupada(int cartocupada) {
	this.cartocupada = cartocupada;
}






public Area getArea() {
	return area;
}






public void setArea(Area area) {
	this.area = area;
}



public double CalculaCostoDiario() {
	
	double costo =Compartimento.COSTO_DIARIO_COMPARTIMENTO *cartocupada/capacidad;
	
	return costo;
	
}


public boolean agregarCantidad( int cantidad) {
	boolean es = false;
	if (capacidad>=cantidad){
		 es=true;
	}
	return es;
	
}

public boolean retirarCantidad(int cantidad) {
	boolean es = false;
	
	if (cartocupada>=cantidad)
	{
		es=true;
	}
	return es;
	
	
	
}


@Override
public String toString() {
	return  idcompartimento + " " +descripcion + "  capacidad  "+ capacidad + "  ocupado " + cartocupada ;
  

}	

}
