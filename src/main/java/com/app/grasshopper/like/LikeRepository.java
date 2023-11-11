package com.app.grasshopper.like;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
    
public interface LikeRepository extends CrudRepository<Like, Long>{
    List<Like> findAll();
}
