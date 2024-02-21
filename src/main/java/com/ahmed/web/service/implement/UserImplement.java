package com.ahmed.web.service.implement;

import com.ahmed.web.dto.RegistrationDto;
import com.ahmed.web.model.Role;
import com.ahmed.web.model.UserEntity;
import com.ahmed.web.repository.RoleRepository;
import com.ahmed.web.repository.UserEntityRepository;
import com.ahmed.web.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class UserImplement implements UserServices {
UserEntityRepository userEntityRepository;
RoleRepository roleRepository;
@Autowired
    public UserImplement(UserEntityRepository userEntityRepository, RoleRepository roleRepository) {
        this.userEntityRepository = userEntityRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity userEntity =new UserEntity();
        userEntity.setEmail(registrationDto.getEmail());
        userEntity.setPassword(registrationDto.getPassword());
        userEntity.setUsername(registrationDto.getUsername());
        Role role = roleRepository.findByName("USER");
        userEntity.setRoles(Arrays.asList(role));
        userEntityRepository.save(userEntity);
    }
}
