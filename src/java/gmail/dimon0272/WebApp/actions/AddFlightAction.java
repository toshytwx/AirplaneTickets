package gmail.dimon0272.WebApp.actions;

import gmail.dimon0272.WebApp.model.Flight;
import gmail.dimon0272.WebApp.service.FlightService;

public class AddFlightAction implements Action {
    private FlightService flightService;
    private Flight flight;

    public AddFlightAction(FlightService flightService, Flight flight) {
        this.flightService = flightService;
        this.flight = flight;
    }

    @Override
    public void execute() {
        flightService.saveFlight(flight);
    }
}
