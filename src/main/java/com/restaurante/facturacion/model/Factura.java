package com.restaurante.facturacion.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información de Facturas del Restaurante")
@Entity
@Table(name = "FACTURA")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FACTURA")
	private Integer idFactura;
	
	@ApiModelProperty(notes = "Cliente de la Factura")
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURA_CLIENTE"))
	private Cliente cliente;
	
	@ApiModelProperty(notes = "Mesa de la Factura")
	@ManyToOne
	@JoinColumn(name = "ID_MESA", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURA_MESA"))
	private Mesa mesa;

	@ApiModelProperty(notes = "Garzon de la Factura")
	@ManyToOne
	@JoinColumn(name = "ID_GARZON", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURA_GARZON"))
	private Garzon garzon;
	
	@ApiModelProperty(notes = "Descuento de la Factura")
	@ManyToOne
	@JoinColumn(name = "ID_DESCUENTO", nullable = false, foreignKey = @ForeignKey(name = "FK_FACTURA_DESCUENTO"))
	private Descuento descuento;
	
	@OneToMany(mappedBy = "factura", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<DetalleFactura> detalleFactura;
	
	private LocalDateTime fecha;

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Garzon getGarzon() {
		return garzon;
	}

	public void setGarzon(Garzon garzon) {
		this.garzon = garzon;
	}

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public List<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFactura == null) ? 0 : idFactura.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		if (idFactura == null) {
			if (other.idFactura != null)
				return false;
		} else if (!idFactura.equals(other.idFactura))
			return false;
		return true;
	}
	
}
