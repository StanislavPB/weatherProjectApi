package org.weatherprojectapi.dto;

import lombok.Data;

@Data
public class WeatherDataDto {

    private String ip;
    private String latitude;
    private String longitude;
    private String temp;
}
