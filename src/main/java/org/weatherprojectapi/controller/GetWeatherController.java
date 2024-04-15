package org.weatherprojectapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.weatherprojectapi.dto.WeatherDataDto;
import org.weatherprojectapi.services.WeatherDataService;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class GetWeatherController {
    private final WeatherDataService service;

    public GetWeatherController(WeatherDataService service) {
        this.service = service;
    }

    @GetMapping("/weather")
    public WeatherDataDto getWeather(@RequestParam String lat, @RequestParam String lon) throws MalformedURLException, URISyntaxException {
        return service.getWeather(lat,lon);
    }

}
