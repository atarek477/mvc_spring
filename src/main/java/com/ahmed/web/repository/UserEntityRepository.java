package com.ahmed.web.repository;

import com.ahmed.web.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {



    @Query("SELECT u FROM UserEntity u WHERE u.Email = ?1")
    UserEntity findByEmail(String email);

    @Query("SELECT u FROM UserEntity u WHERE u.Username = ?1")
    UserEntity findUserByUsername(String username);




}
