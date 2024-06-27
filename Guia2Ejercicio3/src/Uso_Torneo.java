/*Se desea tener informaci�n de los equipos que juegan un torneo de tenis. Cada equipo 
tiene un nombre y se compone de 4 jugadores. De los jugadores, adem�s de su nombre, se 
debe conocer su ranking y su edad.

 La aplicaci�n deber�:
a) Listar la informaci�n de los equipos y de sus integrantes
b) Listar los equipos orden�ndolos por ranking ascendente (los mejores se muestran primero), 
mostrando para cada uno, su ranking y la edad promedio de sus jugadores. El ranking del 
Equipo se obtiene con la sumatoria de los rankings de los jugadores
c) �Qu� cambio implementar�as en el diagrama de clases para saber a qu� equipo pertenece 
el Jugador? Implementa listar los jugadores ordenados por ranking, incluyendo el equipo al 
que pertenece cada uno:
Jean (3�) - Francia
Ronald (8�) � EEUU
Gianni (9�) � Italia
Juan (10�) � Argentina

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Uso_Torneo {

	public static void main(String[] args) {
		
		
	
		Torneo torneo = new Torneo("TorneoDeTennis");
		
		
		try {
            BufferedReader reader = new BufferedReader(new FileReader("TorneoTenis.txt"));
           
            
               
        //Lectura del txt
            
            String linea = reader.readLine();
            
           
            
            
            while (((linea = reader.readLine()) != null)  ) {
            	
	          String[] datos = linea.split(";");
            
              String NombreEquipo = datos[0];
             
              Equipo equipo = new Equipo (NombreEquipo);
              
              for (int i = 1; i < datos.length; i++) {   //Voy a ir iterando los jugadores del archivo de txt
            	  
                  String[] jugadorDatos = datos[i].split(",");
                  String nombre = jugadorDatos[0].trim();
                  int partidosJugados = Integer.parseInt(jugadorDatos[1].trim());
                  int edad = Integer.parseInt(jugadorDatos[2].trim());
               
                  Jugador jugador = new Jugador(nombre, partidosJugados, edad,NombreEquipo); // creo jugador
                 
                  equipo.getJugadores().add(jugador);
                  
              }
              
              
             
             torneo.getEquipos().add(equipo);
   	
		  
              

        
            }
            reader.close();
            
        /* Listar la información de los equipos y de sus integrantes*/    
       System.out.println("Listar la informacion " );  
            
 
            
            for (Equipo equipo : torneo.getEquipos()) {
            	System.out.println("Equipo " + equipo.getNombreEquipo() + ":");
               
                
                for (Jugador jugador : equipo.getJugadores()) {
                	 System.out.println("- " + jugador.getNombre() + " ha jugado " + jugador.getRanking() + " partidos y tiene " + jugador.getEdad() + " años.");
                    }
                System.out.println();
                }
                
             
            
            
     
            
            
            
          /*  Listar los equipos ordenándolos por ranking ascendente (los mejores se muestran primero), 
            mostrando para cada uno, su ranking y la edad promedio de sus jugadores. El ranking del 
            Equipo se obtiene con la sumatoria de los rankings de los jugadores  */
            
            
            /* Collections.sort Permite ordenar en orden ascendente utilizando el orden natural de los elementos (Comparable) o en orden descendente mediante un Comparator.*/
            System.out.println(" Calcular el ranking de cada equipo y ordenarlos por ranking ascendente");
            Collections.sort(torneo.getEquipos(), new Comparator<Equipo>() {
                @Override
                public int compare(Equipo e1, Equipo e2) {
                    return Integer.compare(e1.getRanking(), e2.getRanking());
                }
            });
            
            // Mostrar la información requerida para cada equipo
            for (Equipo equipo : torneo.getEquipos()) {
                System.out.println("Equipo: " + equipo.getNombreEquipo());
                System.out.println("Ranking: " + equipo.getRanking());
                System.out.println("Edad promedio de los jugadores: " + equipo.getEdadPromedio());
                System.out.println("------------------------------------");
            }
        
            
            
            
            
            
            
            
            
            /*¿Qué cambio implementarías en el diagrama de clases para saber a qué equipo pertenece 
el Jugador? Implementa listar los jugadores ordenados por ranking, incluyendo el equipo al 
que pertenece cada uno:*/
         System.out.println(" Obtener el jugador con mejor ranking por cada equipo y ordenarlos");
            ArrayList<Jugador> mejorRanking = new ArrayList<>();
            
            for (Equipo equipo : torneo.getEquipos()) {
                Jugador jugadorConMayorRanking = null;
                int mayorRanking = Integer.MAX_VALUE;
                
                for (Jugador jugador : equipo.getJugadores()) {
                    if (jugador.getRanking() < mayorRanking) {
                        mayorRanking = jugador.getRanking();
                        jugadorConMayorRanking = jugador;
                    }
                }
                
                mejorRanking.add(jugadorConMayorRanking);
            }
            
            Collections.sort(mejorRanking, new Comparator<Jugador>() {
                public int compare(Jugador j1 ,Jugador j2) {
                    return  Integer.compare(j1.getRanking(), j2.getRanking());
                }

            });

            for (Jugador jugadores : mejorRanking) {
            	
            	 System.out.println("Su nombre es " + jugadores.getNombre() +"(" +jugadores.getRanking()+")" +" - "+ jugadores.getEquipo() );
            	
            }
		}

		
		
		
		
            
            
            catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
		
		}


}
