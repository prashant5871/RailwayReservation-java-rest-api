package com.project.railway.beans;

public class SearchResult {
    public int fare;
    public int trainNo;
    
    
	public SearchResult(int fare, int trainNo) {
		super();
		this.fare = fare;
		this.trainNo = trainNo;
	}
	
	
	public SearchResult() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}


	@Override
	public String toString() {
		return "SearchResult [fare=" + fare + ", trainNo=" + trainNo + "]";
	}

	
    
    
}
