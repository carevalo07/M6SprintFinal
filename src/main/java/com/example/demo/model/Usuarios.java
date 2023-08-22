package com.example.demo.model;

public class Usuarios {

	private String nombre;
	private String tipo;
	
	public Usuarios(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", tipo=" + tipo + "]";
	}
	
	
}
