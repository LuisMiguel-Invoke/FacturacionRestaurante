package com.restaurante.facturacion.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.restaurante.facturacion.exception.ModeloNotFoundException;
import com.restaurante.facturacion.model.Descuento;
import com.restaurante.facturacion.service.IDescuentoService;

@RestController
@RequestMapping("/descuentos")
public class DescuentoController {
	
	@Autowired
	private IDescuentoService service;
	
	@GetMapping
	public ResponseEntity<List<Descuento>> listar(){
		 List<Descuento> lista = service.listar();
		return new ResponseEntity<List<Descuento>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Descuento> listarPorId(@PathVariable("id") Integer id){
		Descuento descuento = service.leerPorId(id);
		if(descuento.getIdDescuento() == null) {
			throw new ModeloNotFoundException("ID DESCUENTO NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Descuento>(descuento, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Descuento descuento) {
		Descuento obj = service.registrar(descuento);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(descuento.getIdDescuento()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Descuento> modificar(@Valid @RequestBody Descuento descuento) {
		Descuento obj = service.modificar(descuento);
		return new ResponseEntity<Descuento>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Descuento descuento = service.leerPorId(id);
		if(descuento.getIdDescuento() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
