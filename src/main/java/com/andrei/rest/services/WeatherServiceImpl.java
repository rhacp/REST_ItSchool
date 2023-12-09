package com.andrei.rest.services;

import com.andrei.rest.models.entities.Weather;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService{

    private final WeatherValidatorService weatherValidatorService;
    private final ObjectMapper objectMapper;

    public WeatherServiceImpl(WeatherValidatorService weatherValidatorService, ObjectMapper objectMapper) {
        this.weatherValidatorService = weatherValidatorService;
        this.objectMapper = objectMapper;
    }

    @Override
    public Weather getWeather(String city) throws IOException {
        weatherValidatorService.validateCity(city);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.weatherapi.com/v1/current.json?key=c95443508af34df68be161532231011&q=" + city)
                .build();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        System.out.println(responseBody);
        JsonNode jsonNode = objectMapper.readTree(responseBody);
//        System.out.println(jsonNode.asText()); //nu merge ca sa printam obiectul

        String cityName = jsonNode.get("location").get("name").asText();
//        System.out.println(cityName + "___________");

        String descriptionValue = jsonNode.get("current").get("condition").get("text").asText();
        String lastUpdateValue = jsonNode.get("current").get("last_updated").asText();

        //2023-11-10 20:30
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime lastUpdated = LocalDateTime.parse(lastUpdateValue, formatter);

        Weather weather = new Weather();
        weather.setCity(cityName);
        weather.setDescription(descriptionValue);
        weather.setLastUpdated(lastUpdated);

        return weather;
    }
}
