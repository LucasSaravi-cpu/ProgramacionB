
public class HoraPrincipal {

	public static void main(String[] args) {
		
		    //Se crean los 3 constructores
		    Hora hora1 = new Hora(16, 30, 30);
		 
		    Hora hora2 = new Hora(18, 15, 20);
		    
		    Hora hora3 = new Hora();
		    
		    
		    
		    System.out.println("Hora 1: ");
		    
		    hora1.mostrarHora();
		    
		    System.out.println("Hora 2: ");
		    
		    hora2.mostrarHora();
		    
		    
		    hora3.sumarHoras(hora1, hora2);
		    
		    System.out.println("Hora 3  ");
		    
		    hora3.mostrarHora();
		

	}

}
