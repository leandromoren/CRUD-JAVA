package com.crudproject.crud.service;

import java.util.List;

import com.crudproject.crud.model.Datos;

public interface CrudService {

	void guardar(Datos datos);
	
	List<Datos> buscarTodas();
	
	Datos editar(int idDatos);
	
	void eliminar(int idDatos);
}
