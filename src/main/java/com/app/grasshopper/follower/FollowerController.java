package com.app.grasshopper.follower;

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

import java.util.List;

@RestController
@RequestMapping("api/follower")
@CrossOrigin({ "*" })
@Tag(name = "Controlador Followers (seguidores)", description = "Tabla followers")
public class FollowerController {

    @Autowired
    private FollowerService followerService;

    @Operation(summary = "Guarda un seguidor, Requiere postfollow_permission")
    @PreAuthorize("hasAuthority('postfollow_permission')")
    @PostMapping("/")
    public Follower save(@RequestBody Follower entity) {
        return followerService.save(entity);
    }

    // Para el metodo read
    @Operation(summary = "Obtiene un seguidor por su id, Requiere readfollow_permission")
    @PreAuthorize("hasAuthority('readfollow_permission')")
    @GetMapping("/{id}/")
    public Follower findById(@PathVariable int id) {
        return followerService.findByiId(id);
    }

    // UPDATE
    @Operation(summary = "Actualiza un seguidor por su id, Requiere updatefollow_permission")
    @PreAuthorize("hasAuthority('pdatefollow_permission')")
    @PutMapping("/")
    public Follower update(@RequestBody Follower entity) {
        return followerService.save(entity);
    }

    // DELETE
    @Operation(summary = "Borra un seguidor por su id, Requiere deletefollow_permission")
    @PreAuthorize("hasAuthority('deletefollow_permission')")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable int id) {
        followerService.deleteById(id);
    }

    // SELECT ALL
    @Operation(summary = "Obtiene todos los seguidores, Requiere readallfollow_permission")
    @PreAuthorize("hasAuthority('readallfollow_permission')")
    @GetMapping("/")
    public List<Follower> findAll() {
        return followerService.findAll();
    }
}
