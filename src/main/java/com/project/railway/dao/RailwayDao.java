package com.project.railway.dao;

import java.util.*;

import com.project.railway.entities.Station;
import com.project.railway.entities.Train;
import com.project.railway.entities.Route;

public interface RailwayDao {
    public Train saveTrain(Train train);
    public Station saveStation(Station station);
    public Route addRoute(Route route);
    public List<Train> searchTrain(String Source,String dest);
}
