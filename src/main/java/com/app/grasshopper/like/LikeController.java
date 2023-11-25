package com.app.grasshopper.like;

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

@RestController
@RequestMapping("/api/like")
@CrossOrigin({ "*" })
public class LikeController {

    @Autowired
    LikeService service;

    @PreAuthorize("getlike_permission")
    @GetMapping("/{id}/")
    public Like findById(@PathVariable long id) {
        return service.findById(id);
    }

    @PreAuthorize("getalllike_permission")
    @GetMapping("/")
    public List<Like> findAll() {
        return service.findAll();
    }

    @PreAuthorize("postlike_permission")
    @PostMapping("/")
    public Like save(@RequestBody Like entitiy) {
        return service.save(entitiy);
    }

    @PreAuthorize("putlike_permission")
    @PutMapping("/")
    public Like update(@RequestBody Like entity) {
        return service.save(entity);
    }

    @PreAuthorize("deletelike_permission")
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    @PreAuthorize("patchlike_permission")
    @PatchMapping("/{id}/")
    public Like partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields) {

        Like entity = findById(id);

        // itera sobre los campos que se desean actualizar
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();

            // utiliza reflection para establecer el valor del campo en la entidad
            try {
                Field campoEntidad = Like.class.getDeclaredField(fieldName);
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
