package Control;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Model.Alquiler;
import Model.AlquilerKilometrajeLibre;
import Model.AlquilerKilometrajeLimitado;
import Model.Automovil;
import Model.Cliente;

public class Empresa {
	
	 private String nombre;
	 private BigDecimal recargoTanqueIncompleto;
	 private BigDecimal porcentajeRecargoMultiplesConductores;
	 private BigDecimal porcentajeRecargoPorKmExcedido;
	 private int topeKilometraje;
	 
	
	 private List<Cliente> clientes;
	 private List<Automovil> automoviles;
	 private List<Alquiler> alquileres;
	 

	    public Empresa(String nombre,BigDecimal recargoTanqueIncompleto, BigDecimal porcentajeRecargoMultiplesConductores,BigDecimal porcentajeRecargoPorKmExcedido,int topeKilometraje) {
	        this.nombre = nombre;
	        this.recargoTanqueIncompleto = recargoTanqueIncompleto;
	        this.porcentajeRecargoMultiplesConductores = porcentajeRecargoMultiplesConductores;
	        this.porcentajeRecargoPorKmExcedido = porcentajeRecargoPorKmExcedido;
	        this.topeKilometraje = topeKilometraje;
	        
	        
	        clientes = new ArrayList<>();
	        automoviles = new ArrayList<>();
	        alquileres = new ArrayList<>();
	    }

	    
	    
	    public void agregarCliente(Cliente c) {
	        clientes.add(c);
	    }

	    public void agregarAutomovil(Automovil a) {
	        automoviles.add(a);
	    }

	    public void agregarAlquiler(Alquiler a) {
	        alquileres.add(a);
	    }
	    
	    
	 
	   public String listarAlquileres () {
		   
		   alquileres.sort((a1, a2) -> a2.calcularCostoTotal().compareTo(a1.calcularCostoTotal()));
		   StringBuilder result = new StringBuilder();	
		   
		   for(Alquiler a : getAlquileres()){

			   result.append(a.tipo()+"\t"+"Costo Total : "+ a.calcularCostoTotal()+"\n");
			   result.append("Fecha desde  " + a.getDesdeFecha() + "  hasta  " + a.getHastaFecha()+"\n");
			   result.append(a.getAutomovil().toString() + "\n");
			   result.append("Kilometros recorridos \t" + a.getKilometrosRecorridos() + "\n");
			   result.append("--------------------------------------------- \n");
			   

			}   
		   
		   return result.toString();
	   }
	
	    
	    public void CrearInstancias () {
	    
	
	    Cliente cliente1 = new Cliente("lucas","12345678");
	    Cliente cliente2 = new Cliente("Maria","910111213");
	    Cliente cliente3 = new Cliente("Loana","14151617");	
	    
	  
	    
	    Automovil auto1 = new Automovil("12345","Falcon", new BigDecimal("10000"),new BigDecimal("15000"));
	    Automovil auto2 = new Automovil("36987","Audi", new BigDecimal("20000"),new BigDecimal("10000"));
	    Automovil auto3 = new Automovil("58745","Ferrari", new BigDecimal("30000"),new BigDecimal("20000"));
		   
	    agregarAutomovil(auto1);
	    agregarAutomovil(auto2);
	    agregarAutomovil(auto3);
	    
	    agregarCliente(cliente1);
        agregarCliente(cliente2);
        agregarCliente(cliente3);

       

        Alquiler a1 = new AlquilerKilometrajeLimitado(LocalDateTime.now(),LocalDateTime.now().plusHours(30),auto1.getCostoPorDiaLimitado(),1000,1300,true,getRecargoTanqueIncompleto(),cliente1,
                auto1,getTopeKilometraje(),getPorcentajeRecargoPorKmExcedido());

        Alquiler a2 = new AlquilerKilometrajeLimitado(LocalDateTime.now(),LocalDateTime.now().plusHours(50),auto2.getCostoPorDiaLimitado(), 2000,
                2400, false,getRecargoTanqueIncompleto(),cliente2,auto2,getTopeKilometraje(),getPorcentajeRecargoPorKmExcedido());

        Alquiler a3 = new AlquilerKilometrajeLimitado( LocalDateTime.now(),LocalDateTime.now().plusHours(70),
                auto3.getCostoPorDiaLimitado(),500,700,true,getRecargoTanqueIncompleto(),cliente3,
                auto3,getTopeKilometraje(),getPorcentajeRecargoPorKmExcedido() );

        agregarAlquiler(a1);
        agregarAlquiler(a2);
        agregarAlquiler(a3);


      

        Alquiler a4 = new AlquilerKilometrajeLibre(LocalDateTime.now(),
                LocalDateTime.now().plusHours(20), auto1.getCostoPorDiaLibre(),1000,
                1500,true,getRecargoTanqueIncompleto(),cliente1,auto1,true,
                getPorcentajeRecargoMultiplesConductores());


        Alquiler a5 = new AlquilerKilometrajeLibre(LocalDateTime.now(),
                LocalDateTime.now().plusHours(60),auto2.getCostoPorDiaLibre(), 2000,2600,  false, getRecargoTanqueIncompleto(), cliente2, auto2,false,
                getPorcentajeRecargoMultiplesConductores());


        Alquiler a6 = new AlquilerKilometrajeLibre(LocalDateTime.now(),LocalDateTime.now().plusHours(40),auto3.getCostoPorDiaLibre(),
  3000, 3500, true,getRecargoTanqueIncompleto(),cliente3, auto3,true, getPorcentajeRecargoMultiplesConductores());


        agregarAlquiler(a4);
        agregarAlquiler(a5);
        agregarAlquiler(a6);
	    
      
	    	
	    }



