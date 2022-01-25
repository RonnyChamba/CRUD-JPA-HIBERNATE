package com.ideas.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.ideas.app.jpa.model.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado,Integer> {

}
