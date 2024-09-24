package com.project.railway.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.project.railway.entities.Train;
import com.project.railway.service.TrainService;

@RestController
@RequestMapping("/admin")
public class TrainController {
	public TrainService trainService;

	@Autowired
	public TrainController(TrainService trainService) {
		this.trainService = trainService;
	}

	@PostMapping("/add-train")
	public Train addTrain(@RequestBody Train train) {
		return trainService.saveTrain(train);
	}

	@GetMapping("/trains")
	public List<Train> getTrains() {
		return trainService.getTrains();
	}

	@GetMapping("/trains/{trainNo}")
	public Train getTrain(@PathVariable int trainNo) {
		return trainService.findById(trainNo);
	}

	@GetMapping("/search-train/{source}/{destination}")
	public List<Train> searchTrain(@PathVariable String source, @PathVariable String destination) {
		return trainService.searchTrain(source, destination);

	}
	
	@DeleteMapping("/remove-train/{trainId}")
	public String deleteTrain(@PathVariable int trainId)
	{
		return trainService.deleteTrain(trainId);
	}
}
