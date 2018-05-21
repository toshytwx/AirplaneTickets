package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.dao.TicketDao;
import gmail.dimon0272.WebApp.model.Customer;
import gmail.dimon0272.WebApp.model.Flight;
import gmail.dimon0272.WebApp.model.Luggage;
import gmail.dimon0272.WebApp.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketDao ticketDao;

    @PersistenceContext
    private EntityManager entityManager;

    private Query query;

    @Override
    public void saveTicket(Ticket ticket) {
        ticketDao.save(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        entityManager.merge(ticket);
    }

    @Override
    @Transactional
    public Ticket findTicketByCustomer(Customer customer) {
        query = entityManager.createQuery("SELECT t FROM Ticket t WHERE t.id = :id", Ticket.class);
        query.setParameter("id", customer.getId());
        return (Ticket) query.getSingleResult();
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
