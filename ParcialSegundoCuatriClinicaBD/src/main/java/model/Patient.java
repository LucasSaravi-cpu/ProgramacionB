package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Patient implements Comparable {

	private int patient;
	private String name;
	private Date birthdate;
	private MedicalAssurance medicalAssurance;
	
	public Patient(int patient, String name, Date birthdate,
			MedicalAssurance medicalAssurance) {
		super();
		this.patient = patient;
		this.name = name;
		this.birthdate = birthdate;
		this.medicalAssurance = medicalAssurance;
	}

	public int getPatient() {
		return patient;
	}

	public void setPatient(int patient) {
		this.patient = patient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public MedicalAssurance getMedicalAssurance() {
		return medicalAssurance;
	}

	public void setMedicalAssurance(MedicalAssurance medicalAssurance) {
		this.medicalAssurance = medicalAssurance;
	}

	@Override
	public int compareTo(Object o) {
	    Patient other = (Patient) o;	    
	    return new Integer(this.getPatient()).compareTo(new Integer(other.getPatient()));
	}

	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append(getName()).append("\tFecha Nacimiento: ").append(simpleDateFormat.format(getBirthdate()))
			.append("\tObra Social: ").append(getMedicalAssurance().getName());
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(patient);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return patient == other.patient;
	}
}
