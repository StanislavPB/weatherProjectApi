package org.weatherprojectapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.weatherprojectapi.entity.WeatherDataEntity;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherDataEntity, Integer> {

    Optional<WeatherDataEntity> findByLatitudeAndLongitude (String lat, String lon);

    Optional<WeatherDataEntity> findByTimeCreated(LocalDateTime timeCreated);

}
