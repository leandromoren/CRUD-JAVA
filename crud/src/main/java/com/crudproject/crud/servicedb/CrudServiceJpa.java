package com.crudproject.crud.servicedb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudproject.crud.model.Datos;
import com.crudproject.crud.repository.CrudRepository;
import com.crudproject.crud.service.CrudService;

@Service
public class CrudServiceJpa implements CrudService {

	@Autowired
	private  CrudRepository crudRepo;
	
	
	@Override
	public void guardar(Datos datos) {
       crudRepo.save(datos);
	}

	@Override
	public List<Datos> buscarTodas() {
		return crudRepo.findAll();
	}

	@Override
	public void eliminar(int idDatos) {
		crudRepo.deleteById(idDatos);

	}

	@Override
	public Datos editar(int idDatos) {
		Optional<Datos> optional = crudRepo.findById(idDatos);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
