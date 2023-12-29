package com.restapi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class,SessionAutoConfiguration.class})
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan({"com.restapi.demo", "com.restapi.demo.objects.rest"})
@EntityScan({"com.restapi.demo.objects"})
@EnableJpaRepositories({"com.restapi.demo.dao"})
public class RestProductosApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestProductosApplication.class, args);
	}
}
