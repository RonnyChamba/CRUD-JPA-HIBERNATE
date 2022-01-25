package com.ideas.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ideas.app.jpa.model.Conductor;
import com.ideas.app.jpa.model.TipoTransporte;
import com.ideas.app.jpa.model.Transporte;
import com.ideas.app.service.ConductorService;
import com.ideas.app.service.TipoTransporteService;
import com.ideas.app.service.TransporteService;

@Controller
@RequestMapping("/transporte")
public class ControllTransporte {

	
	@Autowired
	private TransporteService transporteService;
	
	@Autowired
	private TipoTransporteService tipoTransporteService;
	
	@Autowired
	private ConductorService conductorService;
	
	private static final Logger LOGGER= LogManager.getLogger(ControllTransporte.class);
	
	@RequestMapping(value = {"", "/list"})
	public String home(Model model) {
		
		Iterable<Transporte> transportes = transporteService.list();
		
		LOGGER.info("Lista de transportes: "  +transportes);	
		model.addAttribute("listTransportes", transportes);
		
		return "homeTransporte";	
	}
	
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Transporte transporte = new Transporte();
		
		Iterable<TipoTransporte> tiposTransportes =  tipoTransporteService.list();	
		Iterable<Conductor> conductores = conductorService.conductorList(); 
		
		Map<Integer, String> mapTipoTransporte = new HashMap<Integer, String>();
		Map<Integer, String> mapConductor = new HashMap<Integer, String>();
		
		for(TipoTransporte t : tiposTransportes) {
			mapTipoTransporte.put( t.getCodigo(), t.getTipo());
		}

		transporte.setMapTransportes( mapTipoTransporte);
		
		for(Conductor c : conductores) {
			
			mapConductor.put( c.getCodigo(), c.getNombre() + " " + c.getApellido());
		}
		
		transporte.setMapConductores(mapConductor);
		 LOGGER.info("Nuevo modelo transporte: "+ transporte );
		model.addAttribute("nuevoTransporte", transporte);
		
		return "nuevo-transporte";		
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute("nuevoTransporte") Transporte transporte) {
		
		LOGGER.info("Transporte a guardar: " + transporte);
		transporteService.add(transporte);		
		return "redirect:/transporte";
		
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("codigo") Integer codigo, Model model) {
		
		
		LOGGER.info("Transporte a editar " + codigo);
		Transporte  transporte =  transporteService.buscarById(codigo);
		LOGGER.info("Transporte recuperado: " + transporte);
		
		
		/*// NO es necesario, lo puedo comentar
		Conductor conductor = transporte.getConductor();
		TipoTransporte tipoTransporte  = transporte.getTipoTransporte();
		LOGGER.info("Transporte conductor: " + conductor);
		LOGGER.info("Transporte tipo transporte: " + tipoTransporte);
		*/

		
		Iterable<TipoTransporte> tiposTransportes =  tipoTransporteService.list();	
		Iterable<Conductor> conductores = conductorService.conductorList(); 
		
		Map<Integer, String> mapTipoTransporte = new HashMap<Integer, String>();
		Map<Integer, String> mapConductor = new HashMap<Integer, String>();
		
		for(TipoTransporte t : tiposTransportes) {
			mapTipoTransporte.put( t.getCodigo(), t.getTipo());
		}

		transporte.setMapTransportes( mapTipoTransporte);
		
		for(Conductor c : conductores) {
			
			mapConductor.put( c.getCodigo(), c.getNombre() + " " + c.getApellido());
		}
		
		transporte.setMapConductores(mapConductor);
		transporte.setMapTransportes(mapTipoTransporte);
				
		model.addAttribute("datosTransporte",  transporte);
		
		return "update-transporte";
		
	}
	
	@PostMapping("/actualizarTransporte")
	public String actualizar(@ModelAttribute ("datosTransporte") Transporte transporte) {
				
		LOGGER.info("Transporte a actualizar: " + transporte);
		 transporteService.update(transporte);
		return "redirect:/transporte";
	}
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("codigo") Integer codigo) {
				
		LOGGER.info("Transporte a eliminar: " + codigo);
		 transporteService.delete(codigo);
		 
		return "redirect:/transporte";
	}
	
	
}
