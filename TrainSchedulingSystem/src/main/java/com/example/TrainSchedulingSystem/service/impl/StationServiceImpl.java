package com.example.TrainSchedulingSystem.service.impl;

import com.example.TrainSchedulingSystem.entity.Station;
import com.example.TrainSchedulingSystem.dtos.AddOrUpdateStationRequest;
import com.example.TrainSchedulingSystem.repository.StationRepository;
import com.example.TrainSchedulingSystem.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService {

    private static Map<String,Station> stationMap = new HashMap<>();
    @Autowired
    private StationRepository stationRepository;
    @Override
    public void addStation(AddOrUpdateStationRequest addStationRequest) {
        Station station = Station.builder()
                .name(addStationRequest.getName())
                .build();
        station = stationRepository.save(station);
        stationMap.put(station.getName().toLowerCase(),station);
    }
    @Override
    public Station getStation(int uid) {
        Optional<Station> optionalStation = stationRepository.findById(uid);
        return optionalStation.get();
    }
    @Override
    public void updateStation(AddOrUpdateStationRequest updateStationRequest, int uid) {
        Optional<Station> optionalStation = stationRepository.findById(uid);
        Station station = optionalStation.get();
        station.setName(updateStationRequest.getName());
        stationRepository.save(station);
    }
    @Override
    public void removeStation(int uid) {
        stationRepository.deleteById(uid);
    }

    @Override
    public List<Station> getAllStation() {
        List<Station> allStations = stationRepository.findAll();
        return allStations;
    }

    @Override
    public void loadStationMap() {
        List<Station> stationsList = stationRepository.findAll();
        for(Station station : stationsList){
            stationMap.put(station.getName().toLowerCase(),station);
        }
    }

    @Override
    public Station getStationByName(String name) {
        if(!stationMap.containsKey(name.trim().toLowerCase())){
            addStation(AddOrUpdateStationRequest.builder()
                    .name(name)
                    .build());
        }
        return stationMap.get(name.trim().toLowerCase());
    }
}
