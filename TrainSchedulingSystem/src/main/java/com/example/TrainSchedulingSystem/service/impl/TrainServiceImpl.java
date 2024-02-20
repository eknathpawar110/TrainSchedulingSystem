package com.example.TrainSchedulingSystem.service.impl;

import com.example.TrainSchedulingSystem.dtos.*;
import com.example.TrainSchedulingSystem.entity.Station;
import com.example.TrainSchedulingSystem.entity.Train;
import com.example.TrainSchedulingSystem.entity.TrainStation;
import com.example.TrainSchedulingSystem.repository.TrainRepository;
import com.example.TrainSchedulingSystem.repository.TrainStationRepository;
import com.example.TrainSchedulingSystem.service.StationService;
import com.example.TrainSchedulingSystem.service.TrainService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private TrainStationRepository trainStationRepository;
    @Autowired
    private StationService stationService;
    @Override
    public final void addTrain(AddOrUpdateTrainRequest addTrainRequest) {

        Train train = Train.builder()
                .name(addTrainRequest.getName())
                .number(addTrainRequest.getNumber())
                .build();
        train = trainRepository.save(train);
        List<TrainStation> trainStationList = new ArrayList<>();
        for(int i = 0; i < addTrainRequest.getStations().size(); i++){
            Station station = stationService.getStationByName(addTrainRequest.getStations().get(i).trim());
            TrainStation trainStation = TrainStation.builder()
                    .sequenceNumber(i)
                    .train(train)
                    .station(station)
                    .build();
            trainStationList.add(trainStation);
        }
        trainStationRepository.saveAll(trainStationList);
    }
    @Override
    public final GetTrainResponse getTrain(Long number) {
        Optional<Train> optionalTrain = trainRepository.findByNumber(number);
        List<TrainStation> trainStationList = trainStationRepository.findByTrainOrderBySequenceNumber(optionalTrain.get());
        Train train = optionalTrain.get();
        List<String> stationList =  new ArrayList<>();
        for(int i = 0 ; i < trainStationList.size() ; i++){
            stationList.add(trainStationList.get(i).getStation().getName());
        }
        return GetTrainResponse.builder()
                .name(train.getName())
                .number(train.getNumber())
                .stations(stationList)
                .build();
    }

    @Override
    public final void updateTrain(AddOrUpdateTrainRequest updateTrainRequest) {
        removeTrain(RemoveTrainRequest.builder().number(updateTrainRequest.getNumber()).build());
        addTrain(updateTrainRequest);
//        Optional<Train> trainOptional = trainRepository.findByNumber(updateTrainRequest.getNumber());
//        trainStationRepository.deleteByTrain(trainOptional.get());
//        Train train = trainOptional.get();
//        train.setName(updateTrainRequest.getName());
//        train = trainRepository.save(train);
//        List<TrainStation> trainStationList = new ArrayList<>();
//        for(int i = 0; i < updateTrainRequest.getStations().size(); i++){
//            Station station = stationService.getStationByName(updateTrainRequest.getStations().get(i).trim());
//            TrainStation trainStation = TrainStation.builder()
//                    .sequenceNumber(i)
//                    .train(train)
//                    .station(station)
//                    .build();
//            trainStationList.add(trainStation);
//        }
//        trainStationRepository.saveAll(trainStationList);
    }

    @Override
    public final void removeTrain(RemoveTrainRequest request) {
        Optional<Train> trainOptional = trainRepository.findByNumber(request.getNumber());
        trainStationRepository.deleteByTrain(trainOptional.get());
        trainRepository.deleteById(trainOptional.get().getUid());
    }

    @Override
    public final List<Train> findAllTrainsBySourceAndDestination(GetTrainBySourceAndDestinationRequest request) {
        Station sourceStation = stationService.getStationByName(request.getSource().trim());
        Station destinationStation = stationService.getStationByName(request.getDestination().trim());
        List<Train> trainList = trainRepository.findAllBySourceAndDestination(sourceStation.getUid(),
                destinationStation.getUid());
        return trainList;
    }

    @Override
    public final List<TrainStationSchedule> getAllTrainSchedule() {
        List<TrainStationSchedule> trainStationSchedules = trainRepository.getAllTrainSchedule();
        return trainStationSchedules;
    }
}
