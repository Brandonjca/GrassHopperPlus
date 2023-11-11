package com.app.grasshopper.shared;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service
public class SharedService {
    @Autowired
    SharedRepository repository;
    
    public Shared save( Shared entity ){
        return repository.save(entity);
    }
    
    public void deleteById( Long id ){
        repository.deleteById(id);
    }
    
    public Shared findById(Long id){
        return repository.findById(id).orElse(null);
    }
    
    public List<Shared> findAll(){
        return repository.findAll();
    }
    
}
