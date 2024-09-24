package com.project.railway.service;

import java.util.*;
import com.project.railway.entities.Train;

public interface TrainService {
	public Train saveTrain(Train train);
	public List<Train> getTrains();
	public Train findById(int id);
	public List<Train> searchTrain(String source,String destination);
	public String deleteTrain(int trainId);
}
