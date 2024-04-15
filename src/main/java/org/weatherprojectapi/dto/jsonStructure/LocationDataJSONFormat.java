package org.weatherprojectapi.dto.jsonStructure;

import lombok.Data;


@Data
public class LocationDataJSONFormat {

    private String ip;
    private String city;
    private String region;
    private String region_code;
    private String country;
    private String country_name;
    private String continent_code;
    private boolean in_eu;
    private String postal;
    private String latitude;
    private String longitude;
    private String timezone;
    private String utc_offset;
    private String country_calling_code;
    private String currency;
    private String languages;
    private String asn;
    private String org;
}
