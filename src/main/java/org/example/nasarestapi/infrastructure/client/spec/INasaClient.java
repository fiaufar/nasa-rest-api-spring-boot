package org.example.nasarestapi.infrastructure.client.spec;

import org.example.nasarestapi.app.model.Asteroid;

import java.util.Date;
import java.util.List;

public interface INasaClient {
    List<Asteroid> findByDateRange(String startDate, String endDate);
}
