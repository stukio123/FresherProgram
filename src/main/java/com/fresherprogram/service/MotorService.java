package com.fresherprogram.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fresherprogram.dao.MotorDAO;
import com.fresherprogram.dto.PolicyDTO;

public class MotorService {
	private MotorDAO motorDAO;
	
	@Autowired
	public void setMotorDAO(MotorDAO motorDAO) {
		this.motorDAO = motorDAO;
	}
	
	public String checkInputs(PolicyDTO policyDTO) {
		String chassisNo = policyDTO.getChassisNo();
		String engineNo = policyDTO.getEngineNo();
		
		if(chassisNo == null || "".equals(chassisNo))
			return "Chassis No is mandatory";
		if(engineNo == null || "".equals(engineNo))
			return "Engine No is mandatory";
		if(chassisNo.equals(engineNo))
			return "Duplicate Engine and Chassis No";
		return null;
	}
}
