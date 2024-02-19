package com.ahmed.web.mapper;

import com.ahmed.web.dto.EventDto;
import com.ahmed.web.model.Event;

public class EventMapper {

    public static Event mapToEvent(EventDto eventDto){
        Event event= Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .type(eventDto.getType())
                .photoUrl(eventDto.getPhotoUrl())
                .createdOn(eventDto.getCreatedOn())
                .updatedOn(eventDto.getUpdatedOn())
                .build();
        return event;

    }
    public static EventDto mapToEventDto(Event event){

        EventDto eventDto= EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .type(event.getType())
                .photoUrl(event.getPhotoUrl())
                .createdOn(event.getCreatedOn())
                .updatedOn(event.getUpdatedOn())
                .build();
        return eventDto;
    }

}
