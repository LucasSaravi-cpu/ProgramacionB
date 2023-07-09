package model;

import java.util.Random;

import controlador.Empresa;
import modeloclases.Area;
import modeloclases.Compartimento;
import modeloclases.Estanteria;
import modeloclases.Refrigerado;

public class RunEmpresa {
	
  private Empresa empresa;

  
  public RunEmpresa(Empresa empresa) {
	  this.empresa=empresa;
  }

	public static void main(String[] args) {
		
	RunEmpresa.CrearEmpresa();
	
	
		

	}
	
	public static void sacarCantidadesRandom(Area area) {
		
		Random random = new Random() ;
		
		 for (Compartimento com : area.getCompartimento()) {
			 
				int can=0;
				int randomValue = random.nextInt(10000+1);
				
			    if (com.retirarCantidad(randomValue)) {
			    can= com.getCartocupada() -randomValue;
			    com.setCartocupada(can);
			    
			    }
			 
		 }
	}
	
	
	public static void agregarCantidadesRandom(Area area ) {
		
		Random random = new Random();
		
		 for (Compartimento com : area.getCompartimento()) {
	   	int can=0;
		int randomValue = random.nextInt(10000+1);
	
		 
		  can = randomValue+ com.getCartocupada();
		 
         if (com.agregarCantidad(can)) {
        	
         com.setCartocupada(can); //Le pongo valores random + la cantida ocupada 
         
         }
		 }	
		}
		
	
	
	
	public static void  CrearEmpresa() {
		
		
	
		
		Empresa empresa = new Empresa("Acovacha y Despacho S.A");
		Area area1 = new Area("SO3","SECTOR3");

		Estanteria estanteria1 = new Estanteria("E01", "Estante Aceites(Estanteria)", 1000, 245,area1, 4);	     
		Estanteria estanteria2 = new Estanteria("E02", "Estante limpieza(Estanteria)", 4000, 13,area1, 2);		
		Estanteria estanteria3 = new Estanteria("E03", "Estante vinoteca(Estanteria)", 3000, 1671,area1, 1);
		
		
		Compartimento compartimento1 = estanteria1;
		
		
		Compartimento compartimento2 =estanteria2;
		
		Compartimento compartimento3 = estanteria3;
		
		area1.agregarCompartimento(compartimento1);
		area1.agregarCompartimento(compartimento2);
		area1.agregarCompartimento(compartimento3);
		
		
		Area area2 = new Area("SO2","SECTOR2");

		Estanteria estanteria4 = new Estanteria("E04", "Estante ELECTRO(Estanteria)", 5000, 4686,area2, 3);	     
		Estanteria estanteria5 = new Estanteria("E05", "Estante MASCOTAS(Estanteria)", 1000, 97,area2, 2);		
		Estanteria estanteria6 = new Estanteria("E06", "Estante JARDINES(Estanteria)", 3000, 2860,area2, 2);
		
	
		Compartimento compartimento4 = estanteria4;
		
		
		Compartimento compartimento5 =estanteria5;
		
		Compartimento compartimento6 = estanteria6;
	
		area2.agregarCompartimento(compartimento4);
		area2.agregarCompartimento(compartimento5);
		area2.agregarCompartimento(compartimento6);
		
		
		Area area3 = new Area("F01","Frigorifico");
		
		Estanteria estanteria7 = new Estanteria("EO7", "Estante de quesos (Estanteria)", 1000, 567,area3,2);	     
	    Refrigerado estanteria8 =new Refrigerado("C01", "Camara carniceria(Refrigerado)", 5000, 3977, area3,0, 10);
	   
	    
	    Refrigerado estanteria9 =new Refrigerado("C02", "Camara de lacteos(Refrigerado)", 3000, 1709, area3,6, 30);
	    Refrigerado estanteria10 =new Refrigerado("C03", "Camara congelados(Refrigerado)", 3000, 2326, area3,-5, 20);
	
	    
		Compartimento compartimento7 = estanteria7;
		Compartimento compartimento8 = estanteria8;
		Compartimento compartimento9 = estanteria9;
		Compartimento compartimento10 = estanteria10;
	
		area3.agregarCompartimento(compartimento7);
		area3.agregarCompartimento(compartimento8);
		
		area3.agregarCompartimento(compartimento9);
		
		area3.agregarCompartimento(compartimento10);
		
	
		empresa.agregarArea(area1);
		empresa.agregarArea(area2);
		empresa.agregarArea(area3);
	
		System.out.println(empresa.ShowInformationCostosDiarios());
		

	
	

	}



}
