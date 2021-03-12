package com.fresherprogram.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class PolicyDAO {
	
	JdbcTemplate jdbcTemplate;
	@Autowired
	ClientDAO clientDAO;
	@Autowired
	CurrencyDAO currencyDAO;
	@Autowired
	MotorDAO motorDAO;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}
	
	
}
