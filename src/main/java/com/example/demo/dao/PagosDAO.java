package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pagos;

import jakarta.transaction.Transactional;


@Repository 
public interface PagosDAO extends JpaRepository<Pagos, Long> {
	List<Pagos> findAll();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update pagos p set p.cliente_id = ?, p.monto = ?, p.fecha_pago = ? where p.id = ?;", nativeQuery=true)
	void actualizar(int cliente_id, int monto, String fecha_pago, Long id);
}
