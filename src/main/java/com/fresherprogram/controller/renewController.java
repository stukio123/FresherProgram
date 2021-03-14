package com.fresherprogram.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.type.CalendarDateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fresherprogram.dao.ClientDAO;
import com.fresherprogram.dao.PolicyDAO;
import com.fresherprogram.dto.PolicyDTO;
import com.fresherprogram.model.Policy;
import com.fresherprogram.service.PolicyService;

@Controller
public class renewController {
	
	
	@Autowired
	PolicyDAO policyDAO;
	
	@Autowired
	PolicyService policyService;
	
	public String formatDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String month = cal.get(Calendar.MONTH)+"";
		String day = cal.get(Calendar.DAY_OF_MONTH) + "";
		String year = cal.get(Calendar.YEAR)+"";
		if(cal.get(Calendar.MONTH) < 10)
			month = "0"+cal.get(Calendar.MONTH);
		if(cal.get(Calendar.DAY_OF_MONTH)<10)
			day = "0"+cal.get(Calendar.DAY_OF_MONTH);
		return String.format("%s-%s-%s", year,month,day);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public String getMethod(Model model, @PathVariable("id") String id) {
		Policy p = policyDAO.findById(id);
		Calendar cal = Calendar.getInstance();
		cal.setTime(p.getExpiryDate());
		cal.add(Calendar.YEAR, 1);
		String date = formatDate(cal.getTime());
		model.addAttribute("policy",new PolicyDTO());
		model.addAttribute("p",p.getPolicyOwner().getClientID());
		model.addAttribute("renewalDate",date);
		model.addAttribute("policyID",p.getPolicyNo());
		return "renew";
	}
	
	@RequestMapping(value="/renewPolicy", method = RequestMethod.POST, params="Save")
	public String postRenew(@ModelAttribute("policy") PolicyDTO request, ModelMap modelMap) throws ParseException {
		String error = policyService.checkInput(request);
		if(error == null) {
			String result = policyService.renew(request);
			modelMap.addAttribute("messages",result);
		}else {
			modelMap.addAttribute("messages",error);
		}
		
		return "renew";
	}
	
	@RequestMapping(value="/renewPolicy", method = RequestMethod.POST, params="Issue")
	public String postIssue(@ModelAttribute("policy") PolicyDTO request, ModelMap modelMap) throws ParseException {
		String error = policyService.checkInput(request);
		if(error == null) {
			String result = policyService.issue(request);
			modelMap.addAttribute("messages",result);
		}else {
			modelMap.addAttribute("messages",error);
		}
		
		return "renew";
	}
	
}
