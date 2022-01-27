package com.ideas.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas.app.jpa.model.Factura;
import com.ideas.app.service.FacturaService;

@Controller
@RequestMapping("/factura")
public class ControllFactura {

	
	@Autowired
	private FacturaService facturaService;
	
	private static final Logger LOGGER= LogManager.getLogger(ControllFactura.class);
	
	@RequestMapping(value = {"", "/list"})
	public String home(Model model) {
		
		Iterable<Factura> facturas = facturaService.list();
		
		LOGGER.info("Facturas de compra: " +  facturas);
		
		model.addAttribute("listFacturas", facturas);
		
		
		return "homeFactura";
	}
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("codigo") Integer codigo) {
		
		LOGGER.info("Factura codigo a eliminar: " + codigo);
		facturaService.delete(codigo);
		
		return "redirect:/factura";
	}
	
	
}
