package com.ahmed.web.service;

import com.ahmed.web.dto.EventDto;
import com.ahmed.web.model.Club;
import com.ahmed.web.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {
    void createEvent(Long clubId , EventDto eventDto);


    List<EventDto> getAllEvent();

    EventDto getEvent(Long eventId);

    void updateEvent(EventDto eventDto);


    Club findClubByEventId(Long eventId);
}
