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
import com.ideas.app.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ControllCliente {
	
	
	@Autowired
	private ClienteService clienteService; 
	
	@RequestMapping(value = {"", "/listar"})
	public String homeCliente(Model model) {
		
		Iterable<Cliente> clientes =  clienteService.clienteList();
		
		// clientes.forEach( x -> System.out.println(x));
		
		model.addAttribute("listClientes", clientes );
		
		return "homeCliente";
	}
	
	@GetMapping("/nuevo")
	public String register(Model model) {
		
		Cliente nuevoCliente = new Cliente();
		model.addAttribute("nuevoCliente", nuevoCliente);
		return "nuevo-cliente";
		
	}
	
	@PostMapping("/guardar")
	public String saveCliente(@ModelAttribute("nuevoCliente") Cliente clienteNuevo) {
		
		clienteService.clienteAdd(clienteNuevo);
		return "redirect:/cliente";	
	}
	
	
	@GetMapping("/edit")
	public String formUpdateCliente(@RequestParam("codigo") Integer codigo, Model model) {
		
		Cliente cliente = clienteService.buscarById(codigo);
		
		// Si existe el cliente
		if (cliente !=null) {			
			model.addAttribute("datosCliente", cliente);
			return "update-cliente";
		
		}
		
		// Si no
		
		return "redirect:/cliente";	
	}
	
	@PostMapping("/actualizarCliente")
	public String  actualizarCliente( @ModelAttribute("datosCliente") Cliente cliente) {
		
		clienteService.actualizar(cliente);
		
		return "redirect:/cliente";	
	}
	
	@GetMapping("/delete")
	public String  delete( @RequestParam("codigo") Integer codigo) {
		
		clienteService.clienteDelete(codigo);
		
		return "redirect:/cliente";	
	}
	

	
}
