package com.app.grasshopper.cometario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@CrossOrigin({ "*" })
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    // CREAR
    @PreAuthorize("postcomment_permission")
    @PostMapping("/")
    public Comentario save(@RequestBody Comentario entity) {
        return comentarioService.save(entity);
    }

    // BUSCAR POR ID
    @PreAuthorize("searchcomment_permission")
    @GetMapping("/{id}/")
    public Comentario findById(@PathVariable long id) {
        return comentarioService.findById(id);
    }

    @PreAuthorize("putcomment_permission")
    @PutMapping("/")
    public Comentario update(@RequestBody Comentario entity) {
        return comentarioService.save(entity);
    }

    @PreAuthorize("deletecomment_permission")

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable long id) {
        comentarioService.deleteById(id);
    }

    @PreAuthorize("getallcomment_permission")
    @GetMapping("/")
    public List<Comentario> findAll() {
        return comentarioService.findAll();
    }
}