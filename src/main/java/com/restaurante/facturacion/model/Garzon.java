package com.restaurante.facturacion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información de Garzones del Restaurante")
@Entity
@Table(name = "GARZON")
public class Garzon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GARZON")
	private Integer idGarzon;
	
	@ApiModelProperty(notes = "Rut del garzon")
	@Column(name = "RUT", nullable = false)
	private Integer rut;
	
	@ApiModelProperty(notes = "Digito Verificador del garzon")
	@Size(max = 1, message = "Digito Verificador debe tener maximo 1 caracter")
	@Column(name = "DV", nullable = false, length = 1)
	private String dv;

	@ApiModelProperty(notes = "Nombres del garzon")
	@Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
	@Column(name = "NOMBRES", nullable = false, length = 70)
	private String nombres;
	
	@ApiModelProperty(notes = "Apellidos del garzon")
	@Size(min = 3, message = "Apellidos debe tener minimo 3 caracteres")
	@Column(name = "APELLIDOS", nullable = false, length = 70)
	private String apellidos;

	@ApiModelProperty(notes = "Foto del garzon")
	@Column(name = "FOTO", nullable = true)
	private String fotoUrl;

	public Integer getIdGarzon() {
		return idGarzon;
	}

	public void setIdGarzon(Integer idGarzon) {
		this.idGarzon = idGarzon;
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

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

}
