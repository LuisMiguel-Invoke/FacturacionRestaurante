package com.restaurante.facturacion.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.facturacion.model.Mesa;
import com.restaurante.facturacion.repo.IMesaRepo;
import com.restaurante.facturacion.service.IMesaService;

@Service
public class MesaServiceImpl implements IMesaService{
	
	@Autowired	
	private IMesaRepo repo;
	
	@Override
	public Mesa registrar(Mesa mesa) {
		return repo.save(mesa);
	}

	@Override
	public Mesa modificar(Mesa mesa) {		
		return repo.save(mesa);
	}

	@Override
	public List<Mesa> listar() {
		return repo.findAll();
	}

	@Override
	public Mesa leerPorId(Integer id) {
		Optional<Mesa> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Mesa();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}
}
