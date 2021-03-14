package com.fresherprogram.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fresherprogram.dao.ClientDAO;
import com.fresherprogram.dto.PolicyDTO;

public class ClientService {
	private ClientDAO clientDAO;
	
	@Autowired
	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	
	public String checkInputs(PolicyDTO policyDTO) {
		String policyOwner = policyDTO.getPolicyOwner();
		return null;
	}
}
