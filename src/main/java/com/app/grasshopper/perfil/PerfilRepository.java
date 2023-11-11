package com.app.grasshopper.perfil;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface PerfilRepository extends CrudRepository<Perfil, Long> {
    List<Perfil> findAll();
}