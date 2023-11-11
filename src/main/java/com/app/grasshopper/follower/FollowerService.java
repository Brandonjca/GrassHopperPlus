package com.app.grasshopper.follower;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {
    @Autowired
    private FollowerRepository followerRepository;

    // CREATE
    public Follower save(Follower entity) {
        return followerRepository.save(entity);
    }

    // READ
    public Follower findByiId(long id) {
        return followerRepository.findById(id).orElse(null);
    }

    // UPDATE UTILIZA EL METODO DE CREATE

    // DELETE
    public void deleteById(long id) {
        followerRepository.deleteById(id);
    }

    // SELECT ALL
    public List<Follower> findAll() {
        return followerRepository.findAll();
    }
}
