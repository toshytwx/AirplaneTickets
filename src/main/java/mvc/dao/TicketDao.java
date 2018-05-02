package mvc.dao;

import mvc.model.Customer;
import mvc.model.Flight;
import mvc.model.Luggage;
import mvc.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDao extends JpaRepository<Ticket, Long> {
    Ticket findByCustomer(Customer customer);
    Ticket findByFlight(Flight flight);
    Ticket findByLuggage(Luggage luggage);
}
