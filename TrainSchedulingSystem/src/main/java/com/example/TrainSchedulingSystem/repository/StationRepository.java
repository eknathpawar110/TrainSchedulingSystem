package com.example.TrainSchedulingSystem.repository;

import com.example.TrainSchedulingSystem.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Integer> {
}
