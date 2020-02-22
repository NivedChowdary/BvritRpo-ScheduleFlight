package com.cg.fms.dao;

//Our purpose of this layer is to Schedule the flights.............

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.cg.fms.bean.Airport;
import com.cg.fms.bean.DateTime;
import com.cg.fms.bean.Flight;
import com.cg.fms.bean.Schedule;
import com.cg.fms.bean.ScheduledFlight;
import com.cg.fms.flightexception.FlightException;

public class ScheduledFlightDaoImpl implements ScheduledFlightDao{

	private Map<Integer,ScheduledFlight> schedflight;

	public  ScheduledFlightDaoImpl() {
		schedflight = new HashMap<Integer,ScheduledFlight>();

		
	}
	public int scheduleFlight(ScheduledFlight scheduledFlight) throws FlightException {
		
		
		if(schedflight.containsKey(scheduledFlight.getFlight().getFlightNumber()))
				{
					throw new FlightException(" Flight is already scheduled");
				}
		schedflight.put(scheduledFlight.getFlight().getFlightNumber(), scheduledFlight);
	
		return scheduledFlight.getFlight().getFlightNumber();

	}

	public List<ScheduledFlight> viewScheduledFlights(Airport source, Airport destination, DateTime dateTime) throws FlightException {
	List<ScheduledFlight> list1= new ArrayList<ScheduledFlight>();

		String sour=source.getAirportCode();
		String dest =destination.getAirportCode();
		String date2 = dateTime.getDate();
		Collection<ScheduledFlight> col = schedflight.values();
		List<ScheduledFlight> list = new ArrayList<ScheduledFlight>(col);
		for(ScheduledFlight x : list) {

			Schedule s =x.getSchedule();
			DateTime date =s.getArrivalTime();
			String date1 =date.getDate();
			Airport source1 =s.getSourceAirport();
			Airport dest1=s.getDestinationAirport();
			String sourceCode =source1.getAirportCode();
			String destCode = dest1.getAirportCode();
			if(sourceCode.equals(sour)&&destCode.equals(dest)&&date1.equals(date2)) {
				
				list1.add(x);
			}
		}

	
		return list1;
	}

	public Flight viewScheduledFlights(int flightNumber) throws FlightException {
		if(!schedflight.containsKey(flightNumber))
		{
			throw new FlightException(" No Flight is Present ");
		}
		Flight f =schedflight.values().stream().map(p->p.getFlight()).filter(p->p.getFlightNumber()==flightNumber).findFirst().get();
		
		return f;
	}

	public List<ScheduledFlight> viewScheduledFlight() throws FlightException{
		if(schedflight.isEmpty())
		{
			throw new FlightException(" No Flight is Scheduled ");
		}
		Collection<ScheduledFlight> col = schedflight.values();
		List<ScheduledFlight> list = new ArrayList<ScheduledFlight>(col);
		
		
		

		return list;
	}

	@Override
	public ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule, int seatnumbers) throws FlightException{

		if(!schedflight.containsKey(flight.getFlightNumber())) {
			throw new FlightException(" Flight number does not exist");
			
		}
		ScheduledFlight obj = new ScheduledFlight(flight,seatnumbers,schedule);
		schedflight.put(obj.getFlight().getFlightNumber(), obj);
		return obj;
		
	}

	@Override
	public void deleteScheduledFlight(int flightNumber) throws FlightException{
		ScheduledFlight scheduledFlight=null;
		
		if(!schedflight.containsKey(flightNumber)) {
			throw new FlightException(" Flight number does not exist");
			
		}
		schedflight.remove(flightNumber);
		
		
	}

}