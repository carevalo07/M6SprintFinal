package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pagos;
import com.example.demo.model.PagosRowMapper;

@Repository
public class PagosDAOImpl implements PagosDAO{
	

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public PagosDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Pagos> ListarPagos() {
    	 String sql = "SELECT id, cliente_id, monto, fecha_pago FROM pagos;";
		return jdbcTemplate.query(sql, new PagosRowMapper());

	}

}
