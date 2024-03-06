package org.example.nasarestapi.presenter.api.v1.controller;

import org.example.nasarestapi.app.model.Asteroid;
import org.example.nasarestapi.app.service.spec.IAsteroidService;
import org.example.nasarestapi.presenter.api.v1.dto.AsteroidPublicData;
import org.example.nasarestapi.presenter.api.v1.mapper.AsteroidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/asteroid")
public class AsteroidController {

    private final IAsteroidService asteroidService;
    private final AsteroidMapper mapper;

    @Autowired
    public AsteroidController(IAsteroidService asteroidService, AsteroidMapper mapper) {
        this.asteroidService = asteroidService;
        this.mapper = mapper;
    }

    @RequestMapping(value = "/top-closest", method = RequestMethod.GET)
    public ResponseEntity<List<AsteroidPublicData>> getListTopClosestAsteroid(@RequestParam(name = "start_date") String startDate, @RequestParam(name = "end_date") String endDate) throws Throwable {
        List<Asteroid> asteroids = this.asteroidService.getTopClosestAsteroid(startDate, endDate);

        return new ResponseEntity<List<AsteroidPublicData>>(asteroids
                .stream()
                .map(as -> mapper.toDto(as))
                .toList()
                , HttpStatus.OK);
    }
}
