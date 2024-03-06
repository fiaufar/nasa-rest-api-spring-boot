package org.example.nasarestapi.infrastructure.client.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NasaNeoFeedSchema {
    @JsonProperty("element_count")
    private long elementCount;
    @JsonProperty("near_earth_objects")
    private Map<String, List<AsteroidSchema>> nearEarthObjects = new HashMap<String, List<AsteroidSchema>>();
}
