package com.app.grasshopper.publication;

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

@RestController
@RequestMapping("api/publication")
@CrossOrigin({ "*" })
public class PublicationController {
   
    @Autowired
    private PublicationServicio publicationServicio;

    @Operation(summary = "Permite realizar plublicaciones")
        @PreAuthorize("postpublication_permission")

    @PostMapping("/") 
    public Publication save(@RequestBody Publication entity) {
        return publicationServicio.save(entity);
    }

    // Para el metodo read
        @Operation(summary = "Trae la publicacion por ID")
        @PreAuthorize("getpublication_permission")

    @GetMapping("/{id}/") 
    public Publication findById(@PathVariable int id) {
        return publicationServicio.findByiId(id);
    }

    // UPDATE
        @Operation(summary = "Actualiza las publicaciones")
        @PreAuthorize("putpublication_permission")

    @PutMapping("/")
    public Publication update(@RequestBody Publication entity) {
        return publicationServicio.save(entity);
    }

    // DELETE
    @Operation(summary = "elimina las publicaciones")
        @PreAuthorize("deletepublication_permission")

    @DeleteMapping("/{id}/") 
    public void deleteById(@PathVariable int id) {
        publicationServicio.deleteById(id);
    }

    // SELECT ALL
        @Operation(summary = "trae todas las publicaciones")
        @PreAuthorize("getallpublication_permission")

    @GetMapping("/")
    public List<Publication> findAll() {
        return publicationServicio.findAll();
    }
}

