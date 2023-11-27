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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/comentario")
@CrossOrigin({ "*" })
@Tag(name = "Controlador comments (comentarios) ", description = "Tabla comment")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    // CREAR
    @Operation(summary = "Guarda un comentario con su descripcion, Requiere postcomment_permission")
    @PreAuthorize("hasAuthority('postcomment_permission')")
    @PostMapping("/")
    public Comentario save(@RequestBody Comentario entity) {
        return comentarioService.save(entity);
    }

    // BUSCAR POR ID
    @Operation(summary = "Obtiene un comentario por su id, Requiere searchcomment_permission")
    @PreAuthorize("hasAuthority('searchcomment_permission')")
    @GetMapping("/{id}/")
    public Comentario findById(@PathVariable long id) {
        return comentarioService.findById(id);
    }

    @Operation(summary = "Actualiza la descripción de un comentario, Requiere putcomment_permission")
    @PreAuthorize("hasAuthority('putcomment_permission')")
    @PutMapping("/")
    public Comentario update(@RequestBody Comentario entity) {
        return comentarioService.save(entity);
    }

    @Operation(summary = "Elimina un comentario por su id, Requiere deletecomment_permission")
    @PreAuthorize("hasAuthority('deletecomment_permission')")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable long id) {
        comentarioService.deleteById(id);
    }

    @Operation(summary = "Obtiene todos los comentarios, Requiere getallcomment_permission")
    @PreAuthorize("hasAuthority('getallcomment_permission')")
    @GetMapping("/")
    public List<Comentario> findAll() {
        return comentarioService.findAll();
    }
}