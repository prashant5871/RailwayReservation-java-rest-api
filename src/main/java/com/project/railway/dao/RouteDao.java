package com.project.railway.dao;

import java.util.*;

import com.project.railway.entities.Route;
import com.project.railway.entities.Station;

public interface RouteDao {
	
	public Route addRoute(Route route);
	public List<Station> getAllStationInRoute(int trainId);
}
