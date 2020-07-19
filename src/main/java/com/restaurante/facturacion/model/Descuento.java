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

@ApiModel(description = "Información de Promociones del Restaurante")
@Entity
@Table(name = "DESCUENTO")
public class Descuento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DESCUENTO")
	private Integer idDescuento;
	
	@ApiModelProperty(notes = "Día de descuento en el restaurante")
	@Size(max = 50, message = "Día debe tener un máximo de 20 caracteres")
	@Column(name = "DIA", nullable = false, length = 20)
	private String dia;
	
	@ApiModelProperty(notes = "Porcentaje de Descuento a aplicar")
	@Column(name = "DESCUENTO", nullable = false)
	private Integer descuento;
	
	@ApiModelProperty(notes = "Descripción del descuento a aplicar")
	@Column(name = "DESCRIPCION", nullable = false, length = 200)
	private String descripcion;

	public Integer getIdDescuento() {
		return idDescuento;
	}

	public void setIdDescuento(Integer idDescuento) {
		this.idDescuento = idDescuento;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
