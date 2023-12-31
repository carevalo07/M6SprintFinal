package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pagos")
public class Pagos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int cliente_id;
	private int monto;
	private String fecha_pago;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pagos() {
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public String getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(String fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	@Override
	public String toString() {
		return "Pagos [cliente_id=" + cliente_id + ", monto=" + monto + ", fecha_pago=" + fecha_pago + "]";
	}

}
