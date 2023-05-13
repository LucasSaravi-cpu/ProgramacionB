/*Se desea tener información de los equipos que juegan un torneo de tenis. Cada equipo 
tiene un nombre y se compone de 4 jugadores. De los jugadores, además de su nombre, se 
debe conocer su ranking y su edad.

 La aplicación deberá:
a) Listar la información de los equipos y de sus integrantes
b) Listar los equipos ordenándolos por ranking ascendente (los mejores se muestran primero), 
mostrando para cada uno, su ranking y la edad promedio de sus jugadores. El ranking del 
Equipo se obtiene con la sumatoria de los rankings de los jugadores
c) ¿Qué cambio implementarías en el diagrama de clases para saber a qué equipo pertenece 
el Jugador? Implementa listar los jugadores ordenados por ranking, incluyendo el equipo al 
que pertenece cada uno:
Jean (3º) - Francia
Ronald (8º) – EEUU
Gianni (9º) – Italia
Juan (10º) – Argentina

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
		
		
	
		
		
		
		try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Principal\\Desktop\\Fasta\\Programacion B\\Programas\\Guia2Ejercicio3\\TorneoTenis.txt"));
           
            
               
        //Lectura del txt
            
            String linea = reader.readLine();
            
           
            ArrayList<Equipo> equipos = new ArrayList<Equipo>();
            
            while (((linea = reader.readLine()) != null)  ) {
            	
	            String[] datos = linea.split(";");
            
              String NombreEquipo = datos[0];
              ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
             
              
              for (int i = 1; i < datos.length; i++) {   //Voy a ir iterando los jugadores del archivo de txt
            	  
                  String[] jugadorDatos = datos[i].split(",");
                  String nombre = jugadorDatos[0].trim();
                  int partidosJugados = Integer.parseInt(jugadorDatos[1].trim());
                  int edad = Integer.parseInt(jugadorDatos[2].trim());
               
                  Jugador jugador = new Jugador(nombre, partidosJugados, edad,NombreEquipo); // creo jugador
                  jugadores.add(jugador);   //Los agrego al array de jugadores
                  
              }
              
              Equipo equipo = new Equipo(NombreEquipo, jugadores); // Creo un equipo
              equipos.add(equipo);  // Y lo agrego al array
   	
		  
              

        
            }
            reader.close();
            
            
        /*    //Listar la información
            
            for (Equipo equipo : equipos) {
                System.out.println("Equipo " + equipo.getNombreEquipo() + ":");
                for (Jugador jugador : equipo.getJugadores()) {
                    System.out.println("- " + jugador.getNombre() + " ha jugado " + jugador.getRanking() + " partidos y tiene " + jugador.getEdad() + " años.");
                }
                System.out.println();
            }*/
            
            
            
        // Ordenar equipos por ranking ascendente
    //El método Collections.sort ordena los elementos de la colección en base al 
     // Comparator que se le pasa como segundo argumento. En este caso, el Comparator 
     // compara los rankings de los equipos y devuelve un número negativo si el primer 
     // equipo tiene un ranking menor que el segundo, cero si ambos equipos 
     // tienen el mismo ranking, o un número positivo si el primer equipo tiene un ranking mayor que el segundo.
       /*     Collections.sort(equipos, new Comparator<Equipo>() {
                public int compare(Equipo e1, Equipo e2) {
                    return Integer.compare(e1.getRanking(), e2.getRanking());
                }
            });
            
            // Mostrar información de los equipos
            for (Equipo equipo : equipos) {
                System.out.println("Equipo " + equipo.getNombreEquipo() + ":");
                System.out.println("- Ranking: " + equipo.getRanking());
                System.out.println("- Edad promedio de los jugadores: " + equipo.getEdadPromedio());
                System.out.println();
            }
         
            */
            ArrayList<Jugador> MejorRanking = new ArrayList<Jugador>();
     
            for (Equipo equipo : equipos) {
            	  Jugador jugadorConMayorRanking = null;
                  int mayorRanking =Integer.MAX_VALUE;
            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador.getRanking() < mayorRanking) {
                	
                    mayorRanking = jugador.getRanking();
                    jugadorConMayorRanking = jugador;
                }
            }
            MejorRanking.add(jugadorConMayorRanking);
            
            }
            
            Collections.sort(MejorRanking, new Comparator<Jugador>() {
                public int compare(Jugador j1 ,Jugador j2) {
                    return  Integer.compare(j1.getRanking(), j2.getRanking());
                }

            });

            for (Jugador jugadores : MejorRanking) {
            	
            	 System.out.println("Su nombre es " + jugadores.getNombre() +"(" +jugadores.getRanking()+")" +" - "+ jugadores.getEquipo() );
            	
            }
		}

            
            
            catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
		
		}


}
