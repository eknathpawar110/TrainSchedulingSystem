package com.example.TrainSchedulingSystem.service;

import com.example.TrainSchedulingSystem.entity.Station;
import com.example.TrainSchedulingSystem.dtos.AddOrUpdateStationRequest;

import java.util.List;

public interface StationService {
    void addStation(AddOrUpdateStationRequest addStationRequest);
    Station getStation(int uid);
    Station getStationByName(String name);
    void updateStation(AddOrUpdateStationRequest updateStationRequest, int uid);
    void removeStation(int uid);
    List<Station> getAllStation();

    void loadStationMap();
}
