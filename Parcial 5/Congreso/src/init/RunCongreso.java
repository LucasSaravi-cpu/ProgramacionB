package init;

import java.util.Date;

import controlador.Congreso;
import modelo.Universidad;
import modelo.Alumno;
import modelo.AreaTematica;
import modelo.Empresa;
import modelo.TrabajoEstudiantil;
import vista.VentanaTrabajos;

public class RunCongreso {

	public static void main(String[] args) {
		Congreso congreso = new Congreso("INFORCong", "Mar del Plata", new Date(2022,11,22));
		
		congreso.agregar(new Empresa("Agrometal", "1111"));
		congreso.agregar(new Empresa("InforMax", "2222"));
		congreso.agregar(new Empresa("Net3 S.A.", "3333"));
		congreso.agregar(new Empresa("System SRL", "4444"));
		
		congreso.agregar(new Universidad(1, "Univ. FASTA", false));
		congreso.agregar(new Universidad(2, "Univ. Oeste", true));
		congreso.agregar(new Universidad(3, "Univ. Delta", false));
		congreso.agregar(new Universidad(4, "Univ. Norte", true));
		congreso.agregar(new Universidad(5, "Univ.  Este", true));
		
		congreso.agregar(new AreaTematica(1, "Ing. Sistemas"));
		congreso.agregar(new AreaTematica(2, "Sist.Operativos"));
		congreso.agregar(new AreaTematica(3, "Bases de Datos"));
		congreso.agregar(new AreaTematica(4, "Seg.Informatica"));
		congreso.agregar(new AreaTematica(5, "Int. Artificial"));

		congreso.agregar(new Alumno(1, "Juan Pedro", congreso.getListaUniversidades().get(0)));
		congreso.agregar(new Alumno(2, "Ana Daiana", congreso.getListaUniversidades().get(1)));
		congreso.agregar(new Alumno(3, "Sebastiano", congreso.getListaUniversidades().get(0)));
		congreso.agregar(new Alumno(4, "Diana Maia", congreso.getListaUniversidades().get(2)));
		congreso.agregar(new Alumno(5, "Carlos Teo", congreso.getListaUniversidades().get(1)));
		congreso.agregar(new Alumno(6, "Analía Lía", congreso.getListaUniversidades().get(3)));
		congreso.agregar(new Alumno(7, "Onofre Ian", congreso.getListaUniversidades().get(0)));
		congreso.agregar(new Alumno(8, "Diego Leon", congreso.getListaUniversidades().get(3)));
		congreso.agregar(new Alumno(9, "Alejo Luis", congreso.getListaUniversidades().get(4)));
		
		VentanaTrabajos ventanaTrabajos = new VentanaTrabajos(congreso);
		ventanaTrabajos.setVisible(true);
		
	

	
	}

}
