package init;

import java.time.LocalDate;
import java.util.Date;

import controlador.Empresa;
import modelo.parametricas.Especialidad;
import modelo.personas.Enfermero;
import modelo.personas.Kinesiologo;
import modelo.personas.Medico;
import modelo.personas.Paciente;
import vista.VentanaInternaciones;

public class RunIntDomiciliaria {

	public static void main(String[] args) {
		Empresa empresa = new Empresa("Salud en Casa");
		Especialidad e1 = new Especialidad("Cardiología");
		empresa.agregar(e1);
		Especialidad e2 = new Especialidad("Cl.Médica");
		empresa.agregar(e2);
		Especialidad e3 = new Especialidad("Pediatria");
		empresa.agregar(e3);
		Especialidad e4 = new Especialidad("Enfermería");
		empresa.agregar(e4);
		Especialidad e5 = new Especialidad("Kinesiología");
		empresa.agregar(e5);
		
		empresa.agregar(new Medico(11111, "Juan Cureta", new Date(65, 8, 10), "Dr.", "12345", e2));
		empresa.agregar(new Medico(22222, "Ana Curatella", new Date(81, 8, 15), "Dra.", "67890", e1));
		empresa.agregar(new Medico(33333, "Alan Pinino", new Date(89, 2, 19), "Dr.", "13579", e3));
		empresa.agregar(new Kinesiologo(44444, "Jose Dedos", new Date(81, 8, 15), "Lic.", "24680", e5, true));		
		empresa.agregar(new Kinesiologo(55555, "Leara Massage", new Date(97, 6, 30), "Lic.", "97531", e5, false));
		empresa.agregar(new Enfermero(66666, "Lia Jeringola", new Date(81, 8, 15), "Enf.", "86420", e4, true));
		empresa.agregar(new Enfermero(77777, "Leo Curatuti", new Date(100, 1, 1), "Enf.", "91375", e4, false));
		
		empresa.agregar(new Paciente(11223, "Peter Duck", new Date(70, 1, 1), "Salta 1234"));
		empresa.agregar(new Paciente(22334, "John Horse", new Date(80, 1, 1), "Jujuy 3328"));
		empresa.agregar(new Paciente(33445, "Anne Birds", new Date(90, 1, 1), "Agote 4545"));
		empresa.agregar(new Paciente(44556, "Laura Cows", new Date(105, 1, 1), "Funes 6655"));
		empresa.agregar(new Paciente(55667, "Donald Dog", new Date(118, 1, 1), "E.Rios 975"));
		
		VentanaInternaciones ventana = new VentanaInternaciones(empresa);
		ventana.setVisible(true);
	}

}
