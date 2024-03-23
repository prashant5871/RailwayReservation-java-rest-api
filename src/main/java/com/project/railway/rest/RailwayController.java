package com.project.railway.rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.railway.entities.Station;
import com.project.railway.entities.Train;
import com.project.railway.entities.TrainStation;
import com.project.railway.service.RailwayService;
import com.project.railway.service.RailwayServiceImpl;

@RestController
@RequestMapping("/api")
public class RailwayController {
    RailwayService railwayService;

    @Autowired
    public RailwayController(RailwayService railwayService)
    {
        this.railwayService = railwayService;
    }

    @PostMapping("/addTrain")
    public Train addTrain(@RequestBody Train train)
    {
        return railwayService.saveTrain(train);
    }

    @PostMapping("/addStation")
    public Station addStation(@RequestBody Station station)
    {
        return railwayService.saveStation(station);
    }

    @PostMapping("/addRoute")
    public TrainStation addRoute(@RequestBody TrainStation trainStation)
    {
        return railwayService.addRoute(trainStation);
    }
    
    @GetMapping("/searchTrain/{source}/{destination}")
    public List<Train> searchTrain(@PathVariable String source,@PathVariable String destination)
    {
    	return railwayService.searchTrain(source,destination);
    	
    }
    

}
