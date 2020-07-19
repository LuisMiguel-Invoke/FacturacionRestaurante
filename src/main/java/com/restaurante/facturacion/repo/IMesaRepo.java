package com.restaurante.facturacion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.facturacion.model.Mesa;

public interface IMesaRepo extends JpaRepository<Mesa, Integer> {

}
