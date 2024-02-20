package com.example.TrainSchedulingSystem.service;

import com.example.TrainSchedulingSystem.dtos.GetTrainResponse;
import com.example.TrainSchedulingSystem.dtos.RemoveTrainRequest;
import com.example.TrainSchedulingSystem.entity.Train;
import com.example.TrainSchedulingSystem.dtos.AddOrUpdateTrainRequest;
import com.example.TrainSchedulingSystem.dtos.GetTrainBySourceAndDestinationRequest;

public interface TrainService {
    void addTrain(AddOrUpdateTrainRequest addTrainRequest);
    GetTrainResponse getTrain(Long number);
    void updateTrain(AddOrUpdateTrainRequest updateTrainRequest);
    void removeTrain(RemoveTrainRequest request);

    Object findAllTrainsBySourceAndDestination(GetTrainBySourceAndDestinationRequest request);

    Object getAllTrainSchedule();
}
