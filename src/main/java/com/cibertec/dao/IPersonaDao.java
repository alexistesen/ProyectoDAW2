package com.cibertec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.model.Empleado;

public interface IPersonaDao extends JpaRepository<Empleado, Integer> {

}
