package com.demoprogb.objects.entities;




import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;



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
