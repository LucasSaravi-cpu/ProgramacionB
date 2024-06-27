import java.util.ArrayList;

public class Torneo {


	private String NombreTorneo;
    private ArrayList<Equipo> equipos;

	
	

	public Torneo(String nombreTorneo) {
		super();
		NombreTorneo = nombreTorneo;
		 this.equipos = new ArrayList<Equipo>();
	}


	public String getNombreTorneo() {
		return NombreTorneo;
	}


	public void setNombreTorneo(String nombreTorneo) {
		NombreTorneo = nombreTorneo;
	}


	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}


	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}


	@Override
	public String toString() {
		return "Torneo " + NombreTorneo ;
	}



	
	
}
