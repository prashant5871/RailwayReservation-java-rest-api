package com.project.railway.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.railway.dao.RouteDao;
import com.project.railway.entities.Route;
import com.project.railway.entities.Station;

import jakarta.transaction.Transactional;


@Service
public class RouteServiceImpl implements RouteService{
	public RouteDao routeDao;
	
	@Autowired
	public RouteServiceImpl(RouteDao routeDao)
	{
		this.routeDao = routeDao;
	}

	@Override
	@Transactional
	public Route addRoute(Route route) {
		return routeDao.addRoute(route);
	}

	@Override
	public List<Station> getAllStationInRoute(int trainId) {
		return routeDao.getAllStationInRoute(trainId);
	}

}
