package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuarios;
import com.example.demo.model.UsuariosRowMapper;

@Repository
public class UsuariosDAOImpl implements UsuariosDAO {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UsuariosDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Usuarios> ListarUsuarios() {
        String sql = "SELECT id, nombre, tipo FROM usuarios;";
		return jdbcTemplate.query(sql, new UsuariosRowMapper());
	}

}
