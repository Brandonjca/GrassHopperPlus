package com.app.grasshopper.cometario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    
    @Autowired
    private ComentarioRepository comentarioRepository;

    //CREAR 
    public Comentario save(Comentario entity){
        return comentarioRepository.save(entity);
    }

    //SELECCIONAR POR ID

    public Comentario findById(long id){
        return comentarioRepository.findById(id).orElse(null);
    }

    //ELIMINAR POR ID 

    public void deleteById(long id){
        comentarioRepository.deleteById(id);
    }

    //SELECCIONAR TODOS

    public List<Comentario>findAll(){
        return comentarioRepository.findAll();
    }
}
