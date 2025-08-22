package modelo;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Candidato {
	
	private String nombre;
	private int aniosExperiencia;
	private List<Habilidad> habilidades;
	
	
	public Candidato(String nombre, int aniosExperiencia, List<Habilidad> habilidades) {
		super();
		this.nombre = nombre;
		this.aniosExperiencia = aniosExperiencia;
		this.habilidades = habilidades;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getAniosExperiencia() {
		return aniosExperiencia;
	}


	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}


	public List<Habilidad> getHabilidades() {
		return habilidades;
	}


	public void setHabilidades(List<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}


	@Override
	public String toString() {
		return "Candidato [nombre=" + nombre + ", aniosExperiencia=" + aniosExperiencia + ", habilidades=" + habilidades
				+ "]";
	}
	
	

	  public double getPorcentajeCoincidencia(PuestoTrabajo p) {
	        List<Habilidad> requeridas = p.getHabilidadesRequeridas();
	        if (requeridas.isEmpty()) return 0;

	        long coincidentes = this.habilidades.stream()
	                                .filter(requeridas::contains)
	                                .count();

	        return (coincidentes * 100.0) / requeridas.size();
	    }

	

}
