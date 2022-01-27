package com.ideas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideas.app.service.FacturaService;

@Controller
@RequestMapping("/factura")
public class ControllFactura {

	
	@Autowired
	private FacturaService facturaService;
	
	@RequestMapping(value = {"", "/list"})
	@ResponseBody
	public String home(Model model) {
		
		
		
		return "";
	}
	
	
}
