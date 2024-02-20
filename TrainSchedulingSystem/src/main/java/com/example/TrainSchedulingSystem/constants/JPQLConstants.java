package com.example.TrainSchedulingSystem.constants;

public interface JPQLConstants {

    String sourceDestinationQuery = "select t  " +
            "from Train t  " +
            "inner join  " +
            "  TrainStation tsa  " +
            "    on tsa.train = t and tsa.station.uid=:sourceUid " +
            "inner join  " +
            "  TrainStation tsd  " +
            "    on tsd.train = t and tsd.station.uid=:destinationUid and tsd.sequenceNumber > tsa.sequenceNumber";

    String trainsStationSchedule = "select t.name as trainName, sa.name as sourceStationName, sd.name as destinationStationName,t.number as trainNumber " +
            "   " +
            "from    " +
            "  train_station tsa   " +
            "inner join   " +
            "  train_station tsd    " +
            "    on tsd.train_uid=tsa.train_uid and tsd.sequence_number=tsa.sequence_number+1   " +
            "inner join    " +
            "  train t on t.uid = tsa.train_uid   " +
            "inner join   " +
            "  station sa on sa.uid=tsa.station_uid   " +
            "inner join   " +
            "  station sd on sd.uid=tsd.station_uid    " +
            "order by t.name,tsa.sequence_number";
}
