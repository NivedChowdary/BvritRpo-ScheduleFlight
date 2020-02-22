package com.cg.fms.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.fms.bean.Airport;
import com.cg.fms.bean.DateTime;
import com.cg.fms.bean.Flight;
import com.cg.fms.bean.Schedule;
import com.cg.fms.bean.ScheduledFlight;
import com.cg.fms.dao.ScheduledFlightDao;
import com.cg.fms.dao.ScheduledFlightDaoImpl;

class FmsTest {

	ScheduledFlightDao dao = null;
	Flight f1 = new Flight(999, "AllType", "Airbus", 250);

	Airport s1 = new Airport("Hyderabad Airport", "HYD", "Hyderabad");

	Airport d1 = new Airport("Hyderabad Airport", "HYD", "Hyderabad");

	Schedule s = new Schedule(s1, d1, new DateTime(), new DateTime());
	ScheduledFlight sf = new ScheduledFlight(f1, 0, s);

	@BeforeEach
	public void setUp() {
		dao = new ScheduledFlightDaoImpl();

	}

	@Test
	void testScheduleFlight() throws Exception {

		int num = dao.scheduleFlight(sf);

		assertTrue(num > 0);

	}

	@Test
	void validateViewScheduledFlight() throws Exception {

		dao.scheduleFlight(sf);
		List<ScheduledFlight> list = dao.viewScheduledFlight();
		assertEquals(1, list.size());

	}

	
	@Test
	void testviewscheduleFlight() throws Exception {

		dao.scheduleFlight(sf);
		Flight a = dao.viewScheduledFlights(sf.getFlight().getFlightNumber());
		assertEquals(999, a.getFlightNumber());

	}
}