package com.restaurante.facturacion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.facturacion.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer> {

}
