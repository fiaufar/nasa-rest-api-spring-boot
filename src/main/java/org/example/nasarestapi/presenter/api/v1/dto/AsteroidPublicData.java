package org.example.nasarestapi.presenter.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.nasarestapi.infrastructure.client.schema.MissDistanceSchema;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsteroidPublicData {
    private String id;
    private String name;
    private float absoluteMagnitudeH;
    private boolean isPotentiallyHazardousAsteroid;
    private boolean isSentryObject;

    private String closeApproachDateFull;
    private BigDecimal missDistanceInAstronomical;
    private BigDecimal missDistanceInLunar;
    private BigDecimal missDistanceInKilometers;

    private BigDecimal estimatedDiameterMinInKilometer;
    private BigDecimal estimatedDiameterMaxInKilometer;
}
