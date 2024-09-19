package com.example.demoCRUD;  // Define el paquete donde se encuentra esta clase.

import jakarta.annotation.PostConstruct;  // Importa la anotación @PostConstruct, que se usa para indicar que un método debe ejecutarse después de la construcción del bean.
import org.springframework.boot.SpringApplication;  // Importa la clase SpringApplication, que se utiliza para lanzar la aplicación Spring Boot.
import org.springframework.boot.autoconfigure.SpringBootApplication;  // Importa la anotación @SpringBootApplication, que se usa para marcar la clase principal de la aplicación Spring Boot.

@SpringBootApplication  // Marca la clase como una aplicación Spring Boot, habilitando la configuración automática, el escaneo de componentes y la configuración de Spring.
public class DemoCrudApplication {  //

    public static void main(String[] args) {  
        SpringApplication.run(DemoCrudApplication.class, args);  // Llama al método estático run() de SpringApplication para iniciar la aplicación Spring Boot.
    }

    @PostConstruct  // Indica que el método siguiente debe ser llamado después de que el bean haya sido construido e inicializado.
    private void runMethod() {  // Define un método privado que se ejecutará después de que el bean haya sido creado.
        System.setProperty("java.awt.headless", "false");  // Establece la propiedad del sistema "java.awt.headless" en "false", indicando que la aplicación no debe funcionar en modo sin cabeza (sin interfaz gráfica).
        Main main = new Main();  // Crea una nueva instancia de la clase Main (asumiendo que existe una clase Main en el mismo paquete o en el classpath).
    }

}
