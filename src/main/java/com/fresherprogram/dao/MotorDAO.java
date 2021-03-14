package com.fresherprogram.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fresherprogram.model.Motor;

public class MotorDAO {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}
	
	public Motor findByChassisNo(String chassisNo) {
		String query = String.format("select * from Policy where chassisNo = '%s'",chassisNo);
		return jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<Motor>(Motor.class));
	}
	
	public Motor findByEngineNo(String engineNo) {
		String query = String.format("select * from Policy where engineNo = '%s'",engineNo);
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Motor>(Motor.class));
	}
}
