package org.example.nasarestapi.infrastructure.client.impl;

import org.example.nasarestapi.infrastructure.client.schema.SBDBCloseApproachDataSchema;
import org.example.nasarestapi.infrastructure.client.spec.INasaCADClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class NasaCADClientImpl implements INasaCADClient {
    private final String BASE_URL = "https://ssd-api.jpl.nasa.gov/cad.api";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public long countClosestAsteroidByDistance(BigInteger kilometers) {
        BigDecimal astronomicalUnit = BigDecimal.valueOf(kilometers.doubleValue() * 0.000000006684587122);
        boolean totalOnly = true;

        String nasaSBDBUrl = BASE_URL + "?dist-min=" + astronomicalUnit.toPlainString() + "&total-only=" + totalOnly;
        System.out.println(nasaSBDBUrl);
        // Make a request to Nasa API
        ResponseEntity<SBDBCloseApproachDataSchema> responseEntity = this.restTemplate
                .getForEntity(nasaSBDBUrl, SBDBCloseApproachDataSchema.class);
        SBDBCloseApproachDataSchema sbdbCloseApproachDataSchema = responseEntity.getBody();

        return sbdbCloseApproachDataSchema.getTotal();
    }
}
