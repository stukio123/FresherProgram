package com.fresherprogram.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fresherprogram.model.Client;
import com.fresherprogram.model.Motor;
import com.fresherprogram.model.Policy;

public class PolicyRowMapper implements RowMapper<Policy>{

	
	@Override
	public Policy mapRow(ResultSet rs, int rowNum) throws SQLException {
		Policy policy = new Policy();
		Motor motor = new Motor();
		Client client = new Client();
		
		client.setClientID(rs.getString("clientId"));
		client.setFirstName(rs.getString("firstName"));
		client.setLastName(rs.getString("lastName"));
		client.setAddress(rs.getString("ClientAddress"));
		client.setCountry(rs.getString("country"));
		client.setDateOfBirth(rs.getDate("dateOfBirth"));
		client.setGender(rs.getString("gender"));
		client.setMaritalStatus(rs.getString("maritalStatus"));
		
		motor.setVehicleRegistration(rs.getString("vehicleRegistrationNo"));
		motor.setchassisNo(rs.getString("chassisNo"));
		motor.setengineNo(rs.getString("engineNo"));
		
		policy.setPolicyOwner(client);
		policy.setMotor(motor);
		policy.setPolicyNo(rs.getString("policyNo"));
		policy.setBillingCurrency(rs.getString("billingCurrency"));
		policy.setRate(rs.getFloat("rate"));
		policy.setInceptionDate(rs.getDate("inceptionDate"));
		policy.setExpiryDate(rs.getDate("expiryDate"));
		policy.setRenewDate(rs.getDate("renewDate"));
		policy.setSumInsured(rs.getLong("sumInsured"));
		policy.setAnnualPremium(rs.getLong("annualPremium"));
		policy.setPostedPremium(rs.getLong("postedPremium"));
		return policy;
	}
	
	

}
