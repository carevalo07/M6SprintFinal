package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsuariosRowMapper implements RowMapper<Usuarios>{

	@Override
	public Usuarios mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Usuarios( rs.getString("nombre"), rs.getString("tipo"));
	}

}
