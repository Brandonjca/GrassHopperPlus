package com.app.grasshopper.notification;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/notificacion")
@CrossOrigin({"*"})
public class NotificationController {

    @Autowired
    NotificationService service;

    
    //Metodo Crear
     @PostMapping("/")
    public Notification save( @RequestBody Notification entitiy ){
        return service.save(entitiy);
    }

    //Metodo Leer
    @GetMapping("/{id}/")
    public Notification findById( @PathVariable long id ){
        return service.findById(id);
    }

    //Metodo Select All
    @GetMapping("/")
    public List<Notification> findAll() {
        return service.findAll();
    }

   //Metodo Eliminar
    @DeleteMapping("/{id}/")
    public void deleteById( @PathVariable long id ){
        service.deleteById(id);
    }

}