package org.weatherprojectapi.services;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.weatherprojectapi.dto.WeatherDataDto;
import org.weatherprojectapi.dto.jsonStructure.weatherJSONDataModel.WeatherJSON;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
@AllArgsConstructor
public class OutWeatherApi {

    private static Logger log = LoggerFactory.getLogger(OutWeatherApi.class);

    private final RestTemplate restTemplate;

    public WeatherDataDto receivedFromWeatherApi(String lat, String lon) throws MalformedURLException, URISyntaxException {

        String urlString = createUrl(lat, lon);

        URL url = new URL(urlString);

        log.info("Sending request to {}", url);
        ResponseEntity<WeatherJSON> weatherData = restTemplate.getForEntity(url.toURI(), WeatherJSON.class);
        log.info("Received response {}", weatherData);

        if (weatherData.getBody() != null) {
            String tempFromResponse = "" + weatherData.getBody().getData().getFirst().getTemp();
            return getWeatherDataDto(lat, lon, tempFromResponse);
        } else {
            throw new IllegalArgumentException("Response bode not found");
        }




    }

    private WeatherDataDto getWeatherDataDto(String lat, String lon, String tempFromResponse) {
        WeatherDataDto dto = new WeatherDataDto();
        dto.setLatitude(lat);
        dto.setLongitude(lon);
        dto.setTemp(tempFromResponse);
        return dto;
    }

    private String createUrl(String lat, String lon) {
        return UriComponentsBuilder.fromHttpUrl("https://api.weatherbit.io/v2.0/current")
        //https://api.weatherbit.io/v2.0/current?lat=35.7796&lon=-78.6382&key=API_KEY
                .queryParam("lat",lat)
                .queryParam("lon", lon)
                .queryParam("key", "c5fa99ba76184caa90085636fe6778a6")
                .build()
                .toString();
    }

}
