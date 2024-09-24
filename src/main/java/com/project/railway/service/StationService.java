package com.project.railway.service;

import java.util.List;

import com.project.railway.entities.Station;

public interface StationService {
	public Station saveStation(Station station);
	public List<Station> getAllStation();
	public Station getStationById(int id);
	public Station updateStation(int stationId,Station station);
}
