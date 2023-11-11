package com.app.grasshopper.cometario;

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
@RequestMapping("api/comentario")
@CrossOrigin({"*"})
public class ComentarioController {
    
    @Autowired
    private ComentarioService comentarioService;

    //CREAR 
    @PostMapping("/")
    public Comentario save(@RequestBody Comentario entity){
        return comentarioService.save(entity);
    }

    //BUSCAR POR ID

    @GetMapping("/{id}/")
    public Comentario findById(@PathVariable long id) {
        return comentarioService.findById(id);
    }

    @PutMapping("/")
    public Comentario update(@RequestBody Comentario entity){
        return comentarioService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable long id){
        comentarioService.deleteById(id);
    }
    @GetMapping("/")
    public List<Comentario> findAll(){
        return comentarioService.findAll();
    }
}