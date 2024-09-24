package com.project.railway.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.railway.entities.Route;
import com.project.railway.entities.Station;
import com.project.railway.entities.Train;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class RouteDaoImpl implements RouteDao {
	public EntityManager entityManager;

	@Autowired
	public RouteDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Route addRoute(Route route) {
		route.setId(0);
		return entityManager.merge(route);
	}

	@Override
	public List<Station> getAllStationInRoute(int trainId) {
		TypedQuery<Station> query = entityManager.createQuery(
				"FROM Station where stationId IN(select stationId from Route where trainId=:param)", Station.class);
		query.setParameter("param", trainId);
		List<Station> stations = query.getResultList();

		Train train = entityManager.find(Train.class, trainId);
		int sourceId = train.getSource().getStationId();
		int destId = train.getDestination().getStationId();

		Station sourceStation = entityManager.find(Station.class, sourceId);
		Station destStation = entityManager.find(Station.class, destId);

		stations.add(sourceStation);
		stations.add(destStation);
		return stations;
	}

}
