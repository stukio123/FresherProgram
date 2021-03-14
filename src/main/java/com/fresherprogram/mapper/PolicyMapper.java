package com.fresherprogram.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.fresherprogram.dao.ClientDAO;
import com.fresherprogram.dao.MotorDAO;
import com.fresherprogram.dao.PolicyDAO;
import com.fresherprogram.dto.PolicyDTO;
import com.fresherprogram.model.Client;
import com.fresherprogram.model.Motor;
import com.fresherprogram.model.Policy;
import com.fresherprogram.service.MotorService;
import com.fresherprogram.service.PolicyService;

public class PolicyMapper {
	
	private PolicyDAO policyDAO;
	
	private PolicyService policyService;
	
	private MotorMapper motorMapper;
	
	private ClientDAO clientDAO;
	
	private MotorDAO motorDAO;
	
	@Autowired
	public void setPolicyDAO(PolicyDAO policyDAO) {
		this.policyDAO = policyDAO;
	}
	
	@Autowired
	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	
	@Autowired
	public void setPolicyService(PolicyService policyService) {
		this.policyService = policyService;
	}
	
	@Autowired
	public void setMotorDAO(MotorDAO motorDAO) {
		this.motorDAO = motorDAO;
	}
	
	@Autowired
	public void setMotorMapper(MotorMapper motorMapper) {
		this.motorMapper = motorMapper;
	}

	public Policy toPolicy(PolicyDTO policyDTO) throws ParseException{
		if(policyService.checkInput(policyDTO) == null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date renewalDate = null;
			Date expiryDate = null;
			Calendar cal = Calendar.getInstance();
			cal.setTime(format.parse(policyDTO.getRenewalDate()));
			String date1 = String.format("%s-%s-%s",cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH));
			renewalDate = new Date(cal.getTimeInMillis());
			cal.setTime(format.parse(policyDTO.getExpiryDate()));
			String date2 = String.format("%s-%s-%s",cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH));
			expiryDate = new Date(cal.getTimeInMillis());
			double annual = Double.parseDouble(policyDTO.getAnnualPremium());
			double posted = Double.parseDouble(policyDTO.getPostedPremium());
			double sumInsured = Double.parseDouble(policyDTO.getSumInsured());
			float rate = Float.parseFloat(policyDTO.getRate());
			Client client = clientDAO.findById(policyDTO.getPolicyOwner());
			//Motor motor = motorMapper.toMotor(policyDTO);
			Motor motor = new Motor();
			motor.setVehicleRegistration(policyDTO.getVehicleRegistrationNo());
			motor.setchassisNo(policyDTO.getChassisNo());
			motor.setengineNo(policyDTO.getEngineNo());
			Policy p = policyDAO.findById(policyDTO.getPolicyNo());
			p.setAnnualPremium(annual);
			p.setPostedPremium(posted);
			p.setRate(rate);
			p.setSumInsured(sumInsured);
			p.setRenewDate(renewalDate);
			p.setExpiryDate(expiryDate);
			p.setPolicyOwner(client);
			p.setMotor(motor);
			p.setStatusPolicy("PR");
			p.setBillingCurrency(policyDTO.getBillingCurrency());
			System.out.println(p.toString());
			return p;
		}else 
			return null;
	}
}
