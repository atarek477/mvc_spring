package com.ahmed.web.controller;

import com.ahmed.web.dto.EventDto;
import com.ahmed.web.model.Event;
import com.ahmed.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {
    private EventService eventService;
@Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/event/create/{clubId}")
    public String createEventForm(@PathVariable("clubId")Long clubId, Model model){

        Event event=new Event();
        model.addAttribute("clubId",clubId);
        model.addAttribute("event",event);
        return "event-create";

    }

    @PostMapping("/event/create/{clubId}")
    public String createEvent(@PathVariable("clubId")Long clubId, @ModelAttribute("event")EventDto eventDto,Model model){


        eventService.createEvent(clubId,eventDto);
        return "redirect:/clubs";

    }


    @GetMapping("/event/list")
    public String createEventForm( Model model){

        List<EventDto>events=eventService.getAllEvent();
        model.addAttribute("events",events);
        return "event-list";

    }


    @GetMapping("/event/{eventId}")
    public String getEvent( @PathVariable("eventId")Long eventId, Model model){

         EventDto event=eventService.getEvent(eventId);
        model.addAttribute("event",event);
        return "event-details";

    }


}
