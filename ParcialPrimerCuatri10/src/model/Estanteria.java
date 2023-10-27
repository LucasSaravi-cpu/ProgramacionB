package model;



public class Estanteria extends  Compartimento {

private int cantidad;

public Estanteria(String identificacion, String descripcion, int capacidad, String ubicacion, int cantidad) {
	super(identificacion, descripcion, capacidad, ubicacion);
	this.cantidad = cantidad;
}


public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}


@Override
public String toString() {
	return super.toString() + "cantidad: " + cantidad +"\n" ;
}

public String tipocompartimento() {
	 return "Estanteria";
}
	
}
