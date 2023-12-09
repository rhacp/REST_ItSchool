package com.andrei.rest.services;

import com.andrei.rest.models.entities.Weather;

import java.io.IOException;

public interface WeatherService {

    Weather getWeather(String city) throws IOException;
}
