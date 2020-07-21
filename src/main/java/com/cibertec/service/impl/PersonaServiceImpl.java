package com.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.commons.GenericServiceImpl;
import com.cibertec.dao.IPersonaDao;
import com.cibertec.model.Persona;
import com.cibertec.service.IPersonaService;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Integer> implements IPersonaService{

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	public JpaRepository<Persona, Integer> getDao() {
		// TODO Auto-generated method stub
		return personaDao;
	}

}
