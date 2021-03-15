package com.fresherprogram.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.fresherprogram.dao.ClientDAO;
import com.fresherprogram.dao.MotorDAO;
import com.fresherprogram.dao.PolicyDAO;
import com.fresherprogram.dto.PolicyDTO;
import com.fresherprogram.mapper.PolicyMapper;

public class PolicyService {
	
	
	private PolicyDAO policyDAO;
	
	@Autowired
	public void setPolicyDao(PolicyDAO policyDAO) {
		this.policyDAO = policyDAO;
	}
	
	private MotorDAO motorDAO;
	
	@Autowired
	public void setMotorDAO(MotorDAO motorDAO) {
		this.motorDAO = motorDAO;
	}
	
	private ClientDAO clientDAO;
	
	@Autowired
	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	
	private PolicyMapper policyMapper;
	
	@Autowired
	public void setPolicyMapper(PolicyMapper policyMapper) {
		this.policyMapper = policyMapper;
	}
	
	public String checkInput(PolicyDTO policyDTO) {
		String policyNo = policyDTO.getPolicyNo();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String billingCurrency = policyDTO.getBillingCurrency();
		System.out.println(policyDTO.toString());
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(format.parse(policyDTO.getRenewalDate()));
			Date renewalDate = cal.getTime();
			cal.setTime(format.parse(policyDTO.getExpiryDate()));
			Date expiryDate = cal.getTime();
			double sumInsured = Double.parseDouble(policyDTO.getSumInsured());
			float rate = Float.parseFloat(policyDTO.getRate());
			double annualPremium = Double.parseDouble(policyDTO.getAnnualPremium());
			double postedPremium = Double.parseDouble(policyDTO.getPostedPremium());
			if(daysBetween(renewalDate,expiryDate) < 0) 
				return "Expiry Date must be greater than Renewal Date";
			if(rate < 0)
				return "Rate must not be Negative";
			if(sumInsured < 0)
				return "Sum Insured must not be Negative";
			if(annualPremium < 0)
				return "Annual Premium must not be Negative";
			if(postedPremium < 0)
				return "Posted Premium must not be Negative";
		}catch (Exception e) {
			System.out.println(e);
			System.out.println(policyDTO.toString());
			return "Wrong data type";
		}
		
		if(policyDAO.findById(policyNo) == null)
			return "Policy No not found";
		if(billingCurrency == null || "".equals(billingCurrency))
			return "Billing Currency is madatory";
		
		return null;
	}
	
	public String renew(PolicyDTO policy) throws ParseException {
		if(checkInput(policy) != null) {
			return checkInput(policy);
		}else {
			try {
				policyDAO.save(policyMapper.toPolicy(policy));
				return "Renew successful";
			}
			catch(DuplicateKeyException duplicate) {
				return "Duplicate Engine No and Chassis No";
			}
		}
	}
	public String issue(PolicyDTO policy) throws ParseException {
		if(checkInput(policy) != null) {
			return checkInput(policy);
		}else {
			try{
				policyDAO.issue(policyMapper.toPolicy(policy));
				return "Issue successful";
			}catch(DuplicateKeyException duplicate) {
				return "Duplicate Engine No and Chassis No";
			}
			
		}
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
