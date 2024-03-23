package com.project.railway.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.railway.entities.Station;
import com.project.railway.entities.Train;
import com.project.railway.entities.TrainStation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class RailwayDaoImpl implements RailwayDao {

	private EntityManager entityManager;

	@Autowired
	public RailwayDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public Train saveTrain(Train train) {
		entityManager.persist(train);
		return train;
	}

	public Station saveStation(Station station) {
		entityManager.persist(station);
		return station;
	}

	public TrainStation addRoute(TrainStation trainStation) {
		entityManager.persist(trainStation);
		return trainStation;
	}

	public List<Train> searchTrain(String source, String destination) {
		TypedQuery<Integer> query = entityManager.createQuery("select stationId from Station where stationName=:param",
				Integer.class);
		query.setParameter("param", source);
		int source_id = (int) query.getSingleResult();

		query = entityManager.createQuery("select stationId from Station where stationName=:param", Integer.class);
		query.setParameter("param", destination);
		int dest_id = (int) query.getSingleResult();

		List<Train> trains = new ArrayList<Train>();

		TypedQuery<Train> q2 = entityManager.createQuery(
				"from Train where source.stationId=:param1 and destination.stationId=:param2", Train.class);
		q2.setParameter("param1", source_id);
		q2.setParameter("param2", dest_id);

		List<Train> l2 = q2.getResultList();

		for (Train t : l2) {
			trains.add(t);
		}

		/*
		 * select distinct t1.id,t1.fare,t1.station_id,t1.train_id from train_station as
		 * t1,train_station as t2 where t1.station_id =2 and t2.station_id = 4 and
		 * t1.train_id=t2.train_id;
		 */
//		TypedQuery<SearchResult> result = entityManager.createQuery(
//				"select t1.trainId as trainNo,(t1.fare-t2.fare) as fare from TrainStation as t1,TrainStation as t2 where t1.stationId =:param1 and t2.stationId = :param2 and t1.trainId=t2.trainId",
//				SearchResult.class);
//
//		result.setParameter("param1", source_id);
//		result.setParameter("param2", dest_id);
//
//		List<SearchResult> search = result.getResultList();
//
//		for (SearchResult value : search) {
//			int trainNo = value.getTrainNo();
//			int fare = value.getFare();
//			if (fare < 0) {
//				fare = fare * -1;
//			}
//
//			TypedQuery<Train> t = entityManager.createQuery("from Train where trainNo=:param", Train.class);
//			t.setParameter("param", trainNo);
//
//			List<Train> train2 = t.getResultList();
//			for (Train value2 : train2) {
//				value2.setFare(fare);
//				value2.source.setStationName(source);
//				value2.destination.setStationName(destination);
//
//				trains.add(value2);
//			}
//		}

		// Adjust the query to return a List<Object[]>
		TypedQuery<Object[]> result = entityManager.createQuery(
				"select t1.trainId, (t1.fare - t2.fare) " + "from TrainStation as t1, TrainStation as t2 "
						+ "where t1.stationId = :param1 and t2.stationId = :param2 and t1.trainId = t2.trainId",
				Object[].class);

		result.setParameter("param1", source_id);
		result.setParameter("param2", dest_id);

		List<Object[]> search = result.getResultList();

		for (Object[] values : search) {
			int trainNo = (int) values[0];
			int fare = (int) values[1]; // Assuming fare is an integer

			if (fare < 0) {
				fare = fare * -1;
			}

			TypedQuery<Train> trainQuery = entityManager.createQuery("from Train where trainNo = :trainNo",
					Train.class);
			trainQuery.setParameter("trainNo", trainNo);

			List<Train> trainList = trainQuery.getResultList();
			for (Train train : trainList) {
				train.setFare(fare);
				train.getSource().setStationName(source);
				train.getDestination().setStationName(destination);
				trains.add(train);
			}
		}

		return trains;
	}

}
