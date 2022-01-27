package com.ideas.app.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ideas.app.jpa.model.Cliente;
import com.ideas.app.jpa.model.Compra;
import com.ideas.app.jpa.model.Destino;
import com.ideas.app.jpa.model.Empleado;
import com.ideas.app.jpa.model.Transporte;
import com.ideas.app.service.ClienteService;
import com.ideas.app.service.CompraService;
import com.ideas.app.service.DestinoService;
import com.ideas.app.service.EmpleadoService;
import com.ideas.app.service.TransporteService;

@Controller
@RequestMapping("/compra")
public class ControllCompra {

	
	@Autowired
	private CompraService compraService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private DestinoService destinoService;
	
	@Autowired
	private TransporteService transporteService;
	
	
	private static final Logger LOGGER= LogManager.getLogger(ControllCompra.class);
	
	
	@RequestMapping(value = {"", "/list"})
	public String home(Model model) {
		
		Compra compra = new Compra();
		
		Iterable<Cliente> clientes = clienteService.clienteList();
		
		Iterable<Empleado> empleados = empleadoService.empleadoList();
		
		Iterable<Destino> destinos = destinoService.list();
		
		Iterable<Transporte> transportes  = transporteService.list();
		
		LOGGER.info("Clientes compra: " + clientes);
		LOGGER.info("Empleados compra: " + empleados);
		LOGGER.info("Destinos compra: " + destinos);
		LOGGER.info("Transportes compra: " + transportes);
		
		
		Map<Integer, String> mapClientes = new HashMap<Integer, String>();
		Map<Integer, String> mapEmpleados = new HashMap<Integer, String>();
		Map<Integer, String> mapDestinos = new HashMap<Integer, String>();
		Map<Integer, String> mapTransportes = new HashMap<Integer, String>();
		
		for(Cliente cl: clientes) {
			
			
			mapClientes.put(cl.getCodigo(), cl.getNombre() + " " + cl.getApellido());
		}
		
		
		for(Empleado empl: empleados ) {
			
			mapEmpleados.put(empl.getCodigo(), empl.getNombre() + " " +  empl.getApellido());
		}
		
		for(Destino dt: destinos ) {
			
			mapDestinos.put(dt.getCodigo(), dt.getLugar() + " $ " + dt.getTipoViaje().getPrecio());
		}
		
		for(Transporte tr : transportes ) {
			
			mapTransportes.put(tr.getCodigo(), tr.getTipoTransporte().getTipo());
		}
		compra.setMapClientes(mapClientes);
		compra.setMapEmpleados(mapEmpleados);
		compra.setMapDestinos(mapDestinos);
		compra.setMapTransportes(mapTransportes);
		model.addAttribute("nuevaCompra", compra);
		return "homeCompra";
		
		
	}
	
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute("nuevaCompra") Compra compra) {
		
		// Asignar fecha para la factura:
		compra.getFactura().setFecha(LocalDate.now().toString());
		
		LOGGER.info("Datos factura compra a guardar: " + compra.getFactura());
		LOGGER.info("Datos compra a guardar: " + compra);
			
		compraService.add(compra);
		return "redirect:/";
	}
}
