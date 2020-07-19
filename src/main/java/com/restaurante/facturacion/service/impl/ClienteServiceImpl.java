package com.restaurante.facturacion.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.facturacion.model.Cliente;
import com.restaurante.facturacion.repo.IClienteRepo;
import com.restaurante.facturacion.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired	
	private IClienteRepo repo;
	
	@Override
	public Cliente registrar(Cliente cliente) {
		return repo.save(cliente);
	}

	@Override
	public Cliente modificar(Cliente cliente) {		
		return repo.save(cliente);
	}

	@Override
	public List<Cliente> listar() {
		return repo.findAll();
	}

	@Override
	public Cliente leerPorId(Integer id) {
		Optional<Cliente> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Cliente();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}
}
