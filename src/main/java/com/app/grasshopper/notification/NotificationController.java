package com.app.grasshopper.notification;

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
@RequestMapping("/api/notificacion")
@Tag(name = "Controlador Notificación (Notificación) ", description = "Tabla Notificación")
@CrossOrigin({ "*" })
public class NotificationController {

    @Autowired
    NotificationService service;

    // Metodo Crear
    @Operation(summary = "Guarda una Notificación, Requiere postnotification_permission")
    @PreAuthorize("hasAuthority('postnotification_permission')")
    @PostMapping("/")
    public Notification save(@RequestBody Notification entitiy) {
        return service.save(entitiy);
    }

    // Metodo Leer
    @Operation(summary = "Obtiene una notificación por su ID, Requiere notification_permission")
    @PreAuthorize("hasAuthority('notification_permission')")
    @GetMapping("/{id}/")
    public Notification findById(@PathVariable long id) {
        return service.findById(id);
    }

    // Metodo Select All
    @Operation(summary = "Obtiene todas las notificaciones de la tabla, Requiere getnotification_permission")
    @PreAuthorize("hasAuthority('getnotification_permission')")
    @GetMapping("/")
    public List<Notification> findAll() {
        return service.findAll();
    }

    // Metodo Eliminar
    @Operation(summary = "Elimina una Notificación por ID, Requiere deletenotification_permission")
    @PreAuthorize("hasAuthority('deletenotification_permission')")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }


     //Metodo Actualizar
    @Operation(summary = "Actuliza un notificación, Requiere putnotificacion_permission")
    @PreAuthorize("hasAuthority('putnotificacion_permission')")
    @PutMapping("/")
    public Notification update ( @RequestBody Notification entity){
        return service.save(entity);
    }

}