package controlador;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Entrega;
import modelo.HojaRuta;
import modelo.HojaRutaBicicleta;
import modelo.HojaRutaCamion;
import modelo.HojaRutaRefrigerada;
import modelo.Movil;
import modelo.TipoMovil;
import modelo.Zonas;
import modelo.TipoMovil.tipoMovil;







public class Empresa {

	private String nombre;
	
	 private List<Entrega> entregasPendientes;

	 private Map<String, HojaRuta> hojasDeRuta;
	 private List<Movil> moviles;
	 private static float PESO_BICICLETA=3;
	 private static float TEMP_REFRIGERADA=10;
	 
	 
	 
	
    public Empresa(String nombre) {
		super();
		this.nombre = nombre;
		this.entregasPendientes = new ArrayList<Entrega>();
		
		this.hojasDeRuta = new HashMap<>();
		this.moviles = new ArrayList<Movil>();
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void agregar(Movil movil) {
		//Agregar un Movil a la Empresa
		moviles.add(movil);
	}

	

    public void agregar(Entrega entrega) {
       
    	String clave =  generarClaveHojaRuta(entrega);
    	
 	/*
    	 char tipoHojaRuta = Empresa.getTipoHojaRutaSegunPesoTemperatura(entrega.getTemperaturaRecomendada(), entrega.getPeso());


    	    HojaRuta hojaRuta = null;
    	    boolean agregada = false;

    	    switch (tipoHojaRuta) {
    	        case 'C':
    	            Movil movilCamion = getMovil(tipoMovil.CAMION, entrega.getZona());
    	            hojaRuta = new HojaRutaCamion(entrega.getFechaRecepcion(), 0, 0, movilCamion);
    	            break;
    	        case 'B':
    	            Movil movilBicicleta = getMovil(tipoMovil.BICICLETA, entrega.getZona());
    	            hojaRuta = new HojaRutaBicicleta(entrega.getFechaRecepcion(), 0, 0, movilBicicleta);
    	            break;
    	        case 'R':
    	            Movil movilRefrigerado = getMovil(tipoMovil.REFRIGERADO, entrega.getZona());
    	            hojaRuta = new HojaRutaRefrigerada(entrega.getFechaRecepcion(), 0, 0, movilRefrigerado);
    	            break;
    	        default:
    	            System.out.println("Tipo de hoja de ruta no reconocido");
    	            return; // Terminar método si el tipo de hoja de ruta no es reconocido
    	    }

    	    agregada = hojaRuta.agregar(entrega);

    	    if (agregada) {
    	    	
    	    
    	        hojasDeRuta.put(clave, hojaRuta);
    	    } else {
    	        System.out.println("No se pudo agregar a la hoja de ruta, se añade a pendientes");
    	        entregasPendientes.add(entrega);
    	    }
    	    */
    	    
    	 // Verificar si la clave ya existe en el mapa hojasDeRuta
        if (hojasDeRuta.containsKey(clave)) {
            HojaRuta hojaRutaExistente = hojasDeRuta.get(clave);
            boolean agregada = hojaRutaExistente.agregar(entrega);

            if (agregada) {
           //     System.out.println("Entrega agregada a la hoja de ruta existente");
            } else {
             //   System.out.println("No se pudo agregar la entrega a la hoja de ruta existente, se añade a pendientes");
                entregasPendientes.add(entrega);
            }
        } else {
          
          //  System.out.println("No existe una hoja de ruta para la clave " + clave + ", se crea una nueva");

            // Crear una nueva hoja de ruta según el tipo
            char tipoHojaRuta = Empresa.getTipoHojaRutaSegunPesoTemperatura(entrega.getTemperaturaRecomendada(), entrega.getPeso());

            HojaRuta hojaRuta = null;
            boolean agregada = false;

            switch (tipoHojaRuta) {
                case 'C':
                    Movil movilCamion = getMovil(tipoMovil.CAMION, entrega.getZona());
                    hojaRuta = new HojaRutaCamion(entrega.getFechaRecepcion(), 0, 0, movilCamion);
                    break;
                case 'B':
                    Movil movilBicicleta = getMovil(tipoMovil.BICICLETA, entrega.getZona());
                    hojaRuta = new HojaRutaBicicleta(entrega.getFechaRecepcion(), 0, 0, movilBicicleta);
                    break;
                case 'R':
                    Movil movilRefrigerado = getMovil(tipoMovil.REFRIGERADO, entrega.getZona());
                    hojaRuta = new HojaRutaRefrigerada(entrega.getFechaRecepcion(), 0, 0, movilRefrigerado);
                    break;
                default:
                    System.out.println("Tipo de hoja de ruta no reconocido");
                    return; // Terminar método si el tipo de hoja de ruta no es reconocido
            }

            agregada = hojaRuta.agregar(entrega);

            if (agregada) {
                hojasDeRuta.put(clave, hojaRuta);
            } else {
                //System.out.println("No se pudo agregar a la hoja de ruta, se añade a pendientes");
                entregasPendientes.add(entrega);
            }
        }  
    	    
    	    
    	}
		
    	
    	
    	
    	
    	  

	
    public Movil getMovil(TipoMovil.tipoMovil tipo, Zonas.Zona zona) {
        for (Movil movil : moviles) {
            if (movil.getTipomovil()== tipo && movil.getZonas() == zona) {
                return movil;
            }
        }
        return null; // Si no se encuentra ningún móvil que cumpla las condiciones
    }
 
    
    
    public static char getTipoHojaRutaSegunPesoTemperatura ( float temperatura , float peso) {
    	
    
    	if (temperatura < TEMP_REFRIGERADA)
			return 'R';
		else if (peso <= PESO_BICICLETA)
				return 'B';
			else
				return 'C';
    	
    	
    }
    
  

    


	public List<Entrega> getEntregas() {
		return entregasPendientes;
	}



	public void setEntregas(List<Entrega> entregasPedientes) {
		this.entregasPendientes = entregasPedientes;
	}



	


	public List<Movil> getMoviles() {
		return moviles;
	}



	public void setMoviles(List<Movil> moviles) {
		this.moviles = moviles;
	}

		
		
		
	
    private String generarClaveHojaRuta(Entrega entrega) {
        StringBuilder sb = new StringBuilder();
        sb.append(entrega.getFechaRecepcion()).append("_");
        sb.append(entrega.getZona()).append("_");
        sb.append(getTipoHojaRutaSegunPesoTemperatura(entrega.getTemperaturaRecomendada(), entrega.getPeso()));
        return sb.toString();
    }
    
	public String listarHojasRuta() {
		
		
		StringBuilder stb = new StringBuilder();
		
	
		

     	Empresa empresa = new Empresa("TeLoLlevo S.A - Hojas de ruta");
    	
     	
     	stb.append(empresa.getNombre());
     	
     	
    	stb.append("\n");
    	stb.append(" >>========================================================================================================\n");
		
    	for (Map.Entry<String, HojaRuta> entry : hojasDeRuta.entrySet()) {
            String clave = entry.getKey();
            HojaRuta hojaRuta = entry.getValue();
          
            stb.append(hojaRuta.tipoHojaRuta()+"\n");
          
           stb.append(clave + " "+hojaRuta.toString()+" "+" Costos "+ hojaRuta.getCosto() +"\n");
            
           
        
           hojaRuta.getEntregas().sort(Comparator.comparingDouble(Entrega::getDistancia));
           
			for ( Entrega entrega : hojaRuta.getEntregas()) {
				
			
				stb.append(entrega.toString()).append("\n");
			}
            
            
        }
    	
    	stb.append("\n");
    	stb.append("Entregas pendientes" + "\n");
    	stb.append("---------------------------------------------------------------------------------------------------------------------  ");
    	stb.append("\n");
    	for ( Entrega entrega : entregasPendientes) {
    		
    		stb.append(entrega.toString() + "\n");
    		
    	}
    	
    
    	
    	
		
		return stb.toString();
	}




	
	
	
	
	
}
