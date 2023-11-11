package com.app.grasshopper.publication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("api/publication")
@CrossOrigin({ "*" })
public class PublicationController {
   
    @Autowired
    private PublicationServicio publicationServicio;

    @PostMapping("/") 
    public Publication save(@RequestBody Publication entity) {
        return publicationServicio.save(entity);
    }

    // Para el metodo read
    @GetMapping("/{id}/") 
    public Publication findById(@PathVariable int id) {
        return publicationServicio.findByiId(id);
    }

    // UPDATE
    @PutMapping("/")
    public Publication update(@RequestBody Publication entity) {
        return publicationServicio.save(entity);
    }

    // DELETE
    @DeleteMapping("/{id}/") 
    public void deleteById(@PathVariable int id) {
        publicationServicio.deleteById(id);
    }

    // SELECT ALL
    @GetMapping("/")
    public List<Publication> findAll() {
        return publicationServicio.findAll();
    }
}

