package com.app.grasshopper.publication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationServicio {

    @Autowired
    private PublicationRepository publicationRepository;

    // CREATE
    public Publication save(Publication entity) {
        return publicationRepository.save(entity);
    }

    // READ
    public Publication findByiId(long id) {
        return publicationRepository.findById(id).orElse(null);
    }

    // UPDATE UTILIZA EL METODO DE CREATE

    // DELETE
    public void deleteById(long id) {
        publicationRepository.deleteById(id);
    }

    // SELECT ALL
    public List<Publication> findAll() {
        return publicationRepository.findAll();
    }
}
