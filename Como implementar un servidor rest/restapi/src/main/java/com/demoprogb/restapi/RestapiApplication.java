package com.demoprogb.restapi;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration
@EnableScheduling
@ComponentScan({"com.demoprogb.restapi"})
@EntityScan({"com.demoprogb.objects"}) //@EntityScan para que la(s) “ruta(s)” en ella indicada(s), incluyan el groupId de la librería de entities
@EnableJpaRepositories({"com.demoprogb.restapi.dao"})
@SpringBootApplication

public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

}
