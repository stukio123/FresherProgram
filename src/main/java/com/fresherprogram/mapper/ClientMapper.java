package com.fresherprogram.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.fresherprogram.dao.ClientDAO;
import com.fresherprogram.dto.PolicyDTO;
import com.fresherprogram.model.Client;

public class ClientMapper {
	private ClientDAO clientDAO;
	
	@Autowired
	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	
	public Client toClient(PolicyDTO policyDTO) {
		Client client = new Client();
		client = clientDAO.findById(policyDTO.getPolicyOwner());
		return client;
	}
}
