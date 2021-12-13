package com.crudproject.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudproject.crud.model.Datos;

public interface CrudRepository extends JpaRepository<Datos, Integer>{

}
