package org.example.nasarestapi.infrastructure.client.schema;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CloseApproachDataSchema {
    private Date closeApproachDate;
    private String closeApproachDateFull;
    private long epochDateCloseApproach;
    private RelativeVelocitySchema relativeVelocity;
    private MissDistanceSchema missDistance;
    private String orbitingBody;
}
