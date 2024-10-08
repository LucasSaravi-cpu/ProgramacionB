package com.demoprogb.objects.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Marca {
	private Long marca;
	private String nombre;	
	private String mail;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getMarca() {
		return marca;
	}
	public void setMarca(Long marca) {
		this.marca = marca;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
