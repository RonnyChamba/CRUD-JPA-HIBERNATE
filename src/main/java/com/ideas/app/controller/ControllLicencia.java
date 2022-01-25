package com.ideas.app.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas.app.jpa.model.Cliente;
import com.ideas.app.jpa.model.Conductor;
import com.ideas.app.jpa.model.Licencia;
import com.ideas.app.service.ConductorService;
import com.ideas.app.service.LicenciaService;

@Controller
@RequestMapping("/licencia")
public class ControllLicencia {
	
	@Autowired
	private LicenciaService licenciaService;
	
	
	@RequestMapping(value = {"", "/listar"})
	public String homeLicencia( @Nullable @RequestParam("codigo") Integer idConductor,  Model model) {
		Conductor conductor =  licenciaService.conductorLicencia(idConductor);
		
		Licencia nuevaLicencia = new Licencia();
		nuevaLicencia.setConductor(conductor);
		// System.out.println(nuevaLicencia.getConductor());
		
		List<Licencia> licencias = conductor.getLicencias();
		model.addAttribute("listLicencias",  licencias);
		model.addAttribute("nuevaLicencia", nuevaLicencia);
		
		
		return "homeLicencia";
	}
	
	@PostMapping("/guardar")
	public String saveLicencia(@ModelAttribute("nuevaLicencia") Licencia licencia) {
		
		licenciaService.add(licencia);
		return "redirect:/licencia?codigo="+ licencia.getConductor().getCodigo();	
	}
	
 
	@GetMapping("/edit")
	public String formUpdateLicencia(@RequestParam("codigo") Integer codigo, Model model) {
		
		Licencia licencia = licenciaService.buscarById(codigo);
		/*System.out.println( "Licencia:" + licencia);
		
	   Conductor conductor = licencia.getConductor();
	   System.out.println("Conductor: "+ conductor );  
	    licencia.setConductor(conductor);
	    */
		model.addAttribute("datosLicencia",licencia);	
		return "update-licencia";	
	}
	
	@PostMapping("/actualizarLicencia")
	public String  actualizarLicencia( @ModelAttribute("datosLicencia") Licencia licencia) {
		
		
		System.out.println("Licencia actualizar:  " + licencia);
		System.out.println("Conductor: " + licencia.getConductor());
		licenciaService.update(licencia);
		
		return "redirect:/licencia?codigo="+ licencia.getConductor().getCodigo();	
	}
	
	@GetMapping("/delete")
	public String  deleteLicencia(@RequestParam("codigo") Integer codigo) {
		
		
		Licencia licencia = licenciaService.buscarById(codigo);
		
		Conductor conductor = licencia.getConductor();
		
		licenciaService.delete(codigo);
		
		
		System.out.println("Licencia eliminar: " + licencia);
		System.out.println("Conductor: " + conductor);
	
		return "redirect:/licencia?codigo="+ licencia.getConductor().getCodigo();	
	}
	
	
	
	
}
