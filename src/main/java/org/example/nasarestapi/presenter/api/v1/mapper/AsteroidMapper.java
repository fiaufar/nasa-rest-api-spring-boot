package org.example.nasarestapi.presenter.api.v1.mapper;

import org.example.nasarestapi.app.model.Asteroid;
import org.example.nasarestapi.presenter.api.v1.dto.AsteroidPublicData;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
abstract public class AsteroidMapper {

    public AsteroidPublicData toDto(Asteroid asteroid) {
        AsteroidPublicData asteroidPublicData = new AsteroidPublicData();
        asteroidPublicData.setId(asteroid.getId());
        asteroidPublicData.setName(asteroid.getName());
        asteroidPublicData.setPotentiallyHazardousAsteroid(asteroid.isPotentiallyHazardousAsteroid());
        asteroidPublicData.setAbsoluteMagnitudeH(asteroid.getAbsoluteMagnitudeH());
        asteroidPublicData.setSentryObject(asteroid.isSentryObject());

        if (!asteroid.getCloseApproachData().isEmpty()) {
            asteroidPublicData.setCloseApproachDateFull(asteroid.getCloseApproachData().get(0).getCloseApproachDateFull());
            asteroidPublicData.setMissDistanceInAstronomical(asteroid.getCloseApproachData().get(0).getMissDistance().getAstronomical());
            asteroidPublicData.setMissDistanceInLunar(asteroid.getCloseApproachData().get(0).getMissDistance().getLunar());
            asteroidPublicData.setMissDistanceInKilometers(asteroid.getCloseApproachData().get(0).getMissDistance().getKilometers());
        }

        if (asteroid.getEstimatedDiameter().containsKey("kilometers")) {
            asteroidPublicData.setEstimatedDiameterMinInKilometer(asteroid.getEstimatedDiameter().get("kilometers").getEstimatedDiameterMin());
            asteroidPublicData.setEstimatedDiameterMaxInKilometer(asteroid.getEstimatedDiameter().get("kilometers").getEstimatedDiameterMax());
        }

        return asteroidPublicData;
    }
}
