package org.example.nasarestapi.app.model;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CloseApproachData {
    private Date closeApproachDate;
    private String closeApproachDateFull;
    private RelativeVelocity relativeVelocity;
    private MissDistance missDistance;
    private String orbitingBody;
}
