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

@ApiModel(description = "Información de Mesas del Restaurante")
@Entity
@Table(name = "MESA")
public class Mesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MESA")
	private Integer idMesa;
	
	@ApiModelProperty(notes = "Máximo de comensales para mesa")
	@Column(name = "MAX_COMENSALES", nullable = false)
	private Integer maxComensales;
	
	@ApiModelProperty(notes = "Ubicación de la mesa en el Restaurante")
	@Size(max = 50, message = "Ubicación debe tener un máximo de 50 caracteres")
	@Column(name = "UBICACION", nullable = false, length = 50)
	private String ubicacion;

	public Integer getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(Integer idMesa) {
		this.idMesa = idMesa;
	}

	public Integer getMaxComensales() {
		return maxComensales;
	}

	public void setMaxComensales(Integer maxComensales) {
		this.maxComensales = maxComensales;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}
