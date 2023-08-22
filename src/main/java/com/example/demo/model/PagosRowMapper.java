package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PagosRowMapper implements RowMapper<Pagos>{

	@Override
	public Pagos mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Pagos(rs.getInt("cliente_id"), rs.getInt("monto"), rs.getString("fecha_pago"));
	}
}
