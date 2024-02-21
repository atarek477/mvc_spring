package com.ahmed.web.repository;

import com.ahmed.web.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository  extends JpaRepository<Role,Long> {

    @Query("SELECT r FROM Role r WHERE r.Name = ?1")
    Role findByName(String name);




}
