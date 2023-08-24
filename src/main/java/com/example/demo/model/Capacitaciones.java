package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="capacitaciones")
public class Capacitaciones {

    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;	

	private String nombre;
	private String detalle;

	public Capacitaciones() {
		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Capacitaciones nombre=" + nombre + ", detalle=" + detalle + "]";
	}

}
