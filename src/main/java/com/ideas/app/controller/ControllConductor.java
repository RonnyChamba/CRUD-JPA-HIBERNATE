package com.ideas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas.app.jpa.model.Cliente;
import com.ideas.app.jpa.model.Conductor;
import com.ideas.app.service.ClienteService;
import com.ideas.app.service.ConductorService;

@Controller
@RequestMapping("/conductor")
public class ControllConductor {
	
	
	@Autowired
	private  ConductorService conductorService; 
	
	@RequestMapping(value = {"", "/listar"})
	public String homeConductor(Model model) {
		
		Iterable<Conductor> conductores = conductorService.conductorList();
		model.addAttribute("listConductores", conductores );
		
		return "homeConductor";
	}
	
	
	
	@GetMapping("/nuevo")
	public String register(Model model) {
		
		Conductor nuevoConductor = new Conductor();
		model.addAttribute("nuevoConductor", nuevoConductor);
		return "nuevo-conductor";
		
	}
	
	
	@PostMapping("/guardar")
	public String saveCliente(@ModelAttribute("nuevoConductor") Conductor conductorNuevo) {
		
		
		conductorService.conductorAdd(conductorNuevo);
		return "redirect:/conductor";	
	}
	
	
	@GetMapping("/edit")
	public String formUpdateCliente(@RequestParam("codigo") Integer codigo, Model model) {
	
		Conductor conductor = conductorService.buscarById(codigo);
		
		// Si existe el
		if (conductor !=null) {			
			model.addAttribute("datosConductor", conductor);
			return "update-conductor";
		
		}
		
		// Si no
		
		return "redirect:/conductor";	
	}
	
	
	@PostMapping("/actualizarConductor")
	public String  actualizarConductor( @ModelAttribute("datosConductor") Conductor conductor) {
		
		 conductorService.actualizar(conductor);
		
		return "redirect:/conductor";	
	}
	
	@GetMapping("/delete")
	public String  delete( @RequestParam("codigo") Integer codigo) {	
		conductorService.conductorDelete(codigo);
		
		return "redirect:/conductor";	
	}
	
	

	
}
