package model;

public class Estrenos extends Peliculas {

	public Estrenos(String nombre, String a�o, String tipo, int entradas) {
		super(nombre, a�o, tipo, entradas);
		// TODO Auto-generated constructor stub
	}
    @Override
	public float costoEntrada () {
    	
    	float monto =0;
    	
    	monto= getEntradas()*1500;
    	
    	
		return monto;
	}
	

}
