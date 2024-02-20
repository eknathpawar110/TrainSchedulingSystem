package com.example.TrainSchedulingSystem.repository;

import com.example.TrainSchedulingSystem.constants.JPQLConstants;
import com.example.TrainSchedulingSystem.dtos.TrainStationSchedule;
import com.example.TrainSchedulingSystem.entity.Train;
import com.example.TrainSchedulingSystem.entity.TrainStation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainRepository extends JpaRepository<Train,Integer> {
    @Query(value = JPQLConstants.sourceDestinationQuery, nativeQuery = false)
    List<Train> findAllBySourceAndDestination(@Param("sourceUid") int sourceUid,
                                              @Param("destinationUid") int destinationUid);
    @Query(value = JPQLConstants.trainsStationSchedule, nativeQuery = true)
    List<TrainStationSchedule> getAllTrainSchedule();
    Optional<Train> findByNumber(Long number);
}
