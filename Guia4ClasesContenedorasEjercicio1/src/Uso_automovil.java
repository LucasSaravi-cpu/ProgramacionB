import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

/*. Modificar el ejercicio 12 de la Pr�ctica 1 (se incluye fragmento de su enunciado) para 
implementar las funcionalidades pedidas: 
Haciendo uso del concepto de Composici�n, crear una clase Automovil con atributos patente, 
due�o y motor. El motor es un atributo de tipo Motor. La clase motor tiene dos atributos: cilindrada y 
tipo (naftero, diesel, el�ctrico). 
a) Implementar el orden natural de Automovil con el atributo patente. 
b) Generar una lista de 5 a 10 autom�viles. 
c) Mostrar todos los datos del autom�vil con patente P (ingresada por teclado, puede no 
existir) 
d) Listarlos permitiendo elegir previamente el orden: patente o due�o. 
e) Listar los autom�viles que posean motor di�sel. 
f) Eliminar los autom�viles cuyas patentes comiencen con la letra M.*/

public class Uso_automovil {

	public static void main(String[] args) {
		
	

	
	// Crear motores
    Motor motor1 = new Motor(2000, "Nafta");
    Motor motor2 = new Motor(1500, "Diesel");
    Motor motor3 = new Motor(2500, "electrico");
    // Crear autom�viles 
    Automovil auto1 = new Automovil("MGA123", "juan", motor1);
    Automovil auto2 = new Automovil("MGA456", "Maria", motor2);
    Automovil auto3 = new Automovil("BLT123", "juan", motor3);
    Automovil auto4 = new Automovil("CDA132", "juan", motor1);
    Automovil auto5 = new Automovil("MLT123", "Dario", motor2);
    Automovil auto6 = new Automovil("TJW123", "Dario", motor3);
    Automovil auto7 = new Automovil("UTL789", "Alfredo", motor1);
    Automovil auto8 = new Automovil("MFT123", "Lucas", motor2);
    Automovil auto9 = new Automovil("LPW789", "Mario", motor3);
    Automovil auto10 = new Automovil("ABC123", "Maria", motor2);
    
    // Crear lista de autom�viles
    ArrayList<Automovil> listaAutomoviles = new ArrayList<>();
    listaAutomoviles.add(auto1);
    listaAutomoviles.add(auto2);
    listaAutomoviles.add(auto3);
    listaAutomoviles.add(auto4);
    listaAutomoviles.add(auto5);
    listaAutomoviles.add(auto6);
    listaAutomoviles.add(auto7);
    listaAutomoviles.add(auto8);
    listaAutomoviles.add(auto9);
    listaAutomoviles.add(auto10);
    
    for (Automovil auto : listaAutomoviles) {
        System.out.println("Patente: " + auto.getPatente() + ", Due�o: " + auto.getDue�o());
    }
   
    Scanner scanner2 = new Scanner(System.in);
    System.out.print("Ingrese el ordenamiento ");
    String ordenamiento = scanner2.nextLine();
    
   
    	
    if (ordenamiento.equalsIgnoreCase("patente")) {
        Collections.sort(listaAutomoviles, new Comparator<Automovil>() {
            public int compare(Automovil auto1, Automovil auto2) {
                return auto1.getPatente().compareTo(auto2.getPatente());
            }
        });

        // Imprimir la lista ordenada por patente
        for (Automovil auto : listaAutomoviles) {
            System.out.println("Patente: " + auto.getPatente() + ", Due�o: " + auto.getDue�o());
        }
    } else if (ordenamiento.equalsIgnoreCase("due�o")) {
        Collections.sort(listaAutomoviles, new Comparator<Automovil>() {
            public int compare(Automovil auto1, Automovil auto2) {
                return auto1.getDue�o().compareTo(auto2.getDue�o());
            }
        });

        // Imprimir la lista ordenada por due�o
        for (Automovil auto : listaAutomoviles) {
            System.out.println("Due�o: " + auto.getDue�o() + ", Patente: " + auto.getPatente());
        }
    } else {
        System.out.println("Opci�n de ordenamiento no v�lida");
    }
    
    
   
    
    // Solicitar al usuario que ingrese la patente ejercicio c.
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese la patente que quiera encontrar del autom�vil: ");
    String patenteBuscada = scanner.nextLine();
    
    
    
    // Crear lista de autom�viles y buscamos por clave
    HashMap<String, Automovil> mapaAutomoviles = new HashMap<>();
    
    // Agregar los autom�viles al mapa usando un bucle for
    for (Automovil auto : listaAutomoviles) {
        mapaAutomoviles.put(auto.getPatente(), auto);
    } 
    
    // Buscar el autom�vil con la patente ingresada en el mapa
    Automovil automovilEncontrado = mapaAutomoviles.get(patenteBuscada);
    
 /*   // Mostrar los autom�viles agregados al mapa
    System.out.println("Autom�viles agregados al mapa:");
    for (Entry<String, Automovil> entry : mapaAutomoviles.entrySet()) {
        System.out.println("Patente: " + entry.getKey() + ", Due�o: " + entry.getValue().getDue�o());
    }*/

    // Mostrar el autom�vil encontrado, si existe
    if (automovilEncontrado != null) {
        System.out.println("Autom�vil encontrado:");
        System.out.println("Patente: " + automovilEncontrado.getPatente());
        System.out.println("Due�o: " + automovilEncontrado.getDue�o());
        System.out.println("Cilindrada del motor: " + automovilEncontrado.getMotor().getCilindrada());
        System.out.println("Tipo de motor: " + automovilEncontrado.getMotor().getTipo());
    } else {
        System.out.println("No se encontr� ning�n autom�vil con la patente " + patenteBuscada);
    }
    
    

    
 // Clases de autom�viles que queremos filtrar
    HashSet<String> clasesFiltrar = new HashSet<>();
    clasesFiltrar.add("Nafta");

    // Filtrar la lista de autom�viles por las clases especificadas
    List<Automovil> automovilesFiltrados = listaAutomoviles.stream()
            .filter(auto -> clasesFiltrar.contains(auto.getMotor().getTipo()))
            .collect(Collectors.toList());

    // Imprimir los autom�viles filtrados
    System.out.println("Autom�viles filtrados por tipo motor a nafta:");
    for (Automovil auto : automovilesFiltrados) {
        System.out.println("Patente: " + auto.getPatente() + ", Due�o: " + auto.getDue�o() +
                ", Tipo de motor: " + auto.getMotor().getTipo() +
                ", Cilindrada del motor: " + auto.getMotor().getCilindrada());
    }

    
    
    Scanner scanner3 = new Scanner(System.in);
    System.out.println("Quiere eliminar los automoviles con la patente que empieza con la letra M");
    
    String respuesta = scanner3.nextLine();

    
    if (respuesta.equalsIgnoreCase("si")) {
    	
    	
    Iterator<Automovil> iterador = listaAutomoviles.iterator();
    while (iterador.hasNext()) {
        Automovil auto = iterador.next();
        if (auto.getPatente().startsWith("M")) {
            iterador.remove();
        }
    }

    // Imprimir la lista de autom�viles actualizada
    System.out.println("Lista de autom�viles despu�s de eliminar las patentes que comienzan con 'M':");
    for (Automovil auto : listaAutomoviles) {
        System.out.println("Patente: " + auto.getPatente() + ", Due�o: " + auto.getDue�o() +
                ", Tipo de motor: " + auto.getMotor().getTipo() +
                ", Cilindrada del motor: " + auto.getMotor().getCilindrada());
    }
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
}


		
		

	}


