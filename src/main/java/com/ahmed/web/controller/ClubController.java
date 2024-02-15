package com.ahmed.web.controller;

import com.ahmed.web.dto.ClubDto;
import com.ahmed.web.model.Club;
import com.ahmed.web.service.ClubService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ClubController {
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String findAllClubs(Model model) {
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";

    }
    @GetMapping("/club/create")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "club-create";

    }
    @PostMapping ("/club/create")
    public String saveClub(@ModelAttribute("club")Club club) {
        clubService.saveClubServices(club);
        return "redirect:/clubs";

    }

    @GetMapping("/club/edit/{id}")
    public String updateClubForm(@PathVariable("id")long id,Model model) {
        ClubDto clubDto= clubService.findClubById(id);
        model.addAttribute("clubDto", clubDto);
        System.out.println(clubDto.toString());
        return "club-edit";

    }

    @PostMapping ("/club/edit/{id}")
    public String saveClub(@PathVariable("id")long id,@Valid @ModelAttribute("club")ClubDto club
    ,BindingResult result) {
        if(result.hasErrors())
            return "club-edit";

        club.setId(id);
        System.out.println(club);
        clubService.updateClub(club);
        return "redirect:/clubs";

    }
}


