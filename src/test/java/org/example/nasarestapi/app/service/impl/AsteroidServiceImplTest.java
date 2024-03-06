package org.example.nasarestapi.app.service.impl;

import org.example.nasarestapi.app.model.Asteroid;
import org.example.nasarestapi.app.model.CloseApproachData;
import org.example.nasarestapi.app.model.EstimatedDiameter;
import org.example.nasarestapi.app.model.MissDistance;
import org.example.nasarestapi.app.service.spec.IAsteroidService;
import org.example.nasarestapi.infrastructure.client.spec.INasaCADClient;
import org.example.nasarestapi.infrastructure.client.spec.INasaNeoClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class AsteroidServiceImplTest {

    @Mock
    private INasaNeoClient nasaNeoClient;
    @Mock
    private INasaCADClient nasaCADClient;
    private IAsteroidService asteroidService;

    @BeforeEach
    void setup() {
        this.asteroidService = new AsteroidServiceImpl(nasaNeoClient, nasaCADClient);
    }

    @Test
    void getTopClosestAsteroidReturnsSortedAsteroidsByDistance() {
        when(nasaNeoClient.findByDateRange("2024-01-15", "2024-01-18"))
                .thenReturn(expectedClosestAsteroids());

        List<Asteroid> asteroids = asteroidService.getTopClosestAsteroid("2024-01-15", "2024-01-18");

        assertThat(asteroids).isNotNull().isEqualTo(sortedClosestAsteroids());
    }

    private List<Asteroid> expectedClosestAsteroids() {
        List<Asteroid> asteroids = new ArrayList();

        // 1
        List<CloseApproachData> closeApproachData = new ArrayList();
        Map<String, EstimatedDiameter> estimatedDiameterMap = new HashMap();

        closeApproachData.add(CloseApproachData.builder().closeApproachDateFull("2024-Jan-22 11:58").missDistance(MissDistance.builder().lunar(BigDecimal.valueOf(0.7618224236)).kilometers(BigDecimal.valueOf(292974.323621588)).astronomical(BigDecimal.valueOf(0.0019584124)).miles(BigDecimal.valueOf(182045.8031223944)).build()).build());
        estimatedDiameterMap.put("kilometers", new EstimatedDiameter(BigDecimal.valueOf(0.0101989386), BigDecimal.valueOf(0.02280552)));
        estimatedDiameterMap.put("meters", new EstimatedDiameter(BigDecimal.valueOf(10.1989385852), BigDecimal.valueOf(22.8055199748)));
        estimatedDiameterMap.put("miles", new EstimatedDiameter(BigDecimal.valueOf(0.0063373247), BigDecimal.valueOf(0.0141706888)));
        estimatedDiameterMap.put("feet", new EstimatedDiameter(BigDecimal.valueOf(33.4610856678), BigDecimal.valueOf(74.8212621542)));
        asteroids.add(Asteroid.builder().id("54422161").name("(2024 BR2)").absoluteMagnitudeH(27.08F).estimatedDiameter(estimatedDiameterMap).closeApproachData(closeApproachData).isPotentiallyHazardousAsteroid(false).isSentryObject(false).build());

        // 2
        List<CloseApproachData> closeApproachData2 = new ArrayList();
        Map<String, EstimatedDiameter> estimatedDiameterMap2 = new HashMap();

        closeApproachData2.add(CloseApproachData.builder().closeApproachDateFull("2024-Jan-20 10:25").missDistance(MissDistance.builder().lunar(BigDecimal.valueOf(0.8976646857)).kilometers(BigDecimal.valueOf(345215.231246631)).astronomical(BigDecimal.valueOf(0.0023076213)).miles(BigDecimal.valueOf(214506.7978842678)).build()).build());
        estimatedDiameterMap2.put("kilometers", new EstimatedDiameter(BigDecimal.valueOf(0.0025736825), BigDecimal.valueOf(0.0057549291)));
        estimatedDiameterMap2.put("meters", new EstimatedDiameter(BigDecimal.valueOf(2.5736825419), BigDecimal.valueOf(5.7549291163)));
        estimatedDiameterMap2.put("miles", new EstimatedDiameter(BigDecimal.valueOf(0.0015992117), BigDecimal.valueOf(0.0035759461)));
        estimatedDiameterMap2.put("feet", new EstimatedDiameter(BigDecimal.valueOf(8.4438406309), BigDecimal.valueOf(18.8810016419)));
        asteroids.add(Asteroid.builder().id("54421644").name("(2024 BQ1)").absoluteMagnitudeH(30.07F).estimatedDiameter(estimatedDiameterMap2).closeApproachData(closeApproachData2).isPotentiallyHazardousAsteroid(false).isSentryObject(false).build());

        // 3
        List<CloseApproachData> closeApproachData3 = new ArrayList();
        Map<String, EstimatedDiameter> estimatedDiameterMap3 = new HashMap();

        closeApproachData3.add(CloseApproachData.builder().closeApproachDateFull("2024-Jan-15 08:11").missDistance(MissDistance.builder().lunar(BigDecimal.valueOf(0.3640678619)).kilometers(BigDecimal.valueOf(140009.708677877)).astronomical(BigDecimal.valueOf(9.359071E-4)).miles(BigDecimal.valueOf(86997.9988216226)).build()).build());
        estimatedDiameterMap3.put("kilometers", new EstimatedDiameter(BigDecimal.valueOf(0.0043306689), BigDecimal.valueOf(0.0096836699)));
        estimatedDiameterMap3.put("meters", new EstimatedDiameter(BigDecimal.valueOf(4.3306688548), BigDecimal.valueOf(9.6836699473)));
        estimatedDiameterMap3.put("miles", new EstimatedDiameter(BigDecimal.valueOf(0.002690952), BigDecimal.valueOf(0.0060171517)));
        estimatedDiameterMap3.put("feet", new EstimatedDiameter(BigDecimal.valueOf(14.2082316054), BigDecimal.valueOf(31.7705717098)));
        asteroids.add(Asteroid.builder().id("54427461").name("(2024 BA16)").absoluteMagnitudeH(28.94F).estimatedDiameter(estimatedDiameterMap3).closeApproachData(closeApproachData3).isPotentiallyHazardousAsteroid(false).isSentryObject(false).build());

        return asteroids;
    }


    private List<Asteroid> sortedClosestAsteroids() {
        List<Asteroid> asteroids = new ArrayList();

        // 1
        List<CloseApproachData> closeApproachData3 = new ArrayList();
        Map<String, EstimatedDiameter> estimatedDiameterMap3 = new HashMap();

        closeApproachData3.add(CloseApproachData.builder().closeApproachDateFull("2024-Jan-15 08:11").missDistance(MissDistance.builder().lunar(BigDecimal.valueOf(0.3640678619)).kilometers(BigDecimal.valueOf(140009.708677877)).astronomical(BigDecimal.valueOf(9.359071E-4)).miles(BigDecimal.valueOf(86997.9988216226)).build()).build());
        estimatedDiameterMap3.put("kilometers", new EstimatedDiameter(BigDecimal.valueOf(0.0043306689), BigDecimal.valueOf(0.0096836699)));
        estimatedDiameterMap3.put("meters", new EstimatedDiameter(BigDecimal.valueOf(4.3306688548), BigDecimal.valueOf(9.6836699473)));
        estimatedDiameterMap3.put("miles", new EstimatedDiameter(BigDecimal.valueOf(0.002690952), BigDecimal.valueOf(0.0060171517)));
        estimatedDiameterMap3.put("feet", new EstimatedDiameter(BigDecimal.valueOf(14.2082316054), BigDecimal.valueOf(31.7705717098)));
        asteroids.add(Asteroid.builder().id("54427461").name("(2024 BA16)").absoluteMagnitudeH(28.94F).estimatedDiameter(estimatedDiameterMap3).closeApproachData(closeApproachData3).isPotentiallyHazardousAsteroid(false).isSentryObject(false).build());

        // 2
        List<CloseApproachData> closeApproachData = new ArrayList();
        Map<String, EstimatedDiameter> estimatedDiameterMap = new HashMap();

        closeApproachData.add(CloseApproachData.builder().closeApproachDateFull("2024-Jan-22 11:58").missDistance(MissDistance.builder().lunar(BigDecimal.valueOf(0.7618224236)).kilometers(BigDecimal.valueOf(292974.323621588)).astronomical(BigDecimal.valueOf(0.0019584124)).miles(BigDecimal.valueOf(182045.8031223944)).build()).build());
        estimatedDiameterMap.put("kilometers", new EstimatedDiameter(BigDecimal.valueOf(0.0101989386), BigDecimal.valueOf(0.02280552)));
        estimatedDiameterMap.put("meters", new EstimatedDiameter(BigDecimal.valueOf(10.1989385852), BigDecimal.valueOf(22.8055199748)));
        estimatedDiameterMap.put("miles", new EstimatedDiameter(BigDecimal.valueOf(0.0063373247), BigDecimal.valueOf(0.0141706888)));
        estimatedDiameterMap.put("feet", new EstimatedDiameter(BigDecimal.valueOf(33.4610856678), BigDecimal.valueOf(74.8212621542)));
        asteroids.add(Asteroid.builder().id("54422161").name("(2024 BR2)").absoluteMagnitudeH(27.08F).estimatedDiameter(estimatedDiameterMap).closeApproachData(closeApproachData).isPotentiallyHazardousAsteroid(false).isSentryObject(false).build());

        // 3
        List<CloseApproachData> closeApproachData2 = new ArrayList();
        Map<String, EstimatedDiameter> estimatedDiameterMap2 = new HashMap();

        closeApproachData2.add(CloseApproachData.builder().closeApproachDateFull("2024-Jan-20 10:25").missDistance(MissDistance.builder().lunar(BigDecimal.valueOf(0.8976646857)).kilometers(BigDecimal.valueOf(345215.231246631)).astronomical(BigDecimal.valueOf(0.0023076213)).miles(BigDecimal.valueOf(214506.7978842678)).build()).build());
        estimatedDiameterMap2.put("kilometers", new EstimatedDiameter(BigDecimal.valueOf(0.0025736825), BigDecimal.valueOf(0.0057549291)));
        estimatedDiameterMap2.put("meters", new EstimatedDiameter(BigDecimal.valueOf(2.5736825419), BigDecimal.valueOf(5.7549291163)));
        estimatedDiameterMap2.put("miles", new EstimatedDiameter(BigDecimal.valueOf(0.0015992117), BigDecimal.valueOf(0.0035759461)));
        estimatedDiameterMap2.put("feet", new EstimatedDiameter(BigDecimal.valueOf(8.4438406309), BigDecimal.valueOf(18.8810016419)));
        asteroids.add(Asteroid.builder().id("54421644").name("(2024 BQ1)").absoluteMagnitudeH(30.07F).estimatedDiameter(estimatedDiameterMap2).closeApproachData(closeApproachData2).isPotentiallyHazardousAsteroid(false).isSentryObject(false).build());

        return asteroids;
    }
}