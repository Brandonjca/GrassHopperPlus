package com.app.grasshopper.megusta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service
public class MegustaService {
    @Autowired
    MegustaRepository repository;
    
    public Megusta save( Megusta entity ){
        return repository.save(entity);
    }
    
    public void deleteById( Long id ){
        repository.deleteById(id);
    }
    
    public Megusta findById(Long id){
        return repository.findById(id).orElse(null);
    }
    
    public List<Megusta> findAll(){
        return repository.findAll();
    }
    
}
