package com.cibertec.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.model.TipoEmpleado;

public interface ITipoEmpleadoService extends JpaRepository<TipoEmpleado, Integer> {

}
