package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="visitas")
public class Visitas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cliente_id;
	private String fecha_visita;
	private String detalle;
	private int profesional_id;
	
	public Visitas() {

	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getFecha_visita() {
		return fecha_visita;
	}

	public void setFecha_visita(String fecha_visita) {
		this.fecha_visita = fecha_visita;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getProfesional_id() {
		return profesional_id;
	}

	public void setProfesional_id(int profesional_id) {
		this.profesional_id = profesional_id;
	}

	@Override
	public String toString() {
		return "Visitas [cliente_id=" + cliente_id + ", fecha_visita=" + fecha_visita + ", detalle=" + detalle
				+ ", profesional_id=" + profesional_id + "]";
	}
	
	
}
