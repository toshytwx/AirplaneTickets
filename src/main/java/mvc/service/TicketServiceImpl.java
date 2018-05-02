package mvc.service;

import mvc.dao.TicketDao;
import mvc.model.Customer;
import mvc.model.Flight;
import mvc.model.Luggage;
import mvc.model.Ticket;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.SessionUtils;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketDao ticketDao;

    @Override
    public void saveTicket(Ticket ticket) {
        ticketDao.save(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        try (Session session = SessionUtils.getSession()) {
            session.merge(ticket);
        }
    }

    @Override
    @Transactional
    public Ticket findTicketByCustomer(Customer customer) {
        return ticketDao.findByCustomer(customer);
    }

    @Override
    @Transactional
    public Ticket findTicketByLuggage(Luggage luggage) {
        return ticketDao.findByLuggage(luggage);
    }

    @Override
    @Transactional
    public Ticket findTicketByFlight(Flight flight) {
        return ticketDao.findByFlight(flight);
    }
}
