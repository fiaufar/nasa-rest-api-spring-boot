package org.example.nasarestapi.controller.v1.asteroid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/asteroid")
public class AsteroidController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<String> helloAsteroid() throws Throwable {
        return new ResponseEntity<String>("Hello asteroid 2", HttpStatus.OK);
    }
}
