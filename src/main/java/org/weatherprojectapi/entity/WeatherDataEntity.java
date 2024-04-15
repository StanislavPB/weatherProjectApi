package org.weatherprojectapi.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data
@Table(name = "weather")
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDataEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;


  @Column(name = "ip")
  private String ip;

  @Column(name = "latitude")
  private String latitude;

  @Column(name = "longitude")
  private String longitude;

  @Column(name = "temperature")
  private String temperature;

  @Column(name = "created")
  private Long created;


}
