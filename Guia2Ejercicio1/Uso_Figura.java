public class Uso_Figura {

	 public static void main(String[] args) {

	 Uso_Figura Uso_Figura =new Uso_Figura();
	 
	 Uso_Figura.Informacion();
		 
	 }
	
	public Figura MisFiguras[]=new Figura[6];
	
	public Uso_Figura() {	
	
	    
		MisFiguras[0] = new Cuadrado(45,45);
		MisFiguras[1] = new Circulo(45,45);
		MisFiguras[2] = new Circulo(20,20);
		MisFiguras[3] = new Rectangulo(10,45);
		MisFiguras[4] = new Elipce(45,25);
		MisFiguras[5] = new Cuadrado(5,5);
		
	}
	
     public void Informacion() {
    	 
	 for (int i=0 ; i<MisFiguras.length ; i++) {
		  
		 System.out.println("Esta figura "+MisFiguras[i].getTipoFigura()+" y sus atributos son " +MisFiguras[i].getInfoAtributos()+" su area es  "+MisFiguras[i].getArea()+ " y su perimetro es de " + MisFiguras[i].getPerimetro()) ;
		 
		 
	  }
	
	}
}

