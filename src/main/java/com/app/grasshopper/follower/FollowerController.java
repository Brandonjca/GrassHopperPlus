package com.app.grasshopper.follower;

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
import java.util.List;

@RestController
@RequestMapping("api/follower")
@CrossOrigin({ "*" })
public class FollowerController {

    @Autowired
    private FollowerService followerService;

    @PostMapping("/") 
    public Follower save(@RequestBody Follower entity) {
        return followerService.save(entity);
    }

    // Para el metodo read
    @GetMapping("/{id}/") 
    public Follower findById(@PathVariable int id) {
        return followerService.findByiId(id);
    }

    // UPDATE
    @PutMapping("/")
    public Follower update(@RequestBody Follower entity) {
        return followerService.save(entity);
    }

    // DELETE
    @DeleteMapping("/{id}/") 
    public void deleteById(@PathVariable int id) {
        followerService.deleteById(id);
    }

    // SELECT ALL
    @GetMapping("/")
    public List<Follower> findAll() {
        return followerService.findAll();
    }
}
