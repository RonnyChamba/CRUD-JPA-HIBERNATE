package com.ideas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ideas.app.jpa.model.TipoViaje;
import com.ideas.app.service.TipoViajeService;

@Controller
@RequestMapping("/tipoViaje")
public class ControllTipoViaje {
	
	
	@Autowired
	private   TipoViajeService tipoViajeService;
	
	@RequestMapping(value = {"", "/listar"})
	public String homeTipoViaje(Model model) {
		
		Iterable<TipoViaje> tipoViajes =  tipoViajeService.list();
		model.addAttribute("listTipoViajes",  tipoViajes );
		
		return "homeTipoViaje";
	}
	
	
	
	@GetMapping("/nuevo")
	public String register(Model model) {
		
		TipoViaje nuevoTipoViaje = new TipoViaje();
		model.addAttribute("nuevoTipoViaje",  nuevoTipoViaje);
		return "nuevo-tipoViaje";
		
	}
	
	
	@PostMapping("/guardar")
	public String saveTipoViaje(@ModelAttribute("nuevoTipoViaje") TipoViaje tipoViaje) {
		
		
		tipoViajeService.add(tipoViaje);
		return "redirect:/tipoViaje";	
	}
	
	
	@GetMapping("/edit")
	public String formUpdateTipoViaje(@RequestParam("codigo") Integer codigo, Model model) {
	
		TipoViaje tipoViaje = tipoViajeService.buscarById(codigo);
		// Si existe el
		if (tipoViaje !=null) {			
			model.addAttribute("datosTipoViaje", tipoViaje);
			return "update-tipoViaje";
		
		}
		
		// Si no
		
		return "redirect:/tipoViaje";	
	}
	
	
	@PostMapping("/actualizarTipoViaje")
	public String  actualizarTipoViaje( @ModelAttribute("datosTipoViaje")TipoViaje tipoViaje) {
		
		 tipoViajeService.update(tipoViaje);
		
		return "redirect:/tipoViaje";	
	}
	
	@GetMapping("/delete")
	public String  delete( @RequestParam("codigo") Integer codigo) {	
		tipoViajeService.delete(codigo);
		return "redirect:/tipoViaje";	
	}
	
	

	
}
