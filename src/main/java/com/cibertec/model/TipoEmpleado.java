package com.cibertec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tb_tipo_empleado")
public class TipoEmpleado implements Serializable{

	@Id
	@Column(name = "tipoEmpleado_id")
	private int tipoEmpleado_id;

	@Column(name = "tipoEmpleado_desc")
	private String tipoEmpleado_desc;

	public int getTipoEmpleado_id() {
		return tipoEmpleado_id;
	}

	public void setTipoEmpleado_id(int tipoEmpleado_id) {
		this.tipoEmpleado_id = tipoEmpleado_id;
	}

	public String getTipoEmpleado_desc() {
		return tipoEmpleado_desc;
	}

	public void setTipoEmpleado_desc(String tipoEmpleado_desc) {
		this.tipoEmpleado_desc = tipoEmpleado_desc;
	}

}
