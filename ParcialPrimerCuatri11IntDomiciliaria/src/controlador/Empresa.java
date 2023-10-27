package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.internaciones.Internacion;
import modelo.internaciones.VisitasXProfesional;
import modelo.parametricas.Especialidad;
import modelo.personas.Paciente;
import modelo.personas.Profesional;
import vista.PanelCargaInternados;

public class Empresa {
	
	private String nombre;
	private List<Paciente> listaPacientes;
	private List<Especialidad> listaEspecialidades;
	private List<Profesional> listaProfesionales;

	private List<Internacion> listaInternaciones;

	public Empresa(String nombre) {
		this.setNombre(nombre);
		listaPacientes = new ArrayList<Paciente>();
		listaProfesionales = new ArrayList<Profesional>();
		listaInternaciones = new ArrayList<Internacion>();
		listaEspecialidades = new ArrayList<Especialidad>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregar(Paciente paciente) {
		listaPacientes.add(paciente);
	}
	
	public void agregar(Profesional profesional) {
		listaProfesionales.add(profesional);
	}
	
	public void agregar(Internacion internacion) {
        listaInternaciones.add(internacion);		
	}
	
	public void agregar(Especialidad especialidad) {
        listaEspecialidades.add(especialidad);		
	}

	public Iterator<Paciente> getPacientes() {
		return listaPacientes.iterator();
	}

	public Iterator<Profesional> getProfesionales() {
		return listaProfesionales.iterator();
	}
	
	public Iterator<Especialidad> getEspecialidades() {
		return listaEspecialidades.iterator();
	}

	public String listarInternados() {
	
		/*
		 * DESARROLLAR aquí la funcionalidad para listar la información de todos los internados presentes en listaInternaciones 
		 */
		
		int j =0, total =0;
		String s = "Salud en casa ===============================================================================================================\n\n";
		
		for (int i=0; i<listaInternaciones.size(); i++) {
//			while (listaPacientes.get(j).) {
//				j++;
//			}
			s+= listaPacientes.get(0).toString();
			s+= listaInternaciones.get(i).toString();
			for (VisitasXProfesional aux: PanelCargaInternados.getListPlanVisitas()){
				total+= aux.getCostoSemanal();
				System.out.println(total);
				System.out.println(aux.getCostoSemanal());
				System.out.println(PanelCargaInternados.getListPlanVisitas().get(0));
				System.out.println(PanelCargaInternados.getListPlanVisitas().size()); //TODO
			}

			s+= "\nTotal semanal: $" + total;
			
		
			s+="\n________________________________________________________________________________________________________________________";
			s+="\n";
		}
		return s+="\n________________________________________________________________________________________________________________________";
	}
	
	
}
