package org.example.nasarestapi.infrastructure.client.schema;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MissDistanceSchema {
    private BigDecimal astronomical;
    private BigDecimal lunar;
    private BigDecimal kilometers;
    private BigDecimal miles;
}
