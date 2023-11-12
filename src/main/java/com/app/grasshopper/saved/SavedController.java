package com.app.grasshopper.saved;

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
@RequestMapping("/api/guardado")
@CrossOrigin({"*"})
public class SavedController {

    @Autowired
    SavedService service;

    
    //Metodo Crear
    @PostMapping("/")
    public Saved save( @RequestBody Saved entitiy ){
        return service.save(entitiy);
    }
    //Metodo Select All
    @GetMapping("/")
    public List<Saved> findAll() {
        return service.findAll();
    }
     //Metodo Leer
    @GetMapping("/{id}/")
    public Saved findById( @PathVariable long id ){
        return service.findById(id);
    }

    //Metodo Eliminar
    @DeleteMapping("/{id}/")
    public void deleteById( @PathVariable long id ){
        service.deleteById(id);
    }

      

}
