package com.app.grasshopper.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service
public class RegisterService {
    @Autowired
    RegisterRepository repository;
    
    public Register save( Register entity ){
        return repository.save(entity);
    }
    
    public void deleteById( Long id ){
        repository.deleteById(id);
    }
    
    public Register findById(Long id){
        return repository.findById(id).orElse(null);
    }
    
    public List<Register> findAll(){
        return repository.findAll();
    }
    
}