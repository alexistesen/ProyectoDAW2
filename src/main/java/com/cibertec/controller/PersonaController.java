package com.cibertec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cibertec.model.LcldDistrito;
import com.cibertec.model.LcldProvincia;
import com.cibertec.model.Persona;
import com.cibertec.service.IDepartamentoService;
import com.cibertec.service.IDistritoService;
import com.cibertec.service.IPersonaService;
import com.cibertec.service.IProvinciaService;

@Controller
public class PersonaController {

	@Autowired
	private IPersonaService personaService;

	@Autowired
	private IDepartamentoService dptoService;
	
	@Autowired
	private IProvinciaService provinciaService;
	
	@Autowired
	private IDistritoService distritoService;
	
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("/inicio")
	public String index(Model model) {
		model.addAttribute("list",personaService.getAll());
		return "inicio";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("listaDepartamento",dptoService.findAll());
		if(id != null && id != 0) {
			model.addAttribute("persona", personaService.get(id));
			model.addAttribute("selectedOn", "true");
			
			/*1.*/
			List<LcldProvincia> listaTotal = provinciaService.findAll();
			List<LcldProvincia> lista = new ArrayList<LcldProvincia>();
			
			if(personaService.get(id).getProvincia().getProvincia_id()!=0) {
			for(LcldProvincia temp: listaTotal) {
				if(temp.getDepartamento().getDpto_id()==personaService.get(id).getProvincia().getProvincia_id()) {
					lista.add(temp);
				}
			}
			}
			
			model.addAttribute("listaProvincia",lista);
			/**/
			
			/*2.*/
			
			List<LcldDistrito> listaTotal2 = distritoService.findAll();
			List<LcldDistrito> lista2 = new ArrayList<LcldDistrito>();
			
			if(personaService.get(id).getDistrito().getDistrito_id()!=0) {
			for(LcldDistrito temp: listaTotal2) {
				if(temp.getProvincia().getProvincia_id()==personaService.get(id).getDistrito().getDistrito_id()) {
					lista2.add(temp);
				}
			}
			}
		
			model.addAttribute("listaDistrito",lista2);
			
			
			/**/
			
			
			
		} else {
			model.addAttribute("persona", new Persona());
		}
		return "save";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Persona persona, BindingResult result, Model model, RedirectAttributes attribute) {
		if (result.hasErrors()) {
			model.addAttribute("listaDepartamento",dptoService.findAll());
			System.out.println("Existieron errores en el formulario");			
			return "save";
		}
		
		personaService.save(persona);
		System.out.println("Cliente guardado con exito!");
		attribute.addFlashAttribute("success", "Cliente guardado con éxito!");
		return "redirect:/inicio";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model, RedirectAttributes attribute) {
		personaService.delete(id);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Éxito!");
		return "redirect:/inicio";
	}
	

	@PostMapping({"/save/listaProvincia","/listaProvincia"})
	public String provincia(Model model, @Valid Integer departamento) {
		
		List<LcldProvincia> listaTotal = provinciaService.findAll();
		List<LcldProvincia> lista = new ArrayList<LcldProvincia>();
		
		if(departamento!=0) {
		for(LcldProvincia temp: listaTotal) {
			if(temp.getDepartamento().getDpto_id()==departamento) {
				lista.add(temp);
			}
		}
		}
		
		model.addAttribute("listaProvincia",lista);
		return "cboProvincia";
	}
		
	
	@PostMapping({"/save/listaDistrito","/listaDistrito"})
	public String distrito(Model model, @Valid Integer provincia) {
		
		List<LcldDistrito> listaTotal = distritoService.findAll();
		List<LcldDistrito> lista = new ArrayList<LcldDistrito>();
		
		if(provincia!=0) {
		for(LcldDistrito temp: listaTotal) {
			if(temp.getProvincia().getProvincia_id()==provincia) {
				lista.add(temp);
			}
		}
		}
	
		model.addAttribute("listaDistrito",lista);
		return "cboDistrito";
	}
	
}
