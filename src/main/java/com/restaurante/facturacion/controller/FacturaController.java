package com.restaurante.facturacion.controller;

import java.net.URI;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restaurante.facturacion.dto.FacturaDTO;
import com.restaurante.facturacion.dto.ResumenFacturaFechaDTO;
import com.restaurante.facturacion.exception.ModeloNotFoundException;
import com.restaurante.facturacion.model.Factura;
import com.restaurante.facturacion.service.IFacturaService;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
	
	@Autowired
	private IFacturaService service;
	
	@GetMapping
	public ResponseEntity<List<Factura>> listar(){
		List<Factura> lista = service.listar();
		return new ResponseEntity<List<Factura>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Factura> listarPorId(@PathVariable("id") Integer id){
		Factura factura = service.leerPorId(id);
		if(factura.getIdFactura() == null) {
			throw new ModeloNotFoundException("ID FACTURA NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Factura>(factura, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Factura factura) {
		Factura obj = service.registrar(factura);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(factura.getIdFactura()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Factura> modificar(@Valid @RequestBody Factura factura) {
		Factura obj = service.modificar(factura);
		return new ResponseEntity<Factura>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Factura factura = service.leerPorId(id);
		if(factura.getIdFactura() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	/* DTOs y HATEOAS */
	
	@GetMapping(value = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FacturaDTO> listarHateoas() {
		List<Factura> facturas = new ArrayList<>();
		List<FacturaDTO> facturasDTO = new ArrayList<>();
		facturas = service.listar();
		
		for (Factura factura : facturas) {
			FacturaDTO facturaDto = new FacturaDTO();
			facturaDto.setIdFactura(factura.getIdFactura());
			facturaDto.setCliente(factura.getCliente());
			facturaDto.setGarzon(factura.getGarzon());
			
			ControllerLinkBuilder linkTo = linkTo(methodOn(FacturaController.class).listarPorId((factura.getIdFactura())));
			facturaDto.add(linkTo.withSelfRel());
			
			ControllerLinkBuilder linkTo1 = linkTo(methodOn(ClienteController.class).listarPorId((factura.getCliente().getIdCliente())));
			facturaDto.add(linkTo1.withSelfRel());
			
			ControllerLinkBuilder linkTo2 = linkTo(methodOn(GarzonController.class).listarPorId((factura.getGarzon().getIdGarzon())));
			facturaDto.add(linkTo2.withSelfRel());		
			facturasDTO.add(facturaDto);
		}
		return facturasDTO;
	}
	
	@GetMapping("/resumen/fecha/{fecha}")
	public ResponseEntity<ResumenFacturaFechaDTO> listarResumenFecha(@PathVariable("fecha") String fecha) throws ParseException{
		
		String formatLocalDateTime = fecha +" 00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime fechaConsulta = LocalDateTime.parse(formatLocalDateTime, formatter);
		
		ResumenFacturaFechaDTO resumen = service.resumenFacturasFecha(fechaConsulta);
		if(resumen.getCantidadFacturas() == 0) {
			throw new ModeloNotFoundException("FECHA SIN FACTURACION REGISTRADA " + fecha);
		}
		return new ResponseEntity<ResumenFacturaFechaDTO>(resumen, HttpStatus.OK); 
	}

}
