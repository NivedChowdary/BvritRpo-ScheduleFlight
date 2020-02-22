package com.cg.fms.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.fms.bean.Airport;
import com.cg.fms.bean.DateTime;
import com.cg.fms.bean.Flight;
import com.cg.fms.bean.Schedule;
import com.cg.fms.bean.ScheduledFlight;
import com.cg.fms.flightexception.FlightException;

public interface ScheduledFlightDao {
	
	List<ScheduledFlight> scheduledFlightList=null;
	
	public int scheduleFlight(ScheduledFlight flight)throws FlightException;
	public List<ScheduledFlight> viewScheduledFlights(Airport souce, Airport destination, DateTime dateTime) throws FlightException;
	public Flight viewScheduledFlights(int flightNumber) throws FlightException;
    public List<ScheduledFlight> viewScheduledFlight() throws FlightException;
    public ScheduledFlight modifyScheduledFlight(Flight flight,Schedule schedule,int a) throws FlightException;
    public void deleteScheduledFlight(int flightNumber) throws FlightException;

}