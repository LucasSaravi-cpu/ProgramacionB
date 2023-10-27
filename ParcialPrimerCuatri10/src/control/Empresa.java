package control;
import java.util.ArrayList;
import model.Compartimento;
import model.Estanteria;
import model.Refrigerado;



public class Empresa{
	
	
	private static ArrayList<Compartimento> compartimentos;
	
	

	public Empresa() {
		 compartimentos = new ArrayList<>();
	}


 public void crearEmpresa() {
		
		
	
		 
		Estanteria estanteria1 = new Estanteria("E01", "Estante Golocina", 1000,"P3-001" , 5);
		Estanteria estanteria2 = new Estanteria("E404", "Estante Legumbres)", 5000, "P4-030",8);	
		Estanteria estanteria3 = new Estanteria("E025", "Estante Mermelada", 2000,"P1-019",10);
		
		
		Compartimento compartimento1 = estanteria1;
		Compartimento compartimento2 =estanteria2;		
		Compartimento compartimento3 = estanteria3;
	
		compartimentos.add(compartimento1);
		compartimentos.add(compartimento2);
		compartimentos.add(compartimento3);
		
		 Refrigerado estanteria4 =new Refrigerado("H001", "Heladera frutas", 500, "P4-022",12,3);
		 Refrigerado estanteria5 =new Refrigerado("CF01", "Camara Carniceria", 3000,"Salon de camaras",4, -10);
		 Refrigerado estanteria6 =new Refrigerado("CF02", "Camara Pescado", 1000, "salon de camaras " , -1, -18);
		
		   Compartimento compartimento4 = estanteria4;
			Compartimento compartimento5 =estanteria5;		
			Compartimento compartimento6 = estanteria6;
			compartimentos.add(compartimento4);
			compartimentos.add(compartimento5);
			compartimentos.add(compartimento6);
			
		
		

	
		
		

	}
	

	
	public static String  mostrarInformacion() {
		
    
		StringBuilder result = new StringBuilder();	

		int TotalEstanteria=0;
		int TotalRefrigerado=0;
		
		result.append("Compartimentos de TIPO ESTANTERIA \n");
		
		for (Compartimento com : compartimentos) {
		
		      if (com.tipocompartimento().equals("Estanteria")) {
			 result.append(com.tipocompartimento() + com.toString()+"\n");
			 TotalEstanteria= TotalEstanteria +  com.getCapacidad();
		  }
		}
		result.append("El total de la capacidad para Estanteria es " +TotalEstanteria +"\n");
		
		result.append("-------------------------------------------------------------- \n ");
		
		result.append("Compartimentos de TIPO REFRIGERADO \n");
		
		for (Compartimento com : compartimentos) {
			
		      if (com.tipocompartimento().equals("Refrigerado")) {
			 result.append(com.tipocompartimento() + com.toString()+"\n");
			 TotalRefrigerado= TotalRefrigerado +  com.getCapacidad();
		  }
		}
		result.append("El total de la capacidad para Refrigerado es " +TotalRefrigerado +"\n");
		

		return result.toString();
	
		
		
	}




	
	

}
