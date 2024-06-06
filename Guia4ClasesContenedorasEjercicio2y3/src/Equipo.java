import java.util.ArrayList;

public class Equipo implements Comparable<Equipo> {
	
	private String NombreEquipo ;
	
	 private ArrayList<Jugador> jugadores;
    
    


	public Equipo(String nombre , ArrayList<Jugador> jugadores) {
		this.NombreEquipo = nombre;
		this.jugadores= jugadores;
        
	}


	public String getNombreEquipo() {
		return NombreEquipo;
	}


	 public ArrayList<Jugador> getJugadores() {
	        return jugadores;
	    }
    
	

	  public int getRanking() {
	        int ranking = 0;
	        for (Jugador jugador : jugadores) {
	            ranking += jugador.getRanking();
	        }
	        return ranking;
	    }
	    
	    public double getEdadPromedio() {
	        int edadTotal = 0;
	        for (Jugador jugador : jugadores) {
	            edadTotal += jugador.getEdad();
	            
	        }
	        
	      
	        return (double)edadTotal / 4;
	    }
	 
	 
	    public Jugador getJugadorConMayorRanking() {
	        Jugador jugadorConMayorRanking = null;
	        int mayorRanking = Integer.MIN_VALUE;
	        
	        
	            
	                for (Jugador jugador:jugadores) {
	                    if (jugador.getRanking() > mayorRanking) {
	                        mayorRanking = jugador.getRanking();
	                        jugadorConMayorRanking = jugador;
	                    }
	                }
	            
	        
	        
	        return jugadorConMayorRanking;
	    }


	    @Override
	    public int compareTo(Equipo otroEquipo) {
	        return this.NombreEquipo.compareTo(otroEquipo.NombreEquipo);
	    }
	 
}
