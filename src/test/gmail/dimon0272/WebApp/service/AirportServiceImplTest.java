package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.model.Airport;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AirportServiceImplTest {
    @org.junit.Test
    public void airportsNames() throws Exception {
        AirportService airportService = new AirportServiceImpl();
        boolean actual = airportService.airportsNames() == null;
        boolean expected = new ArrayList<String>() == null;
        assertEquals(actual, expected);
    }

    @org.junit.Test
    public void findAirportByName() throws Exception {
        AirportService airportService = new AirportServiceImpl();
        Airport actual = airportService.findAirportByName("");
        Airport expected = new Airport();
        assertEquals(actual.getName(), expected.getName());
    }

}