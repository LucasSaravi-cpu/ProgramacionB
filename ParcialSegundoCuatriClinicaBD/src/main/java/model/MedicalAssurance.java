package model;

public class MedicalAssurance {

	private int medicalAssurance;
	private String name;
	
	public MedicalAssurance(int medicalAssurance, String name) {
		super();
		this.medicalAssurance = medicalAssurance;
		this.name = name;
	}	
	
	public int getMedicalAssurance() {
		return medicalAssurance;
	}
	public void setMedicalAssurance(int medicalAssurance) {
		this.medicalAssurance = medicalAssurance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
