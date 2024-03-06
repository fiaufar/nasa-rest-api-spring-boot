package org.example.nasarestapi.app.service.impl;

import lombok.AllArgsConstructor;
import org.example.nasarestapi.app.model.Asteroid;
import org.example.nasarestapi.app.model.MissDistance;
import org.example.nasarestapi.app.service.spec.IAsteroidService;
import org.example.nasarestapi.infrastructure.client.spec.INasaCADClient;
import org.example.nasarestapi.infrastructure.client.spec.INasaNeoClient;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class AsteroidServiceImpl implements IAsteroidService {

    private final INasaNeoClient nasaNeoClient;
    private final INasaCADClient nasaCADClient;

    @Override
    public List<Asteroid> getTopClosestAsteroid(String startDate, String endDate) {
        final int CLOSEST_ASTEROID_LIMIT = 10;
        List<Asteroid> asteroids = this.nasaNeoClient.findByDateRange(startDate,endDate);

        // Sort the asteroid based on distance to earth
        Collections.sort(asteroids, new Comparator<Asteroid>() {
            @Override
            public int compare(Asteroid o1, Asteroid o2) {
                MissDistance distance1 =  o1.getCloseApproachData().get(0).getMissDistance();
                MissDistance distance2 =  o2.getCloseApproachData().get(0).getMissDistance();
                return distance1.getKilometers().compareTo(distance2.getKilometers());
            }
        });

        if (asteroids.size() < CLOSEST_ASTEROID_LIMIT) {
            return asteroids;
        }

        return asteroids.subList(0, CLOSEST_ASTEROID_LIMIT);
    }

    @Override
    public long getTotalClosestAsteroidByDistance(BigInteger kilometers) {
        long totalAsteroid = this.nasaCADClient.countClosestAsteroidByDistance(kilometers);
        return totalAsteroid;
    }
}
