package com.restaurante.facturacion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.facturacion.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

}
