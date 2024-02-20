package com.example.TrainSchedulingSystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTrainResponse {
    private String name;
    private Long number;
    private List<String> stations;
}
