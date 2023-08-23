package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Capacitaciones;


@Repository 
public interface CapacitacionesDAO extends JpaRepository<Capacitaciones, Long> {
	List<Capacitaciones> findAll();
	
}
