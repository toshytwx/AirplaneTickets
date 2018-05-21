package gmail.dimon0272.WebApp.service;

import gmail.dimon0272.WebApp.dao.AirportDao;
import gmail.dimon0272.WebApp.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService{
    @Autowired
    private AirportDao airportDao;

    private Query query;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<String> airportsNames() {
        query = entityManager.createNativeQuery("SELECT a.name FROM Airport a");
        return (ArrayList<String>) query.getResultList();
    }

    @Override
    public Airport findAirportByName(String name) {
        query = entityManager.createQuery("SELECT a FROM Airport a WHERE a.name = :airportName", Airport.class);
        query.setParameter("airportName", name);
        return (Airport) query.getSingleResult();
    }
}
