package init;

import controlador.Clinica;
import modelo.Profesional;
import modelo.Medicamento;
import modelo.Paciente;
import vista.VentanaIndicaciones;

public class RunClinica {

	public static void main(String[] args) {
		Clinica clinica = new Clinica("Clínica del Dr. Mortensen");
		
		clinica.agregar(new Paciente("Elsa Payo", "1111"));
		clinica.agregar(new Paciente("Esteban Quito", "2222"));
		clinica.agregar(new Paciente("Marco Puerta", "3333"));
		clinica.agregar(new Paciente("Susana Torio", "4444"));
		clinica.agregar(new Paciente("Elvio Lin", "5555"));
		clinica.agregar(new Paciente("Mar Brava", "6666"));
		clinica.agregar(new Paciente("Pía Fuerte", "7777"));
		clinica.agregar(new Paciente("Esteban Dido", "8888"));		
		clinica.agregar(new Paciente("Leo Paredes", "9999"));		
		clinica.agregar(new Paciente("Clara Boya", "1234"));		

		clinica.agregar(new Profesional("Dra. Claudia Alivio", 1000, "Clinica Médica"));
		clinica.agregar(new Profesional("Dra. Corazon Ligero", 2000, "Cardiologia"));
		clinica.agregar(new Profesional("Dr. Marcelo Pequeño", 3000, "Pediatria"));
		clinica.agregar(new Profesional("Dr. Alberto Lunares", 4000, "Dermatologia"));
		
		clinica.agregar(new Medicamento("12345", "IBUPROFENO 500 mg", "comprimido"));
		clinica.agregar(new Medicamento("67890", "ACICLOVIR 20 mg", "capsula"));
		clinica.agregar(new Medicamento("54321", "LEXOTANIL 1g", "compr.recubierto"));
		clinica.agregar(new Medicamento("09876", "AMOXICILINA 1000 mg", "ampolla"));
		clinica.agregar(new Medicamento("22334", "PARACETAMOL 10 mg", "comprimido"));
		
		VentanaIndicaciones ventanaStands = new VentanaIndicaciones(clinica);
		ventanaStands.setVisible(true);
	}

}
