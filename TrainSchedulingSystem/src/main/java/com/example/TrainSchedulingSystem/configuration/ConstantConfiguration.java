package com.example.TrainSchedulingSystem.configuration;

import com.example.TrainSchedulingSystem.service.StationService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConstantConfiguration {
    @Autowired
    private StationService stationService;
    @PostConstruct
    public void loadStationMap(){
        stationService.loadStationMap();
    }

}
