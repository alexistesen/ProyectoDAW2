package com.cibertec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.model.Persona;

public interface IPersonaDao extends JpaRepository<Persona, Integer> {

}
