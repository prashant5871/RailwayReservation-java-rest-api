package com.project.railway.service;

import java.util.*;

import com.project.railway.entities.Route;
import com.project.railway.entities.Station;

public interface RouteService {
	public Route addRoute(Route route);
	public List<Station> getAllStationInRoute(int trainId);
}
