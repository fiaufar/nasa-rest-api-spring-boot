package org.example.nasarestapi.app.model;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asteroid {
    private String id;
    private String name;
    private float absoluteMagnitudeH;
    private Map<String, EstimatedDiameter> estimatedDiameter;
    private boolean isPotentiallyHazardousAsteroid;
    private List<CloseApproachData> closeApproachData;
    private boolean isSentryObject;
}
