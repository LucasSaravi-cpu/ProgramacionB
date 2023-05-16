
public class Principal {
	
	   public static void main(String[] args) {
		   
		   
	  // Arreglo de 4 atletas
		   
    Atleta[] atletas = new Atleta[4];
    
    atletas[0] = new Atleta("Lucas", "Categoría A");
    atletas[1] = new Atleta("Rodrigo", "Categoría B");
    atletas[2] = new Atleta("Matias", "Categoría A");
    atletas[3] = new Atleta("Loana", "Categoría C");

    // Mostrar los datos de cada atleta
    for (Atleta atleta : atletas) {
        atleta.verDatos();
    }

// Arreglo de 4 nadadores
    
    Nadador[] nadadores = new Nadador[4];
     
    nadadores[0] = new Triatleta("Lucas" ,"Categoria Estilo libre");
    nadadores[1] = new Triatleta("Loana" , "Saltadora");
    nadadores[2]= new Delfin ("Delfin de risso" , "mamifero marino");
    nadadores[3] = new Delfin ("Delfín de Heaviside", "Mamifero Marino");
    
    
   //Invoca el metodo nadar de cada nadador
    
    for (Nadador nadador : nadadores) {
    	nadador.nadar();
    }
    
    
}
}
