package com.restaurante.facturacion.dto;

import java.util.List;

public class ResumenFacturaFechaDTO {
	
	private List<ResumenMontoFactura> facturas;
	private int cantidadFacturas;
	private int montoFacturado;
	
	public List<ResumenMontoFactura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<ResumenMontoFactura> facturas) {
		this.facturas = facturas;
	}
	public int getCantidadFacturas() {
		return cantidadFacturas;
	}
	public void setCantidadFacturas(int cantidadFacturas) {
		this.cantidadFacturas = cantidadFacturas;
	}
	public int getMontoFacturado() {
		return montoFacturado;
	}
	public void setMontoFacturado(int montoFacturado) {
		this.montoFacturado = montoFacturado;
	}
	
	
	
}
