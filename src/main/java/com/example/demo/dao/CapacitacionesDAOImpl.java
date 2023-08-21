package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Capacitaciones;
import com.example.demo.model.CapacitacionesRowMapper;


@Repository
public class CapacitacionesDAOImpl implements CapacitacionesDAO {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public CapacitacionesDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Capacitaciones> ListarCapacitaciones() {
        String sql = "SELECT id, nombre, detalle FROM capacitaciones;";
		return jdbcTemplate.query(sql, new CapacitacionesRowMapper());
	}

	@Override
	public long addCapacitaciones(Capacitaciones capacitacion) {
		 String sql = """
	        	    INSERT INTO capacitaciones( nombre, detalle)
	        	    VALUES( ?, ? );
	        		""";
			return jdbcTemplate.update(
					sql, 
					capacitacion.getNombre(),
					capacitacion.getDetalle()
					);
	
	}

	@Override
	public Optional<Capacitaciones> findById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public long deleteCapacitaciones(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long updateCapacitaciones(long id, Capacitaciones capacitaciones) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
