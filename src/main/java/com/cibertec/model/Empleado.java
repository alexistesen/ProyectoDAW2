package com.cibertec.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Empleado implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "persona_id")
	private int id;
	
	@Column(name = "persona_nombre")
	@NotEmpty
	private String nombre;
	
	@Column(name = "persona_apellidoP")
	@NotEmpty
	private String apellidoP;
	
	@Column(name = "persona_apellidoM")
	@NotEmpty
	private String apellidoM;
	
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
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name="estadoCivil_id", nullable = false)
	private EstadoCivil estadoCivil;
	
	@ManyToOne
	@JoinColumn(name="tipoEmpleado_id", nullable = false)
	private TipoEmpleado tipoEmpleado;

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

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

}
