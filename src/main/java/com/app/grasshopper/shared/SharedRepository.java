package com.app.grasshopper.shared;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
    
public interface SharedRepository extends CrudRepository<Shared, Long>{
    List<Shared> findAll();
}