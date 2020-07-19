package com.restaurante.facturacion.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.facturacion.model.Producto;
import com.restaurante.facturacion.repo.IProductoRepo;
import com.restaurante.facturacion.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired	
	private IProductoRepo repo;
	
	@Override
	public Producto registrar(Producto producto) {
		return repo.save(producto);
	}

	@Override
	public Producto modificar(Producto producto) {		
		return repo.save(producto);
	}

	@Override
	public List<Producto> listar() {
		return repo.findAll();
	}

	@Override
	public Producto leerPorId(Integer id) {
		Optional<Producto> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Producto();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}
}
