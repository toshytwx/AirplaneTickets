package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.model.Airport;

import java.util.List;

public interface AirportService {
    List<String> airportsNames();
    Airport findAirportByName(String name);
}
