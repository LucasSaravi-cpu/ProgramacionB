
public class Torneo {

	private Equipo Equipo;


	private String NombreTorneo;

	
	public Equipo getEquipo() {
		return Equipo;
	}


	public void setEquipo(Equipo equipo) {
		Equipo = equipo;
	}


	public String getNombreTorneo() {
		return NombreTorneo;
	}


	public void setNombreTorneo(String nombreTorneo) {
		NombreTorneo = nombreTorneo;
	}


	public Torneo(String NombreTorneo) {
		super();	
	    this.NombreTorneo=NombreTorneo;
	}

	
	
}
