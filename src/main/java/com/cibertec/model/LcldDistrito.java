package com.cibertec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tb_distrito")
public class LcldDistrito {

	@Id
	@Column(name = "id_distrito")
	private int distrito_id;

	@Column(name = "desc_distrito")
	private String distrito_desc;

	@ManyToOne
	@JoinColumn(name = "id_provincia", nullable = false)
	private LcldProvincia provincia;

	public int getDistrito_id() {
		return distrito_id;
	}

	public void setDistrito_id(int distrito_id) {
		this.distrito_id = distrito_id;
	}

	public String getDistrito_desc() {
		return distrito_desc;
	}

	public void setDistrito_desc(String distrito_desc) {
		this.distrito_desc = distrito_desc;
	}

	public LcldProvincia getProvincia() {
		return provincia;
	}

	public void setProvincia(LcldProvincia provincia) {
		this.provincia = provincia;
	}

}
