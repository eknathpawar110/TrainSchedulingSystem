package com.example.TrainSchedulingSystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrUpdateTrainRequest {
    private Long number;
    private String name;
    private List<String> stations;
}
