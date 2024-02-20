package com.example.TrainSchedulingSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "train_station", uniqueConstraints = {@UniqueConstraint(columnNames = {"train_uid", "station_uid"})})
public class TrainStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Train train;
    @ManyToOne
    private Station station;
    private int sequenceNumber;
}
