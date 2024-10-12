import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RunOng {

	public static void main(String[] args) {
		
		ong ong = new ong("Ong La solidaria  - Lista de colaboradores"); 
		
		
		Colaboracion colaboracion1 = new Colaboracion("Apoyo escolar",-5000);
		Colaboracion colaboracion2 = new Colaboracion("Tarea administrativa",-30000);
		Colaboracion colaboracion3 = new Colaboracion("Difusion de la Ong",-15000);
	    ong.getColaboraciones().add(colaboracion1);
	    ong.getColaboraciones().add(colaboracion2);
	    ong.getColaboraciones().add(colaboracion3);
		
		Colaborador aportante1 = new Aportante("juan",2000,30000);		
		Colaborador voluntario1= new Voluntario("Luis",2008);		
		Colaborador aportante2= new Aportante("Ciro",2020,3000);
		Colaborador aportante3 = new Aportante("Lara",2021,50000);
		Colaborador voluntario2 = new Voluntario("Aldo",2021);
	  
		
		voluntario1.getColaboraciones().add(colaboracion1);
		voluntario1.getColaboraciones().add(colaboracion2);
		voluntario2.getColaboraciones().add(colaboracion3);
	    voluntario2.getColaboraciones().add(colaboracion1);

       ong.getColaboradores().add(aportante1);
       ong.getColaboradores().add(aportante2);
       ong.getColaboradores().add(aportante3);
       ong.getColaboradores().add(voluntario1);
       ong.getColaboradores().add(voluntario2);
  
		 
       HashMap<String, Double> colaboracionesMap = new HashMap<>();
        int cantidadDeColaboradores = 0;
	  
      
        
		StringBuilder sb = new StringBuilder();
		sb.append("==============================================================================").append("\n");
		sb.append(ong.toString()).append("\n");
		sb.append("------------------------------------------------------------------------------").append("\n");
		sb.append("nombre").append("\t").append("año").append("\t").append("tipo colaborado").append("\t\t")
		  .append("Aporte").append("\t\t").append("colaboraciones").append("\n");
		sb.append("==============================================================================").append("\n");
		 
		 ong.getColaboradores().sort(Comparator.comparingInt(Colaborador::getAnioIngreso));
		 
		  ong.calcularTotales();

		for (Colaborador colaborador: ong.getColaboradores()) {
			
			cantidadDeColaboradores++;
			
			sb.append(colaborador.MotrarInformacion());
					    		
	        
			for (Colaboracion colaboracion : colaborador.getColaboraciones()) {
	                colaboracionesMap.merge(colaboracion.getDescripcion(), colaboracion.getCostomesxVoluntario(), Double::sum);
	              
	            }
			  		
		}
		
		sb.append("------------------------------------------------------------------------------").append("\n");
		sb.append("La cantidad de colaboradores es ").append(cantidadDeColaboradores).append("\n");
		sb.append("Detalles de ingreso y egreso:\n");
		sb.append("Aportes \t"+ ong.getTotalAportes()+"\n");
		 
		 for (Map.Entry<String, Double> entry : colaboracionesMap.entrySet()) {
	            sb.append(entry.getKey()).append("\t").append(entry.getValue()).append("\n");
	        }
		
		
		 
		 sb.append("El presupuesto es superavitario en : " + ong.TotalDeAportes());
		 
		 System.out.println(sb.toString());
		 
		 
		 
	}
	
	
	
		
		
	
	
	
}
