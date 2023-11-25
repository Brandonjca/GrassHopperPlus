package com.app.grasshopper.megusta;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
    
public interface MegustaRepository extends CrudRepository<Megusta, Long>{
    List<Megusta> findAll();
}
