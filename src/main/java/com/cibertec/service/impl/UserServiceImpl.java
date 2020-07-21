package com.cibertec.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.commons.GenericServiceImpl;
import com.cibertec.dao.IUserDao;
import com.cibertec.model.Usuario;
import com.cibertec.service.IUserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<Usuario, Integer> implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public JpaRepository<Usuario, Integer> getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}

	@Override
	public Optional<Usuario> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

}