		public String getNombre() {
			return nombre;
		}



		public void setNombre(String nombre) {
			this.nombre = nombre;
		}



		public BigDecimal getRecargoTanqueIncompleto() {
			return recargoTanqueIncompleto;
		}



		public void setRecargoTanqueIncompleto(BigDecimal recargoTanqueIncompleto) {
			this.recargoTanqueIncompleto = recargoTanqueIncompleto;
		}



		public BigDecimal getPorcentajeRecargoMultiplesConductores() {
			return porcentajeRecargoMultiplesConductores;
		}



		public void setPorcentajeRecargoMultiplesConductores(BigDecimal porcentajeRecargoMultiplesConductores) {
			this.porcentajeRecargoMultiplesConductores = porcentajeRecargoMultiplesConductores;
		}



		public BigDecimal getPorcentajeRecargoPorKmExcedido() {
			return porcentajeRecargoPorKmExcedido;
		}



		public void setPorcentajeRecargoPorKmExcedido(BigDecimal porcentajeRecargoPorKmExcedido) {
			this.porcentajeRecargoPorKmExcedido = porcentajeRecargoPorKmExcedido;
		}



		public int getTopeKilometraje() {
			return topeKilometraje;
		}



		public void setTopeKilometraje(int topeKilometraje) {
			this.topeKilometraje = topeKilometraje;
		}



		public List<Cliente> getClientes() {
			return clientes;
		}



		public void setClientes(List<Cliente> clientes) {
			this.clientes = clientes;
		}



		public List<Automovil> getAutomoviles() {
			return automoviles;
		}



		public void setAutomoviles(List<Automovil> automoviles) {
			this.automoviles = automoviles;
		}



		public List<Alquiler> getAlquileres() {
			return alquileres;
		}



		public void setAlquileres(List<Alquiler> alquileres) {
			this.alquileres = alquileres;
		}
	    
	    
		
		/*----------------------------------------------*/
		
		public double promedioKms(String patente){

		    int totalKms = 0;
		    int contador = 0;

		    for(Alquiler a : alquileres){

		        if(a.getAutomovil().getPatente().equals(patente)){

		            totalKms += a.getKilometrosRecorridos();
		            contador++;

		        }
		    }

		    if(contador == 0)
		        return 0;

		    return (double)totalKms / contador;
		}
		
		public BigDecimal totalFacturado(String patente){

		    BigDecimal total = BigDecimal.ZERO;

		    for(Alquiler a : alquileres){

		        if(a.getAutomovil().getPatente().equals(patente)){

		            total = total.add(a.calcularCostoTotal());

		        }
		    }

		    return total;
		}
		
		
		public int cantidadAlquileres(String patente){

		    int contador = 0;

		    for(Alquiler a : alquileres){

		        if(a.getAutomovil().getPatente().equals(patente))
		            contador++;
		    }

		    return contador;
		}
		
		
		public boolean existePatente(String patente){

		    patente = patente.trim();
		  
		    for(Automovil a : automoviles){

		        if(a.getPatente().equalsIgnoreCase(patente))
		            return true;
		    }
		    
		    return false;
		}

}
