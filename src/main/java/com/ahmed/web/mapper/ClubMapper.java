package com.ahmed.web.mapper;

import com.ahmed.web.dto.ClubDto;
import com.ahmed.web.model.Club;

import java.util.stream.Collectors;

import static com.ahmed.web.mapper.EventMapper.mapToEventDto;

public class ClubMapper {

    public static Club mapToClub(ClubDto clubDto) {
        Club club= Club.builder().id(clubDto.getId())
                .title(clubDto.getTitle())
                .photoUrl(clubDto.getPhotoUrl())
                .content(clubDto.getContent())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .build();
        return club;


    }


    public static ClubDto mapToClubDto(Club club){
        ClubDto clubDto= ClubDto.builder().id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .eventDtos(club.getEvent().stream().map(EventMapper::mapToEventDto).collect(Collectors.toList()))
                .build();
        return clubDto;
    }
}
