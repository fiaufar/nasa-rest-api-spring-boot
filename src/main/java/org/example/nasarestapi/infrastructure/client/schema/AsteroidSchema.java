package org.example.nasarestapi.infrastructure.client.schema;

//import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AsteroidSchema {
    private String id;
    private String name;
    private float absoluteMagnitudeH;
    private Map<String, EstimatedDiameterSchema> estimatedDiameter;
    private boolean isPotentiallyHazardousAsteroid;
    private List<CloseApproachDataSchema> closeApproachData;
    private boolean isSentryObject;
}
