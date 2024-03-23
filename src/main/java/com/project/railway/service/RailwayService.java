package com.project.railway.service;

import java.util.List;

import com.project.railway.entities.Station;
import com.project.railway.entities.Train;
import com.project.railway.entities.TrainStation;

public interface RailwayService {
    public Train saveTrain(Train train);
    public Station saveStation(Station station);
    public TrainStation addRoute(TrainStation trainStation);
    public List<Train> searchTrain(String source,String destination);
}
