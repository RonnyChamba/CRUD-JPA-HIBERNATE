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
import com.ideas.app.jpa.model.Empleado;
import com.ideas.app.service.EmpleadoService;

@Controller

@RequestMapping("/empleado")
public class ControllEmpleado {
	
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@RequestMapping(value = {"", "/list"})
	public String homeEmpleado(Model model) {
		
		Iterable<Empleado> empleados = empleadoService.empleadoList();
		
		model.addAttribute("listEmpleados", empleados);
		return "homeEmpleado";
		
	}
	
	@GetMapping("/nuevo")
	public String register(Model model) {
		
		Empleado nuevoEmpleado = new Empleado();
		model.addAttribute("nuevoEmpleado", nuevoEmpleado);
		return "nuevo-empleado";
		
	}
	
	@PostMapping("/guardar")
	public String saveEmpleado(@ModelAttribute("nuevoEmpleado") Empleado nuevoEmpleado) {
		
		empleadoService.empleadoAdd(nuevoEmpleado);
		return "redirect:/empleado";	
	}
	
	@GetMapping("/edit")
	public String formUpdateCliente(@RequestParam("codigo") Integer codigo, Model model) {
		
		Empleado empleado = empleadoService.buscarById(codigo);
		
		// Si existe el empleado
		if (empleado !=null) {			
			model.addAttribute("datosEmpleado", empleado);
			return "update-empleado";
		
		}
		
		// Si no
		
		return "redirect:/empleado";	
	}
	
	@PostMapping("/actualizarEmpleado")
	public String  actualizarEmpleado( @ModelAttribute("datosEmpleado") Empleado empleado) {
		
		empleadoService.actualizar(empleado);
		
		return "redirect:/empleado";	
	}
	
	@GetMapping("/delete")
	public String  delete( @RequestParam("codigo") Integer codigo) {
		
		empleadoService.empleadoDelete(codigo);
		
		return "redirect:/empleado";	
	}

}
