package com.app.grasshopper.authz.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.grasshopper.authz.entity.Role;




public interface RoleRepository extends CrudRepository <Role, Long> {

    List<Role> findAll();
    
}
