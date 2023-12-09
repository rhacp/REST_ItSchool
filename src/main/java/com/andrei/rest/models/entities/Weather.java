package com.andrei.rest.models.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Weather {

    private String city;
    private String description;
    private LocalDateTime lastUpdated;
}
