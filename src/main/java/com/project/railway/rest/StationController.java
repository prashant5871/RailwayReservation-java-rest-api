package com.project.railway.rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.railway.entities.Station;
import com.project.railway.service.StationService;
import com.project.railway.service.StationServiceImpl;

@RestController
@RequestMapping("/admin")
public class StationController {
	public StationService stationService;

	@Autowired
	public StationController(StationService stationService) {
		this.stationService = stationService;
	}

	@PostMapping("/station")
	public Station addStation(@RequestBody Station station) {
		return stationService.saveStation(station);
	}

	@GetMapping("/stations")
	public List<Station> getAllStation() {
		return stationService.getAllStation();
	}

	@GetMapping("/stations/{stationId}")
	public Station getStationById(@PathVariable int stationId) {
		return stationService.getStationById(stationId);
	}

	@PutMapping("/station/{stationId}")
	public Station updateStation(@PathVariable int stationId, @RequestBody Station station) {
		return stationService.updateStation(stationId, station);
	}
}
