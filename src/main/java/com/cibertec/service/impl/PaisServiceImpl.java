package com.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.commons.GenericServiceImpl;
import com.cibertec.dao.IPaisDao;
import com.cibertec.model.Pais;
import com.cibertec.service.IPaisService;

@Service
public class PaisServiceImpl extends GenericServiceImpl<Pais, Integer> implements IPaisService{

	@Autowired
	private IPaisDao paisDao;
	
	@Override
	public JpaRepository<Pais, Integer> getDao() {
		// TODO Auto-generated method stub
		return paisDao;
	}

}
