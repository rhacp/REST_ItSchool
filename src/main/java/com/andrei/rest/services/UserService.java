package com.andrei.rest.services;

import com.andrei.rest.models.dtos.UserDTO;
import com.andrei.rest.models.entities.User;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
}
