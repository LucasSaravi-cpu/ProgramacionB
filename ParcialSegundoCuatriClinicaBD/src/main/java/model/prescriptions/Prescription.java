package model.prescriptions;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Patient;

public abstract class Prescription implements Comparable {

	private int prescription;
	private Patient patient;
	private Date date;
	private String professional;
	
	public Prescription(int prescription, Patient patient, Date date, String professional) {
		super();
		this.prescription = prescription;
		this.patient = patient;
		this.date = date;
		this.professional = professional;
	}

	public int getPrescription() {
		return prescription;
	}

	public void setPrescription(int prescription) {
		this.prescription = prescription;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}	
	
	@Override
	public int compareTo(Object o) {
	    Prescription other = (Prescription) o;    
	    return this.getPatient().compareTo(other.getPatient());
	}
	
	
	public abstract String tipoprescription();
	public abstract double getCosto();

	@Override
	public String toString() {
		return date + " " + professional ;
	}


		
		
		
	
}
