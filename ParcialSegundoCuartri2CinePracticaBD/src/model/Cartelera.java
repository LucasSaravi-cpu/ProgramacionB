package model;

public class Cartelera extends Peliculas{

	public Cartelera(String nombre, String a�o, String tipo, int entradas) {
		super(nombre, a�o, tipo, entradas);
		// TODO Auto-generated constructor stub
	}
	
	  @Override
		public float costoEntrada () {
	    	
	    	float monto =0;
	    	
	    	monto= (float) (getEntradas()*1500*0.9);
	    	
	    	
			return monto;
		}
	

}
