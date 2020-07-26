package com.cibertec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tb_estado_civil")
public class EstadoCivil implements Serializable{

	@Id
	@Column(name = "estadoCivil_id")
	private int estadoCivil_id;

	@Column(name = "estadoCivil_desc")
	private String estadoCivil_desc;

	public int getEstadoCivil_id() {
		return estadoCivil_id;
	}

	public void setEstadoCivil_id(int estadoCivil_id) {
		this.estadoCivil_id = estadoCivil_id;
	}

	public String getEstadoCivil_desc() {
		return estadoCivil_desc;
	}

	public void setEstadoCivil_desc(String estadoCivil_desc) {
		this.estadoCivil_desc = estadoCivil_desc;
	}

	

}
