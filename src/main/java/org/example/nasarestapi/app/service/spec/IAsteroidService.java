package org.example.nasarestapi.app.service.spec;

import org.example.nasarestapi.app.model.Asteroid;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface IAsteroidService {
    List<Asteroid> getTopClosestAsteroid(String startDate, String endDate);
    long getTotalClosestAsteroidByDistance(BigInteger kilometers);
}
