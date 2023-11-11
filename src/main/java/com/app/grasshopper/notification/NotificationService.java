package com.app.grasshopper.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service
public class NotificationService {
    @Autowired
    NotificationRepository repository;
    
    //Metodo Crear
    public Notification save( Notification entity ){
        return repository.save(entity);
    }
    
    //Metodo Leer
    public Notification findById(Long id){
        return repository.findById(id).orElse(null);
    }
    
    //Metodo Select All
    public List<Notification> findAll(){
        return repository.findAll();
    }

    //Metodo Eliminar
     public void deleteById( Long id ){
        repository.deleteById(id);
    }
    
}