package com.cibertec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tb_departamento")
public class LcldDpto implements Serializable {

	@Id
	@Column(name = "id_departamento")
	private int dpto_id;

	@Column(name = "desc_departamento")
	private String dpto_desc;

	public int getDpto_id() {
		return dpto_id;
	}

	public void setDpto_id(int dpto_id) {
		this.dpto_id = dpto_id;
	}

	public String getDpto_desc() {
		return dpto_desc;
	}

	public void setDpto_desc(String dpto_desc) {
		this.dpto_desc = dpto_desc;
	}

	@Override
	public String toString() {
		return "LcldDpto [dpto_id=" + dpto_id + ", dpto_desc=" + dpto_desc + "]";
	}
	
	

}
