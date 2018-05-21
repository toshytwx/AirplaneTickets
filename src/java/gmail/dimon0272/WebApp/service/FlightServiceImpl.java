package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.dao.FlightDao;
import gmail.dimon0272.WebApp.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class FlightServiceImpl implements FlightService{
    @Autowired
    private FlightDao flightDao;

    private Query query;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveFlight(Flight flight) {
        flightDao.save(flight);
    }

    @Override
    public Flight findFlightById(Long id) {
        query = entityManager.createQuery("SELECT f FROM Flight f WHERE f.id = :id", Flight.class);
        query.setParameter("id", id);
        return (Flight) query.getSingleResult();
    }
}
