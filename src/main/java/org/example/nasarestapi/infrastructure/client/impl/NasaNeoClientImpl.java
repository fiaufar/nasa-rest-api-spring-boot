package org.example.nasarestapi.infrastructure.client.impl;

import org.example.nasarestapi.app.model.Asteroid;
import org.example.nasarestapi.infrastructure.client.mapper.NasaNeoFeedAsteroidMapper;
import org.example.nasarestapi.infrastructure.client.schema.AsteroidSchema;
import org.example.nasarestapi.infrastructure.client.schema.NasaNeoFeedSchema;
import org.example.nasarestapi.infrastructure.client.spec.INasaNeoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class NasaNeoClientImpl implements INasaNeoClient {

    private final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/feed";
    @Value("${environment.nasa-api-key}")
    private String API_KEY;
    private final RestTemplate restTemplate = new RestTemplate();
    private final NasaNeoFeedAsteroidMapper mapper;

    @Autowired
    public NasaNeoClientImpl(NasaNeoFeedAsteroidMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Asteroid> findByDateRange(String startDate, String endDate) {
        String nasaFeedUrl = BASE_URL + "?start_date=" + startDate + "&end_date" + endDate + "&api_key=" + API_KEY;
        System.out.println(nasaFeedUrl);
        // Make a request to Nasa API
        ResponseEntity<NasaNeoFeedSchema> responseEntity = this.restTemplate
                .getForEntity(nasaFeedUrl,NasaNeoFeedSchema.class);
        NasaNeoFeedSchema nasaNeoFeedSchema = responseEntity.getBody();

        // Mapping the response to our domain object
        List<Asteroid> asteroids = new ArrayList<Asteroid>();
        Map<String, List<AsteroidSchema>> mapNearEarthObjects = nasaNeoFeedSchema.getNearEarthObjects();
        for (Map.Entry<String, List<AsteroidSchema>> entry: mapNearEarthObjects.entrySet()) {
            asteroids.addAll(entry.getValue()
                    .stream()
                    .map(asteroid -> mapper.toDomain(asteroid))
                    .toList());
        }

        return asteroids;
    }
}
