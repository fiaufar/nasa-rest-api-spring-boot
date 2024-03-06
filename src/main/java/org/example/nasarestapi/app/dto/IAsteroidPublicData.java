package org.example.nasarestapi.app.dto;

public interface IAsteroidPublicData {
    String id();
    String name();
    float absoluteMagnitudeH();
    boolean isPotentiallyHazardousAsteroid();
    boolean isSentryObject();
}
