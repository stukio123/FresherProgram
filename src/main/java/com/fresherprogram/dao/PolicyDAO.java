package com.fresherprogram.dao;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fresherprogram.mapper.PolicyMapper;
import com.fresherprogram.model.Policy;

public class PolicyDAO {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}
	
	public List<Policy> findAll() {
		String query = "Select * from Policy";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<Policy>(Policy.class));
	}
	
	public Policy findById(String id) {
		String query = String.format("Select * From Policy, Client where Policy.policyNo = '%s' and Policy.policyOwner = Client.clientId",id);
		return jdbcTemplate.queryForObject(query,new PolicyRowMapper());
	}
	
	public int save(Policy policy) throws DuplicateKeyException{
		String query = String.format("update Policy "
									+ "set renewDate = '%s', "
									+ "expiryDate = '%s', "
									+ "sumInsured = %s, "
									+ "rate = %s, "
									+ "statusPolicy = '%s', "
									+ "annualPremium = %s, "
									+ "postedPremium = %s, "
									+ "vehicleRegistrationNo = '%s', "
									+ "chassisNo = '%s', "
									+ "engineNo = '%s'"
									+ "where Policy.policyNo = '%s'",
									policy.getRenewDate(), policy.getExpiryDate(), policy.getSumInsured(), policy.getRate(),
									policy.getStatusPolicy(), policy.getAnnualPremium(), policy.getPostedPremium(), policy.getMotor().getVehicleRegistration(),
									policy.getMotor().getchassisNo(), policy.getMotor().getengineNo(),policy.getPolicyNo());
		return jdbcTemplate.update(query);
	}
	public int issue(Policy policy) throws DuplicateKeyException{
		String query = String.format("update Policy "
									+ "set renewDate = '%s', "
									+ "expiryDate = '%s',"
									+ "sumInsured = %s, "
									+ "rate = %s, "
									+ "statusPolicy = '%s', "
									+ "annualPremium = %s, "
									+ "postedPremium =%s, "
									+ "vehicleRegistrationNo = '%s', "
									+ "chassisNo = '%s', "
									+ "engineNo = '%s'"
									+ "where Policy.policyNo = '%s'",
									policy.getRenewDate(), policy.getExpiryDate(), policy.getSumInsured(), policy.getRate(),
									"IF", policy.getAnnualPremium(), policy.getPostedPremium(), policy.getMotor().getVehicleRegistration(),
									policy.getMotor().getchassisNo(), policy.getMotor().getengineNo(),policy.getPolicyNo());
		return jdbcTemplate.update(query);
	}
	
	private LocalDate convertToLocalDate(Date dateToConvert) {
		return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	@SuppressWarnings("unused")
	public double daysBetween(Date d1, Date d2) {
		if (d1 != null && d2 != null) {
			LocalDate ld1 = convertToLocalDate(d1);
			LocalDate ld2 = convertToLocalDate(d2);
			double days = ChronoUnit.DAYS.between(ld1, ld2);
			return days;
		}
		return 0;
	}
}
