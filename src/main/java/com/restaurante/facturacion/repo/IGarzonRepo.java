package com.restaurante.facturacion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.facturacion.model.Garzon;

public interface IGarzonRepo extends JpaRepository<Garzon, Integer>{

}
