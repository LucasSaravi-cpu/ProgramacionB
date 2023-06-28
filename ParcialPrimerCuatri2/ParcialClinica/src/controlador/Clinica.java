package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.Profesional;
import modelo.Paciente;
import modelo.Indicacion;
import modelo.Medicamento;

public class Clinica {
	
	private String nombre;
	private List<Profesional> listaProfesionales;
	private List<Paciente> listaPacientes;
	private List<Medicamento> listaMedicamentos;
	
	private List<Indicacion> listaIndicaciones;
	
	public Clinica(String nombre) {
		this.setNombre(nombre);
		listaProfesionales = new ArrayList<Profesional>();
		listaPacientes = new ArrayList<Paciente>();
		listaMedicamentos = new ArrayList<Medicamento>();
		
	    listaIndicaciones = new ArrayList<Indicacion>();
	}
	
	public void agregar(Indicacion i) {
		listaIndicaciones.add(i);	
		}
	public Iterator<Indicacion> getIndicaciones(){
		return listaIndicaciones.iterator();
	}

	public void agregar(Paciente c) {
		listaPacientes.add(c);
	}
	
	public void agregar(Profesional a) {
		listaProfesionales.add(a);
	}
	
	public Iterator<Paciente> getPacientes() {
		return listaPacientes.iterator();
	}

	public Iterator<Profesional> getProfesionales() {
		return listaProfesionales.iterator();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Iterator<Medicamento> getMedicamentos() {
		return listaMedicamentos.iterator();
	}

	public void agregar(Medicamento medicamento) {
		listaMedicamentos.add(medicamento);
	}


	
	
	public String ListaIndicaciones() {
		StringBuilder result = new StringBuilder("LISTADO de Indicaciones \n");
		result.append("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		
		
		for (Iterator<Indicacion> iterator = getIndicaciones(); iterator.hasNext();) {
			 Indicacion indicacion = iterator.next();
		   
			result.append(indicacion.toString());
			result.append("-\n");
		}
	
		
		
		return result.toString();
	}

	
/*	public String ListarPaaciente(Paciente paciente){
		
		StringBuilder result = new StringBuilder("LISTADO de Indicaciones \n");
		result.append("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		
		
		for (Iterator<Indicacion> iterator = getIndicaciones(); iterator.hasNext();) {
			 Indicacion indicacion = iterator.next();
			
            if (indicacion.getPaciente() == paciente) {

            	result.append(indicacion.getIndicacion());
    			result.append("-\n");
            }
			
		}
			
		return result.toString();
		
	}*/
	
	
	
}
