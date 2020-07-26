package com.cibertec.service;

import java.util.Optional;

import com.cibertec.commons.IGenericService;
import com.cibertec.model.User;

public interface IUserService extends IGenericService<User, Integer> {

	public Optional<User> findByUsername(String username);
}
