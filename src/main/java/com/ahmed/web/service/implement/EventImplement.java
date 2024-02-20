package com.ahmed.web.service.implement;

import com.ahmed.web.dto.EventDto;
import com.ahmed.web.mapper.EventMapper;
import com.ahmed.web.model.Club;
import com.ahmed.web.model.Event;
import com.ahmed.web.repository.ClubRepository;
import com.ahmed.web.repository.EventRepository;
import com.ahmed.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ahmed.web.mapper.EventMapper.mapToEvent;
import static com.ahmed.web.mapper.EventMapper.mapToEventDto;

@Service
public class EventImplement implements EventService {
    private ClubRepository clubRepository;
   private EventRepository eventRepository;


   @Autowired
    public EventImplement(ClubRepository clubRepository, EventRepository eventRepository) {
        this.clubRepository = clubRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club= clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);


    }

    @Override
    public List<EventDto> getAllEvent() {
        return eventRepository.findAll().stream().map(EventMapper::mapToEventDto).toList();
    }

    @Override
    public EventDto getEvent(Long eventId) {
        Event event =eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }

    @Override
    public Club findClubByEventId(Long eventId) {
       return eventRepository.findClubByEventId(eventId);

    }

    @Override
    public void deleteEvent(long eventId) {
        eventRepository.deleteById(eventId);
    }


}
