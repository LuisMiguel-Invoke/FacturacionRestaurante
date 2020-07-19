package com.restaurante.facturacion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.facturacion.model.Descuento;

public interface IDescuentoRepo extends JpaRepository<Descuento, Integer> {

}
