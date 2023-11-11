package com.app.grasshopper.saved;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service
public class SavedService {
    @Autowired
    SavedRepository repository;
    
    //Metodo Crear
    public Saved save( Saved entity ){
        return repository.save(entity);
    }
    
    //Metodo Select All

    public List<Saved> findAll(){
        return repository.findAll();
    }

     //Metodo Eliminar
    public void deleteById( Long id ){
        repository.deleteById(id);
    }
    
     //Metodo Select All
    public Saved findById(Long id){
        return repository.findById(id).orElse(null);
    }
    
    
    
}