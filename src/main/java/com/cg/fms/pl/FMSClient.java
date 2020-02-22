package com.cg.fms.pl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.cg.fms.bean.Airport;
import com.cg.fms.bean.DateTime;
import com.cg.fms.bean.Flight;
import com.cg.fms.bean.Schedule;
import com.cg.fms.bean.ScheduledFlight;
import com.cg.fms.service.ScheduleFlightServicesImpl;
import com.cg.fms.util.Util;

public class FMSClient {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ScheduleFlightServicesImpl service = new ScheduleFlightServicesImpl();
		Flight flight = null;
		Airport air = null;
		Schedule sch = null;

		int choice = 0;
		while (choice != 7) {
			System.out.println(" 1. ScheduledFlight ");
			System.out.println(" 2. View list of ScheduledFlights ");
			System.out.println(" 3. Modify a  ScheduledFlight ");
			System.out.println(" 4. Delete a ScheduledFlight ");
			System.out.println(" 5. View a Schedule Flight ");
			System.out.println(" 6. View Scheduled Flights List");
			System.out.println(" 7.exit ");
			System.out.println(" Enter your choice ");
			System.out.println("We Have 3 flights:");
			System.out.println("9999,AllType,INS,250");
			System.out.println("5555,ECONOMY,INS, 150");
			System.out.println("7777,FIRSTCLASS,INS,200");
			System.out.println("Airports are");
			System.out.println("Hyderabad Airport,HYD,Hyderabad");
			System.out.println("Mumbai Airport,MUM,Mumbai");
			System.out.println("Bangalore Airport,BAN,Bengaluru");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				try {
					ScheduledFlight schflight = new ScheduledFlight();
					scan.nextLine();
					System.out.println(" Enter the Flight number");
					int flightnum = scan.nextInt();
					scan.nextLine();
					Flight f = Util.searchSourceFlight(flightnum);
					System.out.println(" Enter the source airport code");
					String sourcecode = scan.nextLine();
					Airport s = Util.searchSourceAirport(sourcecode);
					System.out.println("  Enter the destination airport code");
					String destcode = scan.nextLine();
					Airport d = Util.searchDestAirport(destcode);
					System.out.println(" enter the Arrival Date and Time ");
					String date1 = scan.next();
					String time1 = scan.next();
					System.out.println(" enter the Destination Date and Time ");
					String date2 = scan.next();
					String time2 = scan.next();
					DateTime dt1 = new DateTime(date1, time1);
					DateTime dt2 = new DateTime(date1, time1);
					Schedule s11 = new Schedule(s, d, dt1, dt2);
					System.out.println(" Enter the available seats ");
					int no = scan.nextInt();
					schflight.setFlight(f);
					schflight.setSchedule(s11);
					schflight.setAvailableSeats(no);
					service.scheduleFlight(schflight);
				} catch (Exception e) {
					System.out.println(e.getMessage());

				}
				break;

			case 2:
				try {
					List<ScheduledFlight> list = service.viewScheduledFlight();
					System.out.println(list.size());
					for (ScheduledFlight l : list) {
						int a = l.getAvailableSeats();
						Flight f = l.getFlight();
						Schedule s = l.getSchedule();
						String carrier = f.getCarrierName();
						String model = f.getFlightModel();
						int num = f.getFlightNumber();
						int seat = f.getSeatCapacity();
						Airport source = s.getSourceAirport();
						Airport dest = s.getDestinationAirport();
						String sourcecode = source.getAirportCode();
						String destcode = dest.getAirportCode();
						DateTime arr = s.getArrivalTime();
						DateTime desttime = s.getDepartureTime();
						String adate = arr.getDate();
						String ahour = arr.getHour();
						String ddate = desttime.getDate();
						String dhour = desttime.getHour();
						System.out.println(num + " " + sourcecode + " " + " " + destcode + " " + adate + " " + ahour
								+ " " + ddate + " " + dhour);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {

					scan.nextLine();
					System.out.println(" Enter the Flight number");
					int flightnum = scan.nextInt();
					Flight f = Util.searchSourceFlight(flightnum);
					scan.nextLine();
					System.out.println(" Enter the source airport code");
					String sourcecode = scan.nextLine();
					Airport s = Util.searchSourceAirport(sourcecode);
					System.out.println("  Enter the destination airport code");
					String destcode = scan.nextLine();
					Airport d = Util.searchDestAirport(destcode);
					System.out.println(" enter the Arrival Date and Time ");
					String date1 = scan.next();
					String time1 = scan.next();
					System.out.println(" enter the Destination Date and Time ");
					String date2 = scan.next();
					String time2 = scan.next();
					DateTime dt1 = new DateTime(date1, time1);
					DateTime dt2 = new DateTime(date1, time1);
					Schedule s11 = new Schedule(s, d, dt1, dt2);
					System.out.println(" Enter the available seats ");
					int no = scan.nextInt();
					service.modifyScheduledFlight(f, s11, no);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				try {
					scan.nextLine();
					System.out.println(" Enter the Flight number");
					int flightnum = scan.nextInt();
					Flight f = Util.searchSourceFlight(flightnum);
					service.deleteScheduledFlight(flightnum);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;
			case 5:
				try {
					System.out.println(" Enter the Flight number ");
					int fn = scan.nextInt();
					Flight fobj = service.viewScheduledFlights(fn);
					System.out.println(fobj.getFlightNumber() + " " + fobj.getFlightModel() + " "
							+ fobj.getCarrierName() + " " + fobj.getSeatCapacity());

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				try {
					scan.nextLine();
					System.out.println("Enter Source airport code");
					String s = scan.nextLine();
					Airport sa = Util.searchSourceAirport(s);
					System.out.println("Enter destination airport code");
					String d = scan.nextLine();
					Airport da = Util.searchDestAirport(d);
					System.out.println("Enter Date");
					String dd = scan.nextLine();
					System.out.println("Entertime");
					String tt = scan.nextLine();
					DateTime dt1 = new DateTime(dd, tt);
					List<ScheduledFlight> l = service.viewScheduledFlights(sa, da, dt1);
					System.out.println(l.size());
					for (ScheduledFlight v : l) {
						int fno = v.getFlight().getFlightNumber();
						String fm = v.getFlight().getFlightModel();
						String cn = v.getFlight().getCarrierName();
						int seat = v.getFlight().getSeatCapacity();
						System.out.println(fno + " " + fm + " " + cn + " " + seat);
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				System.out.println("THANK YOU");
				return;

			}

		}

	}
}