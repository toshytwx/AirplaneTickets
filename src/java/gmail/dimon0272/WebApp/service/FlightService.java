package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.model.Flight;

public interface FlightService {
    void saveFlight(Flight flight);
    Flight findFlightById(Long id);
}
