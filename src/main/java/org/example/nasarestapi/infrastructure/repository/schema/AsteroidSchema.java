package org.example.nasarestapi.infrastructure.repository.schema;

import lombok.*;
import org.example.nasarestapi.infrastructure.client.schema.CloseApproachDataSchema;
import org.example.nasarestapi.infrastructure.client.schema.EstimatedDiameterSchema;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class AsteroidSchema {
    private String id;
    private String name;
    private float absoluteMagnitudeH;
    private EstimatedDiameterSchema estimatedDiameter;
    private boolean isPotentiallyHazardousAsteroid;
    private List<CloseApproachDataSchema> closeApproachData;
    private boolean isSentryObject;
}
