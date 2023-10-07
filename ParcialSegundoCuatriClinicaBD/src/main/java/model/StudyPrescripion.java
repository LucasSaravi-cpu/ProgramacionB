package model;

import java.util.Date;

import model.prescriptions.Prescription;

public class StudyPrescripion extends Prescription {
	
private String requiredStudy;
private String diagnosis;

public StudyPrescripion(int prescription, Patient patient, Date date, String professional, String requiredStudy,
		String diagnosis) {
	super(prescription, patient, date, professional);
	this.requiredStudy = requiredStudy;
	this.diagnosis = diagnosis;
}

public String getRequiredStudy() {
	return requiredStudy;
}

public void setRequiredStudy(String requiredStudy) {
	this.requiredStudy = requiredStudy;
}

public String getDiagnosis() {
	return diagnosis;
}

public void setDiagnosis(String diagnosis) {
	this.diagnosis = diagnosis;
}

@Override
public String toString() {
	return super.toString()+ requiredStudy + "Diagnostico" + diagnosis ;
}


	
public  String tipoprescription() {
	return "Estudio Medico";
}
	
public double getCosto() {
	
	float costo = 1000;
	
	
	return costo;
	
}
	

}
