package com.restaurante.facturacion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información de Clientes")
@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENTE")
	private Integer idCliente;
	
	@ApiModelProperty(notes = "Rut del cliente")
	@Column(name = "RUT", nullable = false)
	private Integer rut;
	
	@ApiModelProperty(notes = "Digito Verificador del Rut")
	@Size(max = 1, message = "Digito Verificador debe tener maximo 1 caracter")
	@Column(name = "DV", nullable = false, length = 1)
	private String dv;

	@ApiModelProperty(notes = "Nombres del Cliente")
	@Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
	@Column(name = "NOMBRES", nullable = false, length = 70)
	private String nombres;
	
	@ApiModelProperty(notes = "Apellidos del Cliente")
	@Size(min = 3, message = "Apellidos debe tener minimo 3 caracteres")
	@Column(name = "APELLIDOS", nullable = false, length = 70)
	private String apellidos;

	@ApiModelProperty(notes = "Domicilio del Cliente")
	@Size(min = 3, max = 200, message = "Domicilio debe tener minimo 3 caracteres")
	@Column(name = "DOMICILIO", nullable = true, length = 200)
	private String domicilio;

	@ApiModelProperty(value = "Telefono debe tener 9 caracteres")
	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "TELEFONO", nullable = true, length = 9)
	private String telefono;
	
	@ApiModelProperty(value = "Email del Cliente")
	@Email
	@Column(name = "EMAIL", nullable = true, length = 60)
	private String email;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getRut() {
		return rut;
	}

	public void setRut(Integer rut) {
		this.rut = rut;
	}

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
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

}
