package com.ahmed.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RegistrationDto {
    private  Long UserId;
    @NotEmpty
    private String Username;
    @NotEmpty
    private String Email;
    @NotEmpty
    private String Password;


}
