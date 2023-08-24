package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Capacitaciones;

import jakarta.transaction.Transactional;


@Repository 
public interface CapacitacionesDAO extends JpaRepository<Capacitaciones, Long> {
	List<Capacitaciones> findAll();
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update capacitaciones c set c.nombre = ?, c.detalle = ? where c.id = ?;", nativeQuery=true)
	void actualizar(String nombre, String detalle, Long id);
}
