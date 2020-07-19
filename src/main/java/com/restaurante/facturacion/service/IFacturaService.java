package com.restaurante.facturacion.service;



import java.time.LocalDateTime;

import com.restaurante.facturacion.dto.ResumenFacturaFechaDTO;
import com.restaurante.facturacion.model.Factura;

public interface IFacturaService extends ICRUD<Factura> {
	
	ResumenFacturaFechaDTO resumenFacturasFecha(LocalDateTime fecha);
}
