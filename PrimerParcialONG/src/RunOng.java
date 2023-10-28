import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RunOng {

	public static void main(String[] args) {
		
		ong ong = new ong("Ong La solidaria  -Lista de colaboradores"); 
		
		HashMap<String, Double> colaboraciones  = new HashMap<>();
		
		Colaboracion colaboracion1 = new Colaboracion("Apoyo escolar",-5000);
		Colaboracion colaboracion2 = new Colaboracion("Tarea administrativa",-30000);
		Colaboracion colaboracion3 = new Colaboracion("Difusion de la Ong",-15000);
	    ong.getColaboraciones().add(colaboracion1);
	    ong.getColaboraciones().add(colaboracion2);
	    ong.getColaboraciones().add(colaboracion3);
		
		Aportante aportante1 = new Aportante("juan",2000,30000);
		
		Voluntario voluntario1= new Voluntario("Luis",2000);
		
		Aportante aportante2= new Aportante("Ciro",2020,3000);
		Aportante aportante3 = new Aportante("Lara",2021,50000);
		
		Voluntario voluntario2 = new Voluntario("Aldo",2021);
	  
		
		
		Colaborador colaborador1 = aportante1;
		Colaborador colaborador2 = aportante2;
		Colaborador colaborador3 = aportante3;
		Colaborador colaborador4 = voluntario1;
		Colaborador colaborador5 = voluntario2;
		voluntario1.getColaboraciones().add(colaboracion1);
		voluntario1.getColaboraciones().add(colaboracion2);
		voluntario2.getColaboraciones().add(colaboracion3);
		voluntario2.getColaboraciones().add(colaboracion1);

		
       ong.getColaboradores().add(colaborador1);
       ong.getColaboradores().add(colaborador2);
       ong.getColaboradores().add(colaborador3);
       ong.getColaboradores().add(colaborador4);
       ong.getColaboradores().add(colaborador5);
       
		int cantidadDeColaboradores=0;
		double aportes=0;
	
		double costoColaboracion=0;
		System.out.println(ong.toString());
		System.out.println("nombre"+"\t"+"año"+"\t"+"Aporte"+"\t"+"tipo colaborador"+"\t"+"colaboraciones"+"\n");
	
	
		
		
		for (Colaborador col : ong.getColaboradores()) {
			
			cantidadDeColaboradores++;
			
			if (col.tipo().equals("APORTANTE")) {
			
				aportes= aportes + ((Aportante) col).getAporteMensual(); // se sumarian el aporte mensual
				System.out.println(col.toString() +"\t"+col.aporte() +"\n");
				
				
				
			}
			if (col.tipo().equals("VOLUNTARIO")) {
				
				System.out.println(col.toString() +"\t" +"\t"+col.tipo()+"\n");
			
				    
				  for (Colaboracion colaboracion : ((Voluntario)col).getColaboraciones()) {
			            System.out.println("\t\t\t\t\t\t Colaboración: " + colaboracion.toString() + "\n");
			            costoColaboracion += colaboracion.getCostomesxVoluntario();
			           
			         
			            
			            // Actualizar el HashMap de colaboraciones
			            if (colaboraciones.containsKey(colaboracion.getDescripcion())) {
			                // Si la colaboración ya existe en el HashMap, suma el costo actual al total existente
			                double total = colaboraciones.get(colaboracion.getDescripcion()) + colaboracion.getCostomesxVoluntario();
			                colaboraciones.put(colaboracion.getDescripcion(), total);
			            } else {
			                // Si la colaboración no existe en el HashMap, agrega una nueva entrada con el costo
			                colaboraciones.put(colaboracion.getDescripcion(), colaboracion.getCostomesxVoluntario());
			            }
			            
			            
			      
			        }
			           
			        
			

                 
				
			}
			
		
		
		
		
	 
	
		

	}
		System.out.println("Detalles de ingreso y egreso \n");
		System.out.println("Aportes "+aportes+"\n");
		
		for (Map.Entry<String, Double> entry : colaboraciones.entrySet()) {
		    String descripcion = entry.getKey();
		    Double total = entry.getValue();
		    System.out.println("Colaboración: " + descripcion + ", Total: " + total + "\n");
		}
		
		
		System.out.println("La cantidad de colaboradores es "+cantidadDeColaboradores+"\n");
		 System.out.println("El presupuesto es superavitario en "+ (aportes+costoColaboracion)+"\n");
	}
}
