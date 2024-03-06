package org.example.nasarestapi.app.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstimatedDiameter {
    private BigDecimal estimatedDiameterMin;
    private BigDecimal estimatedDiameterMax;
}
