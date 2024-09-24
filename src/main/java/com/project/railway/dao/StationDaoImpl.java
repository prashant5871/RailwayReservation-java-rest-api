package com.project.railway.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.railway.entities.Station;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StationDaoImpl implements StationDao {
	public EntityManager entityManager;
	
	@Autowired
	public StationDaoImpl(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	public Station saveStation(Station station)
	{
		station.setStationId(0);
		return entityManager.merge(station);
	}

	@Override
	public List<Station> getAllStation() {
		TypedQuery<Station> q = entityManager.createQuery("FROM Station",Station.class);
		List<Station> stations = q.getResultList();
		return stations;
	}

	@Override
	public Station getStationById(int id) {
		Station station = entityManager.find(Station.class, id);
		return station;
	}

	@Override
	public Station updateStation(Station station) {
		return entityManager.merge(station);
	}
}
