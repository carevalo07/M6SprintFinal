package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuarios;

import jakarta.transaction.Transactional;


@Repository 
public interface UsuariosDAO extends JpaRepository<Usuarios, Long> {
	List<Usuarios> findAll();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update usuarios u set u.nombre = ?, u.tipo = ? where u.id = ?;", nativeQuery=true)
	void actualizar(String nombre, String tipo, Long id);
}
