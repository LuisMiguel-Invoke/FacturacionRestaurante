package com.restaurante.facturacion.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.facturacion.model.Descuento;
import com.restaurante.facturacion.repo.IDescuentoRepo;
import com.restaurante.facturacion.service.IDescuentoService;

@Service
public class DescuentoServiceImpl implements IDescuentoService {
	
	@Autowired	
	private IDescuentoRepo repo;
	
	@Override
	public Descuento registrar(Descuento descuento) {
		return repo.save(descuento);
	}

	@Override
	public Descuento modificar(Descuento descuento) {		
		return repo.save(descuento);
	}

	@Override
	public List<Descuento> listar() {
		return repo.findAll();
	}

	@Override
	public Descuento leerPorId(Integer id) {
		Optional<Descuento> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Descuento();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}
}
