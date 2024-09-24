package com.project.railway.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.railway.entities.Station;
import com.project.railway.entities.Train;

import jakarta.persistence.EntityManager;

public interface TrainDao {
	public Train saveTrain(Train train);
	public List<Train> getTrains();
	public Train findById(int id);
	public List<Train> searchTrain(String Source,String dest);
	public String deleteTrain(int trainId);
}
