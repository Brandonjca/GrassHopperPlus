package com.app.grasshopper.cometario;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ComentarioRepository extends CrudRepository<Comentario, Long> {
        List<Comentario> findAll();

}
