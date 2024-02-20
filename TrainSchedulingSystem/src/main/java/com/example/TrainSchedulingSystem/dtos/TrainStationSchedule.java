package com.example.TrainSchedulingSystem.dtos;

public interface TrainStationSchedule {
    String getTrainName();
    String getSourceStationName();
    String getDestinationStationName();

    int getTrainNumber();
}
