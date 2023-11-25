package com.app.grasshopper.perfil;

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
@RequestMapping("api/perfil")
@CrossOrigin({ "*" })
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    // CREAR

    @PostMapping("/")
    @PreAuthorize("postperfil_permission")
    public Perfil save(@RequestBody Perfil entity) {
        return perfilService.save(entity);
    }

    // BUSCAR POR ID
    @PreAuthorize("getperfil_permission")

    @GetMapping("/{id}/")
    public Perfil findById(@PathVariable long id) {
        return perfilService.findById(id);
    }

    // ACTUALIZAR
    @PreAuthorize("updateperfil_permission")

    @PutMapping("/")
    public Perfil update(@RequestBody Perfil entity) {
        return perfilService.save(entity);
    }

    // ELIMINAR POR ID
    @PreAuthorize("deleteperfil_permission")

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable long id) {
        perfilService.deleteById(id);
    }

    // BUSCAR TODO
    
    @PreAuthorize("getallperfil_permission")

    @GetMapping("/")
    public List<Perfil> findAll() {
        return perfilService.findAll();
    }
}
