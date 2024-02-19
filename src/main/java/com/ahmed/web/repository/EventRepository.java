package com.ahmed.web.repository;

import com.ahmed.web.model.Club;
import com.ahmed.web.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    @Query("SELECT e.club FROM Event e WHERE e.id = ?1")
    Club findClubByEventId(Long eventId);
}
