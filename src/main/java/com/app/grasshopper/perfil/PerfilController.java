package com.app.grasshopper.perfil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/perfil")
@CrossOrigin({"*"})
public class PerfilController {
    
    @Autowired
    private PerfilService perfilService;

    //CREAR

    @PostMapping("/")
    public Perfil save(@RequestBody Perfil entity) {
        return perfilService.save(entity);
    }


    //BUSCAR POR ID

    @GetMapping("/{id}/")
    public Perfil findById(@PathVariable long id){
        return perfilService.findById(id);
    }

    //ACTUALIZAR

    @PutMapping("/")
    public Perfil update(@RequestBody Perfil entity){
        return perfilService.save(entity);
    }

    //ELIMINAR POR ID

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable long id){
        perfilService.deleteById(id);
    }

    //BUSCAR TODO

    @GetMapping("/")
    public List<Perfil> findAll() {
        return perfilService.findAll();
    }
}
