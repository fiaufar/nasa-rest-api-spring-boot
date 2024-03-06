package org.example.nasarestapi.infrastructure.client.spec;

import org.example.nasarestapi.app.model.Asteroid;

import java.util.List;

public interface INasaNeoClient {
    List<Asteroid> findByDateRange(String startDate, String endDate);
}
