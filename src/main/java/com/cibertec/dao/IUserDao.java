package com.cibertec.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.model.User;

public interface IUserDao extends JpaRepository<User, Integer> {

	public Optional<User> findByUsername(String username);
}
