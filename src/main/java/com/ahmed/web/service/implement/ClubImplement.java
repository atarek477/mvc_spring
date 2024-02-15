package com.ahmed.web.service.implement;

import com.ahmed.web.dto.ClubDto;
import com.ahmed.web.model.Club;
import com.ahmed.web.repository.ClubRepository;
import com.ahmed.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ClubImplement implements ClubService {
private ClubRepository clubRepository;
    @Autowired
    public ClubImplement(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs= clubRepository.findAll();
return clubs.stream().map((club)->mapToClubDto(club)).collect(Collectors.toList());

    }

    @Override
    public void saveClubServices(ClubDto club) {
        Club club1= mapToClub(club);
        clubRepository.save(club1);
    }

    @Override
    public ClubDto findClubById(long id) {
            Club club= clubRepository.findById(id).get();
            return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);

    }

    private Club mapToClub(ClubDto clubDto) {
        Club club= Club.builder().id(clubDto.getId())
                .title(clubDto.getTitle())
                .photoUrl(clubDto.getPhotoUrl())
                .content(clubDto.getContent())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .build();
        return club;


    }


    public ClubDto mapToClubDto(Club club){
        ClubDto clubDto= ClubDto.builder().id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return clubDto;





    }
}
