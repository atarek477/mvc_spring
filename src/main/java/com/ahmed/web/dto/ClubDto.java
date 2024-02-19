package com.ahmed.web.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ClubDto {

    private Long id;
    @NotEmpty(message = "title should not be empty")
    private String title;
    @NotEmpty(message = "photo link should not be empty")
    private String photoUrl;
    @NotEmpty(message = "content should not be empty")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    private List<EventDto>eventDtos= new ArrayList<>();

}
