package com.ahmed.web.service;

import com.ahmed.web.dto.ClubDto;
import com.ahmed.web.model.Club;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClubService {
    public List<ClubDto> findAllClubs();

    public void saveClubServices(ClubDto club);

    public ClubDto findClubById(long id);

    public void updateClub(ClubDto club);

    public void deleteClub(long id);
    public List<ClubDto> searchClubs(String result);
}
