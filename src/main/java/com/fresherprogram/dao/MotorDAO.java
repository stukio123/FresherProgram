package com.fresherprogram.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fresherprogram.model.Motor;
import com.fresherprogram.model.Status;

public class MotorDAO {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}
	
	public List<Motor> findAll(){
		String query = "Select * from Motor";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<Motor>(Motor.class));
	}
}
