package com.restaurante.facturacion.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.facturacion.model.Garzon;
import com.restaurante.facturacion.repo.IGarzonRepo;
import com.restaurante.facturacion.service.IGarzonService;

@Service
public class GarzonServiceImpl implements IGarzonService {
	
	@Autowired	
	private IGarzonRepo repo;
	
	@Override
	public Garzon registrar(Garzon garzon) {
		return repo.save(garzon);
	}

	@Override
	public Garzon modificar(Garzon garzon) {		
		return repo.save(garzon);
	}

	@Override
	public List<Garzon> listar() {
		return repo.findAll();
	}

	@Override
	public Garzon leerPorId(Integer id) {
		Optional<Garzon> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Garzon();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}
}
