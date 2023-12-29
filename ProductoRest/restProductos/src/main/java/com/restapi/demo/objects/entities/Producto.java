package com.restapi.demo.objects.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Producto")
public class Producto {
	private Long producto;
	private String descripcion;
	private Marca marca;
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getProducto() {
		return producto;
	}
	
	public void setProducto(Long producto) {
		this.producto = producto;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "marca")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	@Transient
	public String getDescripcionCompleta() {
		return marca.getNombre() + " - " + descripcion;
	}
}
