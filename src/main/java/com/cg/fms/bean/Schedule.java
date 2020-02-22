package com.cg.fms.bean;

public class Schedule {
	
	private Airport sourceAirport;
	private Airport destinationAirport;
	private DateTime arrivalTime;
	private DateTime departureTime;
	
	public Schedule( Airport sourceAirport, Airport destinationAirport, DateTime arrivalTime, DateTime departureTime) {
		super();
		
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public Schedule() {
		super();
	}
	
	public Airport getSourceAirport() {
		return sourceAirport;
	}
	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public DateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(DateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public DateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(DateTime departureTime) {
		this.departureTime = departureTime;
	}

}