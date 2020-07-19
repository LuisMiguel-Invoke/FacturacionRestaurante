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
import com.restaurante.facturacion.model.Garzon;
import com.restaurante.facturacion.service.IGarzonService;

@RestController
@RequestMapping("/garzones")
public class GarzonController {
	
	@Autowired
	private IGarzonService service;
	
	@GetMapping
	public ResponseEntity<List<Garzon>> listar(){
		 List<Garzon> lista = service.listar();
		return new ResponseEntity<List<Garzon>>(lista, HttpStatus.OK);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Garzon> listarPorId(@PathVariable("id") Integer id){
		Garzon garzon = service.leerPorId(id);
		if(garzon.getIdGarzon() == null) {
			throw new ModeloNotFoundException("ID GARZON NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Garzon>(garzon, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Garzon garzon) {
		Garzon obj = service.registrar(garzon);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(garzon.getIdGarzon()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping
	public ResponseEntity<Garzon> modificar(@Valid @RequestBody Garzon garzon) {
		Garzon obj = service.modificar(garzon);
		return new ResponseEntity<Garzon>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Garzon garzon = service.leerPorId(id);
		if(garzon.getIdGarzon() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
