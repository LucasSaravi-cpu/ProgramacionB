package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import modelo.Alumno;
import modelo.AreaTematica;
import modelo.Empresa;
import modelo.Trabajo;
import modelo.TrabajoEstudiantil;
import modelo.Universidad;

public class Congreso {
	private String nombre;
	private String lugar;
	private Date fecha;
	private List<Alumno> listaAlumnos;
	private List<Empresa> listaEmpresas;
	private List<Universidad> listaUniversidades;
	private List<AreaTematica> listaAreasTematicas;
	private List<Trabajo> listaTrabajos;
	
	public List<Trabajo> getListaTrabajos() {
		return listaTrabajos;
	}

	public void setListaTrabajos(List<Trabajo> listaTrabajos) {
		this.listaTrabajos = listaTrabajos;
	}

	public Congreso(String nombre, String lugar, Date fecha) {
		this.setNombre(nombre);
		this.setLugar(lugar);
		this.setFecha(fecha);
		listaAlumnos = new ArrayList<Alumno>();
		listaEmpresas = new ArrayList<Empresa>();
		listaUniversidades = new ArrayList<Universidad>();
		listaTrabajos = new ArrayList<Trabajo>();
		listaAreasTematicas = new ArrayList<AreaTematica>();
	}
	
	public void agregar(Empresa c) {
		listaEmpresas.add(c);
	}

	public void agregar(Universidad u) {
		listaUniversidades.add(u);
	}
	
	public void agregar(Alumno a) {
		listaAlumnos.add(a);
	}
	
	public void agregar(Trabajo t) {
		listaTrabajos.add(t);
	}
	
	public void agregar(AreaTematica at) {
		listaAreasTematicas.add(at);
	}
	
	public Iterator<Empresa> getClientes() {
		return listaEmpresas.iterator();
	}

	
	public Iterator<AreaTematica> getAreasTematicas() {
		return listaAreasTematicas.iterator();
	}

	public Iterator<Alumno> getAlumnos() {
		return listaAlumnos.iterator();
	}
	
	public String getListaInscriptos() {
		StringBuilder result = new StringBuilder("LISTADO de TRABAJOS INSCRIPTOS \n");
		result.append("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		
		
		for (Trabajo a:listaTrabajos ) {
			
		
		  
			
		  
		   
			result.append(a.toString());
			result.append("| \n");
		}
	
		
		
		return result.toString();
	}

	public List<Universidad> getListaUniversidades() {
		return listaUniversidades;
	}
	
	public Iterator<Universidad> getUniversidades() {
		return listaUniversidades.iterator();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(List<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}

	public List<AreaTematica> getListaAreasTematicas() {
		return listaAreasTematicas;
	}

	public void setListaAreasTematicas(List<AreaTematica> listaAreasTematicas) {
		this.listaAreasTematicas = listaAreasTematicas;
	}

	public void setListaUniversidades(List<Universidad> listaUniversidades) {
		this.listaUniversidades = listaUniversidades;
	}

	
	
	
}
