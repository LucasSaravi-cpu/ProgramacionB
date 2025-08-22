package run;

import control.BolsaTrabajo;
import modelo.Candidato;
import modelo.Empresa;
import modelo.Habilidad;
import modelo.Independiente;
import modelo.Modalidad;
import modelo.PuestoTrabajo;
import modelo.TiempoCompleto;
import modelo.TiempoParcial;

public class Main {

	
	public static void main(String[] args) {
	
		  BolsaTrabajo bolsaTrabajo = new BolsaTrabajo("TuTrabajoEstaAca");
		  
		  //Se crean las empresas
	      
		    bolsaTrabajo.agregar(new Empresa("Acme Corp", "Tecnología"));
	        bolsaTrabajo.agregar(new Empresa("Rubrick", "Software"));
	        bolsaTrabajo.agregar(new Empresa("Sunrise", "Turismo"));
	        bolsaTrabajo.agregar(new Empresa("Crabber", "Comercio Electronico"));
           //Se crean las habilidades
	        bolsaTrabajo.agregar(new Habilidad("Java"));
	        bolsaTrabajo.agregar(new Habilidad("SQL"));
	        bolsaTrabajo.agregar(new Habilidad("Git"));
	        bolsaTrabajo.agregar(new Habilidad("HTML"));
	        bolsaTrabajo.agregar(new Habilidad("POO"));
	        bolsaTrabajo.agregar(new Habilidad("React"));
	        bolsaTrabajo.agregar(new Habilidad("Python"));
	        bolsaTrabajo.agregar(new Habilidad("C#"));
	        bolsaTrabajo.agregar(new Habilidad("Scrum"));
	        bolsaTrabajo.agregar(new Habilidad("Testing"));
	        bolsaTrabajo.agregar(new Habilidad("BackEnd"));
	        bolsaTrabajo.agregar(new Habilidad("FrontEnd"));
	        bolsaTrabajo.agregar(new Habilidad("UX/UI"));
	     //Se crean los candidatos con habilidades al azar ( Se le crea un atributo que es un lista y se le adjunta el metodo que crea una lista al azar de habilidades
	    
	        Candidato candidato1 = new Candidato ("Lucas",1,bolsaTrabajo.habilidadesAlAzar());
	        Candidato candidato2 = new Candidato ("Mariano",2,bolsaTrabajo.habilidadesAlAzar());
	        Candidato candidato3 = new Candidato ("jorge",3,bolsaTrabajo.habilidadesAlAzar());
	        Candidato candidato4 = new Candidato ("jorge",4,bolsaTrabajo.habilidadesAlAzar());
	  
	    //Se agregan los candidatos a la lista en la bolsa de trabajo
	        bolsaTrabajo.agregar(candidato1);
	        bolsaTrabajo.agregar(candidato2);
	        bolsaTrabajo.agregar(candidato3);
	        bolsaTrabajo.agregar(candidato4);
	    //Se crean diferentes instancias de puestos de trabajo     
	        PuestoTrabajo puestotrabajo1 = new TiempoCompleto(bolsaTrabajo.empresaAlAzar(),"PuestoTrabajo1",10000.00,2,bolsaTrabajo.modalidadAlAzar(),bolsaTrabajo.habilidadesAlAzar(),2); 
	        PuestoTrabajo puestotrabajo2 = new TiempoParcial(bolsaTrabajo.empresaAlAzar(),"PuestoTrabajo2",100000.00,2,bolsaTrabajo.modalidadAlAzar(),bolsaTrabajo.habilidadesAlAzar(),2,4); 
	        PuestoTrabajo puestotrabajo3 = new Independiente(bolsaTrabajo.empresaAlAzar(),"PuestoTrabajo3",5000.00,2,bolsaTrabajo.modalidadAlAzar(),bolsaTrabajo.habilidadesAlAzar(),5);
	        
	        PuestoTrabajo puestotrabajo4 = new Independiente(bolsaTrabajo.empresaAlAzar(),"PuestoTrabajo4",50000.00,9,bolsaTrabajo.modalidadAlAzar(),bolsaTrabajo.habilidadesAlAzar(),2);
	        
	        PuestoTrabajo puestotrabajo5 = new TiempoParcial(bolsaTrabajo.empresaAlAzar(),"PuestoTrabajo5",10000.00,8,bolsaTrabajo.modalidadAlAzar(),bolsaTrabajo.habilidadesAlAzar(),2,4); 
	        PuestoTrabajo puestotrabajo6 = new TiempoParcial(bolsaTrabajo.empresaAlAzar(),"PuestoTrabajo6",100000.00,3,bolsaTrabajo.modalidadAlAzar(),bolsaTrabajo.habilidadesAlAzar(),2,5); 
	        
		//Se agregan a la lista los puestos de trabajo en la bolsatrabajo
	        bolsaTrabajo.agregar(puestotrabajo1);
	        bolsaTrabajo.agregar(puestotrabajo2);
	        bolsaTrabajo.agregar(puestotrabajo3);
	        bolsaTrabajo.agregar(puestotrabajo4);
	        bolsaTrabajo.agregar(puestotrabajo5);
	        bolsaTrabajo.agregar(puestotrabajo6);
	        
	        
	 System.out.println(   bolsaTrabajo.ListarPuestosConCandidatos(60));
	    
		      
	}

}
