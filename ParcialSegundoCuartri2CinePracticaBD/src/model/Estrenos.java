package model;

public class Estrenos extends Peliculas {

	public Estrenos(String nombre, String año, String tipo, int entradas) {
		super(nombre, año, tipo, entradas);
		// TODO Auto-generated constructor stub
	}
    @Override
	public float costoEntrada () {
    	
    	float monto =0;
    	
    	monto= getEntradas()*1500;
    	
    	
		return monto;
	}
	

}
