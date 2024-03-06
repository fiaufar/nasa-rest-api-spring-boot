package org.example.nasarestapi.infrastructure.repository.schema;

//import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

//@Entity
public class AsteroidCloseApproachDataSchema {
//    @Id
    private Date closeApproachDate;
    private Timestamp closeApproachDateFull;
    private long epochDateCloseApproach;
    private float relativeVelocityKilometersPerSecond;
    private float relativeVelocityKilometersPerHour;
    private float relativeVelocityMilesPerHour;
    private float missDistanceAstronomical;
    private float missDistanceLunar;
    private float missDistanceKilometers;
    private float missDistanceMiles;
    private String orbitingBody;
}
