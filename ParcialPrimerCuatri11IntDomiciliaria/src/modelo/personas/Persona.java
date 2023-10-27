package modelo.personas;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import utils.FuncionesVarias;

public abstract class Persona {

	private int dni;
	private String nombre;
	private Date fechaNacimiento;
	
	
	public Persona(int dni, String nombre, Date fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/*
	 * Retorna la edad en años
	 */
	public int getEdad() {
		LocalDate localDate = fechaNacimiento.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
		Period p = localDate.until(LocalDate.now());

		return p.getYears();		
	}
	
	@Override
	public String toString() {
		return getNombre() + " (DNI " + dni + ")" + "F.Nacimiento :" + FuncionesVarias.formateaFecha(fechaNacimiento);
	}
}
