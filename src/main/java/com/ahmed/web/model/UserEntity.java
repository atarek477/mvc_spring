package com.ahmed.web.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private  Long UserId;
    private String Username;
    private String Password;
@ManyToMany
    @JoinTable(name = "User_Role",
    joinColumns =@JoinColumn(name = "user_id"),
    inverseJoinColumns =@JoinColumn(name = "Role_id"))
    List<Role> roles = new ArrayList<>();

}


