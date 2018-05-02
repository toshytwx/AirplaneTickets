package mvc.service;

import mvc.model.Customer;
import mvc.model.Flight;
import mvc.model.Luggage;
import mvc.model.Ticket;

public interface TicketService {
    void saveTicket(Ticket ticket);
    void updateTicket(Ticket ticket);
    Ticket findTicketByCustomer(Customer customer);
    Ticket findTicketByLuggage(Luggage luggage);
    Ticket findTicketByFlight(Flight flight);
}
