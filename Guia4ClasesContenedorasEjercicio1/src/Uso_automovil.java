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

/*. Modificar el ejercicio 12 de la Práctica 1 (se incluye fragmento de su enunciado) para 
implementar las funcionalidades pedidas: 
Haciendo uso del concepto de Composición, crear una clase Automovil con atributos patente, 
dueño y motor. El motor es un atributo de tipo Motor. La clase motor tiene dos atributos: cilindrada y 
tipo (naftero, diesel, eléctrico). 
a) Implementar el orden natural de Automovil con el atributo patente. 
b) Generar una lista de 5 a 10 automóviles. 
c) Mostrar todos los datos del automóvil con patente P (ingresada por teclado, puede no 
existir) 
d) Listarlos permitiendo elegir previamente el orden: patente o dueño. 
e) Listar los automóviles que posean motor diésel. 
f) Eliminar los automóviles cuyas patentes comiencen con la letra M.*/

public class Uso_automovil {

	public static void main(String[] args) {
		
	

	
	// Crear motores
    Motor motor1 = new Motor(2000, "Nafta");
    Motor motor2 = new Motor(1500, "Diesel");
    Motor motor3 = new Motor(2500, "electrico");
    // Crear automóviles 
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
    
    // Crear lista de automóviles
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
        System.out.println("Patente: " + auto.getPatente() + ", Dueño: " + auto.getDueño());
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
            System.out.println("Patente: " + auto.getPatente() + ", Dueño: " + auto.getDueño());
        }
    } else if (ordenamiento.equalsIgnoreCase("dueño")) {
        Collections.sort(listaAutomoviles, new Comparator<Automovil>() {
            public int compare(Automovil auto1, Automovil auto2) {
                return auto1.getDueño().compareTo(auto2.getDueño());
            }
        });

        // Imprimir la lista ordenada por dueño
        for (Automovil auto : listaAutomoviles) {
            System.out.println("Dueño: " + auto.getDueño() + ", Patente: " + auto.getPatente());
        }
    } else {
        System.out.println("Opción de ordenamiento no válida");
    }
    
    
   
    
    // Solicitar al usuario que ingrese la patente ejercicio c.
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese la patente que quiera encontrar del automóvil: ");
    String patenteBuscada = scanner.nextLine();
    
    
    
    // Crear lista de automóviles y buscamos por clave
    HashMap<String, Automovil> mapaAutomoviles = new HashMap<>();
    
    // Agregar los automóviles al mapa usando un bucle for
    for (Automovil auto : listaAutomoviles) {
        mapaAutomoviles.put(auto.getPatente(), auto);
    } 
    
    // Buscar el automóvil con la patente ingresada en el mapa
    Automovil automovilEncontrado = mapaAutomoviles.get(patenteBuscada);
    
 /*   // Mostrar los automóviles agregados al mapa
    System.out.println("Automóviles agregados al mapa:");
    for (Entry<String, Automovil> entry : mapaAutomoviles.entrySet()) {
        System.out.println("Patente: " + entry.getKey() + ", Dueño: " + entry.getValue().getDueño());
    }*/

    // Mostrar el automóvil encontrado, si existe
    if (automovilEncontrado != null) {
        System.out.println("Automóvil encontrado:");
        System.out.println("Patente: " + automovilEncontrado.getPatente());
        System.out.println("Dueño: " + automovilEncontrado.getDueño());
        System.out.println("Cilindrada del motor: " + automovilEncontrado.getMotor().getCilindrada());
        System.out.println("Tipo de motor: " + automovilEncontrado.getMotor().getTipo());
    } else {
        System.out.println("No se encontró ningún automóvil con la patente " + patenteBuscada);
    }
    
    

    
 // Clases de automóviles que queremos filtrar
    HashSet<String> clasesFiltrar = new HashSet<>();
    clasesFiltrar.add("Nafta");

    // Filtrar la lista de automóviles por las clases especificadas
    List<Automovil> automovilesFiltrados = listaAutomoviles.stream()
            .filter(auto -> clasesFiltrar.contains(auto.getMotor().getTipo()))
            .collect(Collectors.toList());

    // Imprimir los automóviles filtrados
    System.out.println("Automóviles filtrados por tipo motor a nafta:");
    for (Automovil auto : automovilesFiltrados) {
        System.out.println("Patente: " + auto.getPatente() + ", Dueño: " + auto.getDueño() +
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

    // Imprimir la lista de automóviles actualizada
    System.out.println("Lista de automóviles después de eliminar las patentes que comienzan con 'M':");
    for (Automovil auto : listaAutomoviles) {
        System.out.println("Patente: " + auto.getPatente() + ", Dueño: " + auto.getDueño() +
                ", Tipo de motor: " + auto.getMotor().getTipo() +
                ", Cilindrada del motor: " + auto.getMotor().getCilindrada());
    }
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
}


		
		

	}


