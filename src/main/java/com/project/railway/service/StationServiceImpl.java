package com.project.railway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.railway.dao.StationDao;
import com.project.railway.entities.Station;

import jakarta.transaction.Transactional;

@Service
public class StationServiceImpl implements StationService {
	public StationDao stationDao;
	
	@Autowired
	public StationServiceImpl(StationDao stationDao)
	{
		this.stationDao = stationDao;
	}
	
	@Transactional
	public Station saveStation(Station station)
	{
		return stationDao.saveStation(station);
		
	}

	@Override
	public List<Station> getAllStation() {
		return stationDao.getAllStation();
	}

	@Override
	public Station getStationById(int id) {
		return stationDao.getStationById(id);
	}

	@Override
	@Transactional
	public Station updateStation(int stationId,Station station) {
		Station oldStation = stationDao.getStationById(stationId);
		if(station.getStationCity() != null && oldStation.getStationCity() != station.getStationCity())
		{
			oldStation.setStationCity(station.getStationCity());
		}
		
		if(station.getStationName() != null && oldStation.getStationName() != station.getStationName())
		{
			oldStation.setStationName(station.getStationName());
		}
		return stationDao.updateStation(oldStation);
	}

}
