package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.model.Customer;
import gmail.dimon0272.WebApp.model.Flight;
import gmail.dimon0272.WebApp.model.Luggage;
import gmail.dimon0272.WebApp.model.Ticket;

public interface TicketService {
    void saveTicket(Ticket ticket);
    void updateTicket(Ticket ticket);
    Ticket findTicketByCustomer(Customer customer);
    Ticket findTicketByLuggage(Luggage luggage);
    Ticket findTicketByFlight(Flight flight);
}
