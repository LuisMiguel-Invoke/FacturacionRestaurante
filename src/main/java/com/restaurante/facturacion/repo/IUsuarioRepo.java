package com.restaurante.facturacion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.facturacion.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {

	//select * from usuario where username = ?
	Usuario findOneByUsername(String username);
}
