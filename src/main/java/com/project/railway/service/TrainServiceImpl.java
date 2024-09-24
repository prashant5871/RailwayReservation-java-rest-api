package com.project.railway.service;

import java.util.*;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.railway.dao.TrainDao;
import com.project.railway.entities.Train;

import jakarta.transaction.Transactional;

@Service
public class TrainServiceImpl implements TrainService {
	public TrainDao trainDao;
	
	@Autowired
	public TrainServiceImpl(TrainDao trainDao)
	{
		this.trainDao = trainDao;
	}
	
	@Transactional
	public Train saveTrain(Train train)
	{
		return trainDao.saveTrain(train);
	}
	
	public List<Train> getTrains()
	{
		return trainDao.getTrains();
	}
	
	public Train findById(int id)
	{
		return trainDao.findById(id);
	}
	
	public List<Train> searchTrain(String source,String destination)
    {
    	return trainDao.searchTrain(source,destination);
    }

	@Override
	@Transactional
	public String deleteTrain(int trainId) {
		return trainDao.deleteTrain(trainId);
	}

}
