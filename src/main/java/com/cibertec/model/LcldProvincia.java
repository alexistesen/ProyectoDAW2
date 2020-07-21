package com.cibertec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tb_provincia")
public class LcldProvincia implements Serializable{

	@Id
	@Column(name = "id_provincia")
	private int provincia_id;

	@Column(name = "desc_provincia")
	private String provincia_desc;

	@ManyToOne
	@JoinColumn(name = "id_departamento", nullable = false)
	private LcldDpto departamento;

	public int getProvincia_id() {
		return provincia_id;
	}

	public void setProvincia_id(int provincia_id) {
		this.provincia_id = provincia_id;
	}

	public String getProvincia_desc() {
		return provincia_desc;
	}

	public void setProvincia_desc(String provincia_desc) {
		this.provincia_desc = provincia_desc;
	}

	public LcldDpto getDepartamento() {
		return departamento;
	}

	public void setDepartamento(LcldDpto departamento) {
		this.departamento = departamento;
	}

}
