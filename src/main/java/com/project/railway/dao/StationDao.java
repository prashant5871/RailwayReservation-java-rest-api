package com.project.railway.dao;

import java.util.*;
import com.project.railway.entities.Station;

public interface StationDao {
	public Station saveStation(Station station);
	public List<Station> getAllStation();
	public Station getStationById(int id);
	public Station updateStation(Station station);
}
