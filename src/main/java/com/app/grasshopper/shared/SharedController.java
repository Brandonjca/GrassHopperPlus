package com.app.grasshopper.shared;

import java.util.List;
import java.util.Map;
import java.lang.reflect.Field;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/shared")
@CrossOrigin({"*"})
public class SharedController {

    @Autowired
    SharedService service;

    @Operation(summary = "Obtiene un por Id")
    @PreAuthorize("getshared_permission")
    @GetMapping("/{id}/")
    public Shared findById( @PathVariable long id ){
        return service.findById(id);
    }


    @Operation(summary = "Obtiene una lista")
    @PreAuthorize("listshared_permission")
    @GetMapping("/")
    public List<Shared> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Crea un Shared")
    @PreAuthorize("postshared_permission")
    @PostMapping("/")
    public Shared save( @RequestBody Shared entitiy ){
        return service.save(entitiy);
    }

    @Operation(summary = "Actualiza un Shared")
    @PreAuthorize("updateshared_permission")
    @PutMapping("/")
    public Shared update ( @RequestBody Shared entity){
        return service.save(entity);
    }


    @Operation(summary = "Elimina un Shared por Id")
    @PreAuthorize("deleteshared_permission")
    @DeleteMapping("/{id}/")
    public void deleteById( @PathVariable long id ){
        service.deleteById(id);
    }

    @Operation(summary = "Actualiza un Shared por Id")
    @PreAuthorize("patchshared_permission")
    @PatchMapping("/{id}/")
    public Shared partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields){

        Shared entity = findById(id);

        // itera sobre los campos que se desean actualizar
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            
            // utiliza reflection para establecer el valor del campo en la entidad
            try {
                Field campoEntidad = Shared.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                campoEntidad.set(entity, mapper.convertValue(fieldValue, campoEntidad.getType()));
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return update(entity);
    }

}
