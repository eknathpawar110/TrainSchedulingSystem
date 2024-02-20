package com.example.TrainSchedulingSystem.repository;

import com.example.TrainSchedulingSystem.entity.Train;
import com.example.TrainSchedulingSystem.entity.TrainStation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainStationRepository extends JpaRepository<TrainStation, Integer> {
    @Modifying
    @Transactional
    void deleteByTrain(Train train);

    List<TrainStation> findByTrainOrderBySequenceNumber(Train train);
}
