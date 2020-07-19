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
import com.restaurante.facturacion.model.Mesa;
import com.restaurante.facturacion.service.IMesaService;

@RestController
@RequestMapping("/mesas")
public class MesaController {
	
	@Autowired
	private IMesaService service;
	
	@GetMapping
	public ResponseEntity<List<Mesa>> listar(){
		 List<Mesa> lista = service.listar();
		return new ResponseEntity<List<Mesa>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Mesa> listarPorId(@PathVariable("id") Integer id){
		Mesa mesa = service.leerPorId(id);
		if(mesa.getIdMesa() == null) {
			throw new ModeloNotFoundException("ID MESA NO ENCONTRADA " + id);
		}
		return new ResponseEntity<Mesa>(mesa, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Mesa mesa) {
		Mesa obj = service.registrar(mesa);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mesa.getIdMesa()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Mesa> modificar(@Valid @RequestBody Mesa mesa) {
		Mesa obj = service.modificar(mesa);
		return new ResponseEntity<Mesa>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Mesa mesa = service.leerPorId(id);
		if(mesa.getIdMesa() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
