package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Contacto;

public interface ContactoDAO extends JpaRepository<Contacto, Long>{

	List<Contacto> findAll();
}
