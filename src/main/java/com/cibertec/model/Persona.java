package com.cibertec.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Persona implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "persona_id")
	private int id;
	
	@Column(name = "persona_nombre")
	@NotEmpty
	private String nombre;
	
	@Column(name = "persona_apellido")
	@NotEmpty
	private String apellido;
	
	@Column(name = "persona_direccion")
	@NotEmpty
	private String direccion;
	
	@Column(name = "persona_telefono")
	@NotEmpty
	@Pattern(regexp="[0-9]{9}")
	private String telefono;
	
	@Column(name = "persona_email")
	@NotEmpty
	@Email
	private String email;
	
	@ManyToOne
	@JoinColumn(name="departamento_id", nullable = false)
	private LcldDpto departamento;
	
	@ManyToOne
	@JoinColumn(name="provincia_id", nullable = false)
	private LcldProvincia provincia;
	
	@ManyToOne
	@JoinColumn(name="distrito_id", nullable = false)
	private LcldDistrito distrito;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LcldDpto getDepartamento() {
		return departamento;
	}

	public void setDepartamento(LcldDpto departamento) {
		this.departamento = departamento;
	}

	public LcldProvincia getProvincia() {
		return provincia;
	}

	public void setProvincia(LcldProvincia provincia) {
		this.provincia = provincia;
	}

	public LcldDistrito getDistrito() {
		return distrito;
	}

	public void setDistrito(LcldDistrito distrito) {
		this.distrito = distrito;
	}
	
	
}
