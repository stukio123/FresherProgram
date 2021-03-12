package com.fresherprogram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fresherprogram.dao.ClientDAO;

@Controller
public class renewController {

	@Autowired
	ClientDAO dao;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getMethod(Model model) {
		model.addAttribute("listClient",dao.findAll());
		return "renew";
	}
}
