package com.cibertec.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.model.EstadoCivil;

public interface IEstadoCivilService extends JpaRepository<EstadoCivil, Integer>{

}
