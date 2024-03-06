package org.example.nasarestapi.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MissDistance {
    private BigDecimal astronomical;
    private BigDecimal lunar;
    private BigDecimal kilometers;
    private BigDecimal miles;
}
