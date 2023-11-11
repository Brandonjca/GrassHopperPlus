package com.app.grasshopper.like;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service
public class LikeService {
    @Autowired
    LikeRepository repository;
    
    public Like save( Like entity ){
        return repository.save(entity);
    }
    
    public void deleteById( Long id ){
        repository.deleteById(id);
    }
    
    public Like findById(Long id){
        return repository.findById(id).orElse(null);
    }
    
    public List<Like> findAll(){
        return repository.findAll();
    }
    
}
