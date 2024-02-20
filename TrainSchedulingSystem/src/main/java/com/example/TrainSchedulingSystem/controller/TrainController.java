package com.example.TrainSchedulingSystem.controller;

import com.example.TrainSchedulingSystem.dtos.AddOrUpdateTrainRequest;
import com.example.TrainSchedulingSystem.dtos.GetTrainBySourceAndDestinationRequest;
import com.example.TrainSchedulingSystem.dtos.RemoveTrainRequest;
import com.example.TrainSchedulingSystem.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/train")
public class TrainController {
    @Autowired
    private TrainService trainService;
    @PostMapping("/add")
    public ResponseEntity<?> addTrain(@RequestBody AddOrUpdateTrainRequest addTrainRequest){
        trainService.addTrain(addTrainRequest);
        return new ResponseEntity("Train successfully added", HttpStatus.CREATED);
    }

    @GetMapping("/get/{number}")
    public ResponseEntity<?> getTrain(@PathVariable Long number){
        return new ResponseEntity<>(trainService.getTrain(number),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTrain(@RequestBody AddOrUpdateTrainRequest updateTrainRequest){
        trainService.updateTrain(updateTrainRequest);
        return new ResponseEntity<>("Train details successfully updated",HttpStatus.OK);
    }
    @DeleteMapping ("/remove")
    public ResponseEntity<?> removeTrain(@RequestBody RemoveTrainRequest request){
        trainService.removeTrain(request);
        return new ResponseEntity<>("Train details successfully removed",HttpStatus.OK);
    }
    @PostMapping("/findAllTrainsBySourceAndDestination")
    public ResponseEntity<?> findAllTrainsBySourceAndDestination(@RequestBody GetTrainBySourceAndDestinationRequest request){
        return new ResponseEntity<>(trainService.findAllTrainsBySourceAndDestination(request), HttpStatus.OK);
    }

    @GetMapping("/getAllTrainSchedule")
    public ResponseEntity<?> getAllTrainSchedule(){
        return new ResponseEntity<>(trainService.getAllTrainSchedule(), HttpStatus.OK);
    }
}
