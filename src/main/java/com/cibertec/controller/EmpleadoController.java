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

import com.cibertec.model.TipoEmpleado;
import com.cibertec.model.EstadoCivil;
import com.cibertec.model.Departamento;
import com.cibertec.model.Empleado;
import com.cibertec.service.IDepartamentoService;
import com.cibertec.service.ITipoEmpleadoService;
import com.cibertec.service.IEmpleadoService;
import com.cibertec.service.IEstadoCivilService;

@Controller
public class EmpleadoController {

	@Autowired
	private IEmpleadoService empleadoService;

	@Autowired
	private IDepartamentoService dptoService;

	@Autowired
	private IEstadoCivilService estadoCivilService;

	@Autowired
	private ITipoEmpleadoService tipoEmpleadoService;


	@GetMapping({ "/", "/login" })
	public String index() {
		return "index";
	}

	@RequestMapping("/inicio")
	public String index(Model model) {
		model.addAttribute("list", empleadoService.getAll());
		return "inicio";
	}

	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Integer id, Model model) {

		List<Departamento> listaDepartamentos = dptoService.findAll();
		List<TipoEmpleado> listaTipoEmpleados = tipoEmpleadoService.findAll();
		List<EstadoCivil> listaEstadoCivil = estadoCivilService.findAll();
		
		model.addAttribute("listaDepartamento", listaDepartamentos);
		model.addAttribute("listaTipoEmpleado", listaTipoEmpleados);
		model.addAttribute("listaEstadoCivil", listaEstadoCivil);

		if (id != null && id != 0) {

			model.addAttribute("empleado", empleadoService.get(id));
			model.addAttribute("selectedOn", "true");

		} else {
			model.addAttribute("empleado", new Empleado());
		}
		return "save";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Empleado empleado, BindingResult result, Model model,
			RedirectAttributes attribute) {
		if (result.hasErrors()) {
			
			List<Departamento> listaDepartamentos = dptoService.findAll();
			List<TipoEmpleado> listaTipoEmpleados = tipoEmpleadoService.findAll();
			List<EstadoCivil> listaEstadoCivil = estadoCivilService.findAll();
			
			model.addAttribute("listaDepartamento", listaDepartamentos);
			model.addAttribute("listaTipoEmpleado", listaTipoEmpleados);
			model.addAttribute("listaEstadoCivil", listaEstadoCivil);
			System.out.println("Existieron errores en el formulario");
			return "save";
		}

		empleadoService.save(empleado);
		System.out.println("empleado guardado con exito!");
		attribute.addFlashAttribute("success", "Cliente guardado con Éxito!");
		return "redirect:/inicio";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model, RedirectAttributes attribute) {
		empleadoService.delete(id);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Éxito!");
		return "redirect:/inicio";
	}

}
