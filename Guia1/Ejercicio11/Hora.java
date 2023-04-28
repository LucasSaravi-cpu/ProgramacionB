 /*Crear una clase Hora que contenga datos miembro de tipo entero para horas, minutos y 
segundos. 
Definir dos constructores: un constructor inicializará los datos en 0 y otro a valores variables. 
Una función miembro mostrará la hora en formato hh:mm:ss. Otra función sumará dos objetos 
de tipo hora pasados como argumento. 
Al iniciar la aplicación, crear tres objetos de la clase Hora inicializando con valores a 2 de ellos, 
que deberán sumarse almacenando el resultado sobre el tercero. Mostrar el resultado*/


public class Hora {
	private int segundos;
	private int minutos;
	private int horas ;
	
	
	
	public Hora() {  // Constructor inicializa las variables en 0
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
    }

    public Hora(int horas, int minutos, int segundos) { // segundo constructor 
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public void mostrarHora() {    //Funcion que muestra el formato en hh:mm:ss
        System.out.printf("%02d:%02d:%02d\n", horas, minutos, segundos);
    }

    public void sumarHoras(Hora hora1, Hora hora2) {  
    	
    	
        int totalSegundos = hora1.segundos + hora2.segundos;
        
        int segundosRestantes = totalSegundos % 60;
        
        int totalMinutos = hora1.minutos + hora2.minutos + (totalSegundos / 60);
        
        int minutosRestantes = totalMinutos % 60;
        
        int totalHoras = hora1.horas + hora2.horas + (totalMinutos / 60);
        
        this.horas = totalHoras % 24;
        this.minutos = minutosRestantes;
        this.segundos = segundosRestantes;
    }
}


