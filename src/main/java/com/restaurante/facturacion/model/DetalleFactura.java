package com.restaurante.facturacion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información de Detalle de Facturas del Restaurante")
@Entity
@Table(name = "DETALLE_FACTURA")
public class DetalleFactura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DETALLE_FACTURA")
	private Integer idDetalleFactura;
	
	@ApiModelProperty(notes = "Factura")
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_FACTURA", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLE_FACTURA"))
	private Factura factura;
	
	@ApiModelProperty(notes = "Producto del Detalle")
	@ManyToOne
	@JoinColumn(name = "ID_PRODUCTO", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLE_FACTURA_PRODUCTO"))
	private Producto producto;
	
	@ApiModelProperty(notes = "Cantidad de Unidades del Producto")
	@Column(name = "CANTIDAD", nullable = false)
	private Integer cantidad;
	
	@ApiModelProperty(notes = "Monto por Producto")
	@Column(name = "MONTO", nullable = false)
	private Integer monto;

	public Integer getIdDetalleFactura() {
		return idDetalleFactura;
	}

	public void setIdDetalleFactura(Integer idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	
	
}
