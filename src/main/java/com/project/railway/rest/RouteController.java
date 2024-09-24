package com.project.railway.rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.railway.entities.Route;
import com.project.railway.entities.Station;
import com.project.railway.service.RouteService;

@RestController
@RequestMapping("/admin")
public class RouteController {
	public RouteService routeService;

	@Autowired
	public RouteController(RouteService routeService) {
		this.routeService = routeService;
	}

	@PostMapping("/add-route")
	public Route addRoute(@RequestBody Route route) {
		return routeService.addRoute(route);
	}

	@GetMapping("/get-route/{trainId}")
	public List<Station> getAllStationById(@PathVariable int trainId) {
		return routeService.getAllStationInRoute(trainId);
	}
}
