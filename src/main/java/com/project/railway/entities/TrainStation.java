package com.project.railway.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "train_station")
public class TrainStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

	@Column(unique = false)
    public int trainId;

    @Column(unique = false)
    public int stationId;

    public int fare;

	public TrainStation(int id, int trainId, int stationId, int fare) {
		super();
		this.id = id;
		this.trainId = trainId;
		this.stationId = stationId;
		this.fare = fare;
	}
	
	public TrainStation() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTrain() {
		return trainId;
	}

	public void setTrain(int trainId) {
		this.trainId = trainId;
	}

	public int getStation() {
		return stationId;
	}

	public void setStation(int stationId) {
		this.stationId = stationId;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

    
}
