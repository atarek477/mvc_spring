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
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Role_Id;
    private String Name;

    @ManyToMany(mappedBy = "roles")
    List<UserEntity>userEntities= new ArrayList<>();


}
