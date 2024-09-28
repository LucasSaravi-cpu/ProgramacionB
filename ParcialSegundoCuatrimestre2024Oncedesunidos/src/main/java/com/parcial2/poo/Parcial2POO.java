package com.parcial2.poo;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import view.Main;

@SpringBootApplication
public class Parcial2POO {

	public static void main(String[] args) {
		SpringApplication.run(Parcial2POO.class, args);
	}

	@PostConstruct
	private void runMethod() {
		System.setProperty("java.awt.headless", "false");
		Main main = new Main();
	}

}
