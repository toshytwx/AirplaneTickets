package gmail.dimon0272.WebApp.dao;

import gmail.dimon0272.WebApp.model.Customer;
import gmail.dimon0272.WebApp.model.Flight;
import gmail.dimon0272.WebApp.model.Luggage;
import gmail.dimon0272.WebApp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDao extends JpaRepository<Ticket, Long>
{
    Ticket findByCustomer(Customer customer);
    Ticket findByFlight(Flight flight);
    Ticket findByLuggage(Luggage luggage);
}
