package com.ideas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas.app.jpa.model.TipoTransporte;
import com.ideas.app.service.TipoTransporteService;

@Controller
@RequestMapping("/tipoTransporte")
public class ControllTipoTransporte {

	
	
	@Autowired
	private TipoTransporteService tipoTransporteService;
	
	@RequestMapping(value = {"", "/listar"})
	public String homeTipoTransporte( Model model) {
		
		
		Iterable<TipoTransporte> tipoTransportes = tipoTransporteService.list();
		model.addAttribute("listTipoTransportes",  tipoTransportes);
		
		return "homeTipoTransporte";
	}
	
	
	
	@GetMapping("/nuevo")
	public String register(Model model) {
		
		
		TipoTransporte  nuevoTipoTranporte = new TipoTransporte();
		model.addAttribute("nuevoTipoTransporte",  nuevoTipoTranporte);
		return "nuevo-tipoTransporte";
		
	}
	
	
	@PostMapping("/guardar")
	public String saveTipoTransporte(@ModelAttribute("nuevoTipoTransporte") TipoTransporte tipoTransporte) {
		
		
		tipoTransporteService.add(tipoTransporte);
		return "redirect:/tipoTransporte";	
	}
	
	
	@GetMapping("/edit")
	public String formUpdateTipoTransporte(@RequestParam("codigo") Integer codigo, Model model) {
	
		TipoTransporte tipoTransporte = tipoTransporteService.buscarById(codigo);
		// Si existe el
		if (tipoTransporte !=null) {			
			model.addAttribute("datosTipoTransporte", tipoTransporte);
			return "update-tipoTransporte";
		
		}
		
		// Si no
		
		return "redirect:/tipoTransporte";	
	}
	
	
	@PostMapping("/actualizarTipoTransporte")
	public String  actualizarTipoTransporte( @ModelAttribute("datosTipoTransporte") TipoTransporte tipoTransporte) {
		
		 tipoTransporteService.update(tipoTransporte);
		
		return "redirect:/tipoTransporte";	
	}
	
	@GetMapping("/delete")
	public String  delete( @RequestParam("codigo") Integer codigo) {	
		tipoTransporteService.delete(codigo);
		return "redirect:/tipoTransporte";	
	}
	
}
