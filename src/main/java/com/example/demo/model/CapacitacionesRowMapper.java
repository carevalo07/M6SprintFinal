package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CapacitacionesRowMapper implements RowMapper<Capacitaciones>{

	@Override
	public Capacitaciones mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Capacitaciones( rs.getString("nombre"), rs.getString("detalle"));
	}

}
