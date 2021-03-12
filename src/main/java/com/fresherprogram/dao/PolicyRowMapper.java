package com.fresherprogram.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fresherprogram.model.Policy;

public class PolicyRowMapper implements RowMapper<Policy>{

	
	@Override
	public Policy mapRow(ResultSet rs, int rowNum) throws SQLException {
		Policy policy = new Policy();
		
		return null;
	}

}
