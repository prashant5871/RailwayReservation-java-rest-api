package com.project.railway.entities;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int trainNo;

    @Column(name = "train_name")
    public String trainName;

    @Temporal(TemporalType.TIME)
    @Column(name = "arrival_time")
    public Date arrivalTime;
 
    @Temporal(TemporalType.TIME)
    @Column(name = "departure_time")
    public Date departureTime;

    @OneToOne
    @JoinColumn(name = "source_id")
    public Station source;

    @OneToOne
    @JoinColumn(name="destination_id")
    public Station destination;
    
    
	public int fare;

	public Train(int trainNo, String trainName, Date arrivalTime, Date departureTime, Station source,
			Station destination,int fare) {
		super();
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
	}
	
	public Train() {}
	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public int getFare(){
		return this.fare;
	}
	public void setFare(int fare){
		this.fare = fare;
	}
	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Station getSource() {
		return source;
	}

	public void setSource(Station source) {
		this.source = source;
	}

	public Station getDestination() {
		return destination;
	}

	public void setDestination(Station destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Train [trainNo=" + trainNo + ", trainName=" + trainName + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", source=" + source + ", destination=" + destination + "]";
	}
    
	
    

}
