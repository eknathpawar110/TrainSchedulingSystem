package com.example.TrainSchedulingSystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTrainBySourceAndDestinationRequest {
    private String source;
    private String destination;
}
