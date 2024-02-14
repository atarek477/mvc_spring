package com.ahmed.web.service;

import com.ahmed.web.dto.ClubDto;
import com.ahmed.web.model.Club;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClubService {
    public List<ClubDto> findAllClubs();
}
