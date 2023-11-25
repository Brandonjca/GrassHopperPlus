package com.app.grasshopper.saved;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/guardado")
@CrossOrigin({"*"})
public class SavedController {

    @Autowired
    SavedService service;

    @Operation(summary = "Guarda un Saved")
    @PreAuthorize("postsaved_permission")
    @PostMapping("/")
    public Saved save( @RequestBody Saved entitiy ){
        return service.save(entitiy);
    }

    @Operation(summary = "Lista un Saved")
    @PreAuthorize("listsaved_permission")
    @GetMapping("/")
    public List<Saved> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Trae un Saved por id")
    @PreAuthorize("idsaved_permission")
    @GetMapping("/{id}/")
    public Saved findById( @PathVariable long id ){
        return service.findById(id);
    }


    @Operation(summary = "Elimina un Saved por id")
    @PreAuthorize("deletesaved_permission")    @DeleteMapping("/{id}/")
    public void deleteById( @PathVariable long id ){
        service.deleteById(id);
    }
}
