package com.app.grasshopper.saved;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
    
public interface SavedRepository extends CrudRepository<Saved, Long>{
    List<Saved> findAll();
}