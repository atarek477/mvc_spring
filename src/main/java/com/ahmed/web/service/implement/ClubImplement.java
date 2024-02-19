package com.ahmed.web.service.implement;

import com.ahmed.web.dto.ClubDto;
import com.ahmed.web.mapper.ClubMapper;
import com.ahmed.web.model.Club;
import com.ahmed.web.repository.ClubRepository;
import com.ahmed.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.ahmed.web.mapper.ClubMapper.mapToClub;
import static com.ahmed.web.mapper.ClubMapper.mapToClubDto;

@Service
public class ClubImplement implements ClubService {
private final ClubRepository clubRepository;
    @Autowired
    public ClubImplement(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs= clubRepository.findAll();
return clubs.stream().map(ClubMapper::mapToClubDto).collect(Collectors.toList());

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

    @Override
    public void deleteClub(long id) {
        clubRepository.deleteById(id);
    }

    @Override
    public List<ClubDto> searchClubs(String result) {
        List<Club> clubs = clubRepository.searchClubs(result);
        return clubs.stream().map(ClubMapper::mapToClubDto).collect(Collectors.toList());
    }


}
