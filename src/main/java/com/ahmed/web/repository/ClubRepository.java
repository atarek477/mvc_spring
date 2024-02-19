package com.ahmed.web.repository;

import com.ahmed.web.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClubRepository extends JpaRepository<Club,Long> {

    @Query("SELECT c FROM Club c WHERE LOWER(c.title) LIKE CONCAT('%', LOWER(:name), '%')")
    List<Club> searchClubs(@Param("name") String name);

}
