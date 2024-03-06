package org.example.nasarestapi.infrastructure.client.spec;

import java.math.BigInteger;

public interface INasaCADClient {
    long countClosestAsteroidByDistance(BigInteger kilometers);
}
