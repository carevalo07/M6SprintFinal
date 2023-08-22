package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuarios;


@Repository 
public interface UsuariosDAO extends JpaRepository<Usuarios, Long> {
	List<Usuarios> findAll();

}
