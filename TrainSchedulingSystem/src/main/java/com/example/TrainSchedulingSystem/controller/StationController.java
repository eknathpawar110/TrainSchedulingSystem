package com.example.TrainSchedulingSystem.controller;

import com.example.TrainSchedulingSystem.dtos.AddOrUpdateStationRequest;
import com.example.TrainSchedulingSystem.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationService stationService;

    @PostMapping("/add")
    public ResponseEntity<?> addStation(@RequestBody AddOrUpdateStationRequest addStationRequest){
        stationService.addStation(addStationRequest);
        return new ResponseEntity("Station successfully added", HttpStatus.CREATED);
    }

    @GetMapping("/get/{uid}")
    public ResponseEntity<?> getStation(@PathVariable int uid){
        return new ResponseEntity<>(stationService.getStation(uid),HttpStatus.OK);
    }
    @GetMapping("/getStationByName")
    public ResponseEntity<?> getStationByName(@RequestParam(required = true) String name){
        return new ResponseEntity<>(stationService.getStationByName(name),HttpStatus.OK);
    }

    @PutMapping("/update/{uid}")
    public ResponseEntity<?> updateStation(@RequestBody AddOrUpdateStationRequest updateStationRequest,
                                         @PathVariable int uid){
        stationService.updateStation(updateStationRequest,uid);
        return new ResponseEntity<>("Station details successfully updated",HttpStatus.OK);
    }
    @DeleteMapping ("/remove/{uid}")
    public ResponseEntity<?> removeStation(@PathVariable int uid){
        stationService.removeStation(uid);
        return new ResponseEntity<>("Station details successfully removed",HttpStatus.OK);
    }

    @GetMapping("/getAllStations")
    public ResponseEntity<?> getAllStation(){
        return new ResponseEntity<>(
                stationService.getAllStation(),HttpStatus.OK);
    }


}
