package com.fresherprogram.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fresherprogram.model.Client;

public class ClientDAO {
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}
	
	public List<Client> findAll(){
		String query = "Select * from Client";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<Client>(Client.class));
	}
	
	public Client findById(String id) {
		String query = String.format("Select * from Client where Client.clientId = '%s'", id);
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Client>(Client.class));
	}
}
