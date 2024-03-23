package com.project.railway.entities;

import org.hibernate.annotations.ValueGenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int stationId;

    @Column(name="name")
    public String stationName;
    @Column(name = "city")
    public String stationCity;
	public Station(int stationId, String stationName, String stationCity) {
		super();
		this.stationId = stationId;
		this.stationName = stationName;
		this.stationCity = stationCity;
	}

	public Station(String stationName, String stationCity) {
		this.stationName = stationName;
		this.stationCity = stationCity;
	}

	public Station(){}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getStationCity() {
		return stationCity;
	}
	public void setStationCity(String stationCity) {
		this.stationCity = stationCity;
	}
	@Override
	public String toString() {
		return "Station [stationId=" + stationId + ", stationName=" + stationName + ", stationCity=" + stationCity
				+ "]";
	}
	
	
    
}
