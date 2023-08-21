package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Capacitaciones;

public interface CapacitacionesDAO {
	List<Capacitaciones> ListarCapacitaciones();
	long addCapacitaciones(Capacitaciones capacitaciones);
	Optional<Capacitaciones> findById(long id);
	
	long deleteCapacitaciones (Long id);
	long updateCapacitaciones (long id, Capacitaciones capacitaciones);

}
