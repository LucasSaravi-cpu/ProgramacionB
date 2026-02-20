package Init;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import Modelo.Alumno;
import Modelo.AlumnoExterno;
import Modelo.AlumnoRegular;
import Modelo.Asignatura;
import Modelo.Evaluacion;
import Modelo.EvaluacionesIncompletasException;
import Modelo.TipoEvaluacion;


public class Main {

	public static void main(String[] args) {
	
		
		
		Asignatura asignatura = new Asignatura ("Programacion B");
		
		Alumno Alumno1 = new AlumnoRegular("Maria", 80);		
		Alumno Alumno3 = new AlumnoRegular("Juan", 60);
		Alumno Alumno5 = new AlumnoRegular("Ana", 90);

		Alumno Alumno2 = new AlumnoExterno("Carlos", "TechSoft");
		Alumno Alumno4 = new AlumnoExterno("Laura", "Global SA");
		Alumno Alumno6 = new AlumnoExterno("Pedro", "Innovar");

     asignatura.agregarAlumno(Alumno1);
     asignatura.agregarAlumno(Alumno2);
     asignatura.agregarAlumno(Alumno3);
     asignatura.agregarAlumno(Alumno4);
     asignatura.agregarAlumno(Alumno5);
     asignatura.agregarAlumno(Alumno6);
     
     Random random = new Random();

     
     try {
     
     for (Alumno a : asignatura.getAlumnos()) {
    	 

     a.agregarEvaluacion(new Evaluacion (TipoEvaluacion.PARCIAL1, random.nextDouble(1, 10), random.nextBoolean()));
     a.agregarEvaluacion(new Evaluacion (TipoEvaluacion.PARCIAL2, random.nextDouble(1, 10), random.nextBoolean()));
     a.agregarEvaluacion(new Evaluacion (TipoEvaluacion.TP_GRUPAL, random.nextDouble(1, 10),random.nextBoolean()));
     
     
     a.validarEvaluaciones();
    
     }
     
     System.out.println("Evaluaciones completas ✔");  
     
     
     } catch (EvaluacionesIncompletasException e) {
         System.out.println("Error: " + e.getMessage());
     }
     
    
        
     Main m = new Main();
     
     System.out.printf(m.GenerarInformeFinal(asignatura)) ;

	}
	
	
	public String GenerarInformeFinal(Asignatura asignatura) {
		
		 StringBuilder sb = new StringBuilder();
		 
			
		
		 
	     sb.append("Asignatura"+"\t" + asignatura.getNombre());
	     sb.append("\n");
	     
	     asignatura.getAlumnos().sort((a1, a2) ->  a1.gettipo().compareTo(a2.gettipo()) );
	    
	     
	     // LISTA para alumnos ausentes
	     List<Alumno> alumnosConAusencias = new ArrayList<>();
	     
	     for ( Alumno a : asignatura.getAlumnos()) {
	     sb.append(a.toString() + "\n"); 	
	    
	     boolean faltoAlguna = false;
	     
	        for (Evaluacion e : a.getEvaluaciones()) {
	     
	        	if (e.isAusente()) {
	        	 	
	        	  sb.append(e.getTipo() +"\t"+ "Ausente" +"\n");	
	        	
	        	  faltoAlguna = true;
	        	}
	        	else 
	        		sb.append(e.getTipo() + "\t" + e.getNota()+"\n");
	        	  
	        }
	     
	        if (faltoAlguna) {
	            alumnosConAusencias.add(a);
	        }
	        
	       sb.append("Promedio"+"\t"+ a.calcularPromedio()+"\n");
	       sb.append("Condicion final" +"\t" +a.Condicion()+"\n");
	     
	        
	        
	        
	    	 
	        }
	     
	     
	     
	    
	     sb.append(" ALUMNOS QUE FALTARON A ALGUNA EVALUACIÓN \n");

	     for (Alumno a : alumnosConAusencias) {
	         sb.append(a.getNombre() + "\n");
	     }
	     
	     return sb.toString();
		
	}
	

	
	
	
	
	
}
