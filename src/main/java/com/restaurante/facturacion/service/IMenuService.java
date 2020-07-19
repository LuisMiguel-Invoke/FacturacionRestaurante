package com.restaurante.facturacion.service;

import java.util.List;

import com.restaurante.facturacion.model.Menu;

public interface IMenuService extends ICRUD<Menu>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
}
