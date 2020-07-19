package com.restaurante.facturacion.dto;

import org.springframework.hateoas.ResourceSupport;

import com.restaurante.facturacion.model.Cliente;
import com.restaurante.facturacion.model.Garzon;

public class FacturaDTO extends ResourceSupport {
	
	private Integer idFactura;
	private Cliente cliente;
	private Garzon garzon;
	
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
	public Garzon getGarzon() {
		return garzon;
	}
	public void setGarzon(Garzon garzon) {
		this.garzon = garzon;
	}

}
