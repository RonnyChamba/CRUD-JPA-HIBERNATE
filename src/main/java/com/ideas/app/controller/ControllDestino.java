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

import com.ideas.app.jpa.model.Destino;
import com.ideas.app.jpa.model.TipoViaje;
import com.ideas.app.service.DestinoService;
import com.ideas.app.service.TipoViajeService;

@Controller
@RequestMapping("/destino")
public class ControllDestino {

	private static final Logger LOGGER = LogManager.getLogger(ControllDestino.class);

	@Autowired
	private DestinoService destinoService;

	@Autowired
	private TipoViajeService tipoViajeService;

	@RequestMapping(value = { "", "/list" })
	public String home(Model model) {

		Iterable<Destino> destinos = destinoService.list();

		LOGGER.info("Listar de destinos: " + destinos);

		model.addAttribute("listDestinos", destinos);

		return "homeDestino";

	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {

		Destino destino = new Destino();

		Iterable<TipoViaje> tiposViajes = tipoViajeService.list();

		Map<Integer, String> mapTipoViajes = new HashMap<Integer, String>();

		for (TipoViaje t : tiposViajes) {

			mapTipoViajes.put(t.getCodigo(), t.getTipo());
		}

		destino.setMapTipoViajes(mapTipoViajes);

		LOGGER.info("Nuevo modelo destino: " + destino);

		model.addAttribute("nuevoDestino", destino);
		return "nuevoDestino";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute("nuevoDestino") Destino destino) {

		LOGGER.info("Destino recibido para guardar: " + destino);

		destinoService.add(destino);
		return "redirect:/destino";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("codigo") Integer codigo, Model model) {

		LOGGER.info("Destino codigo a editar: " + codigo);

		Destino destino = destinoService.buscarById(codigo);
		Iterable<TipoViaje> tiposViajes = tipoViajeService.list();

		Map<Integer, String> mapTipoViajes = new HashMap<Integer, String>();

		for (TipoViaje t : tiposViajes) {

			mapTipoViajes.put(t.getCodigo(), t.getTipo());
		}

		destino.setMapTipoViajes(mapTipoViajes);

		LOGGER.info("Destino consultado a editar: " + destino);

		model.addAttribute("datosDestino", destino);
		return "update-destino";
	}
	
	
	@PostMapping("/actualizarDestino")
	public String actualizar(@ModelAttribute("datosDestino") Destino destino) {
		
		LOGGER.info("Destino datos actualizar: " + destino);
		
		destinoService.update(destino);
		
		return "redirect:/destino";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("codigo") Integer codigo) {
		
		LOGGER.info("Destino codigo a eliminar: " + codigo);
		
		destinoService.delete(codigo);
		
		return "redirect:/destino";
		
	}
	

}
