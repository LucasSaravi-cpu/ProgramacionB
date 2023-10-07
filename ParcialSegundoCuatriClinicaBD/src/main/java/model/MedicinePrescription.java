package model;


import java.util.Date;

import model.prescriptions.Prescription;



public class MedicinePrescription extends Prescription {
	private int dailyDose;
	private int days;
	private Medicine medicine;
	
	
	public MedicinePrescription(int prescription, Patient patient, Date date, String professional, int dailyDose,
			int days, Medicine medicine) {
		super(prescription, patient, date, professional);
		this.dailyDose = dailyDose;
		this.days = days;
		this.medicine = medicine;
	}


	public int getDailyDose() {
		return dailyDose;
	}


	public void setDailyDose(int dailyDose) {
		this.dailyDose = dailyDose;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}


	public Medicine getMedicine() {
		return medicine;
	}


	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}


	@Override
	public String toString() {
		return super.toString()+ "Dosis diaria " + dailyDose + " dias : " + days + "medicamento " + medicine ;
	}
	
	
	public  String tipoprescription() {
		return "Medicamento";
	}
	
	public double getCosto() {
	
	
		
		return  dailyDose*days*medicine.getUnitPrice().doubleValue();
		
	}
	

}
