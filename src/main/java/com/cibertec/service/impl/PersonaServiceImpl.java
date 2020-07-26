package com.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.commons.GenericServiceImpl;
import com.cibertec.dao.IPersonaDao;
import com.cibertec.model.Empleado;
import com.cibertec.service.IEmpleadoService;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Empleado, Integer> implements IEmpleadoService{

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	public JpaRepository<Empleado, Integer> getDao() {
		// TODO Auto-generated method stub
		return personaDao;
	}

}
