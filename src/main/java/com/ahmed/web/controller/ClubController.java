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
    public String saveClub(@Valid @ModelAttribute("club")ClubDto club, BindingResult result,Model model) {

if (result.hasErrors()){
model.addAttribute("club",club);
return "club-create";

}

        clubService.saveClubServices(club);
        return "redirect:/clubs";

    }


    @GetMapping("/club/delete/{id}")
    public String deleteClub(@PathVariable("id")long id) {
        clubService.deleteClub(id);
        return "redirect:/clubs";

    }

    @GetMapping("/club/edit/{id}")
    public String updateClubForm(@PathVariable("id")long id,Model model) {
        ClubDto clubDto= clubService.findClubById(id);
        model.addAttribute("clubDto", clubDto);
        return "club-edit";

    }
    @GetMapping("/club/{id}")
    public String detailClubForm(@PathVariable("id")long id,Model model) {
        ClubDto clubDto= clubService.findClubById(id);
        model.addAttribute("clubDto", clubDto);
        return "club-details";

    }




    @PostMapping("/club/edit/{id}")
    public String saveClub(@PathVariable("id") long id, @Valid @ModelAttribute("clubDto") ClubDto clubDto,
                           BindingResult result) {

        if (result.hasErrors())
            return "club-edit";

        clubDto.setId(id);
        System.out.println(clubDto);
        clubService.updateClub(clubDto);
        return "redirect:/clubs";
    }
}


