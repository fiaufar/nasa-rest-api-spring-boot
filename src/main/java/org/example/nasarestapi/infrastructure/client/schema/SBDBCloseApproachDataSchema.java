package org.example.nasarestapi.infrastructure.client.schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class SBDBCloseApproachDataSchema {
    private long count;
    private long total;
    private List<String> fields;
    private List<List<String>> data;
}
