package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VisitasRowMapper implements RowMapper<Visitas>{

	@Override
	public Visitas mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Visitas( rs.getInt("cliente_id"), rs.getString("nombre"), rs.getString("tipo"), rs.getInt("profesional_id"));
	}

}
