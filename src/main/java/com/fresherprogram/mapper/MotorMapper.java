package com.fresherprogram.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.fresherprogram.dao.MotorDAO;
import com.fresherprogram.dto.PolicyDTO;
import com.fresherprogram.model.Motor;

public class MotorMapper {
	private MotorDAO motorDAO;
	
	@Autowired
	public void setMotorDAO(MotorDAO motorDAO) {
		this.motorDAO = motorDAO;
	}
	
	public Motor toMotor(PolicyDTO policyDTO) {
		Motor motor = new Motor();
		motor = motorDAO.findByEngineNo(policyDTO.getEngineNo());
		if(motor == null) {
			motor = motorDAO.findByChassisNo(policyDTO.getChassisNo());
		}
		return motor;
	}
}
