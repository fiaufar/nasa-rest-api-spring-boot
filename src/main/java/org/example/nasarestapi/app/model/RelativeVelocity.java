package org.example.nasarestapi.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelativeVelocity {
    private BigDecimal kilometersPerSecond;
    private BigDecimal kilometersPerHour;
    private BigDecimal milesPerHour;
}
