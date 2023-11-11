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

    @PostMapping("/")
    public Perfil save(@RequestBody Perfil entity) {
        return perfilService.save(entity);
    }

    @GetMapping("/{id}/")
    public Perfil findById(@PathVariable long id){
        return perfilService.findById(id);
    }

    @PutMapping("/")
    public Perfil update(@RequestBody Perfil entity){
        return perfilService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable long id){
        perfilService.deleteById(id);
    }

    @GetMapping("/")
    public List<Perfil> findAll() {
        return perfilService.findAll();
    }
}
