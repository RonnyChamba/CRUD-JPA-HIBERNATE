package com.ideas.app.controller;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ControllApp {

	
	private static final Logger LOGGER= LogManager.getLogger(ControllApp.class);
	
	@ RequestMapping("/home")	
	public String home(Model model) {
	
		
		LOGGER.info("En el controlador principal");
		model.addAttribute("hello", "Aprendiendo Spring Framework");
		model.addAttribute("hour", Calendar.getInstance().getTime());
		
		return "home";
		
	}
}
