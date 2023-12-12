package com.andrei.rest.services;

import com.andrei.rest.exceptions.UserCreateException;
import com.andrei.rest.models.dtos.UserDTO;
import com.andrei.rest.models.entities.User;
import com.andrei.rest.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        //validate DTO
        //convert DTO to entity
        //save entity to database
        //convert entity to DTO

        //validation
        if (userDTO.getFirstName().length() < 3) {
            throw new UserCreateException("Invalid first name.");
        }

        //conversion to entity
        User userEntity = new User();
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setEmail(userDTO.getEmail());

        //save entity to db
        User savedUser = userRepository.save(userEntity);

        //conversion to DTO
        UserDTO userResponseDTO = new UserDTO();
        userResponseDTO.setId(savedUser.getId());
        userResponseDTO.setFirstName(savedUser.getFirstName());
        userResponseDTO.setLastName(savedUser.getLastName());
        userResponseDTO.setEmail(savedUser.getEmail());

        return userResponseDTO;
    }
}
