package com.cibertec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.Empleado;
import com.cibertec.service.IEmpleadoService;

@RestController
@RequestMapping("/empleados")
public class RestEmpleadoContoller {

	@Autowired
	private IEmpleadoService personaService;
	
	@GetMapping
	public List<Empleado> listar(){
		return personaService.getAll();
	}
	
	@PostMapping
	public void insertar(@RequestBody Empleado per){
		personaService.save(per);
	}
	
	@PutMapping
	public void modificar(@RequestBody Empleado per){
		personaService.save(per);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		personaService.delete(id);
	}
}
