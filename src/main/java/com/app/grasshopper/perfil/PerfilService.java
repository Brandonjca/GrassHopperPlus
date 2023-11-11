package com.app.grasshopper.perfil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    //CREAR

    public Perfil save(Perfil entity){
        return perfilRepository.save(entity);
    }

    //SELECCIONAR POR ID

    public Perfil findById(long id){
        return perfilRepository.findById(id).orElse(null);
    }

    //ELIMINAR POR ID

    public void deleteById(long id){
        perfilRepository.deleteById(id);
    }

    //SELECCIONAR TODOS
    public List<Perfil> findAll(){
        return perfilRepository.findAll();
    }

}
