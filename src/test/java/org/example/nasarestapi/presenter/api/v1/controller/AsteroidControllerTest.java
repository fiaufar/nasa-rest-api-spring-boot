package org.example.nasarestapi.presenter.api.v1.controller;

import org.example.nasarestapi.app.model.Asteroid;
import org.example.nasarestapi.app.model.CloseApproachData;
import org.example.nasarestapi.app.model.EstimatedDiameter;
import org.example.nasarestapi.app.model.MissDistance;
import org.example.nasarestapi.app.service.spec.IAsteroidService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class AsteroidControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private IAsteroidService asteroidService;

    @BeforeEach
    void printApplicationContext() {
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .map(name -> applicationContext.getBean(name).getClass().getName())
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void getListTopClosestAsteroidReturnsHttpStatusOK() throws Exception {
        when(asteroidService.getTopClosestAsteroid("2024-01-15", "2024-01-18"))
                .thenReturn(expectedClosestAsteroids());

        mockMvc.perform(
                get("/api/v1/asteroid/top-closest")
                        .param("start_date", "2024-01-15")
                        .param("end_date", "2024-01-18"))
                .andExpect(status().isOk());
    }

    @Test
    void getListTopClosestAsteroidWithoutStartDateReturnsHttpStatusBadRequest() throws Exception {
        mockMvc.perform(
                        get("/api/v1/asteroid/top-closest")
                                .param("end_date", "2024-01-18"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getListTopClosestAsteroidWithoutEndDateReturnsHttpStatusBadRequest() throws Exception {
        mockMvc.perform(
                        get("/api/v1/asteroid/top-closest")
                                .param("start_date", "2024-01-15"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getListTopClosestAsteroidWithoutDatesReturnsHttpStatusBadRequest() throws Exception {
        mockMvc.perform(
                        get("/api/v1/asteroid/top-closest"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getTotalClosestAsteroidReturnsHttpStatusOK() throws Exception {
        when(asteroidService.getTotalClosestAsteroidByDistance(BigInteger.valueOf(1000000)))
                .thenReturn((long)39);

        mockMvc.perform(
                        get("/api/v1/asteroid/total-closest")
                                .param("distance", "1000000"))
                .andExpect(status().isOk());
    }

    @Test
    void getTotalClosestAsteroidReturnsHttpStatusBadRequest() throws Exception {
        when(asteroidService.getTotalClosestAsteroidByDistance(BigInteger.valueOf(0)))
                .thenReturn((long)0);

        mockMvc.perform(
                        get("/api/v1/asteroid/total-closest"))
                .andExpect(status().isBadRequest());
    }

    private List<Asteroid> expectedClosestAsteroids() {
        List<Asteroid> asteroids = new ArrayList<>();

        List<CloseApproachData> closeApproachData = new ArrayList<>();
        closeApproachData.add(
                        CloseApproachData
                                .builder()
                                .closeApproachDateFull("2024-Jan-15 08:11")
                                .missDistance(
                                        MissDistance
                                                .builder()
                                                .lunar(BigDecimal.valueOf(0.3640678619))
                                                .kilometers(BigDecimal.valueOf(140009.708677877))
                                                .astronomical(BigDecimal.valueOf(0.0009359071))
                                                .miles(BigDecimal.valueOf(86997.9988216226))
                                                .build()
                                )
                                .build()
                        );
        Map<String, EstimatedDiameter> estimatedDiameterMap = new HashMap<>();
        estimatedDiameterMap.put("kilometers", new EstimatedDiameter(BigDecimal.valueOf(0.0043306689), BigDecimal.valueOf(0.0096836699)));
        estimatedDiameterMap.put("meters", new EstimatedDiameter(BigDecimal.valueOf(4.3306688548), BigDecimal.valueOf(9.6836699473)));
        estimatedDiameterMap.put("miles", new EstimatedDiameter(BigDecimal.valueOf(0.002690952), BigDecimal.valueOf(0.0060171517)));
        estimatedDiameterMap.put("feet", new EstimatedDiameter(BigDecimal.valueOf(14.2082316054), BigDecimal.valueOf(31.7705717098)));

        asteroids.add(
                Asteroid.builder()
                        .id("54427461")
                        .name("(2024 BA16)")
                        .absoluteMagnitudeH((float) 28.94)
                        .estimatedDiameter(estimatedDiameterMap)
                        .closeApproachData(closeApproachData)
                        .isPotentiallyHazardousAsteroid(false)
                        .isSentryObject(false)
                        .build()
        );

        return asteroids;
    }
}