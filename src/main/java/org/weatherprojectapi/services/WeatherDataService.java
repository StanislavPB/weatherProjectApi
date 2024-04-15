package org.weatherprojectapi.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.weatherprojectapi.dto.WeatherDataDto;
import org.weatherprojectapi.entity.WeatherDataEntity;
import org.weatherprojectapi.repository.WeatherRepository;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WeatherDataService {

    /**
     * Optional<WeatherDataEntity> getFromDb(String lat, String lon);
     * <p>
     * WeatherDataEntity saveNewEntity(WeatherJSON request);
     * <p>
     * WeatherDataDto getFromApi(String lat, String lon);
     * <p>
     * WeatherDataDto getWeather(String lat, String lon);
     */

    private final WeatherRepository repository;
    private final Converter converter;
    private OutWeatherApi outWeatherApi;


    private Optional<WeatherDataEntity> getFromDb(String lat, String lon) {
        return repository.findByLatitudeAndLongitude(lat, lon);
    }


    private WeatherDataDto getFromApi(String lat, String lon) throws MalformedURLException, URISyntaxException {
        return outWeatherApi.receivedFromWeatherApi(lat, lon);
    }

    public WeatherDataDto getWeather(String lat, String lon) throws MalformedURLException, URISyntaxException {

        Optional<WeatherDataEntity> optEntity = getFromDb(lat, lon);

        if (optEntity.isPresent()) {
            WeatherDataEntity weatherDataEntity = optEntity.get();
            LocalDateTime createdTime = weatherDataEntity.getTimeCreated();

            long durationMinutes = Duration.between(LocalDateTime.now(), createdTime).toMinutes();

            if (durationMinutes < 10) {
                return converter.fromEntity(weatherDataEntity);
            }
        }

        WeatherDataDto newWeatherData = getFromApi(lat, lon);
        repository.save(converter.fromDto(newWeatherData));

        return newWeatherData;

    }

}
