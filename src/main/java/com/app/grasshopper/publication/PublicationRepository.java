package com.app.grasshopper.publication;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PublicationRepository extends CrudRepository<Publication, Long>{
    List<Publication> findAll();
}