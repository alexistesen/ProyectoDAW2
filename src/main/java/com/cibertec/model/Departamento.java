package com.cibertec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tb_departamento")
public class Departamento implements Serializable {

	@Id
	@Column(name = "departamento_id")
	private int departamento_id;

	@Column(name = "desc_departamento")
	private String desc_departamento;

	public int getDepartamento_id() {
		return departamento_id;
	}

	public void setDepartamento_id(int departamento_id) {
		this.departamento_id = departamento_id;
	}

	public String getDesc_departamento() {
		return desc_departamento;
	}

	public void setDesc_departamento(String desc_departamento) {
		this.desc_departamento = desc_departamento;
	}

	
	
	

}
