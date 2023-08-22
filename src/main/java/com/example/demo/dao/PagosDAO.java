package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pagos;


@Repository 
public interface PagosDAO extends JpaRepository<Pagos, Long> {
	List<Pagos> findAll();

}
