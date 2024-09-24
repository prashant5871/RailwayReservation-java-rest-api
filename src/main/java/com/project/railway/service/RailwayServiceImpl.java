package com.project.railway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.railway.dao.RailwayDao;
import com.project.railway.entities.Station;
import com.project.railway.entities.Train;
import com.project.railway.entities.Route;

import jakarta.transaction.Transactional;

@Service
public class RailwayServiceImpl implements RailwayService {
    RailwayDao railwayDao;

    @Autowired 
    public RailwayServiceImpl(RailwayDao railwayDao)
    {
        this.railwayDao = railwayDao;
    }

    @Transactional
    public Train saveTrain(Train train)
    {
        return railwayDao.saveTrain(train);
        
    }
    
    @Transactional
    public Station saveStation(Station station)
    {
        return railwayDao.saveStation(station);
        
    }

    @Transactional
    public Route addRoute(Route route)
    {
        return railwayDao.addRoute(route);
    }
    
    public List<Train> searchTrain(String source,String destination)
    {
    	return railwayDao.searchTrain(source,destination);
    }

}
