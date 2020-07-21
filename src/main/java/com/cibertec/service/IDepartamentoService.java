package com.cibertec.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.model.LcldDpto;

@Service
public interface IDepartamentoService extends JpaRepository<LcldDpto, Integer>{

}
