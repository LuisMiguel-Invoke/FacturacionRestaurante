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

@ApiModel(description = "Información de Productos del Restaurante")
@Entity
@Table(name = "PRODUCTO")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUCTO")
	private Integer idProducto;
	
	@ApiModelProperty(notes = "Nombre del Producto")
	@Size(min = 3, message = "Nombre del Producto debe tener minimo 3 caracteres")
	@Column(name = "NOMBRE", nullable = false, length = 50)
	private String nombre;
	
	@ApiModelProperty(notes = "Tipo del Producto")
	@Size(max = 20, message = "Tipo debe tener un máximo de 20 caracteres")
	@Column(name = "TIPO", nullable = false, length = 20)
	private String tipo;
	
	@ApiModelProperty(notes = "Descripción del descuento a aplicar")
	@Column(name = "DESCRIPCION", nullable = false, length = 200)
	private String descripcion;
	
	@ApiModelProperty(notes = "Precio del Producto")
	@Column(name = "PRECIO", nullable = false)
	private Integer precio;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
}
