package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {
	
	private String nombre;
	private List<Alumno> alumnos;
	
	 public Asignatura(String nombre) {
	        this.nombre = nombre;
	        this.alumnos = new ArrayList<>();
	    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	 public void agregarAlumno(Alumno e) {
	        alumnos.add(e);
	    }
	 
	 
}
