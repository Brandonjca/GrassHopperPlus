package com.app.grasshopper.megusta;

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
@RequestMapping("/api/megusta")
@Tag(name = "Controlador Me Gusta (Me Gusta) ", description = "Tabla Me Gusta")
@CrossOrigin({"*"})
public class MegustaController {

    @Autowired
    MegustaService service;


      // Metodo Leer
    @Operation(summary = "Obtiene un me gusta por su ID, Requiere like_permission")
    @PreAuthorize("hasAuthority('like_permission')")
    @GetMapping("/{id}/")
    public Megusta findById( @PathVariable long id ){
        return service.findById(id);
    }

    // Metodo Select All
    @Operation(summary = "Obtiene todos los Me Gusta de la tabla, Requiere GetLike_permission")
    @PreAuthorize("hasAuthority('GetLike_permission')")
    @GetMapping("/")
    public List<Megusta> findAll() {
        return service.findAll();
    }

    // Metodo Crear
    @Operation(summary = "Guarda un Me Gusta, Requiere PostLike_permission")
    @PreAuthorize("hasAuthority('PostLike_permission')")
    @PostMapping("/")
    public Megusta save( @RequestBody Megusta entitiy ){
        return service.save(entitiy);
    }
    
    //Metodo Actualizar
    @Operation(summary = "Actuliza un Me Gusta, Requiere PutLike_permission")
    @PreAuthorize("hasAuthority('PutLike_permission')")
    @PutMapping("/")
    public Megusta update ( @RequestBody Megusta entity){
        return service.save(entity);
    }

    // Metodo Eliminar
    @Operation(summary = "Elimina un Me Gusta por ID, Requiere DeleteLike_permission")
    @PreAuthorize("hasAuthority('DeleteLike_permission')")
    @DeleteMapping("/{id}/")
    public void deleteById( @PathVariable long id ){
        service.deleteById(id);
    }

}
