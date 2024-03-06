package org.example.nasarestapi.infrastructure.client.mapper;

import org.example.nasarestapi.app.model.Asteroid;
import org.example.nasarestapi.infrastructure.client.schema.AsteroidSchema;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface NasaNeoFeedAsteroidMapper {
    Asteroid toDomain(AsteroidSchema asteroidSchema);
    AsteroidSchema toSchema(Asteroid asteroid);
}

