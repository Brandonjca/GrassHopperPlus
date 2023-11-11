package com.app.grasshopper.register;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
    
public interface RegisterRepository extends CrudRepository<Register, Long>{
    List<Register> findAll();
}