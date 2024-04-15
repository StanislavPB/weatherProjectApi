package org.weatherprojectapi.dto.jsonStructure.weatherJSONDataModel;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data

public class Weather {

    public String icon;
    public int code;
    public String description;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


}
