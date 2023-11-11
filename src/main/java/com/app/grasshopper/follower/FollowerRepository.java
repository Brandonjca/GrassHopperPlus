package com.app.grasshopper.follower;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface FollowerRepository extends CrudRepository<Follower, Long>{
    List<Follower> findAll();
}
