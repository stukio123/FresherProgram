package com.fresherprogram.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fresherprogram.model.Status;

public class CurrencyDAO {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}
	
	public List<Status> findAll(){
		String query = "Select * from BillingCurrency";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<Status>(Status.class));
	}
}
