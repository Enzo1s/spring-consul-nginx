package com.example.factura.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Producto {

	@Id
	private Long Id;
	
	private String nombre;
	
	private Double precio;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}

