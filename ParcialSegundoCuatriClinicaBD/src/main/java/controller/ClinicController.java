package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.text.DateFormatter;

import dataaccess.DBManager;

import model.MedicalAssurance;
import model.Medicine;
import model.MedicinePrescription;
import model.Patient;
import model.StudyPrescripion;
import model.prescriptions.Prescription;

public class ClinicController {
	private DBManager dbManager;
	private HashMap<Integer, Medicine> medicines;
	private HashMap<Integer, MedicalAssurance> medicalAssurances;
	private HashMap<Integer, Patient> patients;
	private ArrayList<Prescription> prescriptions;

	public ClinicController() {
		try {
			dbManager = new DBManager("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/clinic", "postgres", "1234");
			this.initialize();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void initialize() {
		medicines = new HashMap<Integer, Medicine>();
		patients = new HashMap<Integer, Patient>();
		medicalAssurances = new HashMap<Integer, MedicalAssurance>();
		prescriptions = new ArrayList<Prescription>();

		//TODO: completar las colecciones de medicinas, pacientes, coberturas medicas y prescripciones con los datos recuperados desde la Base de Datos 
		 try {
        Connection connection = dbManager.getConnection();
		
		
        Statement statement1 = connection.createStatement();
		Statement statement2 = connection.createStatement();
		Statement statement3 = connection.createStatement();
		Statement statement4 = connection.createStatement();
		
	
		
        String query1 = "SELECT medicalassurance , name FROM medicalassurance";
        String query2 = "SELECT medicine , description ,unitprice FROM medicine" ;
        String query3 ="SELECT patient , name , birthdate , medicalassurance FROM patient";
        String query4 ="SELECT prescription ,date , professional , patient , prescriptiontype , dailydose , days ,medicine , studyrequired,diagnosis FROM prescription";
        
        ResultSet Tabla1Cobertura= statement1.executeQuery(query1);
        ResultSet Tabla2Medicamentos= statement2.executeQuery(query2);
        ResultSet Tabla3Pacientes= statement3.executeQuery(query3);
        ResultSet Tabla4Prescripciones= statement4.executeQuery(query4);
		
        
        int k=1;
        while (Tabla1Cobertura.next()) {
            MedicalAssurance medicalAssurance = new MedicalAssurance(Tabla1Cobertura.getInt("medicalassurance"), Tabla1Cobertura.getString("name"));
            medicalAssurances.put(k, medicalAssurance);
            k++;
        }
        int j=1;
        while (Tabla2Medicamentos.next()) {
            Medicine medicine = new Medicine(Tabla2Medicamentos.getInt("medicine"), Tabla2Medicamentos.getString("description"), Tabla2Medicamentos.getBigDecimal("unitprice"));
            medicines.put(j, medicine);
            j++;
        }

        int i = 1;
        while (Tabla3Pacientes.next()) {
            MedicalAssurance medicalAssurance = medicalAssurances.get(Tabla3Pacientes.getInt("medicalassurance"));
            Patient patient = new Patient(Tabla3Pacientes.getInt("patient"), Tabla3Pacientes.getString("name"), Tabla3Pacientes.getDate("birthdate"), medicalAssurance);
            patients.put(i, patient);
            i++;
        }

        while (Tabla4Prescripciones.next()) {
            Patient patient = patients.get(Tabla4Prescripciones.getInt("patient"));
            Medicine medicine = medicines.get(Tabla4Prescripciones.getInt("medicine"));
            String prescriptionType = Tabla4Prescripciones.getString("prescriptiontype");

            if ("M".equals(prescriptionType)) {
                MedicinePrescription prescription = new MedicinePrescription(Tabla4Prescripciones.getInt("prescription"), patient, Tabla4Prescripciones.getDate("date"), Tabla4Prescripciones.getString("professional"), Tabla4Prescripciones.getInt("dailyDose"), Tabla4Prescripciones.getInt("days"), medicine);
                prescriptions.add(prescription);
            } else if ("S".equals(prescriptionType)) {
                StudyPrescripion prescription = new StudyPrescripion(Tabla4Prescripciones.getInt("prescription"), patient, Tabla4Prescripciones.getDate("date"), Tabla4Prescripciones.getString("professional"), Tabla4Prescripciones.getString("studyrequired"), Tabla4Prescripciones.getString("diagnosis"));
                prescriptions.add(prescription);
            }
        }
		





	
	
		   statement1.close();
		   statement2.close();
		   statement3.close();
		   statement4.close();
		  connection.close();	
		 }catch(SQLException e) {
			 e.printStackTrace();
			}

			}
		 
		

	public String costsReports() {
		
		StringBuilder sb = new StringBuilder();
		Statement st;
		sb.append("=============================================================================================================================================");
		sb.append("\n");
		sb.append("Costo de Prescripciones");
		sb.append("\n");
		sb.append("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");		
		sb.append("\n");
		sb.append("Paciente" + "\t" + "Prescripcion" + "\t\t\t\t\t\t\t" + "Costo");
		sb.append("\n");
		sb.append("=============================================================================================================================================");
		sb.append("\n");
		
		//Ordena las prescripciones por Paciente
     	
		// List<Prescription> sortedPrescriptions = prescriptions.stream().sorted(Comparator.comparing(prescription -> prescription.getPatient().getName())).collect(Collectors.toList());
		//Hash sugerido para obtener el total por cobertura medica
		HashMap<String, Double> assurancesCosts = new HashMap<>();

		//TODO: Completar el reporte de los costos de prescripciones a partir de la lista de prescripciones
	
		
	
		for (Patient patient : patients.values()) {
		
		    sb.append(patient.toString()+"\n");
		    double tot = 0; 
		    for (Prescription prescription : prescriptions) {
		        if (prescription.getPatient() == patient) {
		           
		            Double costo = prescription.getCosto();   
		            tot = tot + costo;
		            sb.append("\t"+prescription.toString() +"\t"+prescription.tipoprescription()+"\t" +costo+ "\n");
		            
		        }
		       
		      
		    }
		    assurancesCosts.put(patient.getMedicalAssurance().getName(),tot); 
	        
	      
		   
		}
	
		
    	sb.append("\n\n");
    	sb.append("Totales por Obra Social\n\n");
		//TODO: Mostrar los Totales por cobertura medica
    	 for (Map.Entry<String, Double> entry : assurancesCosts.entrySet()) {
             String nombre = entry.getKey();
             Double total = entry.getValue();
             sb.append(nombre+ ": "+ total + "\n");
            
         }
    
		return sb.toString();
	}

}
