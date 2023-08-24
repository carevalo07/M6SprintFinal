package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Visitas;

import jakarta.transaction.Transactional;


@Repository 
public interface VisitasDAO extends JpaRepository<Visitas, Long> {
	List<Visitas> findAll();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update visitas v set v.cliente_id = ?, v.fecha_visita = ?, v.detalle = ?, v.profesional_id = ? where v.id = ?;", nativeQuery=true)
	void actualizar(int cliente_id, String fecha_visita, String detalle, int profesional_id, Long id);
}
