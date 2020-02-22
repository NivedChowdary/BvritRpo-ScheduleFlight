package com.cg.fms.util;

import java.util.ArrayList;
import java.util.List;

import com.cg.fms.bean.Airport;
import com.cg.fms.bean.Flight;

public class Util {
public static List<Flight> flightList=new ArrayList<Flight>();
public static List<Airport> sourceList=new ArrayList<Airport>();
public static List<Airport> destList=new ArrayList<Airport>();


static
{

Flight f1= new Flight(999,"AllType","INS",250);
Flight f2= new Flight(555,"ECONOMY","INS", 150);
Flight f3= new Flight(777,"FIRSTCLASS","INS",200);

Airport s1= new Airport("Hyderabad Airport","HYD","Hyderabad");
Airport s2= new Airport("Mumbai Airport","MUM","Mumbai");
Airport s3= new Airport("Bangalore Airport","BAN","Bengaluru");

Airport d1= new Airport("Hyderabad Airport","HYD","Hyderabad");
Airport d2= new Airport("Mumbai Airport","MUM","Mumbai");
Airport d3= new Airport("Bangalore Airport","BAN","Bengaluru");

flightList.add(f1);
flightList.add(f2);
flightList.add(f3);

sourceList.add(s1);
sourceList.add(s2);
sourceList.add(s3);

destList.add(d1);
destList.add(d2);
destList.add(d3);
}
public static Flight  searchSourceFlight(int id)
{

Flight f =flightList.stream().filter(p->p.getFlightNumber()==id).findFirst().get();

 return f ;
}
public static Airport  searchSourceAirport(String sourcecode)
{
Airport a =sourceList.stream().filter(p->p.getAirportCode().equals(sourcecode)).findFirst().get();
 return a;
}
public static Airport  searchDestAirport(String destcode)
{
Airport a =destList.stream().filter(p->p.getAirportCode().equals(destcode)).findFirst().get();
 return a;
}
}