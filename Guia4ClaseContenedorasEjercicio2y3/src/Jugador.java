
public class Jugador {

	private String nombre;
	private int ranking;
	private int edad;
	private String equipo;
	
	
	public Jugador(String nombre, int ranking, int edad , String equipo) {
		super();
		this.nombre = nombre;
		this.ranking = ranking;
		this.edad = edad;
		this.equipo = equipo;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getEquipo() {
		return equipo;
	}


	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}



	
}
