package com.andrei.rest.models.dtos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
