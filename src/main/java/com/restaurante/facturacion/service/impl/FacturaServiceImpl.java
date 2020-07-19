package com.restaurante.facturacion.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.facturacion.dto.ResumenFacturaFechaDTO;
import com.restaurante.facturacion.dto.ResumenMontoFactura;
import com.restaurante.facturacion.model.Factura;
import com.restaurante.facturacion.repo.IFacturaRepo;
import com.restaurante.facturacion.service.IFacturaService;

@Service
public class FacturaServiceImpl implements IFacturaService {
	
	@Autowired	
	private IFacturaRepo repo;
	
	@Override
	public Factura registrar(Factura obj) {
		obj.getDetalleFactura().forEach(det -> {
			det.setFactura(obj);
		});
		return repo.save(obj);
	}

	@Override
	public Factura modificar(Factura factura) {		
		return repo.save(factura);
	}

	@Override
	public List<Factura> listar() {
		return repo.findAll();
	}

	@Override
	public Factura leerPorId(Integer id) {
		Optional<Factura> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Factura();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public ResumenFacturaFechaDTO resumenFacturasFecha(LocalDateTime fecha) {
		int cantidadFacturas = 0;
		int montoFacturado = 0;
		
		LocalDateTime fechaLimite = fecha.plusDays(1);		
		List<ResumenMontoFactura> facturas = new ArrayList<>();
		
		repo.listarResumenFacturas(fecha,fechaLimite).forEach(fac -> {
			ResumenMontoFactura factura = new ResumenMontoFactura();
			factura.setIdFactura(String.valueOf(fac[0]));
			factura.setMonto(Integer.parseInt(String.valueOf(fac[1])));
			facturas.add(factura);
		});
		
		//Calculando Cantidad de Facturas, y Monto Total Facturado en el Día
		for (int i=0; i<=facturas.size()-1;i++) {
			cantidadFacturas ++;
			montoFacturado = montoFacturado + facturas.get(i).getMonto();
		}
		
		ResumenFacturaFechaDTO resumen = new ResumenFacturaFechaDTO();
		resumen.setCantidadFacturas(cantidadFacturas);
		resumen.setMontoFacturado(montoFacturado);
		resumen.setFacturas(facturas);
		return resumen;
	}
}
