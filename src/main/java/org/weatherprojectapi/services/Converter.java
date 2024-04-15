package org.weatherprojectapi.services;

import org.springframework.stereotype.Component;
import org.weatherprojectapi.dto.WeatherDataDto;
import org.weatherprojectapi.entity.WeatherDataEntity;

import java.time.LocalDateTime;

@Component
public class Converter {

    WeatherDataDto fromEntity(WeatherDataEntity entity){
        WeatherDataDto dto = new WeatherDataDto();
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setTemp(entity.getTemperature());
        return dto;
    }

    WeatherDataEntity fromDto(WeatherDataDto dto){

        WeatherDataEntity newEntity = new WeatherDataEntity();
        newEntity.setLatitude(dto.getLatitude());
        newEntity.setLongitude(dto.getLongitude());
        newEntity.setTemperature(dto.getTemp());
        newEntity.setTimeCreated(LocalDateTime.now());

        return newEntity;
    }

}
