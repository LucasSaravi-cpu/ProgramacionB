package model;

public class Cartelera extends Peliculas{

	public Cartelera(String nombre, String año, String tipo, int entradas) {
		super(nombre, año, tipo, entradas);
		// TODO Auto-generated constructor stub
	}
	
	  @Override
		public float costoEntrada () {
	    	
	    	float monto =0;
	    	
	    	monto= (float) (getEntradas()*1500*0.9);
	    	
	    	
			return monto;
		}
	

}
